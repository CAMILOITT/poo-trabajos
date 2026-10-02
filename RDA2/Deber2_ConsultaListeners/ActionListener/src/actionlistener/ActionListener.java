/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actionlistener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author grupo 1
 */
public class ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana = new JFrame("Registro de cliente");
 
        JLabel titulo = new JLabel("Registro de cliente");
        JLabel etiquetaCedula = new JLabel("Cédula o RUC:");
        JTextField campoCedula = new JTextField(15);
        JButton botonRegistrar = new JButton("Registrar");
 
        // Se crea el OBJETO del listener, pasando el campo por su constructor
        Registro listener = new Registro(campoCedula);
 
        // Se registra el listener en el botón
        botonRegistrar.addActionListener(listener);
 
        JPanel panel = new JPanel();
        panel.add(titulo);
        panel.add(etiquetaCedula);
        panel.add(campoCedula);
        panel.add(botonRegistrar);
 
        ventana.add(panel);
        ventana.setSize(300, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }
    
}
