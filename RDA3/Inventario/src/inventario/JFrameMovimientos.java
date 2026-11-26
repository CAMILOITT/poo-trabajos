package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameMovimientos extends javax.swing.JFrame {

    private final String TIPO_ENTRADA = "ENTRADA";
    private ArrayList<Integer> codigosArticulos = new ArrayList<>();

    public JFrameMovimientos() {
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
        etiquetaArticulo = new javax.swing.JLabel();
        comboArticulo = new javax.swing.JComboBox<>();
        etiquetaTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        etiquetaCantidad = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        etiquetaFecha = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
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
        setTitle("Sistema de Inventario - Movimientos");
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
        etiquetaFormulario.setText("Datos del movimiento");
        panelCampos.add(etiquetaFormulario);

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCodigo.setText("Codigo");
        panelCampos.add(etiquetaCodigo);

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);

        etiquetaArticulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaArticulo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaArticulo.setText("Articulo");
        panelCampos.add(etiquetaArticulo);

        comboArticulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboArticulo);

        etiquetaTipo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaTipo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaTipo.setText("Tipo de movimiento");
        panelCampos.add(etiquetaTipo);

        comboTipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENTRADA", "SALIDA" }));
        panelCampos.add(comboTipo);

        etiquetaCantidad.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCantidad.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCantidad.setText("Cantidad");
        panelCampos.add(etiquetaCantidad);

        campoCantidad.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoCantidad);

        etiquetaFecha.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaFecha.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaFecha.setText("Fecha (AAAA-MM-DD)");
        panelCampos.add(etiquetaFecha);

        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoFecha);

        panelFormulario.add(panelCampos, java.awt.BorderLayout.NORTH);

        panelContenido.add(panelFormulario, java.awt.BorderLayout.WEST);

        panelListado.setBackground(new java.awt.Color(236, 240, 244));
        panelListado.setLayout(new java.awt.BorderLayout(0, 8));

        panelBusqueda.setBackground(new java.awt.Color(236, 240, 244));
        panelBusqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        etiquetaBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaBuscar.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_buscar_chico.png"))); // NOI18N
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

        tablaMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Articulo", "Tipo", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMovimientos.setRowHeight(24);
        tablaMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMovimientosMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaMovimientos);

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
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_guardar.png"))); // NOI18N
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
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_editar.png"))); // NOI18N
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
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_eliminar.png"))); // NOI18N
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
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_limpiar.png"))); // NOI18N
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
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_regresar.png"))); // NOI18N
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
        cargarArticulos();
        cargarMovimientos("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarMovimientos(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMovimientosMouseClicked
        mostrarMovimientoSeleccionado();
    }//GEN-LAST:event_tablaMovimientosMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarMovimiento();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarMovimiento();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarMovimiento();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void cargarArticulos() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboArticulo.removeAllItems();
        codigosArticulos.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_articulo,\n" +
            "    codigo || ' - ' || nombre\n" +
            "FROM\n" +
            "    articulos\n" +
            "ORDER BY\n" +
            "    codigo;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosArticulos.add(resultado.getInt(1));
                comboArticulo.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarMovimientos(String texto) {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    m.id_movimiento,\n" +
            "    a.codigo || ' - ' || a.nombre,\n" +
            "    m.tipo,\n" +
            "    m.cantidad,\n" +
            "    m.fecha\n" +
            "FROM\n" +
            "    movimientos AS m\n" +
            "    INNER JOIN articulos AS a ON a.id_articulo = m.id_articulo\n" +
            "WHERE\n" +
            "    a.nombre LIKE ?\n" +
            "    OR a.codigo LIKE ?\n" +
            "    OR m.tipo LIKE ?\n" +
            "    OR m.fecha LIKE ?\n" +
            "ORDER BY\n" +
            "    m.fecha DESC,\n" +
            "    m.id_movimiento DESC;");
            sentencia.setString(1, "%" + texto + "%");
            sentencia.setString(2, "%" + texto + "%");
            sentencia.setString(3, "%" + texto + "%");
            sentencia.setString(4, "%" + texto + "%");
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
            etiquetaEstado.setText(modelo.getRowCount() + " movimiento(s) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarMovimientoSeleccionado() {
        int fila = tablaMovimientos.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaMovimientos.getValueAt(fila, 0).toString());
        comboArticulo.setSelectedItem(tablaMovimientos.getValueAt(fila, 1).toString());
        comboTipo.setSelectedItem(tablaMovimientos.getValueAt(fila, 2).toString());
        campoCantidad.setText(tablaMovimientos.getValueAt(fila, 3).toString());
        campoFecha.setText(tablaMovimientos.getValueAt(fila, 4).toString());
    }

    private void guardarMovimiento() {
        if (!validarFormulario()) {
            return;
        }
        if (!hayExistencias(0)) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO movimientos (id_articulo, tipo, cantidad, fecha)\n" +
            "VALUES (?, ?, ?, ?);");
            sentencia.setInt(1, codigosArticulos.get(comboArticulo.getSelectedIndex()));
            sentencia.setString(2, comboTipo.getSelectedItem().toString());
            sentencia.setInt(3, Integer.parseInt(campoCantidad.getText().trim()));
            sentencia.setString(4, campoFecha.getText().trim());
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El movimiento se guardo correctamente");
            limpiarFormulario();
            cargarMovimientos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarMovimiento() {
        if (!haySeleccion("Primero seleccione un movimiento de la tabla")) {
            return;
        }
        if (!validarFormulario()) {
            return;
        }
        if (!hayExistencias(Integer.parseInt(campoCodigo.getText()))) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE movimientos\n" +
            "SET id_articulo = ?, tipo = ?, cantidad = ?, fecha = ?\n" +
            "WHERE id_movimiento = ?;");
            sentencia.setInt(1, codigosArticulos.get(comboArticulo.getSelectedIndex()));
            sentencia.setString(2, comboTipo.getSelectedItem().toString());
            sentencia.setInt(3, Integer.parseInt(campoCantidad.getText().trim()));
            sentencia.setString(4, campoFecha.getText().trim());
            sentencia.setInt(5, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El movimiento se actualizo correctamente");
            limpiarFormulario();
            cargarMovimientos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarMovimiento() {
        if (!haySeleccion("Primero seleccione un movimiento de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar la " + comboTipo.getSelectedItem() + " de " + comboArticulo.getSelectedItem() + "?")) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM movimientos\n" +
            "WHERE id_movimiento = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El movimiento se elimino correctamente");
            limpiarFormulario();
            cargarMovimientos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean hayExistencias(int codigoActual) {
        if (comboTipo.getSelectedItem().toString().equals(TIPO_ENTRADA)) {
            return true;
        }
        boolean hay = false;
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return false;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    SUM(IIF(tipo = ?, cantidad, -cantidad))\n" +
            "FROM\n" +
            "    movimientos\n" +
            "WHERE\n" +
            "    id_articulo = ?\n" +
            "    AND id_movimiento <> ?;");
            sentencia.setString(1, TIPO_ENTRADA);
            sentencia.setInt(2, codigosArticulos.get(comboArticulo.getSelectedIndex()));
            sentencia.setInt(3, codigoActual);
            ResultSet resultado = sentencia.executeQuery();
            int existencias = 0;
            if (resultado.next()) {
                existencias = resultado.getInt(1);
            }
            hay = Integer.parseInt(campoCantidad.getText().trim()) <= existencias;
            if (!hay) {
                mostrarAviso("Solo hay " + existencias + " unidad(es) de ese articulo en existencia", campoCantidad);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
        return hay;
    }

    private boolean validarFormulario() {
        if (comboArticulo.getItemCount() == 0) {
            mostrarAviso("Primero registre un articulo", comboArticulo);
            return false;
        }
        String cantidad = campoCantidad.getText().trim();
        if (!esNumero(cantidad) || Integer.parseInt(cantidad) == 0) {
            mostrarAviso("La cantidad debe ser un numero entero mayor a 0", campoCantidad);
            return false;
        }
        if (!esFechaValida(campoFecha.getText().trim())) {
            mostrarAviso("La fecha debe tener el formato AAAA-MM-DD, por ejemplo 2026-11-26", campoFecha);
            return false;
        }
        return true;
    }

    private boolean esFechaValida(String texto) {
        if (texto.length() != 10 || texto.charAt(4) != '-' || texto.charAt(7) != '-') {
            return false;
        }
        String anio = texto.substring(0, 4);
        String mes = texto.substring(5, 7);
        String dia = texto.substring(8, 10);
        if (!esNumero(anio) || !esNumero(mes) || !esNumero(dia)) {
            return false;
        }
        int numeroMes = Integer.parseInt(mes);
        int numeroDia = Integer.parseInt(dia);
        return numeroMes >= 1 && numeroMes <= 12 && numeroDia >= 1 && numeroDia <= 31;
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
        if (comboArticulo.getItemCount() > 0) {
            comboArticulo.setSelectedIndex(0);
        }
        comboTipo.setSelectedIndex(0);
        campoCantidad.setText("");
        campoFecha.setText("");
        tablaMovimientos.clearSelection();
        campoCantidad.requestFocus();
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
            mensaje = "Ya existe ese movimiento";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se pudo completar porque el movimiento esta relacionado con otros datos";
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
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JComboBox<String> comboArticulo;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel etiquetaArticulo;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaFormulario;
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
    private javax.swing.JTable tablaMovimientos;
    // End of variables declaration//GEN-END:variables
}
