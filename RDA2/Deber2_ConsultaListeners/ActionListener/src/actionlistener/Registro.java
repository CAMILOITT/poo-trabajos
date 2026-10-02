/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mnobo
 */
public class Registro implements ActionListener {
    
     private JTextField campoCedula;
 
    /**
     * Constructor: recibe el objeto JTextField del que va a leer el dato.
     * @param campoCedula el campo de texto donde el usuario escribe la cédula/RUC
     */
    public Registro(JTextField campoCedula) 
    {
        this.campoCedula = campoCedula;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String cedula = campoCedula.getText().trim();
 
        if (cedula.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null,
                "Debe ingresar una cédula o RUC válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null,
                "Cliente registrado con cédula/RUC: " + cedula,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
