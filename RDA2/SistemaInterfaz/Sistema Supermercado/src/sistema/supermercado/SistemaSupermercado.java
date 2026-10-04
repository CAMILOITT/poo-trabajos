/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.supermercado;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sistema.supermercado.vistas.VistaCliente;
import sistema.supermercado.vistas.VistaInicio;

/**
 *
 * @author grupo 1
 */
public class SistemaSupermercado extends JFrame {

    public SistemaSupermercado() {
        setTitle("Sistema de Supermercado");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        CardLayout cardLayout = new CardLayout();
        JPanel panelContenedor = new JPanel(cardLayout);
        panelContenedor.setSize(500, 300);
        VistaCliente cliente = new VistaCliente(cardLayout, panelContenedor, "cliente");
        VistaInicio inicio = new VistaInicio(cardLayout, panelContenedor, "inicio");

        panelContenedor.add(inicio, "inicio");
        panelContenedor.add(cliente, "cliente");

        add(panelContenedor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaSupermercado().setVisible(true);
        });
    }

}
