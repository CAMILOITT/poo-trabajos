package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameArticulos extends javax.swing.JFrame {

    private ArrayList<Integer> codigosCategorias = new ArrayList<>();
    private ArrayList<Integer> codigosProveedores = new ArrayList<>();

    public JFrameArticulos() {
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
        etiquetaReferencia = new javax.swing.JLabel();
        campoReferencia = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaPrecio = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        etiquetaStockMinimo = new javax.swing.JLabel();
        campoStockMinimo = new javax.swing.JTextField();
        etiquetaCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        etiquetaProveedor = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
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
        setTitle("Sistema de Inventario - Articulos");
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
        panelCampos.setLayout(new java.awt.GridLayout(15, 1, 0, 6));

        etiquetaFormulario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        etiquetaFormulario.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaFormulario.setText("Datos del articulo");
        panelCampos.add(etiquetaFormulario);

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCodigo.setText("Codigo");
        panelCampos.add(etiquetaCodigo);

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);

        etiquetaReferencia.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaReferencia.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaReferencia.setText("Referencia (ej. HER-001)");
        panelCampos.add(etiquetaReferencia);

        campoReferencia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoReferencia);

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaNombre.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaNombre.setText("Nombre del articulo");
        panelCampos.add(etiquetaNombre);

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoNombre);

        etiquetaPrecio.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaPrecio.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaPrecio.setText("Precio unitario");
        panelCampos.add(etiquetaPrecio);

        campoPrecio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoPrecio);

        etiquetaStockMinimo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaStockMinimo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaStockMinimo.setText("Stock minimo");
        panelCampos.add(etiquetaStockMinimo);

        campoStockMinimo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoStockMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoStockMinimoActionPerformed(evt);
            }
        });
        panelCampos.add(campoStockMinimo);

        etiquetaCategoria.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCategoria.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCategoria.setText("Categoria");
        panelCampos.add(etiquetaCategoria);

        comboCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboCategoria);

        etiquetaProveedor.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaProveedor.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaProveedor.setText("Proveedor");
        panelCampos.add(etiquetaProveedor);

        comboProveedor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(comboProveedor);

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

        tablaArticulos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Referencia", "Articulo", "Precio", "Stock minimo", "Categoria", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaArticulos.setRowHeight(24);
        tablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArticulosMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaArticulos);

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
        cargarCategorias();
        cargarProveedores();
        cargarArticulos("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarArticulos(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticulosMouseClicked
        mostrarArticuloSeleccionado();
    }//GEN-LAST:event_tablaArticulosMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarArticulo();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarArticulo();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarArticulo();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void campoStockMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoStockMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoStockMinimoActionPerformed

    private void cargarCategorias() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboCategoria.removeAllItems();
        codigosCategorias.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_categoria,\n" +
            "    nombre\n" +
            "FROM\n" +
            "    categorias\n" +
            "ORDER BY\n" +
            "    nombre;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosCategorias.add(resultado.getInt(1));
                comboCategoria.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarProveedores() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        comboProveedor.removeAllItems();
        codigosProveedores.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_proveedor,\n" +
            "    nombre\n" +
            "FROM\n" +
            "    proveedores\n" +
            "ORDER BY\n" +
            "    nombre;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigosProveedores.add(resultado.getInt(1));
                comboProveedor.addItem(resultado.getString(2));
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarArticulos(String texto) {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    a.id_articulo,\n" +
            "    a.codigo,\n" +
            "    a.nombre,\n" +
            "    a.precio_unitario,\n" +
            "    a.stock_minimo,\n" +
            "    ca.nombre,\n" +
            "    p.nombre\n" +
            "FROM\n" +
            "    articulos AS a\n" +
            "    INNER JOIN categorias AS ca ON ca.id_categoria = a.id_categoria\n" +
            "    INNER JOIN proveedores AS p ON p.id_proveedor = a.id_proveedor\n" +
            "WHERE\n" +
            "    a.nombre LIKE ?\n" +
            "    OR a.codigo LIKE ?\n" +
            "    OR ca.nombre LIKE ?\n" +
            "    OR p.nombre LIKE ?\n" +
            "ORDER BY\n" +
            "    ca.nombre,\n" +
            "    a.nombre;");
            sentencia.setString(1, "%" + texto + "%");
            sentencia.setString(2, "%" + texto + "%");
            sentencia.setString(3, "%" + texto + "%");
            sentencia.setString(4, "%" + texto + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[7];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                fila[4] = resultado.getString(5);
                fila[5] = resultado.getString(6);
                fila[6] = resultado.getString(7);
                modelo.addRow(fila);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            etiquetaEstado.setText(modelo.getRowCount() + " articulo(s) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarArticuloSeleccionado() {
        int fila = tablaArticulos.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaArticulos.getValueAt(fila, 0).toString());
        campoReferencia.setText(tablaArticulos.getValueAt(fila, 1).toString());
        campoNombre.setText(tablaArticulos.getValueAt(fila, 2).toString());
        campoPrecio.setText(tablaArticulos.getValueAt(fila, 3).toString());
        campoStockMinimo.setText(tablaArticulos.getValueAt(fila, 4).toString());
        comboCategoria.setSelectedItem(tablaArticulos.getValueAt(fila, 5).toString());
        comboProveedor.setSelectedItem(tablaArticulos.getValueAt(fila, 6).toString());
    }

    private void guardarArticulo() {
        if (!validarFormulario()) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO articulos (codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor)\n" +
            "VALUES (?, ?, ?, ?, ?, ?);");
            sentencia.setString(1, campoReferencia.getText().trim());
            sentencia.setString(2, campoNombre.getText().trim());
            sentencia.setDouble(3, leerPrecio());
            sentencia.setInt(4, Integer.parseInt(campoStockMinimo.getText().trim()));
            sentencia.setInt(5, codigosCategorias.get(comboCategoria.getSelectedIndex()));
            sentencia.setInt(6, codigosProveedores.get(comboProveedor.getSelectedIndex()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El articulo se guardo correctamente");
            limpiarFormulario();
            cargarArticulos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarArticulo() {
        if (!haySeleccion("Primero seleccione un articulo de la tabla")) {
            return;
        }
        if (!validarFormulario()) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE articulos\n" +
            "SET codigo = ?, nombre = ?, precio_unitario = ?, stock_minimo = ?, id_categoria = ?, id_proveedor = ?\n" +
            "WHERE id_articulo = ?;");
            sentencia.setString(1, campoReferencia.getText().trim());
            sentencia.setString(2, campoNombre.getText().trim());
            sentencia.setDouble(3, leerPrecio());
            sentencia.setInt(4, Integer.parseInt(campoStockMinimo.getText().trim()));
            sentencia.setInt(5, codigosCategorias.get(comboCategoria.getSelectedIndex()));
            sentencia.setInt(6, codigosProveedores.get(comboProveedor.getSelectedIndex()));
            sentencia.setInt(7, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El articulo se actualizo correctamente");
            limpiarFormulario();
            cargarArticulos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarArticulo() {
        if (!haySeleccion("Primero seleccione un articulo de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar el articulo " + campoNombre.getText() + "?")) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM articulos\n" +
            "WHERE id_articulo = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El articulo se elimino correctamente");
            limpiarFormulario();
            cargarArticulos(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean validarFormulario() {
        if (campoReferencia.getText().trim().length() == 0) {
            mostrarAviso("Ingrese la referencia del articulo, por ejemplo HER-001", campoReferencia);
            return false;
        }
        if (campoNombre.getText().trim().length() == 0) {
            mostrarAviso("Ingrese el nombre del articulo", campoNombre);
            return false;
        }
        if (!esPrecioValido(campoPrecio.getText().trim())) {
            mostrarAviso("El precio debe ser un numero mayor a 0", campoPrecio);
            return false;
        }
        if (!esNumero(campoStockMinimo.getText().trim())) {
            mostrarAviso("El stock minimo debe ser un numero entero positivo", campoStockMinimo);
            return false;
        }
        if (comboCategoria.getItemCount() == 0) {
            mostrarAviso("Primero registre una categoria", comboCategoria);
            return false;
        }
        if (comboProveedor.getItemCount() == 0) {
            mostrarAviso("Primero registre un proveedor", comboProveedor);
            return false;
        }
        return true;
    }

    private boolean esPrecioValido(String texto) {
        try {
            double precio = Double.parseDouble(texto.replace(",", "."));
            return precio > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double leerPrecio() {
        return Double.parseDouble(campoPrecio.getText().trim().replace(",", "."));
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
        campoReferencia.setText("");
        campoNombre.setText("");
        campoPrecio.setText("");
        campoStockMinimo.setText("");
        if (comboCategoria.getItemCount() > 0) {
            comboCategoria.setSelectedIndex(0);
        }
        if (comboProveedor.getItemCount() > 0) {
            comboProveedor.setSelectedIndex(0);
        }
        tablaArticulos.clearSelection();
        campoReferencia.requestFocus();
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
            mensaje = "Ya existe un articulo con esa referencia";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se puede eliminar el articulo porque tiene movimientos registrados";
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
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoReferencia;
    private javax.swing.JTextField campoStockMinimo;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCategoria;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaFormulario;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetaProveedor;
    private javax.swing.JLabel etiquetaReferencia;
    private javax.swing.JLabel etiquetaStockMinimo;
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
    private javax.swing.JTable tablaArticulos;
    // End of variables declaration//GEN-END:variables
}
