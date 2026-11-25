package sistemainventario;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Prueba de conexion a SQLite siguiendo los 7 pasos de JDBC.
 *
 * La base es un archivo local incluido en la raiz del proyecto (inventario.db),
 * por lo que funciona en cualquier maquina sin instalar nada. Si el archivo
 * no existe, BaseDatos lo crea automaticamente desde el script embebido.
 */
public class ConnectionDataBase {

    /**
     * Pasos 1 y 2 de la conexion: carga el driver y abre la conexion.
     * Quien la reciba debe cerrarla (paso 7).
     */
    public static Connection getConexion() throws SQLException {
        return BaseDatos.getConexion();
    }

    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;

        try {
            // 1 y 2. Driver cargado y conexion establecida (via BaseDatos)
            conexion = getConexion();
            System.out.println("1. Driver cargado");
            File archivo = BaseDatos.resolverArchivo();
            System.out.println("2. Conexion establecida: " + archivo.getAbsolutePath()
                    + " (existe: " + archivo.exists() + ")");

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
