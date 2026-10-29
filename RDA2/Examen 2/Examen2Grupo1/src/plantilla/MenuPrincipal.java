package plantilla;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Menú principal del sistema. Desde aquí se abren las demás ventanas.
 */
public class MenuPrincipal extends javax.swing.JFrame {

    // Listas con los datos del sistema, llegan desde la clase principal
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Mascota> listaElementos;

    public MenuPrincipal(ArrayList<Persona> listaPersonas, ArrayList<Mascota> listaElementos) {
        initComponents();
        this.listaPersonas = listaPersonas;
        this.listaElementos = listaElementos;
    }

    // Muestra la ventana que se le pase y esconde el menú
    private void abrirVentana(javax.swing.JFrame ventanaNueva) {
        ventanaNueva.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelBotonesMenu = new javax.swing.JPanel();
        botonRegistrarPersona = new javax.swing.JButton();
        panelSalida = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");

        panelFranjaSuperior.setBackground(new java.awt.Color(0, 102, 153));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setLayout(new java.awt.BorderLayout());

        panelBotonesMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 70, 10, 70));
        panelBotonesMenu.setLayout(new java.awt.GridLayout(0, 1, 0, 12));

        botonRegistrarPersona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonRegistrarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_persona.png"))); // NOI18N
        botonRegistrarPersona.setText("Registrar persona");
        botonRegistrarPersona.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonRegistrarPersona.setContentAreaFilled(false);
        botonRegistrarPersona.setIconTextGap(10);
        botonRegistrarPersona.setOpaque(true);
        botonRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarPersonaActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonRegistrarPersona);

        panelContenido.add(panelBotonesMenu, java.awt.BorderLayout.CENTER);

        panelSalida.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));

        botonSalir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonSalir.setContentAreaFilled(false);
        botonSalir.setOpaque(true);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelSalida.add(botonSalir);

        panelContenido.add(panelSalida, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

        panelFranjaInferior.setBackground(new java.awt.Color(0, 102, 153));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarPersonaActionPerformed
        abrirVentana(new RegistrarPersona(this, listaPersonas));
    }//GEN-LAST:event_botonRegistrarPersonaActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_botonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarPersona;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel panelBotonesMenu;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelSalida;
    // End of variables declaration//GEN-END:variables
}
