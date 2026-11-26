package universidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameEstudiantes extends javax.swing.JFrame {

    private ArrayList<Integer> codigosCarreras = new ArrayList<>();

    public JFrameEstudiantes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        panelCampos = new javax.swing.JPanel();
        etiquetaFormulario = new javax.swing.JLabel();
        etiquetaCodigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        etiquetaCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        etiquetaNombres = new javax.swing.JLabel();
        campoNombres = new javax.swing.JTextField();
        etiquetaApellidos = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        etiquetaCarrera = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox<>();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        etiquetaEstado = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Academico - Estudiantes");
        setPreferredSize(new java.awt.Dimension(1100, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelFranjaSuperior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(15, 12));

        panelFormulario.setBackground(new java.awt.Color(255, 255, 255));
        panelFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 18, 15, 18));
        panelFormulario.setPreferredSize(new java.awt.Dimension(300, 100));
        panelFormulario.setLayout(new java.awt.BorderLayout());

        panelCampos.setBackground(new java.awt.Color(255, 255, 255));
        panelCampos.setLayout(new java.awt.GridLayout(11, 1, 0, 6));

        etiquetaFormulario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        etiquetaFormulario.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaFormulario.setText("Datos del estudiante");
        panelCampos.add(etiquetaFormulario);

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCodigo.setText("Codigo");
        panelCampos.add(etiquetaCodigo);

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);

        etiquetaCedula.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCedula.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCedula.setText("Cedula");
        panelCampos.add(etiquetaCedula);

        campoCedula.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoCedula);

        etiquetaNombres.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaNombres.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaNombres.setText("Nombres");
        panelCampos.add(etiquetaNombres);

        campoNombres.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoNombres);

        etiquetaApellidos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaApellidos.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaApellidos.setText("Apellidos");
        panelCampos.add(etiquetaApellidos);

        campoApellidos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoApellidos);

        etiquetaCarrera.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCarrera.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCarrera.setText("Carrera");
        panelCampos.add(etiquetaCarrera);

        comboCarrera.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboCarrera);

        panelFormulario.add(panelCampos, java.awt.BorderLayout.NORTH);

        panelContenido.add(panelFormulario, java.awt.BorderLayout.WEST);

        panelListado.setBackground(new java.awt.Color(236, 240, 244));
        panelListado.setLayout(new java.awt.BorderLayout(0, 8));

        panelBusqueda.setBackground(new java.awt.Color(236, 240, 244));
        panelBusqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        etiquetaBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaBuscar.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_buscar_chico.png"))); // NOI18N
        etiquetaBuscar.setText("Buscar");
        panelBusqueda.add(etiquetaBuscar);

        campoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoBuscar.setColumns(28);
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });
        panelBusqueda.add(campoBuscar);

        panelListado.add(panelBusqueda, java.awt.BorderLayout.NORTH);

        tablaEstudiantes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cedula", "Nombres", "Apellidos", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEstudiantes.setRowHeight(24);
        tablaEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstudiantesMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaEstudiantes);

        panelListado.add(scrollTabla, java.awt.BorderLayout.CENTER);

        etiquetaEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        etiquetaEstado.setForeground(new java.awt.Color(80, 90, 110));
        etiquetaEstado.setText(" ");
        panelListado.add(etiquetaEstado, java.awt.BorderLayout.SOUTH);

        panelContenido.add(panelListado, java.awt.BorderLayout.CENTER);

        panelInferior.setBackground(new java.awt.Color(236, 240, 244));
        panelInferior.setLayout(new java.awt.BorderLayout());

        panelBotones.setBackground(new java.awt.Color(236, 240, 244));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        botonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setOpaque(true);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        panelBotones.add(botonGuardar);

        botonActualizar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_editar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonActualizar.setContentAreaFilled(false);
        botonActualizar.setOpaque(true);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        panelBotones.add(botonActualizar);

        botonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setOpaque(true);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        panelBotones.add(botonEliminar);

        botonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_limpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonLimpiar.setContentAreaFilled(false);
        botonLimpiar.setOpaque(true);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(botonLimpiar);

        panelInferior.add(panelBotones, java.awt.BorderLayout.CENTER);

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_regresar.png"))); // NOI18N
        botonRegresar.setText("Regresar al menu");
        botonRegresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setOpaque(true);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        panelInferior.add(botonRegresar, java.awt.BorderLayout.EAST);

        panelContenido.add(panelInferior, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

        panelFranjaInferior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarCarreras();
        cargarEstudiantes("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarEstudiantes(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstudiantesMouseClicked
        mostrarEstudianteSeleccionado();
    }//GEN-LAST:event_tablaEstudiantesMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarEstudiante();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarEstudiante();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarEstudiante();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void cargarCarreras() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboCarrera.removeAllItems();
        codigosCarreras.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_carrera,\n" +
            "    nombre\n" +
            "FROM\n" +
            "    carreras\n" +
            "ORDER BY\n" +
            "    nombre;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosCarreras.add(resultado.getInt(1));
                comboCarrera.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarEstudiantes(String texto) {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaEstudiantes.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    e.id_estudiante,\n" +
            "    e.cedula,\n" +
            "    e.nombres,\n" +
            "    e.apellidos,\n" +
            "    ca.nombre\n" +
            "FROM\n" +
            "    estudiantes AS e\n" +
            "    INNER JOIN carreras AS ca ON ca.id_carrera = e.id_carrera\n" +
            "WHERE\n" +
            "    e.cedula LIKE ?\n" +
            "    OR e.nombres LIKE ?\n" +
            "    OR e.apellidos LIKE ?\n" +
            "ORDER BY\n" +
            "    e.apellidos,\n" +
            "    e.nombres;");
            sentencia.setString(1, "%" + texto + "%");
            sentencia.setString(2, "%" + texto + "%");
            sentencia.setString(3, "%" + texto + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[5];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                fila[4] = resultado.getString(5);
                modelo.addRow(fila);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            etiquetaEstado.setText(modelo.getRowCount() + " estudiante(s) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarEstudianteSeleccionado() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaEstudiantes.getValueAt(fila, 0).toString());
        campoCedula.setText(tablaEstudiantes.getValueAt(fila, 1).toString());
        campoNombres.setText(tablaEstudiantes.getValueAt(fila, 2).toString());
        campoApellidos.setText(tablaEstudiantes.getValueAt(fila, 3).toString());
        comboCarrera.setSelectedItem(tablaEstudiantes.getValueAt(fila, 4).toString());
    }

    private void guardarEstudiante() {
        if (!validarFormulario()) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO estudiantes (cedula, nombres, apellidos, id_carrera)\n" +
            "VALUES (?, ?, ?, ?);");
            sentencia.setString(1, campoCedula.getText().trim());
            sentencia.setString(2, campoNombres.getText().trim());
            sentencia.setString(3, campoApellidos.getText().trim());
            sentencia.setInt(4, codigosCarreras.get(comboCarrera.getSelectedIndex()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El estudiante se guardo correctamente");
            limpiarFormulario();
            cargarEstudiantes(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarEstudiante() {
        if (!haySeleccion("Primero seleccione un estudiante de la tabla")) {
            return;
        }
        if (!validarFormulario()) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE estudiantes\n" +
            "SET cedula = ?, nombres = ?, apellidos = ?, id_carrera = ?\n" +
            "WHERE id_estudiante = ?;");
            sentencia.setString(1, campoCedula.getText().trim());
            sentencia.setString(2, campoNombres.getText().trim());
            sentencia.setString(3, campoApellidos.getText().trim());
            sentencia.setInt(4, codigosCarreras.get(comboCarrera.getSelectedIndex()));
            sentencia.setInt(5, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El estudiante se actualizo correctamente");
            limpiarFormulario();
            cargarEstudiantes(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarEstudiante() {
        if (!haySeleccion("Primero seleccione un estudiante de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar al estudiante " + campoNombres.getText() + " " + campoApellidos.getText() + "?")) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM estudiantes\n" +
            "WHERE id_estudiante = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El estudiante se elimino correctamente");
            limpiarFormulario();
            cargarEstudiantes(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean validarFormulario() {
        String cedula = campoCedula.getText().trim();
        if (cedula.length() != 10 || !esNumero(cedula)) {
            mostrarAviso("La cedula debe tener 10 numeros", campoCedula);
            return false;
        }
        if (campoNombres.getText().trim().length() == 0) {
            mostrarAviso("Ingrese los nombres del estudiante", campoNombres);
            return false;
        }
        if (campoApellidos.getText().trim().length() == 0) {
            mostrarAviso("Ingrese los apellidos del estudiante", campoApellidos);
            return false;
        }
        if (comboCarrera.getItemCount() == 0) {
            mostrarAviso("Primero registre una carrera", comboCarrera);
            return false;
        }
        return true;
    }

    private boolean esNumero(String texto) {
        if (texto.length() == 0) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void limpiarFormulario() {
        campoCodigo.setText("");
        campoCedula.setText("");
        campoNombres.setText("");
        campoApellidos.setText("");
        if (comboCarrera.getItemCount() > 0) {
            comboCarrera.setSelectedIndex(0);
        }
        tablaEstudiantes.clearSelection();
        campoCedula.requestFocus();
    }

    private boolean haySeleccion(String mensaje) {
        if (campoCodigo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, mensaje, "Sin seleccion", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean confirmarEliminacion(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    private void mostrarAviso(String mensaje, java.awt.Component componente) {
        JOptionPane.showMessageDialog(this, mensaje, "Revise los datos", JOptionPane.WARNING_MESSAGE);
        componente.requestFocus();
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private void regresarAlMenu() {
        JFrameMenu menu = new JFrameMenu();
        menu.setVisible(true);
        dispose();
    }

    private void mostrarError(SQLException e) {
        String mensaje = "Error en la base de datos " + e.getMessage();
        if (e.getMessage().contains("UNIQUE")) {
            mensaje = "Ya existe un estudiante con esa cedula";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se puede eliminar el estudiante porque tiene matriculas registradas";
        }
        JOptionPane.showMessageDialog(this, mensaje, "No se pudo completar", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCarrera;
    private javax.swing.JLabel etiquetaCedula;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaFormulario;
    private javax.swing.JLabel etiquetaNombres;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelListado;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
