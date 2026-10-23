package plantilla;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Menú principal del sistema. Desde aquí se abren las demás ventanas.
 */
public class MenuPrincipal extends javax.swing.JFrame {

    // Listas con los datos del sistema, llegan desde la clase principal
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Elemento> listaElementos;

    public MenuPrincipal(ArrayList<Persona> listaPersonas, ArrayList<Elemento> listaElementos) {
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
        botonRegistrarElemento = new javax.swing.JButton();
        botonBuscarPersona = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        panelSalida = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");
        getContentPane().setLayout(new java.awt.BorderLayout());

        panelFranjaSuperior.setBackground(new java.awt.Color(0, 102, 153));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setLayout(new java.awt.BorderLayout());
        panelBotonesMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 70, 10, 70));
        panelBotonesMenu.setLayout(new java.awt.GridLayout(0, 1, 0, 12));
        botonRegistrarPersona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonRegistrarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_persona.png"))); // NOI18N
        botonRegistrarPersona.setText("Registrar persona");
        botonRegistrarPersona.setIconTextGap(10);
        botonRegistrarPersona.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonRegistrarPersona.setBackground(new java.awt.Color(255, 255, 255));
        botonRegistrarPersona.setContentAreaFilled(false);
        botonRegistrarPersona.setOpaque(true);
        botonRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarPersonaActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonRegistrarPersona);

        botonRegistrarElemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonRegistrarElemento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_elemento.png"))); // NOI18N
        botonRegistrarElemento.setText("Registrar elemento");
        botonRegistrarElemento.setIconTextGap(10);
        botonRegistrarElemento.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonRegistrarElemento.setBackground(new java.awt.Color(255, 255, 255));
        botonRegistrarElemento.setContentAreaFilled(false);
        botonRegistrarElemento.setOpaque(true);
        botonRegistrarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarElementoActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonRegistrarElemento);

        botonBuscarPersona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_buscar.png"))); // NOI18N
        botonBuscarPersona.setText("Buscar persona");
        botonBuscarPersona.setIconTextGap(10);
        botonBuscarPersona.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonBuscarPersona.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarPersona.setContentAreaFilled(false);
        botonBuscarPersona.setOpaque(true);
        botonBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPersonaActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonBuscarPersona);

        botonReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_reporte.png"))); // NOI18N
        botonReportes.setText("Reportes");
        botonReportes.setIconTextGap(10);
        botonReportes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonReportes.setBackground(new java.awt.Color(255, 255, 255));
        botonReportes.setContentAreaFilled(false);
        botonReportes.setOpaque(true);
        botonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonReportes);

        panelContenido.add(panelBotonesMenu, java.awt.BorderLayout.CENTER);

        panelSalida.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));
        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
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

    private void botonRegistrarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarElementoActionPerformed
        abrirVentana(new RegistrarElemento(this, listaElementos));
    }//GEN-LAST:event_botonRegistrarElementoActionPerformed

    private void botonBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPersonaActionPerformed
        abrirVentana(new BuscarPersona(this, listaPersonas));
    }//GEN-LAST:event_botonBuscarPersonaActionPerformed

    private void botonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesActionPerformed
        abrirVentana(new Reportes(this, listaElementos));
    }//GEN-LAST:event_botonReportesActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_botonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelBotonesMenu;
    private javax.swing.JButton botonRegistrarPersona;
    private javax.swing.JButton botonRegistrarElemento;
    private javax.swing.JButton botonBuscarPersona;
    private javax.swing.JButton botonReportes;
    private javax.swing.JPanel panelSalida;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel panelFranjaInferior;
    // End of variables declaration//GEN-END:variables
}
