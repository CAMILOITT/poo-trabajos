package veterinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JFrameMenuPrincipal extends javax.swing.JFrame {

    private ArchivoTexto archivoTexto;
    private ArrayList<Propietario> listaDePropietarios;
    private ArrayList<Veterinario> listaDeVeterinarios;
    private ArrayList<Mascota> listaDeMascotas;
    private ArrayList<Cita> listaDeCitas;

    public JFrameMenuPrincipal(ArchivoTexto archivoTexto, ArrayList<Propietario> listaDePropietarios,
            ArrayList<Veterinario> listaDeVeterinarios, ArrayList<Mascota> listaDeMascotas,
            ArrayList<Cita> listaDeCitas) {
        initComponents();
        this.archivoTexto = archivoTexto;
        this.listaDePropietarios = listaDePropietarios;
        this.listaDeVeterinarios = listaDeVeterinarios;
        this.listaDeMascotas = listaDeMascotas;
        this.listaDeCitas = listaDeCitas;
    }

    public static void main(String args[]) {
        ArrayList<Propietario> listaDePropietarios = new ArrayList<>();
        ArrayList<Veterinario> listaDeVeterinarios = new ArrayList<>();
        ArrayList<Mascota> listaDeMascotas = new ArrayList<>();
        ArrayList<Cita> listaDeCitas = new ArrayList<>();

        ArchivoTexto archivoTexto = new ArchivoTexto(listaDePropietarios, listaDeVeterinarios, listaDeMascotas,
                listaDeCitas);
        archivoTexto.recuperarDatos();

        JFrameMenuPrincipal menu = new JFrameMenuPrincipal(archivoTexto, listaDePropietarios, listaDeVeterinarios,
                listaDeMascotas, listaDeCitas);
        menu.setVisible(true);
    }

    private void abrirVentana(javax.swing.JFrame ventanaNueva) {
        ventanaNueva.setVisible(true);
        this.setVisible(false);
    }

    private boolean confirmarSalida() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Salir",
                JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelBotonesMenu = new javax.swing.JPanel();
        botonRegistrarPropietario = new javax.swing.JButton();
        botonRegistrarMascota = new javax.swing.JButton();
        botonGestionarCitas = new javax.swing.JButton();
        botonConsultarCitas = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        panelSalida = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica veterinaria");

        panelFranjaSuperior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setLayout(new java.awt.BorderLayout());

        panelBotonesMenu.setBackground(new java.awt.Color(236, 240, 244));
        panelBotonesMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 70, 10, 70));
        panelBotonesMenu.setLayout(new java.awt.GridLayout(0, 1, 0, 12));

        botonRegistrarPropietario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonRegistrarPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_propietario.png"))); // NOI18N
        botonRegistrarPropietario.setText("Registrar propietario");
        botonRegistrarPropietario.setIconTextGap(10);
        botonRegistrarPropietario.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonRegistrarPropietario.setContentAreaFilled(false);
        botonRegistrarPropietario.setOpaque(true);
        botonRegistrarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarPropietarioActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonRegistrarPropietario);

        botonRegistrarMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonRegistrarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_mascota.png"))); // NOI18N
        botonRegistrarMascota.setText("Registrar mascota");
        botonRegistrarMascota.setIconTextGap(10);
        botonRegistrarMascota.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonRegistrarMascota.setContentAreaFilled(false);
        botonRegistrarMascota.setOpaque(true);
        botonRegistrarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarMascotaActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonRegistrarMascota);

        botonGestionarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonGestionarCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_cita.png"))); // NOI18N
        botonGestionarCitas.setText("Agendar y cancelar citas");
        botonGestionarCitas.setIconTextGap(10);
        botonGestionarCitas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonGestionarCitas.setContentAreaFilled(false);
        botonGestionarCitas.setOpaque(true);
        botonGestionarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarCitasActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonGestionarCitas);

        botonConsultarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonConsultarCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_consulta.png"))); // NOI18N
        botonConsultarCitas.setText("Consultar citas");
        botonConsultarCitas.setIconTextGap(10);
        botonConsultarCitas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonConsultarCitas.setContentAreaFilled(false);
        botonConsultarCitas.setOpaque(true);
        botonConsultarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarCitasActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonConsultarCitas);

        botonReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_reporte.png"))); // NOI18N
        botonReportes.setText("Reportes");
        botonReportes.setIconTextGap(10);
        botonReportes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172), 2), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        botonReportes.setContentAreaFilled(false);
        botonReportes.setOpaque(true);
        botonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesActionPerformed(evt);
            }
        });
        panelBotonesMenu.add(botonReportes);

        panelContenido.add(panelBotonesMenu, java.awt.BorderLayout.CENTER);

        panelSalida.setBackground(new java.awt.Color(236, 240, 244));
        panelSalida.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));

        botonSalir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
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

        panelFranjaInferior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarPropietarioActionPerformed
        abrirVentana(new JFrameRegistrarPropietario(this, archivoTexto, listaDePropietarios));
    }//GEN-LAST:event_botonRegistrarPropietarioActionPerformed

    private void botonRegistrarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarMascotaActionPerformed
        abrirVentana(new JFrameRegistrarMascota(this, archivoTexto, listaDeMascotas, listaDePropietarios));
    }//GEN-LAST:event_botonRegistrarMascotaActionPerformed

    private void botonGestionarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarCitasActionPerformed
        abrirVentana(new JFrameGestionarCitas(this, archivoTexto, listaDeCitas, listaDeMascotas,
                listaDeVeterinarios));
    }//GEN-LAST:event_botonGestionarCitasActionPerformed

    private void botonConsultarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarCitasActionPerformed
        abrirVentana(new JFrameConsultarCitas(this, listaDeCitas));
    }//GEN-LAST:event_botonConsultarCitasActionPerformed

    private void botonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesActionPerformed
        abrirVentana(new JFrameReportes(this, listaDeMascotas));
    }//GEN-LAST:event_botonReportesActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        if (confirmarSalida()) {
            System.exit(0);
        }
    }//GEN-LAST:event_botonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultarCitas;
    private javax.swing.JButton botonGestionarCitas;
    private javax.swing.JButton botonRegistrarMascota;
    private javax.swing.JButton botonRegistrarPropietario;
    private javax.swing.JButton botonReportes;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel panelBotonesMenu;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelSalida;
    // End of variables declaration//GEN-END:variables
}
