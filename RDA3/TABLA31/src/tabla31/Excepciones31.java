/*======================================================================*/
/* EXCEPCIONES31 - JDBC: que pasa cuando algo no existe                 */
/* Cada prueba provoca un error a proposito y lo captura con catch.     */
/* AUTOR    : Matias Noboa                                              */
/*                                                                      */
/* PASOS                                                                */
/*  1. Cambiar la CLAVE por la de tu usuario sa (para las pruebas 3-6). */
/*  2. Tener encendida la VM y el contenedor sqlserver.                 */
/*  3. Clic derecho en este archivo > Run File (Shift+F6).              */
/*  4. Leer en la salida el mensaje de cada excepcion.                  */
/*                                                                      */
/* PRUEBAS                                                              */
/*  1. No existe el driver          -> ClassNotFoundException           */
/*  2. No existe la conexion        -> SQLException (servidor/puerto)   */
/*  3. No existe la base de datos   -> SQLException                     */
/*  4. No existe la tabla           -> SQLException                     */
/*  5. No existe el tipo de dato    -> SQLException                     */
/*  6. No existe la desconexion     -> SQLException (conexion cerrada)  */
/*  7. Conexion nula (no se creo)   -> NullPointerException             */
/*======================================================================*/
package tabla31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Excepciones31 {

    private static final String SERVIDOR = "jdbc:sqlserver://localhost:1433;";
    private static final String OPCIONES = ";encrypt=true;trustServerCertificate=true;loginTimeout=3";
    private static final String BD = "databaseName=CONTEXTO_COMERCIAL_V3";
    private static final String USUARIO = "sa";
    private static final String CLAVE = "tu_clave";

    public static void main(String[] args) {

        // Prueba 1 - No existe el driver (el nombre de la clase esta mal)
        System.out.println("1. NO EXISTE EL DRIVER");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriverXX");
        } catch (ClassNotFoundException e) {
            System.out.println("   ClassNotFoundException: " + e.getMessage());
        }

        // Prueba 2 - No existe la conexion (puerto equivocado: 1444 en vez de 1433)
        System.out.println("\n2. NO EXISTE LA CONEXION");
        try (Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1444;" + BD + OPCIONES, USUARIO, CLAVE)) {
            System.out.println("   Conectado (no deberia)");
        } catch (SQLException e) {
            System.out.println("   SQLException: " + e.getMessage());
        }

        // Prueba 3 - No existe la base de datos
        System.out.println("\n3. NO EXISTE LA BASE DE DATOS");
        try (Connection con = DriverManager.getConnection(
                SERVIDOR + "databaseName=BD_NO_EXISTE" + OPCIONES, USUARIO, CLAVE)) {
            System.out.println("   Conectado (no deberia)");
        } catch (SQLException e) {
            System.out.println("   SQLException: " + e.getMessage());
        }

        // Pruebas 4, 5 y 6 - con una conexion valida a la base real
        try (Connection con = DriverManager.getConnection(SERVIDOR + BD + OPCIONES, USUARIO, CLAVE)) {

            // Prueba 4 - No existe la tabla
            System.out.println("\n4. NO EXISTE LA TABLA");
            try (Statement st = con.createStatement()) {
                st.executeQuery("SELECT * FROM tabla_no_existe");
            } catch (SQLException e) {
                System.out.println("   SQLException: " + e.getMessage());
            }

            // Prueba 5 - No existe el tipo de dato
            System.out.println("\n5. NO EXISTE EL TIPO DE DATO");
            try (Statement st = con.createStatement()) {
                st.executeUpdate("CREATE TABLE tabla_prueba (id TIPO_NO_EXISTE)");
            } catch (SQLException e) {
                System.out.println("   SQLException: " + e.getMessage());
            }

            // Prueba 6 - No existe la desconexion: se cierra y luego se intenta usar
            System.out.println("\n6. CONEXION CERRADA (YA SE DESCONECTO)");
            con.close();
            try (Statement st = con.createStatement()) {
                st.executeUpdate("DROP TABLE IF EXISTS tabla_prueba");
            } catch (SQLException e) {
                System.out.println("   SQLException: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("\nNo se pudo abrir la conexion para las pruebas 4 a 6: " + e.getMessage());
            System.out.println("Revisar la CLAVE.");
        }

        // Prueba 7 - La conexion nunca se creo (es null)
        System.out.println("\n7. CONEXION NULA");
        Connection conNula = null;
        try {
            conNula.createStatement();
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: la conexion es null");
        } catch (Exception e) {
            System.out.println("   Exception: " + e.getMessage());
        }
    }
}
