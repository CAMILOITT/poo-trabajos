package sistemainventario;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestion portable de la base de datos SQLite del sistema de inventario.
 *
 * La base es un archivo local incluido en la raiz del proyecto (inventario.db).
 */
public final class BaseDatos {

    /** Nombre del archivo por defecto, relativo al directorio de trabajo. */
    private static final String ARCHIVO_POR_DEFECTO = "inventario.db";

    private BaseDatos() {
    }

    /** Resuelve la ruta del archivo: propiedad > variable de entorno > raiz del proyecto. */
    public static File resolverArchivo() {
        String ruta = System.getProperty("sqlite.db", System.getenv("SQLITE_DB"));
        if (ruta == null || ruta.isBlank()) {
            ruta = ARCHIVO_POR_DEFECTO;
        }
        File archivo = new File(ruta);
        // Si es relativa, resolverla contra el directorio desde el que se ejecuta el JAR.
        if (!archivo.isAbsolute()) {
            archivo = new File(System.getProperty("user.dir"), ruta);
        }
        return archivo;
    }

    /**
     * Abre la conexion.
     */
    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de SQLite", e);
        }

        File archivo = resolverArchivo();
        File carpeta = archivo.getAbsoluteFile().getParentFile();
        if (carpeta != null && !carpeta.exists() && !carpeta.mkdirs()) {
            throw new SQLException("No se pudo crear la carpeta: " + carpeta);
        }

        String url = "jdbc:sqlite:" + archivo.getAbsolutePath().replace('\\', '/');
        Connection conexion = DriverManager.getConnection(url);
        try (Statement pragma = conexion.createStatement()) {
            // SQLite requiere activar las claves foraneas por conexion.
            pragma.execute("PRAGMA foreign_keys = ON");
        }
        return conexion;
    }
}
