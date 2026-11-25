package universidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameMatriculas extends javax.swing.JFrame {

    private ArrayList<Integer> codigosEstudiantes = new ArrayList<>();
    private ArrayList<Integer> codigosAsignaturas = new ArrayList<>();

    public JFrameMatriculas() {
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
        etiquetaEstudiante = new javax.swing.JLabel();
        comboEstudiante = new javax.swing.JComboBox<>();
        etiquetaAsignatura = new javax.swing.JLabel();
        comboAsignatura = new javax.swing.JComboBox<>();
        etiquetaPeriodo = new javax.swing.JLabel();
        comboPeriodo = new javax.swing.JComboBox<>();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaMatriculas = new javax.swing.JTable();
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
        setTitle("Sistema Academico - Matriculas");
        setPreferredSize(new java.awt.Dimension(1100, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelFranjaSuperior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        panelFranjaSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 5));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(15, 12));

        panelFormulario.setBackground(new java.awt.Color(255, 255, 255));
        panelFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 18, 15, 18));
        panelFormulario.setPreferredSize(new java.awt.Dimension(300, 100));
        panelFormulario.setLayout(new java.awt.BorderLayout());

        panelCampos.setBackground(new java.awt.Color(255, 255, 255));
        panelCampos.setLayout(new java.awt.GridLayout(9, 1, 0, 6));

        etiquetaFormulario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        etiquetaFormulario.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaFormulario.setText("Datos de la matricula");
        panelCampos.add(etiquetaFormulario);
        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCodigo.setText("Codigo");
        panelCampos.add(etiquetaCodigo);
        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);
        etiquetaEstudiante.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaEstudiante.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaEstudiante.setText("Estudiante");
        panelCampos.add(etiquetaEstudiante);
        comboEstudiante.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboEstudiante);
        etiquetaAsignatura.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaAsignatura.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaAsignatura.setText("Asignatura");
        panelCampos.add(etiquetaAsignatura);
        comboAsignatura.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboAsignatura);
        etiquetaPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaPeriodo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaPeriodo.setText("Periodo");
        panelCampos.add(etiquetaPeriodo);
        comboPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        comboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025-1", "2025-2", "2026-1", "2026-2" }));
        panelCampos.add(comboPeriodo);
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

        tablaMatriculas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Estudiante", "Asignatura", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMatriculas.setRowHeight(24);
        tablaMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMatriculasMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaMatriculas);

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

        botonGuardar.setBackground(new java.awt.Color(255, 255, 255));
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
        botonActualizar.setBackground(new java.awt.Color(255, 255, 255));
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
        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
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
        botonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
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

        botonRegresar.setBackground(new java.awt.Color(255, 255, 255));
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
        panelFranjaInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 5));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarEstudiantes();
        cargarAsignaturas();
        cargarMatriculas("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarMatriculas(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMatriculasMouseClicked
        mostrarMatriculaSeleccionada();
    }//GEN-LAST:event_tablaMatriculasMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarMatricula();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarMatricula();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarMatricula();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void cargarEstudiantes() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboEstudiante.removeAllItems();
        codigosEstudiantes.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    e.id_estudiante,\n" +
            "    e.apellidos || ' ' || e.nombres || ' - ' || e.cedula\n" +
            "FROM\n" +
            "    estudiantes AS e\n" +
            "ORDER BY\n" +
            "    e.apellidos,\n" +
            "    e.nombres;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosEstudiantes.add(resultado.getInt(1));
                comboEstudiante.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarAsignaturas() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboAsignatura.removeAllItems();
        codigosAsignaturas.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_asignatura,\n" +
            "    nombre\n" +
            "FROM\n" +
            "    asignaturas\n" +
            "ORDER BY\n" +
            "    nombre;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosAsignaturas.add(resultado.getInt(1));
                comboAsignatura.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarMatriculas(String texto) {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaMatriculas.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    m.id_matricula,\n" +
            "    e.apellidos || ' ' || e.nombres || ' - ' || e.cedula,\n" +
            "    a.nombre,\n" +
            "    m.periodo\n" +
            "FROM\n" +
            "    matriculas AS m\n" +
            "    INNER JOIN estudiantes AS e ON e.id_estudiante = m.id_estudiante\n" +
            "    INNER JOIN asignaturas AS a ON a.id_asignatura = m.id_asignatura\n" +
            "WHERE\n" +
            "    e.apellidos LIKE ?\n" +
            "    OR e.nombres LIKE ?\n" +
            "    OR e.cedula LIKE ?\n" +
            "    OR a.nombre LIKE ?\n" +
            "ORDER BY\n" +
            "    m.periodo DESC,\n" +
            "    e.apellidos;");
            sentencia.setString(1, "%" + texto + "%");
            sentencia.setString(2, "%" + texto + "%");
            sentencia.setString(3, "%" + texto + "%");
            sentencia.setString(4, "%" + texto + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[4];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                modelo.addRow(fila);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            etiquetaEstado.setText(modelo.getRowCount() + " matricula(s) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarMatriculaSeleccionada() {
        int fila = tablaMatriculas.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaMatriculas.getValueAt(fila, 0).toString());
        comboEstudiante.setSelectedItem(tablaMatriculas.getValueAt(fila, 1).toString());
        comboAsignatura.setSelectedItem(tablaMatriculas.getValueAt(fila, 2).toString());
        comboPeriodo.setSelectedItem(tablaMatriculas.getValueAt(fila, 3).toString());
    }

    private void guardarMatricula() {
        if (!validarFormulario()) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO matriculas (id_estudiante, id_asignatura, periodo)\n" +
            "VALUES (?, ?, ?);");
            sentencia.setInt(1, codigosEstudiantes.get(comboEstudiante.getSelectedIndex()));
            sentencia.setInt(2, codigosAsignaturas.get(comboAsignatura.getSelectedIndex()));
            sentencia.setString(3, comboPeriodo.getSelectedItem().toString());
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La matricula se guardo correctamente");
            limpiarFormulario();
            cargarMatriculas(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarMatricula() {
        if (!haySeleccion("Primero seleccione una matricula de la tabla")) {
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
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE matriculas\n" +
            "SET id_estudiante = ?, id_asignatura = ?, periodo = ?\n" +
            "WHERE id_matricula = ?;");
            sentencia.setInt(1, codigosEstudiantes.get(comboEstudiante.getSelectedIndex()));
            sentencia.setInt(2, codigosAsignaturas.get(comboAsignatura.getSelectedIndex()));
            sentencia.setString(3, comboPeriodo.getSelectedItem().toString());
            sentencia.setInt(4, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La matricula se actualizo correctamente");
            limpiarFormulario();
            cargarMatriculas(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarMatricula() {
        if (!haySeleccion("Primero seleccione una matricula de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar la matricula de " + comboEstudiante.getSelectedItem() + " en " + comboAsignatura.getSelectedItem() + "?")) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM matriculas\n" +
            "WHERE id_matricula = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La matricula se elimino correctamente");
            limpiarFormulario();
            cargarMatriculas(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean validarFormulario() {
        if (comboEstudiante.getItemCount() == 0) {
            mostrarAviso("Primero registre un estudiante", comboEstudiante);
            return false;
        }
        if (comboAsignatura.getItemCount() == 0) {
            mostrarAviso("Primero registre una asignatura", comboAsignatura);
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        campoCodigo.setText("");
        if (comboEstudiante.getItemCount() > 0) {
            comboEstudiante.setSelectedIndex(0);
        }
        if (comboAsignatura.getItemCount() > 0) {
            comboAsignatura.setSelectedIndex(0);
        }
        comboPeriodo.setSelectedIndex(0);
        tablaMatriculas.clearSelection();
        comboEstudiante.requestFocus();
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
            mensaje = "El estudiante ya esta matriculado en esa asignatura en ese periodo";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se puede eliminar la matricula porque tiene calificaciones registradas";
        }
        JOptionPane.showMessageDialog(this, mensaje, "No se pudo completar", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JComboBox<String> comboAsignatura;
    private javax.swing.JComboBox<String> comboEstudiante;
    private javax.swing.JComboBox<String> comboPeriodo;
    private javax.swing.JLabel etiquetaAsignatura;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaEstudiante;
    private javax.swing.JLabel etiquetaFormulario;
    private javax.swing.JLabel etiquetaPeriodo;
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
    private javax.swing.JTable tablaMatriculas;
    // End of variables declaration//GEN-END:variables
}
