package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameProveedores extends javax.swing.JFrame {

    public JFrameProveedores() {
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
        etiquetaRuc = new javax.swing.JLabel();
        campoRuc = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaCiudad = new javax.swing.JLabel();
        campoCiudad = new javax.swing.JTextField();
        etiquetaTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        panelListado = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
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
        setTitle("Sistema de Inventario - Proveedores");
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
        etiquetaFormulario.setText("Datos del proveedor");
        panelCampos.add(etiquetaFormulario);

        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCodigo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCodigo.setText("Codigo");
        panelCampos.add(etiquetaCodigo);

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        campoCodigo.setEditable(false);
        panelCampos.add(campoCodigo);

        etiquetaRuc.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaRuc.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaRuc.setText("RUC");
        panelCampos.add(etiquetaRuc);

        campoRuc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoRuc);

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaNombre.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaNombre.setText("Nombre del proveedor");
        panelCampos.add(etiquetaNombre);

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoNombre);

        etiquetaCiudad.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaCiudad.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaCiudad.setText("Ciudad");
        panelCampos.add(etiquetaCiudad);

        campoCiudad.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoCiudad);

        etiquetaTelefono.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        etiquetaTelefono.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaTelefono.setText("Telefono");
        panelCampos.add(etiquetaTelefono);

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelCampos.add(campoTelefono);

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

        tablaProveedores.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "RUC", "Proveedor", "Ciudad", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProveedores.setRowHeight(24);
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tablaProveedores);

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
        cargarProveedores("");
    }//GEN-LAST:event_formWindowOpened

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarProveedores(campoBuscar.getText().trim());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        mostrarProveedorSeleccionado();
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarProveedor();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarProveedor();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarProveedor();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void cargarProveedores(String texto) {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        modelo.setRowCount(0);
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    id_proveedor,\n" +
            "    ruc,\n" +
            "    nombre,\n" +
            "    ciudad,\n" +
            "    telefono\n" +
            "FROM\n" +
            "    proveedores\n" +
            "WHERE\n" +
            "    nombre LIKE ?\n" +
            "    OR ruc LIKE ?\n" +
            "    OR ciudad LIKE ?\n" +
            "ORDER BY\n" +
            "    nombre;");
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
            etiquetaEstado.setText(modelo.getRowCount() + " proveedor(es) en la lista");
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarProveedorSeleccionado() {
        int fila = tablaProveedores.getSelectedRow();
        if (fila == -1) {
            return;
        }
        campoCodigo.setText(tablaProveedores.getValueAt(fila, 0).toString());
        campoRuc.setText(tablaProveedores.getValueAt(fila, 1).toString());
        campoNombre.setText(tablaProveedores.getValueAt(fila, 2).toString());
        campoCiudad.setText(tablaProveedores.getValueAt(fila, 3).toString());
        campoTelefono.setText(tablaProveedores.getValueAt(fila, 4).toString());
    }

    private void guardarProveedor() {
        if (!validarFormulario()) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO proveedores (ruc, nombre, ciudad, telefono)\n" +
            "VALUES (?, ?, ?, ?);");
            sentencia.setString(1, campoRuc.getText().trim());
            sentencia.setString(2, campoNombre.getText().trim());
            sentencia.setString(3, campoCiudad.getText().trim());
            sentencia.setString(4, campoTelefono.getText().trim());
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El proveedor se guardo correctamente");
            limpiarFormulario();
            cargarProveedores(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void actualizarProveedor() {
        if (!haySeleccion("Primero seleccione un proveedor de la tabla")) {
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
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE proveedores\n" +
            "SET ruc = ?, nombre = ?, ciudad = ?, telefono = ?\n" +
            "WHERE id_proveedor = ?;");
            sentencia.setString(1, campoRuc.getText().trim());
            sentencia.setString(2, campoNombre.getText().trim());
            sentencia.setString(3, campoCiudad.getText().trim());
            sentencia.setString(4, campoTelefono.getText().trim());
            sentencia.setInt(5, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El proveedor se actualizo correctamente");
            limpiarFormulario();
            cargarProveedores(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void eliminarProveedor() {
        if (!haySeleccion("Primero seleccione un proveedor de la tabla")) {
            return;
        }
        if (!confirmarEliminacion("Esta seguro de eliminar el proveedor " + campoNombre.getText() + "?")) {
            return;
        }
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            return;
        }
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM proveedores\n" +
            "WHERE id_proveedor = ?;");
            sentencia.setInt(1, Integer.parseInt(campoCodigo.getText()));
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            mostrarMensaje("El proveedor se elimino correctamente");
            limpiarFormulario();
            cargarProveedores(campoBuscar.getText().trim());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private boolean validarFormulario() {
        String ruc = campoRuc.getText().trim();
        if (ruc.length() != 13 || !esNumero(ruc)) {
            mostrarAviso("El RUC debe tener 13 numeros", campoRuc);
            return false;
        }
        if (campoNombre.getText().trim().length() == 0) {
            mostrarAviso("Ingrese el nombre del proveedor", campoNombre);
            return false;
        }
        if (campoCiudad.getText().trim().length() == 0) {
            mostrarAviso("Ingrese la ciudad del proveedor", campoCiudad);
            return false;
        }
        String telefono = campoTelefono.getText().trim();
        if ((telefono.length() != 9 && telefono.length() != 10) || !esNumero(telefono)) {
            mostrarAviso("El telefono debe tener 9 o 10 numeros", campoTelefono);
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
        campoRuc.setText("");
        campoNombre.setText("");
        campoCiudad.setText("");
        campoTelefono.setText("");
        tablaProveedores.clearSelection();
        campoRuc.requestFocus();
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
            mensaje = "Ya existe un proveedor con ese RUC";
        }
        if (e.getMessage().contains("FOREIGN KEY")) {
            mensaje = "No se puede eliminar el proveedor porque tiene articulos registrados";
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
    private javax.swing.JTextField campoCiudad;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRuc;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel etiquetaBuscar;
    private javax.swing.JLabel etiquetaCiudad;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaFormulario;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaRuc;
    private javax.swing.JLabel etiquetaTelefono;
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
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
