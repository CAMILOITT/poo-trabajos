package universidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameCalificaciones extends javax.swing.JFrame {

    private ArrayList<Integer> codigosEstudiantes = new ArrayList<>();
    private ArrayList<Integer> codigosMatriculas = new ArrayList<>();

    public JFrameCalificaciones() {
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
        etiquetaMatricula = new javax.swing.JLabel();
        comboMatricula = new javax.swing.JComboBox<>();
        etiquetaTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        etiquetaNota = new javax.swing.JLabel();
        campoNota = new javax.swing.JTextField();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
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
        setTitle("Sistema Academico - Calificaciones");
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
        etiquetaFormulario.setText("Datos de la calificacion");
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
        comboEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstudianteActionPerformed(evt);
            }
        });
        panelCampos.add(comboEstudiante);

        etiquetaMatricula.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaMatricula.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaMatricula.setText("Asignatura y periodo");
        panelCampos.add(etiquetaMatricula);

        comboMatricula.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboMatricula);

        etiquetaTipo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaTipo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaTipo.setText("Tipo de calificacion");
        panelCampos.add(etiquetaTipo);

        comboTipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primer parcial", "Segundo parcial", "Examen final" }));
        panelCampos.add(comboTipo);

        etiquetaNota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaNota.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaNota.setText("Nota (de 0 a 50)");
        panelCampos.add(etiquetaNota);

        campoNota.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoNota);

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

        tablaCalificaciones.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Estudiante", "Asignatura", "Periodo", "Tipo", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCalificaciones.setRowHeight(24);
        tablaCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCalificacionesMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaCalificaciones);

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

    private void comboEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstudianteActionPerformed
        cargarMatriculasDelEstudiante();
    }//GEN-LAST:event_comboEstudianteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarEstudiantes();
        cargarCalificaciones("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarCalificaciones(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaCalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCalificacionesMouseClicked
        mostrarCalificacionSeleccionada();
    }//GEN-LAST:event_tablaCalificacionesMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarCalificacion();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarCalificacion();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarCalificacion();
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

    private void cargarMatriculasDelEstudiante() {
        comboMatricula.removeAllItems();
        codigosMatriculas.clear();
        int posicion = comboEstudiante.getSelectedIndex();
        if (posicion == -1 || posicion >= codigosEstudiantes.size()) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    m.id_matricula,\n" +
            "    a.nombre || ' - ' || m.periodo\n" +
            "FROM\n" +
            "    matriculas AS m\n" +
            "    INNER JOIN asignaturas AS a ON a.id_asignatura = m.id_asignatura\n" +
            "WHERE\n" +
            "    m.id_estudiante = ?\n" +
            "ORDER BY\n" +
            "    m.periodo DESC,\n" +
            "    a.nombre;");
            sentencia.setInt(1, codigosEstudiantes.get(posicion));
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosMatriculas.add(resultado.getInt(1));
                comboMatricula.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarCalificaciones(String texto) {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaCalificaciones.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    c.id_calificacion,\n" +
            "    e.apellidos || ' ' || e.nombres || ' - ' || e.cedula,\n" +
            "    a.nombre,\n" +
            "    m.periodo,\n" +
            "    c.tipo,\n" +
            "    c.nota\n" +
            "FROM\n" +
            "    calificaciones AS c\n" +
            "    INNER JOIN matriculas AS m ON m.id_matricula = c.id_matricula\n" +
            "    INNER JOIN estudiantes AS e ON e.id_estudiante = m.id_estudiante\n" +
            "    INNER JOIN asignaturas AS a ON a.id_asignatura = m.id_asignatura\n" +
            "WHERE\n" +
            "    e.apellidos LIKE ?\n" +
            "    OR e.nombres LIKE ?\n" +
            "    OR e.cedula LIKE ?\n" +
            "    OR a.nombre LIKE ?\n" +
            "ORDER BY\n" +
            "    e.apellidos,\n" +
            "    a.nombre,\n" +
            "    c.id_calificacion;");
            sentencia.setString(1, "%" + texto + "%");
            sentencia.setString(2, "%" + texto + "%");
            sentencia.setString(3, "%" + texto + "%");
            sentencia.setString(4, "%" + texto + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[6];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                fila[4] = resultado.getString(5);
                fila[5] = resultado.getString(6);
                modelo.addRow(fila);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            etiquetaEstado.setText(modelo.getRowCount() + " calificacion(es) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarCalificacionSeleccionada() {
        int fila = tablaCalificaciones.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaCalificaciones.getValueAt(fila, 0).toString());
        comboEstudiante.setSelectedItem(tablaCalificaciones.getValueAt(fila, 1).toString());
        comboMatricula.setSelectedItem(tablaCalificaciones.getValueAt(fila, 2).toString() + " - " + tablaCalificaciones.getValueAt(fila, 3).toString());
        comboTipo.setSelectedItem(tablaCalificaciones.getValueAt(fila, 4).toString());
        campoNota.setText(tablaCalificaciones.getValueAt(fila, 5).toString());
    }

    private void guardarCalificacion() {
        if (!validarFormulario()) {
            return;
        }
        if (existeCalificacion(0)) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO calificaciones (id_matricula, tipo, nota)\n" +
            "VALUES (?, ?, ?);");
            sentencia.setInt(1, codigosMatriculas.get(comboMatricula.getSelectedIndex()));
            sentencia.setString(2, comboTipo.getSelectedItem().toString());
            sentencia.setDouble(3, leerNota());
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La calificacion se guardo correctamente");
            limpiarFormulario();
            cargarCalificaciones(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarCalificacion() {
        if (!haySeleccion("Primero seleccione una calificacion de la tabla")) {
            return;
        }
        if (!validarFormulario()) {
            return;
        }
        if (existeCalificacion(Integer.parseInt(campoCodigo.getText()))) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE calificaciones\n" +
            "SET id_matricula = ?, tipo = ?, nota = ?\n" +
            "WHERE id_calificacion = ?;");
            sentencia.setInt(1, codigosMatriculas.get(comboMatricula.getSelectedIndex()));
            sentencia.setString(2, comboTipo.getSelectedItem().toString());
            sentencia.setDouble(3, leerNota());
            sentencia.setInt(4, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La calificacion se actualizo correctamente");
            limpiarFormulario();
            cargarCalificaciones(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarCalificacion() {
        if (!haySeleccion("Primero seleccione una calificacion de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar la nota del " + comboTipo.getSelectedItem() + " de " + comboEstudiante.getSelectedItem() + "?")) {
            return;
        }
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM calificaciones\n" +
            "WHERE id_calificacion = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("La calificacion se elimino correctamente");
            limpiarFormulario();
            cargarCalificaciones(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean existeCalificacion(int codigoActual) {
        boolean existe = false;
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            return true;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    COUNT(*)\n" +
            "FROM\n" +
            "    calificaciones\n" +
            "WHERE\n" +
            "    id_matricula = ?\n" +
            "    AND tipo = ?\n" +
            "    AND id_calificacion <> ?;");
            sentencia.setInt(1, codigosMatriculas.get(comboMatricula.getSelectedIndex()));
            sentencia.setString(2, comboTipo.getSelectedItem().toString());
            sentencia.setInt(3, codigoActual);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                existe = true;
                mostrarAviso("Ese estudiante ya tiene registrado el " + comboTipo.getSelectedItem() + " en esa asignatura", comboTipo);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
            existe = true;
        }
        return existe;
    }

    private boolean validarFormulario() {
        if (comboEstudiante.getItemCount() == 0) {
            mostrarAviso("Primero registre un estudiante", comboEstudiante);
            return false;
        }
        if (comboMatricula.getItemCount() == 0) {
            mostrarAviso("El estudiante no tiene matriculas, primero matriculelo en una asignatura", comboEstudiante);
            return false;
        }
        if (!esNotaValida(campoNota.getText().trim())) {
            mostrarAviso("La nota debe ser un numero entre 0 y 50", campoNota);
            return false;
        }
        return true;
    }

    private boolean esNotaValida(String texto) {
        try {
            double nota = Double.parseDouble(texto.replace(",", "."));
            return nota >= 0 && nota <= 50;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double leerNota() {
        return Double.parseDouble(campoNota.getText().trim().replace(",", "."));
    }

    private void limpiarFormulario() {
        campoCodigo.setText("");
        comboTipo.setSelectedIndex(0);
        campoNota.setText("");
        tablaCalificaciones.clearSelection();
        campoNota.requestFocus();
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
            mensaje = "Ya existe esa calificacion";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se pudo completar porque la calificacion esta relacionada con otros datos";
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
    private javax.swing.JTextField campoNota;
    private javax.swing.JComboBox<String> comboEstudiante;
    private javax.swing.JComboBox<String> comboMatricula;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaEstudiante;
    private javax.swing.JLabel etiquetaFormulario;
    private javax.swing.JLabel etiquetaMatricula;
    private javax.swing.JLabel etiquetaNota;
    private javax.swing.JLabel etiquetaTipo;
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
    private javax.swing.JTable tablaCalificaciones;
    // End of variables declaration//GEN-END:variables
}
