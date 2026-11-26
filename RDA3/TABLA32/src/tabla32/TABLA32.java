/*======================================================================*/
/* TABLA32 - JDBC a traves de ODBC: conexion y creacion de la tabla     */
/* Conexion : puente JDBC-ODBC (PuenteJdbcOdbc.java, en este paquete)   */
/* BASE     : CONTEXTO_COMERCIAL_V3 (SQL Server en Docker, puerto 1433) */
/* AUTOR    : Matias Noboa                                              */
/*                                                                      */
/* PASOS                                                                */
/*  1. Instalado en Windows: "ODBC Driver 17 for SQL Server" (ya esta). */
/*  2. El puente sun.jdbc.odbc.JdbcOdbcDriver ya no existe desde Java 8;*/
/*     por eso se incluye PuenteJdbcOdbc.java, que hace lo mismo y      */
/*     llama a odbc32.dll de Windows.                                   */
/*  3. Cambiar la CLAVE de abajo por la de tu usuario sa.               */
/*  4. Verificar que la VM y el contenedor sqlserver esten encendidos.  */
/*  5. Cargar el puente con Class.forName (se registra en DriverManager)*/
/*  6. Abrir la conexion: DriverManager.getConnection("jdbc:odbc:...").  */
/*  7. Crear la tabla tabla32 con Statement.executeUpdate(CREATE ...).  */
/*  8. Ejecutar con Run (F6). No se insertan datos.                     */
/*======================================================================*/
package tabla32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TABLA32 {

    // Paso 3 - Datos de conexion: cambiar la clave por la de tu usuario sa
    private static final String URL = "jdbc:odbc:Driver={ODBC Driver 17 for SQL Server};"
            + "Server=localhost,1433;Database=CONTEXTO_COMERCIAL_V3;TrustServerCertificate=yes;";
    private static final String USUARIO = "sa";
    private static final String CLAVE = "tu_clave";

    public static void main(String[] args) {

        try {
            // Paso 5 - Cargar el puente JDBC-ODBC (equivale a sun.jdbc.odbc.JdbcOdbcDriver)
            Class.forName("tabla32.PuenteJdbcOdbc");

            // Paso 6 - try-with-resources: la conexion se cierra sola al terminar
            try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE)) {

                System.out.println("Conectado por JDBC a traves de ODBC.");

                // Paso 7 - CREATE TABLE (si ya existe se borra y se vuelve a crear)
                try (Statement st = con.createStatement()) {
                    st.executeUpdate("DROP TABLE IF EXISTS tabla32");
                    st.executeUpdate(
                        "CREATE TABLE tabla32 ("
                      + "  id              INT         PRIMARY KEY,"
                      + "  nombre          VARCHAR(40) NOT NULL,"
                      + "  apellido        VARCHAR(40) NOT NULL,"
                      + "  fechanacimiento DATE        NOT NULL)");
                    System.out.println("Tabla tabla32 creada (sin datos).");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el puente: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
