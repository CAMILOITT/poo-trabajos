/*======================================================================*/
/* PUENTE JDBC -> ODBC (reemplazo de sun.jdbc.odbc.JdbcOdbcDriver)      */
/* El puente original se elimino en Java 8; este lo reemplaza llamando  */
/* directamente a odbc32.dll de Windows (API java.lang.foreign, Java 22+)*/
/* Es un driver JDBC minimo: conectar, crear Statement, ejecutar        */
/* sentencias (DDL/INSERT/UPDATE/DELETE) y cerrar.                      */
/* AUTOR    : Matias Noboa                                              */
/*======================================================================*/
package tabla32;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public class PuenteJdbcOdbc implements Driver {

    // Al cargar la clase, el driver se registra solo en DriverManager
    static {
        try {
            DriverManager.registerDriver(new PuenteJdbcOdbc());
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // ---------------------------------------------------------------
    // Funciones de la API ODBC (odbc32.dll en Windows, libodbc en Linux)
    // ---------------------------------------------------------------
    private static final short SQL_HANDLE_ENV = 1;
    private static final short SQL_HANDLE_DBC = 2;
    private static final short SQL_HANDLE_STMT = 3;
    private static final int SQL_ATTR_ODBC_VERSION = 200;
    private static final int SQL_OV_ODBC3 = 3;
    private static final int SQL_NTS = -3;
    private static final short SQL_DRIVER_NOPROMPT = 0;

    private static final Linker LINKER = Linker.nativeLinker();
    private static final SymbolLookup ODBC = SymbolLookup.libraryLookup(
            System.getProperty("os.name").toLowerCase().contains("win") ? "odbc32" : "libodbc.so.2",
            Arena.global());

    private static MethodHandle funcion(String nombre, FunctionDescriptor descriptor) {
        return LINKER.downcallHandle(ODBC.find(nombre).orElseThrow(), descriptor);
    }

    private static final ValueLayout.OfShort S = ValueLayout.JAVA_SHORT;
    private static final ValueLayout.OfInt I = ValueLayout.JAVA_INT;
    private static final ValueLayout.OfLong L = ValueLayout.JAVA_LONG;
    private static final java.lang.foreign.AddressLayout A = ValueLayout.ADDRESS;

    private static final MethodHandle ALLOC_HANDLE = funcion("SQLAllocHandle", FunctionDescriptor.of(S, S, A, A));
    private static final MethodHandle FREE_HANDLE = funcion("SQLFreeHandle", FunctionDescriptor.of(S, S, A));
    private static final MethodHandle SET_ENV_ATTR = funcion("SQLSetEnvAttr", FunctionDescriptor.of(S, A, I, A, I));
    private static final MethodHandle DRIVER_CONNECT = funcion("SQLDriverConnectW", FunctionDescriptor.of(S, A, A, A, S, A, S, A, S));
    private static final MethodHandle DISCONNECT = funcion("SQLDisconnect", FunctionDescriptor.of(S, A));
    private static final MethodHandle EXEC_DIRECT = funcion("SQLExecDirectW", FunctionDescriptor.of(S, A, A, I));
    private static final MethodHandle ROW_COUNT = funcion("SQLRowCount", FunctionDescriptor.of(S, A, A));
    private static final MethodHandle GET_DIAG = funcion("SQLGetDiagRecW", FunctionDescriptor.of(S, S, A, S, A, A, A, S, A));

    // Texto Java -> UTF-16 terminado en cero (SQLWCHAR)
    private static MemorySegment texto(Arena arena, String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_16LE);
        MemorySegment segmento = arena.allocate(bytes.length + 2);
        segmento.copyFrom(MemorySegment.ofArray(bytes));
        return segmento;
    }

    private static boolean exito(short codigo) {
        return codigo == 0 || codigo == 1; // SQL_SUCCESS o SQL_SUCCESS_WITH_INFO
    }

    // Lee el mensaje de error que dejo ODBC en el handle
    private static SQLException error(short tipo, MemorySegment handle, String contexto) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment estado = arena.allocate(14);
            MemorySegment nativo = arena.allocate(4);
            MemorySegment mensaje = arena.allocate(2048);
            MemorySegment largo = arena.allocate(2);
            short rc = (short) GET_DIAG.invokeExact(tipo, handle, (short) 1, estado, nativo, mensaje, (short) 1000, largo);
            if (exito(rc)) {
                String sqlState = new String(estado.toArray(ValueLayout.JAVA_BYTE), 0, 10, StandardCharsets.UTF_16LE);
                int chars = Math.min(largo.get(ValueLayout.JAVA_SHORT, 0), 1000);
                String texto = new String(mensaje.toArray(ValueLayout.JAVA_BYTE), 0, chars * 2, StandardCharsets.UTF_16LE);
                return new SQLException(contexto + ": " + texto, sqlState, nativo.get(ValueLayout.JAVA_INT, 0));
            }
        } catch (Throwable t) {
            return new SQLException(contexto + " (" + t + ")");
        }
        return new SQLException(contexto);
    }

    // ---------------------------------------------------------------
    // Driver
    // ---------------------------------------------------------------
    @Override
    public boolean acceptsURL(String url) {
        return url != null && url.startsWith("jdbc:odbc:");
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!acceptsURL(url)) {
            return null;
        }
        // jdbc:odbc:NombreDelDSN   o   jdbc:odbc:Driver={...};Server=...;Database=...;
        String cadena = url.substring("jdbc:odbc:".length());
        if (!cadena.contains("=")) {
            cadena = "DSN=" + cadena + ";";
        }
        if (!cadena.endsWith(";")) {
            cadena = cadena + ";";
        }
        if (info != null && info.getProperty("user") != null) {
            cadena = cadena + "UID={" + info.getProperty("user") + "};";
        }
        if (info != null && info.getProperty("password") != null) {
            cadena = cadena + "PWD={" + info.getProperty("password").replace("}", "}}") + "};";
        }
        return new Conexion(cadena).proxy();
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    // ---------------------------------------------------------------
    // Connection (se implementa con un Proxy: solo los metodos usados)
    // ---------------------------------------------------------------
    private static class Conexion implements InvocationHandler {

        private final Arena arena = Arena.ofShared();
        private MemorySegment env;
        private MemorySegment dbc;
        private boolean cerrada = false;

        Conexion(String cadena) throws SQLException {
            try {
                MemorySegment salida = arena.allocate(A);
                if (!exito((short) ALLOC_HANDLE.invokeExact(SQL_HANDLE_ENV, MemorySegment.NULL, salida))) {
                    throw new SQLException("No se pudo crear el entorno ODBC");
                }
                env = salida.get(A, 0);
                short r1 = (short) SET_ENV_ATTR.invokeExact(env, SQL_ATTR_ODBC_VERSION, MemorySegment.ofAddress(SQL_OV_ODBC3), 0);
                if (!exito((short) ALLOC_HANDLE.invokeExact(SQL_HANDLE_DBC, env, salida))) {
                    throw error(SQL_HANDLE_ENV, env, "No se pudo crear la conexion ODBC");
                }
                dbc = salida.get(A, 0);
                short rc = (short) DRIVER_CONNECT.invokeExact(dbc, MemorySegment.NULL, texto(arena, cadena), (short) SQL_NTS,
                        MemorySegment.NULL, (short) 0, MemorySegment.NULL, SQL_DRIVER_NOPROMPT);
                if (!exito(rc)) {
                    SQLException e = error(SQL_HANDLE_DBC, dbc, "No se pudo conectar por ODBC");
                    liberar();
                    throw e;
                }
            } catch (SQLException e) {
                throw e;
            } catch (Throwable t) {
                throw new SQLException("Error al llamar a ODBC: " + t, t);
            }
        }

        Connection proxy() {
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class<?>[]{Connection.class}, this);
        }

        private void liberar() {
            try {
                if (dbc != null) {
                    short r2 = (short) DISCONNECT.invokeExact(dbc);
                    short r3 = (short) FREE_HANDLE.invokeExact(SQL_HANDLE_DBC, dbc);
                    dbc = null;
                }
                if (env != null) {
                    short r4 = (short) FREE_HANDLE.invokeExact(SQL_HANDLE_ENV, env);
                    env = null;
                }
            } catch (Throwable ignorado) {
            }
            arena.close();
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method metodo, Object[] args) throws Throwable {
            switch (metodo.getName()) {
                case "createStatement":
                    if (cerrada) {
                        throw new SQLException("La conexion esta cerrada");
                    }
                    return new Sentencia(dbc).proxy();
                case "close":
                    if (!cerrada) {
                        cerrada = true;
                        liberar();
                    }
                    return null;
                case "isClosed":
                    return cerrada;
                case "getAutoCommit":
                    return true;
                case "setAutoCommit":
                case "commit":
                case "rollback":
                case "clearWarnings":
                    return null; // ODBC trabaja en autocommit
                case "isValid":
                    return !cerrada;
                case "toString":
                    return "PuenteJdbcOdbc.Connection";
                case "hashCode":
                    return System.identityHashCode(proxy);
                case "equals":
                    return proxy == args[0];
                default:
                    throw new SQLFeatureNotSupportedException("Metodo no soportado por el puente: " + metodo.getName());
            }
        }
    }

    // ---------------------------------------------------------------
    // Statement
    // ---------------------------------------------------------------
    private static class Sentencia implements InvocationHandler {

        private MemorySegment stmt;
        private int ultimoConteo = -1;

        Sentencia(MemorySegment dbc) throws SQLException {
            try (Arena arena = Arena.ofConfined()) {
                MemorySegment salida = arena.allocate(A);
                if (!exito((short) ALLOC_HANDLE.invokeExact(SQL_HANDLE_STMT, dbc, salida))) {
                    throw error(SQL_HANDLE_DBC, dbc, "No se pudo crear la sentencia");
                }
                stmt = salida.get(A, 0);
            } catch (SQLException e) {
                throw e;
            } catch (Throwable t) {
                throw new SQLException("Error al llamar a ODBC: " + t, t);
            }
        }

        Statement proxy() {
            return (Statement) Proxy.newProxyInstance(Statement.class.getClassLoader(), new Class<?>[]{Statement.class}, this);
        }

        private int ejecutar(String sql) throws SQLException {
            if (stmt == null) {
                throw new SQLException("La sentencia esta cerrada");
            }
            try (Arena arena = Arena.ofConfined()) {
                short rc = (short) EXEC_DIRECT.invokeExact(stmt, texto(arena, sql), SQL_NTS);
                if (!exito(rc) && rc != 100) { // 100 = SQL_NO_DATA (UPDATE/DELETE sin filas)
                    throw error(SQL_HANDLE_STMT, stmt, "Error al ejecutar la sentencia");
                }
                MemorySegment filas = arena.allocate(8);
                short r5 = (short) ROW_COUNT.invokeExact(stmt, filas);
                long n = filas.get(L, 0);
                ultimoConteo = n < 0 ? 0 : (int) n; // DDL devuelve -1 -> 0
                return ultimoConteo;
            } catch (SQLException e) {
                throw e;
            } catch (Throwable t) {
                throw new SQLException("Error al llamar a ODBC: " + t, t);
            }
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method metodo, Object[] args) throws Throwable {
            switch (metodo.getName()) {
                case "executeUpdate":
                    return ejecutar((String) args[0]);
                case "execute":
                    ejecutar((String) args[0]);
                    return false; // este puente no devuelve ResultSet
                case "getUpdateCount":
                    return ultimoConteo;
                case "close":
                    if (stmt != null) {
                        try {
                            short r6 = (short) FREE_HANDLE.invokeExact(SQL_HANDLE_STMT, stmt);
                        } catch (Throwable ignorado) {
                        }
                        stmt = null;
                    }
                    return null;
                case "isClosed":
                    return stmt == null;
                case "toString":
                    return "PuenteJdbcOdbc.Statement";
                case "hashCode":
                    return System.identityHashCode(proxy);
                case "equals":
                    return proxy == args[0];
                default:
                    throw new SQLFeatureNotSupportedException("Metodo no soportado por el puente: " + metodo.getName());
            }
        }
    }
}
