package sistemainventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Prueba de conexion a PostgreSQL siguiendo los 7 pasos de JDBC.
 */
public class ConnectionDataBase {

    private static final String URL = "jdbc:postgresql://localhost:5432/Inventario";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "Kam3009";

    /**
     * Pasos 1 y 2 de la conexion: carga el driver y abre la conexion.
     * Quien la reciba debe cerrarla (paso 7).
     */
    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de PostgreSQL", e);
        }
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;

        try {
            // 1. Establecer el driver
            Class.forName("org.postgresql.Driver");
            System.out.println("1. Driver cargado");

            // 2. Establecer la conexion
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("2. Conexion establecida");

            // 3. Establecer el query
            String sql = "SELECT id_categoria, nombre, descripcion, estado FROM categorias";
            sentencia = conexion.createStatement();
            System.out.println("3. Query establecido: " + sql);

            // 4. Consultar el query
            resultado = sentencia.executeQuery(sql);
            System.out.println("4. Query ejecutado");

            // 5. Procesar la informacion
            System.out.println("5. Procesando informacion:");
            while (resultado.next()) {
                int id = resultado.getInt("id_categoria");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                String estado = resultado.getString("estado");
                System.out.println(id + " | " + nombre + " | " + descripcion + " | " + estado);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } finally {
            try {
                // 6. Cerrar el query
                if (resultado != null) {
                    resultado.close();
                }
                if (sentencia != null) {
                    sentencia.close();
                }
                System.out.println("6. Query cerrado");

                // 7. Cerrar la conexion
                if (conexion != null) {
                    conexion.close();
                }
                System.out.println("7. Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
}
