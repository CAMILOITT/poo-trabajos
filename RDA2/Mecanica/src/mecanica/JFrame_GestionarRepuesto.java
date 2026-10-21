/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mecanica;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo1
 */
public class JFrame_GestionarRepuesto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrame_GestionarRepuesto.class.getName());
    private ArrayList<Repuesto> listaRepuestos;
    private JFrameTallerMenu menu;
    private boolean cargandoCombo = false;

    /**
     * Creates new form JFrame_GestionarRepuesto
     */
    public JFrame_GestionarRepuesto() {
        initComponents();
        this.listaRepuestos = new ArrayList<>();
    }

    public JFrame_GestionarRepuesto(ArrayList<Repuesto> listaRepuestos, JFrameTallerMenu menu) {
        initComponents();
        this.listaRepuestos = listaRepuestos;
        this.menu = menu;
        cargarTabla();
        cargarCombo();
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaRepuestos.getModel();
        modelo.setRowCount(0);
        for (Repuesto r : listaRepuestos) {
            modelo.addRow(new Object[]{
                r.getCodigo(),
                r.getNombre(),
                String.format("%.2f", r.getPrecio()),
                r.getCantidad()
            });
        }
    }

    private void limpiarCampos() {
        campoCodigoRepuesto.setText("");
        campoNombreRepuesto.setText("");
        campoPrecioRepuesto.setText("");
        campoCantidadRepuesto.setText("");
        campoCodigoRepuesto.requestFocus();
    }

    private void cargarCombo() {
        cargandoCombo = true;
        comboRepuestos.removeAllItems();
        comboRepuestos.addItem("-- Nuevo repuesto --");
        for (Repuesto r : listaRepuestos) {
            comboRepuestos.addItem(r.getCodigo() + " - " + r.getNombre());
        }
        comboRepuestos.setSelectedIndex(0);
        cargandoCombo = false;
        modoNuevo();
    }

    private void modoNuevo() {
        limpiarCampos();
        campoCodigoRepuesto.setEditable(true);
        botonRegistrar.setText("Registrar");
    }

    private void modoEditar(Repuesto r) {
        campoCodigoRepuesto.setText(r.getCodigo());
        campoNombreRepuesto.setText(r.getNombre());
        campoPrecioRepuesto.setText(String.format("%.2f", r.getPrecio()).replace(",", "."));
        campoCantidadRepuesto.setText(String.valueOf(r.getCantidad()));
        campoCodigoRepuesto.setEditable(false);
        botonRegistrar.setText("Guardar cambios");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCentro = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        panelEtiquetasRepuesto = new javax.swing.JPanel();
        etiquetaRepuesto = new javax.swing.JLabel();
        etiquetaCodigoRepuesto = new javax.swing.JLabel();
        etiquetaNombreRepuesto = new javax.swing.JLabel();
        etiquetaPrecioRepuesto = new javax.swing.JLabel();
        etiquetaCantidadRepuesto = new javax.swing.JLabel();
        PanelEntradasRepuesto = new javax.swing.JPanel();
        comboRepuestos = new javax.swing.JComboBox<>();
        campoCodigoRepuesto = new javax.swing.JTextField();
        campoNombreRepuesto = new javax.swing.JTextField();
        campoPrecioRepuesto = new javax.swing.JTextField();
        campoCantidadRepuesto = new javax.swing.JTextField();
        scrollRepuestos = new javax.swing.JScrollPane();
        tablaRepuestos = new javax.swing.JTable();
        PanelBotones = new javax.swing.JPanel();
        botonRegistrar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        BotonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de repuestos");

        PanelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        PanelCentro.setLayout(new java.awt.BorderLayout(0, 15));

        PanelDatos.setLayout(new java.awt.BorderLayout(10, 0));

        panelEtiquetasRepuesto.setLayout(new java.awt.GridLayout(0, 1, 0, 15));

        etiquetaRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaRepuesto.setText("Repuesto:");
        panelEtiquetasRepuesto.add(etiquetaRepuesto);

        etiquetaCodigoRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaCodigoRepuesto.setText("Código:");
        panelEtiquetasRepuesto.add(etiquetaCodigoRepuesto);

        etiquetaNombreRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaNombreRepuesto.setText("Nombre:");
        panelEtiquetasRepuesto.add(etiquetaNombreRepuesto);

        etiquetaPrecioRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaPrecioRepuesto.setText("Precio ($):");
        panelEtiquetasRepuesto.add(etiquetaPrecioRepuesto);

        etiquetaCantidadRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaCantidadRepuesto.setText("Cantidad:");
        panelEtiquetasRepuesto.add(etiquetaCantidadRepuesto);

        PanelDatos.add(panelEtiquetasRepuesto, java.awt.BorderLayout.WEST);

        PanelEntradasRepuesto.setLayout(new java.awt.GridLayout(0, 1, 0, 15));

        comboRepuestos.addActionListener(this::comboRepuestosActionPerformed);
        PanelEntradasRepuesto.add(comboRepuestos);

        campoCodigoRepuesto.addActionListener(this::campoCodigoRepuestoActionPerformed);
        PanelEntradasRepuesto.add(campoCodigoRepuesto);
        PanelEntradasRepuesto.add(campoNombreRepuesto);
        PanelEntradasRepuesto.add(campoPrecioRepuesto);
        PanelEntradasRepuesto.add(campoCantidadRepuesto);

        PanelDatos.add(PanelEntradasRepuesto, java.awt.BorderLayout.CENTER);

        PanelCentro.add(PanelDatos, java.awt.BorderLayout.NORTH);

        tablaRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio ($)", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRepuestos.setViewportView(tablaRepuestos);

        PanelCentro.add(scrollRepuestos, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        PanelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 15));

        botonRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        botonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mecanica/imagenes/icono_guardar.png"))); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.setIconTextGap(6);
        botonRegistrar.addActionListener(this::botonRegistrarActionPerformed);
        PanelBotones.add(botonRegistrar);

        botonLimpiar.setBackground(new java.awt.Color(255, 255, 204));
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mecanica/imagenes/icono_limpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setIconTextGap(6);
        botonLimpiar.addActionListener(this::botonLimpiarActionPerformed);
        PanelBotones.add(botonLimpiar);

        BotonVolver.setBackground(new java.awt.Color(255, 51, 51));
        BotonVolver.setForeground(new java.awt.Color(255, 255, 255));
        BotonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mecanica/imagenes/icono_volver.png"))); // NOI18N
        BotonVolver.setText("Volver");
        BotonVolver.setIconTextGap(6);
        BotonVolver.addActionListener(this::BotonVolverActionPerformed);
        PanelBotones.add(BotonVolver);

        getContentPane().add(PanelBotones, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed

        String codigo = campoCodigoRepuesto.getText().trim();
        String nombre = campoNombreRepuesto.getText().trim();
        String precioTexto = campoPrecioRepuesto.getText().trim();
        String cantidadTexto = campoCantidadRepuesto.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || precioTexto.isEmpty() || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        float precio;
        int cantidad;
        try {
            precio = Float.parseFloat(precioTexto.replace(",", "."));
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser números.");
            return;
        }

        if (precio <= 0 || cantidad < 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0 y la cantidad no puede ser negativa.");
            return;
        }

        int indice = comboRepuestos.getSelectedIndex();

        if (indice <= 0) {
            for (Repuesto r : listaRepuestos) {
                if (r.getCodigo().equalsIgnoreCase(codigo)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un repuesto con ese código.");
                    return;
                }
            }
            listaRepuestos.add(new Repuesto(codigo, nombre, precio, cantidad));
            JOptionPane.showMessageDialog(this, "Repuesto registrado correctamente.");
        } else {
            Repuesto r = listaRepuestos.get(indice - 1);
            r.setNombre(nombre);
            r.setPrecio(precio);
            r.setCantidad(cantidad);
            JOptionPane.showMessageDialog(this, "Repuesto actualizado correctamente.");
        }

        cargarTabla();
        cargarCombo();
        ArchivoDatos.guardarRepuestos(listaRepuestos);
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        comboRepuestos.setSelectedIndex(0);
        modoNuevo();

    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActionPerformed
        // TODO add your handling code here:
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonVolverActionPerformed

    private void campoCodigoRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCodigoRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCodigoRepuestoActionPerformed

    private void comboRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRepuestosActionPerformed
        // TODO add your handling code here:
        if (cargandoCombo) {
            return;
        }
        int indice = comboRepuestos.getSelectedIndex();
        if (indice <= 0) {
            modoNuevo();
        } else {
            modoEditar(listaRepuestos.get(indice - 1));
        }
    }//GEN-LAST:event_comboRepuestosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrame_GestionarRepuesto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVolver;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelEntradasRepuesto;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField campoCantidadRepuesto;
    private javax.swing.JTextField campoCodigoRepuesto;
    private javax.swing.JTextField campoNombreRepuesto;
    private javax.swing.JTextField campoPrecioRepuesto;
    private javax.swing.JComboBox<String> comboRepuestos;
    private javax.swing.JLabel etiquetaCantidadRepuesto;
    private javax.swing.JLabel etiquetaCodigoRepuesto;
    private javax.swing.JLabel etiquetaNombreRepuesto;
    private javax.swing.JLabel etiquetaPrecioRepuesto;
    private javax.swing.JLabel etiquetaRepuesto;
    private javax.swing.JPanel panelEtiquetasRepuesto;
    private javax.swing.JScrollPane scrollRepuestos;
    private javax.swing.JTable tablaRepuestos;
    // End of variables declaration//GEN-END:variables
}
