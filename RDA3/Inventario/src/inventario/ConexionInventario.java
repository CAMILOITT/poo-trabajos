package inventario;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionInventario {

    private final String archivo = "inventario.db";
    private final String url = "jdbc:sqlite:" + archivo;

    public Connection abrirConexion() {
        Connection conexion = null;
        if (!existeBaseDatos()) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo " + archivo, "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return conexion;
        }
        try {
            conexion = DriverManager.getConnection(url);
            activarClavesForaneas(conexion);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base " + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }

    private boolean existeBaseDatos() {
        File base = new File(archivo);
        return base.exists();
    }

    private void activarClavesForaneas(Connection conexion) throws SQLException {
        Statement sentencia = conexion.createStatement();
        sentencia.execute("PRAGMA foreign_keys = ON");
        sentencia.close();
    }
}
