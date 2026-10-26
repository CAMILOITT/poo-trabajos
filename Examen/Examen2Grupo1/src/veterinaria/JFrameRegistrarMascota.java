package veterinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameRegistrarMascota extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArchivoTexto archivoTexto;
    private ArrayList<Mascota> listaDeMascotas;
    private ArrayList<Propietario> listaDePropietarios;

    public JFrameRegistrarMascota(javax.swing.JFrame ventanaAnterior, ArchivoTexto archivoTexto,
            ArrayList<Mascota> listaDeMascotas, ArrayList<Propietario> listaDePropietarios) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.archivoTexto = archivoTexto;
        this.listaDeMascotas = listaDeMascotas;
        this.listaDePropietarios = listaDePropietarios;
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMascotas.getModel();
        modeloTabla.setRowCount(0);
        for (Mascota mascota : listaDeMascotas) {
            modeloTabla.addRow(new Object[]{mascota.getCodigo(), mascota.getNombre(), mascota.getEspecie(),
                mascota.getRaza(), mascota.getEdad(), mascota.getPropietario().getNombre() + " "
                + mascota.getPropietario().getApellido()});
        }
    }

    private void cargarComboPropietarios() {
        comboPropietario.removeAllItems();
        for (Propietario propietario : listaDePropietarios) {
            comboPropietario.addItem(propietario.getCedula() + " - " + propietario.getNombre() + " "
                    + propietario.getApellido());
        }
    }

    private String generarCodigoMascota() {
        int numero = listaDeMascotas.size() + 1;
        while (ArchivoTexto.buscarMascota(listaDeMascotas, "M" + numero) != null) {
            numero++;
        }
        return "M" + numero;
    }

    private void limpiarCampos() {
        campoCodigo.setText(generarCodigoMascota());
        campoNombre.setText("");
        comboEspecie.setSelectedIndex(0);
        campoRaza.setText("");
        campoEdad.setText("");
        campoNombre.requestFocus();
    }

    private boolean validarCamposLlenos() {
        if (listaDePropietarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero registra al menos un propietario");
            return false;
        }
        if (campoNombre.getText().trim().isEmpty() || campoRaza.getText().trim().isEmpty()
                || campoEdad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos");
            return false;
        }
        return true;
    }

    private boolean validarCampoEdad() {
        try {
            Integer.parseInt(campoEdad.getText().trim());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero");
            campoEdad.requestFocus();
            return false;
        }
    }

    private boolean validarCampos() {
        return validarCamposLlenos() && validarCampoEdad();
    }

    private void registrarMascota() {
        Propietario propietario = listaDePropietarios.get(comboPropietario.getSelectedIndex());
        int edad = Integer.parseInt(campoEdad.getText().trim());
        Mascota mascota = new Mascota(campoCodigo.getText(), campoNombre.getText().trim(),
                comboEspecie.getSelectedItem().toString(), campoRaza.getText().trim(), edad, propietario);
        listaDeMascotas.add(mascota);
        propietario.agregarMascota(mascota);
        JOptionPane.showMessageDialog(this, "Mascota registrada");
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
        etiquetaCodigo = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaEspecie = new javax.swing.JLabel();
        etiquetaRaza = new javax.swing.JLabel();
        etiquetaEdad = new javax.swing.JLabel();
        etiquetaPropietario = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoCodigo = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        comboEspecie = new javax.swing.JComboBox<>();
        campoRaza = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
        comboPropietario = new javax.swing.JComboBox<>();
        scrollMascotas = new javax.swing.JScrollPane();
        tablaMascotas = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar mascota");
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

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCodigo.setText("Código");
        panelEtiquetas.add(etiquetaCodigo);

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaNombre.setText("Nombre");
        panelEtiquetas.add(etiquetaNombre);

        etiquetaEspecie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaEspecie.setText("Especie");
        panelEtiquetas.add(etiquetaEspecie);

        etiquetaRaza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaRaza.setText("Raza");
        panelEtiquetas.add(etiquetaRaza);

        etiquetaEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaEdad.setText("Edad (años)");
        panelEtiquetas.add(etiquetaEdad);

        etiquetaPropietario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaPropietario.setText("Propietario");
        panelEtiquetas.add(etiquetaPropietario);

        panelDatos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setBackground(new java.awt.Color(236, 240, 244));
        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoNombre);

        comboEspecie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato", "Ave", "Conejo", "Otro" }));
        panelCampos.add(comboEspecie);

        campoRaza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoRaza);

        campoEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoEdad);

        comboPropietario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboPropietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin propietarios" }));
        panelCampos.add(comboPropietario);

        panelDatos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelDatos, java.awt.BorderLayout.NORTH);

        scrollMascotas.setPreferredSize(new java.awt.Dimension(680, 170));

        tablaMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Especie", "Raza", "Edad", "Propietario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollMascotas.setViewportView(tablaMascotas);

        panelContenido.add(scrollMascotas, java.awt.BorderLayout.CENTER);

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
        cargarComboPropietarios();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }
        registrarMascota();
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
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRaza;
    private javax.swing.JComboBox<String> comboEspecie;
    private javax.swing.JComboBox<String> comboPropietario;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaEspecie;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPropietario;
    private javax.swing.JLabel etiquetaRaza;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JScrollPane scrollMascotas;
    private javax.swing.JTable tablaMascotas;
    // End of variables declaration//GEN-END:variables
}
