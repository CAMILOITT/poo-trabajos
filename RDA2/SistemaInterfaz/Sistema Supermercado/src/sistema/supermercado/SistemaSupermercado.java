/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.supermercado;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author grupo 1
 */
public class SistemaSupermercado extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    // public static Producto buscarProducto(String codigo, ArrayList listaDeProductos)
    // {
    //     // for (int i = 0; i< listaDeProductos.size(); i++)
    //     // {
    //     //     if (codigo.equals(listaDeProductos.get(i).getCodigo()))
    //     //     {
    //     //         return listaDeProductos.get(i);
    //     //     }
    //     // }
    // }
    public SistemaSupermercado() {
        setTitle("Sistema de Supermercado");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CardLayout para gestionar las vistas
        CardLayout cardLayout = new CardLayout();
        JPanel panelContenedor = new JPanel(cardLayout);

        // Creamos e instanciamos nuestros paneles personalizados
        VentanaCliente login = new VentanaCliente("es una prueba");
        VentanaCliente login2 = new VentanaCliente("otra cosa");


        // Agregamos los PANELS al contenedor (No JFrames)
        panelContenedor.add(login, "inicio");
        panelContenedor.add(login2, "otro");

        // Agregamos el contenedor principal a la ventana
        add(panelContenedor);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new SistemaSupermercado().setVisible(true);
        });

        // CardLayout vistas = new CardLayout();
        // JPanel panelContenedor = new JPanel(vistas);
        // VentanaCliente vistaCliente = new VentanaCliente();
        
        // panelContenedor.add(vistaCliente, "cliente");

        // vistas.show(panelContenedor, "cliente");

    //     ArrayList<Producto> listaDeProductos = new ArrayList();

    //     javax.swing.SwingUtilities.invokeLater(() -> {
    //         VentanaCliente vistaCliente = new VentanaCliente();
    //         vistaCliente.setVisible(true);
    //     });;
    }
    
}
