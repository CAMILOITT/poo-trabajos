package universidad;

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

    private final double NOTA_APROBACION = 30;

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
        botonEjecutar = new javax.swing.JButton();
        panelResultados = new javax.swing.JPanel();
        scrollResultados = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelGrafico = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        etiquetaEstado = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Academico - Consultas");

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
        comboConsultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Promedio y numero de notas por asignatura", "Promedio por carrera", "Asignaturas con promedio mayor o igual a 30", "Resumen global de notas" }));
        panelSeleccion.add(comboConsultas);

        botonEjecutar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_consulta.png"))); // NOI18N
        botonEjecutar.setText("Ejecutar");
        botonEjecutar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonEjecutar.setContentAreaFilled(false);
        botonEjecutar.setOpaque(true);
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });
        panelSeleccion.add(botonEjecutar);

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
        etiquetaEstado.setText("Elija una consulta y presione Ejecutar");
        panelInferior.add(etiquetaEstado, java.awt.BorderLayout.CENTER);

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

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
        ejecutarConsulta();
    }//GEN-LAST:event_botonEjecutarActionPerformed

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
            cargarPromedioPorAsignatura();
        }
        if (opcion == 1) {
            cargarPromedioPorCarrera();
        }
        if (opcion == 2) {
            cargarAsignaturasAprobadas();
        }
        if (opcion == 3) {
            cargarResumenGlobal();
        }
        if (tablaResultados.getRowCount() > 0) {
            mostrarGrafico(opcion);
        }
    }

    private void cargarPromedioPorAsignatura() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Asignatura", "Numero de notas", "Promedio" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    a.nombre AS asignatura,\n" +
            "    COUNT(c.id_calificacion) AS numero_notas,\n" +
            "    ROUND(AVG(c.nota), 2) AS promedio\n" +
            "FROM\n" +
            "    asignaturas AS a\n" +
            "    INNER JOIN matriculas AS m ON m.id_asignatura = a.id_asignatura\n" +
            "    INNER JOIN calificaciones AS c ON c.id_matricula = m.id_matricula\n" +
            "GROUP BY\n" +
            "    a.id_asignatura,\n" +
            "    a.nombre\n" +
            "ORDER BY\n" +
            "    promedio DESC;");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[3];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
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

    private void cargarPromedioPorCarrera() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Carrera", "Estudiantes", "Numero de notas", "Promedio" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    ca.nombre AS carrera,\n" +
            "    COUNT(DISTINCT e.id_estudiante) AS estudiantes,\n" +
            "    COUNT(c.id_calificacion) AS numero_notas,\n" +
            "    ROUND(AVG(c.nota), 2) AS promedio\n" +
            "FROM\n" +
            "    carreras AS ca\n" +
            "    INNER JOIN estudiantes AS e ON e.id_carrera = ca.id_carrera\n" +
            "    INNER JOIN matriculas AS m ON m.id_estudiante = e.id_estudiante\n" +
            "    INNER JOIN calificaciones AS c ON c.id_matricula = m.id_matricula\n" +
            "GROUP BY\n" +
            "    ca.id_carrera,\n" +
            "    ca.nombre\n" +
            "ORDER BY\n" +
            "    promedio DESC;");
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

    private void cargarAsignaturasAprobadas() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Asignatura", "Numero de notas", "Promedio" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    a.nombre AS asignatura,\n" +
            "    COUNT(c.id_calificacion) AS numero_notas,\n" +
            "    ROUND(AVG(c.nota), 2) AS promedio\n" +
            "FROM\n" +
            "    asignaturas AS a\n" +
            "    INNER JOIN matriculas AS m ON m.id_asignatura = a.id_asignatura\n" +
            "    INNER JOIN calificaciones AS c ON c.id_matricula = m.id_matricula\n" +
            "GROUP BY\n" +
            "    a.id_asignatura,\n" +
            "    a.nombre\n" +
            "HAVING\n" +
            "    AVG(c.nota) >= ?\n" +
            "ORDER BY\n" +
            "    promedio DESC;");
            sentencia.setDouble(1, NOTA_APROBACION);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String[] fila = new String[3];
                fila[0] = resultado.getString(1);
                fila[1] = resultado.getString(2);
                fila[2] = resultado.getString(3);
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

    private void cargarResumenGlobal() {
        ConexionUniversidad conexionUniversidad = new ConexionUniversidad();
        Connection conexion = conexionUniversidad.abrirConexion();
        if (conexion == null) {
            etiquetaEstado.setText("No hay conexion con la base de datos");
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Total de notas", "Promedio", "Nota maxima", "Nota minima", "Notas aprobadas", "Notas reprobadas" });
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT\n" +
            "    COUNT(c.id_calificacion) AS total_notas,\n" +
            "    ROUND(AVG(c.nota), 2) AS promedio,\n" +
            "    MAX(c.nota) AS nota_maxima,\n" +
            "    MIN(c.nota) AS nota_minima,\n" +
            "    SUM(IIF(c.nota >= ?, 1, 0)) AS aprobadas,\n" +
            "    SUM(IIF(c.nota < ?, 1, 0)) AS reprobadas\n" +
            "FROM\n" +
            "    calificaciones AS c;");
            sentencia.setDouble(1, NOTA_APROBACION);
            sentencia.setDouble(2, NOTA_APROBACION);
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
            datos = crearDatosResumen();
        } else {
            datos = crearDatosPromedios();
        }
        JFreeChart grafico = crearGrafico(opcion, datos);
        ChartPanel panel = new ChartPanel(grafico);
        panelGrafico.removeAll();
        panelGrafico.add(panel, java.awt.BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    private DefaultCategoryDataset crearDatosPromedios() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        int ultimaColumna = tablaResultados.getColumnCount() - 1;
        for (int i = 0; i < tablaResultados.getRowCount(); i++) {
            String nombre = tablaResultados.getValueAt(i, 0).toString();
            double promedio = Double.parseDouble(tablaResultados.getValueAt(i, ultimaColumna).toString());
            datos.addValue(promedio, "Promedio", nombre);
        }
        return datos;
    }

    private DefaultCategoryDataset crearDatosResumen() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(Double.parseDouble(tablaResultados.getValueAt(0, 1).toString()), "Nota", "Promedio");
        datos.addValue(Double.parseDouble(tablaResultados.getValueAt(0, 2).toString()), "Nota", "Nota maxima");
        datos.addValue(Double.parseDouble(tablaResultados.getValueAt(0, 3).toString()), "Nota", "Nota minima");
        return datos;
    }

    private JFreeChart crearGrafico(int opcion, DefaultCategoryDataset datos) {
        String titulo = "Promedio de notas por asignatura";
        String ejeX = "Asignatura";
        if (opcion == 1) {
            titulo = "Promedio de notas por carrera";
            ejeX = "Carrera";
        }
        if (opcion == 2) {
            titulo = "Asignaturas con promedio mayor o igual a 30";
        }
        if (opcion == 3) {
            titulo = "Resumen global de notas";
            ejeX = "Medida";
        }
        JFreeChart grafico = ChartFactory.createBarChart(titulo, ejeX, "Nota (sobre 50)", datos,
                PlotOrientation.HORIZONTAL, false, true, false);
        darFormatoGrafico(grafico);
        return grafico;
    }

    private void darFormatoGrafico(JFreeChart grafico) {
        CategoryPlot plano = grafico.getCategoryPlot();
        plano.setBackgroundPaint(java.awt.Color.WHITE);
        plano.setRangeGridlinePaint(java.awt.Color.LIGHT_GRAY);
        plano.getRangeAxis().setRange(0, 55);

        BarRenderer barras = (BarRenderer) plano.getRenderer();
        barras.setSeriesPaint(0, new java.awt.Color(46, 111, 186));
        barras.setBarPainter(new StandardBarPainter());
        barras.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barras.setDefaultItemLabelsVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEjecutar;
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
