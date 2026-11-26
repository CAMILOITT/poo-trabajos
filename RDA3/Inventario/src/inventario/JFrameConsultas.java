package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFrameConsultas extends javax.swing.JFrame {

    private final double UNIDADES_MINIMAS = 50;
    private final String TIPO_ENTRADA = "ENTRADA";
    private final String TIPO_SALIDA = "SALIDA";

    public JFrameConsultas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelSeleccion = new javax.swing.JPanel();
        etiquetaConsulta = new javax.swing.JLabel();
        comboConsultas = new javax.swing.JComboBox<>();
        panelResultados = new javax.swing.JPanel();
        scrollResultados = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelGrafico = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        etiquetaEstado = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario - Consultas");

        panelFranjaSuperior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(0, 12));

        panelSeleccion.setBackground(new java.awt.Color(236, 240, 244));
        panelSeleccion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        etiquetaConsulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiquetaConsulta.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaConsulta.setText("Consulta");
        panelSeleccion.add(etiquetaConsulta);

        comboConsultas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboConsultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Existencias por articulo", "Valor de existencias por categoria", "Proveedores con mas de 50 unidades de entrada", "Estadisticas de movimientos por tipo" }));
        comboConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConsultasActionPerformed(evt);
            }
        });
        panelSeleccion.add(comboConsultas);


        panelContenido.add(panelSeleccion, java.awt.BorderLayout.NORTH);

        panelResultados.setBackground(new java.awt.Color(236, 240, 244));
        panelResultados.setLayout(new java.awt.GridLayout(2, 1, 0, 12));

        tablaResultados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaResultados.setRowHeight(24);
        scrollResultados.setViewportView(tablaResultados);

        panelResultados.add(scrollResultados);

        panelGrafico.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafico.setLayout(new java.awt.BorderLayout());
        panelResultados.add(panelGrafico);

        panelContenido.add(panelResultados, java.awt.BorderLayout.CENTER);

        panelInferior.setBackground(new java.awt.Color(236, 240, 244));
        panelInferior.setLayout(new java.awt.BorderLayout());

        etiquetaEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        etiquetaEstado.setForeground(new java.awt.Color(80, 90, 110));
        etiquetaEstado.setText("Elija una consulta para ver los resultados");
        panelInferior.add(etiquetaEstado, java.awt.BorderLayout.CENTER);

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

    private void comboConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConsultasActionPerformed
        ejecutarConsulta();
    }//GEN-LAST:event_comboConsultasActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresarAlMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void regresarAlMenu() {
        JFrameMenu menu = new JFrameMenu();
        menu.setVisible(true);
        dispose();
    }

    private void ejecutarConsulta() {
        int opcion = comboConsultas.getSelectedIndex();
        if (opcion == 0) {
            cargarExistenciasPorArticulo();
        }
        if (opcion == 1) {
            cargarValorPorCategoria();
        }
        if (opcion == 2) {
            cargarProveedoresConEntradas();
        }
        if (opcion == 3) {
            cargarEstadisticasPorTipo();
        }
        if (tablaResultados.getRowCount() > 0) {
            mostrarGrafico(opcion);
        }
    }

    private void cargarExistenciasPorArticulo() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Articulo", "Categoria", "Entradas", "Salidas", "Existencias" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    a.nombre AS articulo,\n" +
            "    ca.nombre AS categoria,\n" +
            "    SUM(IIF(m.tipo = ?, m.cantidad, 0)) AS entradas,\n" +
            "    SUM(IIF(m.tipo = ?, m.cantidad, 0)) AS salidas,\n" +
            "    SUM(IIF(m.tipo = ?, m.cantidad, -m.cantidad)) AS existencias\n" +
            "FROM\n" +
            "    articulos AS a\n" +
            "    INNER JOIN categorias AS ca ON ca.id_categoria = a.id_categoria\n" +
            "    INNER JOIN movimientos AS m ON m.id_articulo = a.id_articulo\n" +
            "GROUP BY\n" +
            "    a.id_articulo,\n" +
            "    a.nombre,\n" +
            "    ca.nombre\n" +
            "ORDER BY\n" +
            "    existencias DESC;");
            sentencia.setString(1, TIPO_ENTRADA);
            sentencia.setString(2, TIPO_SALIDA);
            sentencia.setString(3, TIPO_ENTRADA);
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
            tablaResultados.setModel(modelo);
            resultado.close();
            sentencia.close();
            conexion.close();
            mostrarEstado(modelo.getRowCount());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarValorPorCategoria() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Categoria", "Articulos", "Unidades en existencia", "Valor de existencias" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    ca.nombre AS categoria,\n" +
            "    COUNT(DISTINCT a.id_articulo) AS articulos,\n" +
            "    SUM(IIF(m.tipo = ?, m.cantidad, -m.cantidad)) AS unidades,\n" +
            "    ROUND(SUM(IIF(m.tipo = ?, m.cantidad, -m.cantidad) * a.precio_unitario), 2) AS valor\n" +
            "FROM\n" +
            "    categorias AS ca\n" +
            "    INNER JOIN articulos AS a ON a.id_categoria = ca.id_categoria\n" +
            "    INNER JOIN movimientos AS m ON m.id_articulo = a.id_articulo\n" +
            "GROUP BY\n" +
            "    ca.id_categoria,\n" +
            "    ca.nombre\n" +
            "ORDER BY\n" +
            "    valor DESC;");
            sentencia.setString(1, TIPO_ENTRADA);
            sentencia.setString(2, TIPO_ENTRADA);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[4];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                modelo.addRow(fila);
            }
            tablaResultados.setModel(modelo);
            resultado.close();
            sentencia.close();
            conexion.close();
            mostrarEstado(modelo.getRowCount());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarProveedoresConEntradas() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Proveedor", "Ciudad", "Movimientos de entrada", "Unidades de entrada" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    p.nombre AS proveedor,\n" +
            "    p.ciudad AS ciudad,\n" +
            "    COUNT(m.id_movimiento) AS movimientos_entrada,\n" +
            "    SUM(m.cantidad) AS unidades_entrada\n" +
            "FROM\n" +
            "    proveedores AS p\n" +
            "    INNER JOIN articulos AS a ON a.id_proveedor = p.id_proveedor\n" +
            "    INNER JOIN movimientos AS m ON m.id_articulo = a.id_articulo\n" +
            "WHERE\n" +
            "    m.tipo = ?\n" +
            "GROUP BY\n" +
            "    p.id_proveedor,\n" +
            "    p.nombre,\n" +
            "    p.ciudad\n" +
            "HAVING\n" +
            "    SUM(m.cantidad) > ?\n" +
            "ORDER BY\n" +
            "    unidades_entrada DESC;");
            sentencia.setString(1, TIPO_ENTRADA);
            sentencia.setDouble(2, UNIDADES_MINIMAS);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[4];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
                fila[3] = resultado.getString(4);
                modelo.addRow(fila);
            }
            tablaResultados.setModel(modelo);
            resultado.close();
            sentencia.close();
            conexion.close();
            mostrarEstado(modelo.getRowCount());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void cargarEstadisticasPorTipo() {
        ConexionInventario conexionInventario = new ConexionInventario();
        Connection conexion = conexionInventario.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Tipo", "Numero de movimientos", "Total de unidades", "Promedio", "Cantidad maxima", "Cantidad minima" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    m.tipo AS tipo,\n" +
            "    COUNT(m.id_movimiento) AS numero_movimientos,\n" +
            "    SUM(m.cantidad) AS total_unidades,\n" +
            "    ROUND(AVG(m.cantidad), 2) AS promedio,\n" +
            "    MAX(m.cantidad) AS cantidad_maxima,\n" +
            "    MIN(m.cantidad) AS cantidad_minima\n" +
            "FROM\n" +
            "    movimientos AS m\n" +
            "GROUP BY\n" +
            "    m.tipo\n" +
            "ORDER BY\n" +
            "    total_unidades DESC;");
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
            tablaResultados.setModel(modelo);
            resultado.close();
            sentencia.close();
            conexion.close();
            mostrarEstado(modelo.getRowCount());
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    private void mostrarEstado(int filas) {
        etiquetaEstado.setText("Consulta ejecutada correctamente, " + filas + " fila(s) encontradas");
    }

    private void mostrarError(SQLException e) {
        tablaResultados.setModel(new DefaultTableModel());
        etiquetaEstado.setText("Error al ejecutar la consulta");
        JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarGrafico(int opcion) {
        DefaultCategoryDataset datos;
        if (opcion == 3) {
            datos = crearDatosMovimientos();
        } else {
            datos = crearDatosConsulta();
        }
        JFreeChart grafico = crearGrafico(opcion, datos);
        ChartPanel panel = new ChartPanel(grafico);
        panelGrafico.removeAll();
        panelGrafico.add(panel, java.awt.BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    private DefaultCategoryDataset crearDatosConsulta() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        int ultimaColumna = tablaResultados.getColumnCount() - 1;
        for (int i = 0; i < tablaResultados.getRowCount(); i++) {
            String nombre = tablaResultados.getValueAt(i, 0).toString();
            double valor = Double.parseDouble(tablaResultados.getValueAt(i, ultimaColumna).toString());
            datos.addValue(valor, "Total", nombre);
        }
        return datos;
    }

    private DefaultCategoryDataset crearDatosMovimientos() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (int i = 0; i < tablaResultados.getRowCount(); i++) {
            String tipo = tablaResultados.getValueAt(i, 0).toString();
            double unidades = Double.parseDouble(tablaResultados.getValueAt(i, 2).toString());
            datos.addValue(unidades, "Total de unidades", tipo);
        }
        return datos;
    }

    private JFreeChart crearGrafico(int opcion, DefaultCategoryDataset datos) {
        String titulo = "Existencias por articulo";
        String ejeX = "Articulo";
        String ejeY = "Unidades";
        if (opcion == 1) {
            titulo = "Valor de existencias por categoria";
            ejeX = "Categoria";
            ejeY = "Valor (dolares)";
        }
        if (opcion == 2) {
            titulo = "Proveedores con mas de 50 unidades de entrada";
            ejeX = "Proveedor";
        }
        if (opcion == 3) {
            titulo = "Total de unidades por tipo de movimiento";
            ejeX = "Tipo";
        }
        JFreeChart grafico = ChartFactory.createBarChart(titulo, ejeX, ejeY, datos,
                PlotOrientation.HORIZONTAL, false, true, false);
        darFormatoGrafico(grafico);
        return grafico;
    }

    private void darFormatoGrafico(JFreeChart grafico) {
        CategoryPlot plano = grafico.getCategoryPlot();
        plano.setBackgroundPaint(java.awt.Color.WHITE);
        plano.setRangeGridlinePaint(java.awt.Color.LIGHT_GRAY);

        BarRenderer barras = (BarRenderer) plano.getRenderer();
        barras.setSeriesPaint(0, new java.awt.Color(46, 111, 186));
        barras.setBarPainter(new StandardBarPainter());
        barras.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barras.setDefaultItemLabelsVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox<String> comboConsultas;
    private javax.swing.JLabel etiquetaConsulta;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
