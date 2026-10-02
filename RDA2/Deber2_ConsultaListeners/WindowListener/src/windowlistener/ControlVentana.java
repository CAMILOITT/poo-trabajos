/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windowlistener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
/**
 *
 * @author grupo1
 */
public class ControlVentana implements java.awt.event.WindowListener {

    private JLabel mensaje;

    // Constructor que recibe la etiqueta donde se mostrarán los mensajes
    public ControlVentana(JLabel mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        mensaje.setText("La ventana se abrio");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando la ventana...");
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("La ventana se minimizó");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        mensaje.setText("¡Volviste! La ventana se restauro");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("La ventana esta activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("La ventana dejo de estar activa");
    }
}
