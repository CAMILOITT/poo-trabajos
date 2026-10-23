package plantilla;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Registra, edita y elimina elementos (productos, repuestos, libros, lo que pida el sistema).
 * Al hacer clic en una fila de la tabla sus datos pasan a los campos y Guardar actualiza.
 */
public class RegistrarElemento extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Elemento> listaElementos;
    // Fila elegida en la tabla, -1 quiere decir que no hay ninguna
    private int filaSeleccionada = -1;

    public RegistrarElemento(javax.swing.JFrame ventanaAnterior, ArrayList<Elemento> listaElementos) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaElementos = listaElementos;
        cargarTabla();
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaElementos.getModel();
        modeloTabla.setRowCount(0);
        for (Elemento elemento : listaElementos) {
            modeloTabla.addRow(new Object[]{elemento.getCodigo(), elemento.getNombre(), elemento.getCategoria(),
                elemento.getCantidad(), String.format("%.2f", elemento.getPrecio())});
        }
    }

    private void limpiarCampos() {
        campoCodigo.setText("");
        campoNombre.setText("");
        comboCategoria.setSelectedIndex(0);
        campoCantidad.setText("");
        campoPrecio.setText("");
        campoCodigo.setEditable(true);
        tablaElementos.clearSelection();
        filaSeleccionada = -1;
        campoCodigo.requestFocus();
    }

    private boolean validarCampos() {
        String codigo = campoCodigo.getText().trim();
        String nombre = campoNombre.getText().trim();
        String cantidad = campoCantidad.getText().trim();
        String precio = campoPrecio.getText().trim();

        if (Validaciones.estaVacio(codigo) || Validaciones.estaVacio(nombre)
                || Validaciones.estaVacio(cantidad) || Validaciones.estaVacio(precio)) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos");
            return false;
        }
        if (!Validaciones.validarEntero(cantidad)) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero mayor o igual a 0");
            campoCantidad.requestFocus();
            return false;
        }
        if (!Validaciones.validarDecimal(precio)) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número mayor a 0, por ejemplo 12.50");
            campoPrecio.requestFocus();
            return false;
        }
        return true;
    }

    // Devuelve el elemento con ese código o null si no existe
    private Elemento buscarElemento(String codigo) {
        for (Elemento elemento : listaElementos) {
            if (elemento.getCodigo().equalsIgnoreCase(codigo)) {
                return elemento;
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
        etiquetaCodigo = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaCategoria = new javax.swing.JLabel();
        etiquetaCantidad = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoCodigo = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox<>();
        campoCantidad = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        scrollElementos = new javax.swing.JScrollPane();
        tablaElementos = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar elemento");
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
        etiquetaCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCodigo.setText("Código");
        panelEtiquetas.add(etiquetaCodigo);

        etiquetaNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaNombre.setText("Nombre");
        panelEtiquetas.add(etiquetaNombre);

        etiquetaCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCategoria.setText("Categoría");
        panelEtiquetas.add(etiquetaCategoria);

        etiquetaCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCantidad.setText("Cantidad");
        panelEtiquetas.add(etiquetaCantidad);

        etiquetaPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaPrecio.setText("Precio");
        panelEtiquetas.add(etiquetaPrecio);

        panelDatos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoCodigo);

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoNombre);

        comboCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría A", "Categoría B", "Categoría C" }));
        panelCampos.add(comboCategoria);

        campoCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoCantidad);

        campoPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoPrecio);

        panelDatos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelDatos, java.awt.BorderLayout.NORTH);

        scrollElementos.setPreferredSize(new java.awt.Dimension(560, 170));
        tablaElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Categoría", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaElementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaElementosMouseClicked(evt);
            }
        });

        scrollElementos.setViewportView(tablaElementos);
        panelContenido.add(scrollElementos, java.awt.BorderLayout.CENTER);

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

    private void tablaElementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaElementosMouseClicked
        filaSeleccionada = tablaElementos.getSelectedRow();
        if (filaSeleccionada == -1) {
            return;
        }
        Elemento elemento = listaElementos.get(filaSeleccionada);
        campoCodigo.setText(elemento.getCodigo());
        campoNombre.setText(elemento.getNombre());
        comboCategoria.setSelectedItem(elemento.getCategoria());
        campoCantidad.setText(String.valueOf(elemento.getCantidad()));
        campoPrecio.setText(String.valueOf(elemento.getPrecio()));
        // El código no se puede cambiar cuando se edita
        campoCodigo.setEditable(false);
    }//GEN-LAST:event_tablaElementosMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String codigo = campoCodigo.getText().trim();
        String nombre = campoNombre.getText().trim();
        String categoria = comboCategoria.getSelectedItem().toString();
        int cantidad = Integer.parseInt(campoCantidad.getText().trim());
        double precio = Double.parseDouble(campoPrecio.getText().trim());

        if (filaSeleccionada == -1) {
            // Registro nuevo
            if (buscarElemento(codigo) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un elemento con ese código");
                return;
            }
            listaElementos.add(new Elemento(codigo, nombre, categoria, cantidad, precio));
            JOptionPane.showMessageDialog(this, "Elemento registrado");
        } else {
            // Edición del elemento elegido en la tabla
            Elemento elemento = listaElementos.get(filaSeleccionada);
            elemento.setNombre(nombre);
            elemento.setCategoria(categoria);
            elemento.setCantidad(cantidad);
            elemento.setPrecio(precio);
            JOptionPane.showMessageDialog(this, "Datos actualizados");
        }
        ArchivoTexto.guardarElementos(listaElementos);
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Primero elige un elemento en la tabla");
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este elemento?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            listaElementos.remove(filaSeleccionada);
            ArchivoTexto.guardarElementos(listaElementos);
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
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaCategoria;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JScrollPane scrollElementos;
    private javax.swing.JTable tablaElementos;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel panelFranjaInferior;
    // End of variables declaration//GEN-END:variables
}
