/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionHotel {

    private final String url = "jdbc:ucanaccess://Hotel.accdb";

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


