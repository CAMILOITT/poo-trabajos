/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keylistener;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author grupo 1
 */
public class login extends JFrame implements KeyListener{
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JLabel mensaje;
 
    public login() {
        super("Login simple");
 
        campoUsuario = new JTextField(12);
        campoContrasena = new JPasswordField(12);
        mensaje = new JLabel(" ");
 
        campoContrasena.addKeyListener(this);
 
        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Usuario:"));
        add(campoUsuario);
        add(new JLabel("Contraseña:"));
        add(campoContrasena);
        add(new JLabel()); // celda vacía para alinear la fila del mensaje
        add(mensaje);
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String usuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());
 
            if (usuario.equals("admin") && contrasena.equals("1234")) {
                mensaje.setText("Bienvenido, " + usuario + "!");
            } else {
                mensaje.setText("Usuario o contraseña incorrectos.");
            }
        }
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        // Vacío: obligatorio por la interfaz, no se usa en este ejemplo.
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
        // Vacío: obligatorio por la interfaz, no se usa en este ejemplo.
    }
 
}
