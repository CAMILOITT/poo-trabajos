package veterinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameRegistrarPropietario extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArchivoTexto archivoTexto;
    private ArrayList<Propietario> listaDePropietarios;

    public JFrameRegistrarPropietario(javax.swing.JFrame ventanaAnterior, ArchivoTexto archivoTexto,
            ArrayList<Propietario> listaDePropietarios) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.archivoTexto = archivoTexto;
        this.listaDePropietarios = listaDePropietarios;
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaPropietarios.getModel();
        modeloTabla.setRowCount(0);
        for (Propietario propietario : listaDePropietarios) {
            modeloTabla.addRow(new Object[]{propietario.getCedula(), propietario.getNombre(),
                propietario.getApellido(), propietario.getTelefono(), propietario.getListaDeMascotas().size()});
        }
    }

    private void limpiarCampos() {
        campoCedula.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoTelefono.setText("");
        campoCedula.requestFocus();
    }

    private boolean tieneDiezNumeros(String texto) {
        if (texto.length() != 10) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validarCamposLlenos() {
        if (campoCedula.getText().trim().isEmpty() || campoNombre.getText().trim().isEmpty()
                || campoApellido.getText().trim().isEmpty() || campoTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos");
            return false;
        }
        return true;
    }

    private boolean validarCampoCedula() {
        if (!tieneDiezNumeros(campoCedula.getText().trim())) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 números");
            campoCedula.requestFocus();
            return false;
        }
        if (ArchivoTexto.buscarPropietario(listaDePropietarios, campoCedula.getText().trim()) != null) {
            JOptionPane.showMessageDialog(this, "Ya existe un propietario con esa cédula");
            campoCedula.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validarCampoTelefono() {
        if (!tieneDiezNumeros(campoTelefono.getText().trim())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 números");
            campoTelefono.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validarCampos() {
        return validarCamposLlenos() && validarCampoCedula() && validarCampoTelefono();
    }

    private void registrarPropietario() {
        Propietario propietario = new Propietario(campoCedula.getText().trim(), campoNombre.getText().trim(),
                campoApellido.getText().trim(), campoTelefono.getText().trim(), new ArrayList<>());
        listaDePropietarios.add(propietario);
        JOptionPane.showMessageDialog(this, "Propietario registrado");
    }

    private void regresar() {
        ventanaAnterior.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        etiquetaCedula = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaApellido = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoCedula = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoApellido = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        scrollPropietarios = new javax.swing.JScrollPane();
        tablaPropietarios = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar propietario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelFranjaSuperior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(0, 15));

        panelDatos.setBackground(new java.awt.Color(236, 240, 244));
        panelDatos.setLayout(new java.awt.BorderLayout(10, 0));

        panelEtiquetas.setBackground(new java.awt.Color(236, 240, 244));
        panelEtiquetas.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        etiquetaCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCedula.setText("Cédula");
        panelEtiquetas.add(etiquetaCedula);

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaNombre.setText("Nombre");
        panelEtiquetas.add(etiquetaNombre);

        etiquetaApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaApellido.setText("Apellido");
        panelEtiquetas.add(etiquetaApellido);

        etiquetaTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaTelefono.setText("Teléfono");
        panelEtiquetas.add(etiquetaTelefono);

        panelDatos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setBackground(new java.awt.Color(236, 240, 244));
        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        campoCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoCedula);

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoNombre);

        campoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoApellido);

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoTelefono);

        panelDatos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelDatos, java.awt.BorderLayout.NORTH);

        scrollPropietarios.setPreferredSize(new java.awt.Dimension(620, 170));

        tablaPropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Teléfono", "Mascotas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPropietarios.setViewportView(tablaPropietarios);

        panelContenido.add(scrollPropietarios, java.awt.BorderLayout.CENTER);

        panelBotones.setBackground(new java.awt.Color(236, 240, 244));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        botonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setOpaque(true);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        panelBotones.add(botonGuardar);

        botonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_limpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonLimpiar.setContentAreaFilled(false);
        botonLimpiar.setOpaque(true);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(botonLimpiar);

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_regresar.png"))); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setOpaque(true);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        panelBotones.add(botonRegresar);

        panelContenido.add(panelBotones, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

        panelFranjaInferior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }
        registrarPropietario();
        archivoTexto.guardarDatos();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel etiquetaApellido;
    private javax.swing.JLabel etiquetaCedula;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JScrollPane scrollPropietarios;
    private javax.swing.JTable tablaPropietarios;
    // End of variables declaration//GEN-END:variables
}
