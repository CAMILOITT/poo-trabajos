package plantilla;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Registra, edita y elimina personas. Al hacer clic en una fila de la tabla
 * sus datos pasan a los campos y el botón Guardar actualiza en lugar de crear.
 */
public class RegistrarPersona extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Persona> listaPersonas;
    // Fila elegida en la tabla, -1 quiere decir que no hay ninguna
    private int filaSeleccionada = -1;

    public RegistrarPersona(javax.swing.JFrame ventanaAnterior, ArrayList<Persona> listaPersonas) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaPersonas = listaPersonas;
        cargarTabla();
    }

    // Borra la tabla y la vuelve a llenar con lo que tiene la lista
    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaPersonas.getModel();
        modeloTabla.setRowCount(0);
        for (Persona persona : listaPersonas) {
            modeloTabla.addRow(new Object[]{persona.getCedula(), persona.getNombres(),
                persona.getApellidos(), persona.getTelefono(), persona.getCorreo()});
        }
    }

    private void limpiarCampos() {
        campoCedula.setText("");
        campoNombres.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoCedula.setEditable(true);
        tablaPersonas.clearSelection();
        filaSeleccionada = -1;
        campoCedula.requestFocus();
    }

    // Revisa los campos uno por uno y avisa del primer error que encuentre
    private boolean validarCampos() {
        String cedula = campoCedula.getText().trim();
        String nombres = campoNombres.getText().trim();
        String apellidos = campoApellidos.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String correo = campoCorreo.getText().trim();

        if (Validaciones.estaVacio(cedula) || Validaciones.estaVacio(nombres) || Validaciones.estaVacio(apellidos)
                || Validaciones.estaVacio(telefono) || Validaciones.estaVacio(correo)) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos");
            return false;
        }
        if (!Validaciones.validarCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "La cédula no es válida");
            campoCedula.requestFocus();
            return false;
        }
        if (!Validaciones.validarNombre(nombres) || !Validaciones.validarNombre(apellidos)) {
            JOptionPane.showMessageDialog(this, "Los nombres y apellidos solo pueden tener letras");
            campoNombres.requestFocus();
            return false;
        }
        if (!Validaciones.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos y empezar con 09");
            campoTelefono.requestFocus();
            return false;
        }
        if (!Validaciones.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "El correo no es válido");
            campoCorreo.requestFocus();
            return false;
        }
        return true;
    }

    // Devuelve la persona con esa cédula o null si no existe
    private Persona buscarPersona(String cedula) {
        for (Persona persona : listaPersonas) {
            if (persona.getCedula().equals(cedula)) {
                return persona;
            }
        }
        return null;
    }

    // Vuelve a mostrar la ventana anterior (el menú) y cierra esta
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
        etiquetaNombres = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaCorreo = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoCedula = new javax.swing.JTextField();
        campoNombres = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoCorreo = new javax.swing.JTextField();
        scrollPersonas = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar persona");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout());

        panelFranjaSuperior.setBackground(new java.awt.Color(0, 102, 153));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(0, 15));
        panelDatos.setLayout(new java.awt.BorderLayout(10, 0));
        panelEtiquetas.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        etiquetaCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCedula.setText("Cédula");
        panelEtiquetas.add(etiquetaCedula);

        etiquetaNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaNombres.setText("Nombres");
        panelEtiquetas.add(etiquetaNombres);

        etiquetaApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaApellidos.setText("Apellidos");
        panelEtiquetas.add(etiquetaApellidos);

        etiquetaTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaTelefono.setText("Teléfono");
        panelEtiquetas.add(etiquetaTelefono);

        etiquetaCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCorreo.setText("Correo");
        panelEtiquetas.add(etiquetaCorreo);

        panelDatos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        campoCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoCedula);

        campoNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoNombres);

        campoApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoApellidos);

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoTelefono);

        campoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoCorreo);

        panelDatos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelDatos, java.awt.BorderLayout.NORTH);

        scrollPersonas.setPreferredSize(new java.awt.Dimension(560, 170));
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseClicked(evt);
            }
        });

        scrollPersonas.setViewportView(tablaPersonas);
        panelContenido.add(scrollPersonas, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));
        botonGuardar.setBackground(new java.awt.Color(255, 255, 255));
        botonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setOpaque(true);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        panelBotones.add(botonGuardar);

        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        botonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setOpaque(true);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        panelBotones.add(botonEliminar);

        botonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_limpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonLimpiar.setContentAreaFilled(false);
        botonLimpiar.setOpaque(true);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(botonLimpiar);

        botonRegresar.setBackground(new java.awt.Color(255, 255, 255));
        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_regresar.png"))); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
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

        panelFranjaInferior.setBackground(new java.awt.Color(0, 102, 153));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void tablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseClicked
        filaSeleccionada = tablaPersonas.getSelectedRow();
        if (filaSeleccionada == -1) {
            return;
        }
        Persona persona = listaPersonas.get(filaSeleccionada);
        campoCedula.setText(persona.getCedula());
        campoNombres.setText(persona.getNombres());
        campoApellidos.setText(persona.getApellidos());
        campoTelefono.setText(persona.getTelefono());
        campoCorreo.setText(persona.getCorreo());
        // La cédula no se puede cambiar cuando se edita
        campoCedula.setEditable(false);
    }//GEN-LAST:event_tablaPersonasMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String cedula = campoCedula.getText().trim();
        String nombres = campoNombres.getText().trim();
        String apellidos = campoApellidos.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String correo = campoCorreo.getText().trim();

        if (filaSeleccionada == -1) {
            // Registro nuevo
            if (buscarPersona(cedula) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe una persona con esa cédula");
                return;
            }
            listaPersonas.add(new Persona(cedula, nombres, apellidos, telefono, correo));
            JOptionPane.showMessageDialog(this, "Persona registrada");
        } else {
            // Edición de la persona elegida en la tabla
            Persona persona = listaPersonas.get(filaSeleccionada);
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setTelefono(telefono);
            persona.setCorreo(correo);
            JOptionPane.showMessageDialog(this, "Datos actualizados");
        }
        ArchivoTexto.guardarPersonas(listaPersonas);
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Primero elige una persona en la tabla");
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar a esta persona?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            listaPersonas.remove(filaSeleccionada);
            ArchivoTexto.guardarPersonas(listaPersonas);
            cargarTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JLabel etiquetaCedula;
    private javax.swing.JLabel etiquetaNombres;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JLabel etiquetaCorreo;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JScrollPane scrollPersonas;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel panelFranjaInferior;
    // End of variables declaration//GEN-END:variables
}
