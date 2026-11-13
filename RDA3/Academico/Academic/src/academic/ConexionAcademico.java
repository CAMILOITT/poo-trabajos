package academic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionAcademico {

    // Ruta relativa: el archivo AcademicoDB.accdb debe estar en la carpeta raíz del proyecto
    private final String url = "jdbc:ucanaccess://AcademicoDB.accdb";

    public Connection abrirConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base " + e.getMessage());
        }
        return conexion;
    }
}
