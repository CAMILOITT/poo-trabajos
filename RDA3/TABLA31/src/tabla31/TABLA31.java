/*======================================================================*/
/* TABLA31 - JDBC: conexion, crear tabla, insertar y consultar          */
/* Conexion : JDBC (driver mssql-jdbc-13.4.0.jre11.jar en Libraries)    */
/* BASE     : CONTEXTO_COMERCIAL_V3 (SQL Server en Docker, puerto 1433) */
/* AUTOR    : Matias Noboa                                              */
/*                                                                      */
/* PASOS                                                                */
/*  1. Agregar el driver: clic derecho en Libraries > Add JAR/Folder >  */
/*     lib/mssql-jdbc-13.4.0.jre11.jar (este proyecto ya lo trae).      */
/*  2. Cambiar la CLAVE de abajo por la de tu usuario sa.               */
/*  3. Verificar que la VM y el contenedor sqlserver esten encendidos.  */
/*  4. Abrir la conexion con DriverManager.getConnection(URL, ...).     */
/*  5. Crear la tabla tabla31 con Statement.executeUpdate(CREATE ...).  */
/*  6. Insertar 5 registros con PreparedStatement (los ? son valores).  */
/*  7. Consultar con SELECT * y mostrar el ResultSet.                   */
/*  8. Ejecutar con Run (F6) y revisar el resultado en la salida.       */
/*======================================================================*/
package tabla31;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TABLA31 {

    // Paso 2 - Datos de conexion: cambiar la clave por la de tu usuario sa
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CONTEXTO_COMERCIAL_V3;encrypt=true;trustServerCertificate=true";
    private static final String USUARIO = "sa";
    private static final String CLAVE = "Server12*";

    public static void main(String[] args) {

        // Paso 3 - try-with-resources: la conexion se cierra sola al terminar
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE)) {

            System.out.println("Conectado por JDBC a: "
                    + con.getMetaData().getDatabaseProductName() + " "
                    + con.getMetaData().getDatabaseProductVersion());

            // Paso 4 - CREATE TABLE (si ya existe se borra y se vuelve a crear)
            try (Statement st = con.createStatement()) {
                st.executeUpdate("DROP TABLE IF EXISTS tabla31");
                st.executeUpdate(
                    "CREATE TABLE tabla31 ("
                  + "  id              INT         PRIMARY KEY,"
                  + "  nombre          VARCHAR(40) NOT NULL,"
                  + "  apellido        VARCHAR(40) NOT NULL,"
                  + "  fechanacimiento DATE        NOT NULL)");
                System.out.println("\nTabla tabla31 creada.");
            }

            // Paso 5 - INSERT con PreparedStatement (los ? se reemplazan por valores)
            String sqlInsert = "INSERT INTO tabla31 (id, nombre, apellido, fechanacimiento) VALUES (?, ?, ?, ?)";
            int[] ids = {1, 2, 3, 4, 5};
            String[] nombres = {"Matias", "Maria", "Carlos", "Ana", "Luis"};
            String[] apellidos = {"Noboa", "Lopez", "Cuenca", "Zambrano", "Leon"};
            String[] fechas = {"2004-03-15", "2003-07-22", "2002-11-05", "2004-01-30", "2003-09-18"};
            try (PreparedStatement ps = con.prepareStatement(sqlInsert)) {
                for (int i = 0; i < ids.length; i++) {
                    ps.setInt(1, ids[i]);
                    ps.setString(2, nombres[i]);
                    ps.setString(3, apellidos[i]);
                    ps.setDate(4, Date.valueOf(fechas[i]));
                    ps.executeUpdate();
                }
                System.out.println(ids.length + " registros insertados.");
            }

            // Paso 6 - SELECT * de la tabla creada
            System.out.println("\n--- SELECT * FROM tabla31 ---");
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM tabla31 ORDER BY id")) {
                System.out.printf("%-4s %-12s %-12s %-12s%n", "ID", "NOMBRE", "APELLIDO", "NACIMIENTO");
                while (rs.next()) {
                    System.out.printf("%-4d %-12s %-12s %-12s%n",
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getDate("fechanacimiento"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
