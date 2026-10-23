package plantilla;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Reportes con JFreeChart. Un gráfico de barras y uno de pastel.
 * Necesita la librería jfreechart-1.5.5.jar agregada en Libraries.
 */
public class Reportes extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Mascota> listaElementos;

    public Reportes(javax.swing.JFrame ventanaAnterior, ArrayList<Mascota> listaElementos) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaElementos = listaElementos;
        mostrarGraficoBarras();
    }

    // Pone el gráfico dentro de panelGrafico (que tiene BorderLayout)
    private void mostrarGrafico(JFreeChart grafico) {
        panelGrafico.removeAll();
        panelGrafico.add(new ChartPanel(grafico), java.awt.BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    // Barras con la cantidad que hay de cada elemento
    private void mostrarGraficoBarras() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (Mascota elemento : listaElementos) {
            datos.addValue(elemento.getCantidad(), "Cantidad", elemento.getNombre());
        }
        JFreeChart grafico = ChartFactory.createBarChart("Cantidad por elemento", "Elemento", "Cantidad", datos);
        CategoryPlot area = grafico.getCategoryPlot();
        area.setBackgroundPaint(Color.WHITE);
        area.setRangeGridlinePaint(Color.LIGHT_GRAY);
        // Barras planas, sin brillo ni sombra, con el color del sistema
        BarRenderer barras = (BarRenderer) area.getRenderer();
        barras.setBarPainter(new StandardBarPainter());
        barras.setShadowVisible(false);
        barras.setSeriesPaint(0, new Color(0, 102, 153));
        // Para que el eje vertical muestre solo números enteros
        NumberAxis ejeCantidad = (NumberAxis) area.getRangeAxis();
        ejeCantidad.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        mostrarGrafico(grafico);
    }

    // Pastel con cuántos elementos hay en cada categoría
    private void mostrarGraficoPastel() {
        DefaultPieDataset<String> datos = new DefaultPieDataset<>();
        for (Mascota elemento : listaElementos) {
            String categoria = elemento.getCategoria();
            if (datos.getKeys().contains(categoria)) {
                datos.setValue(categoria, datos.getValue(categoria).intValue() + 1);
            } else {
                datos.setValue(categoria, 1);
            }
        }
        JFreeChart grafico = ChartFactory.createPieChart("Elementos por categoría", datos, true, true, false);
        PiePlot pastel = (PiePlot) grafico.getPlot();
        pastel.setBackgroundPaint(Color.WHITE);
        pastel.setOutlineVisible(false);
        pastel.setShadowPaint(null);
        // Cada etiqueta muestra la categoría y cuántos elementos tiene
        pastel.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
        mostrarGrafico(grafico);
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
        panelBotonesReporte = new javax.swing.JPanel();
        botonGraficoBarras = new javax.swing.JButton();
        botonGraficoPastel = new javax.swing.JButton();
        panelGrafico = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
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
        panelBotonesReporte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 0));
        botonGraficoBarras.setBackground(new java.awt.Color(255, 255, 255));
        botonGraficoBarras.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonGraficoBarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_barras.png"))); // NOI18N
        botonGraficoBarras.setText("Cantidad por elemento");
        botonGraficoBarras.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonGraficoBarras.setContentAreaFilled(false);
        botonGraficoBarras.setOpaque(true);
        botonGraficoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficoBarrasActionPerformed(evt);
            }
        });
        panelBotonesReporte.add(botonGraficoBarras);

        botonGraficoPastel.setBackground(new java.awt.Color(255, 255, 255));
        botonGraficoPastel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonGraficoPastel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_pastel.png"))); // NOI18N
        botonGraficoPastel.setText("Elementos por categoría");
        botonGraficoPastel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonGraficoPastel.setContentAreaFilled(false);
        botonGraficoPastel.setOpaque(true);
        botonGraficoPastel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficoPastelActionPerformed(evt);
            }
        });
        panelBotonesReporte.add(botonGraficoPastel);

        panelContenido.add(panelBotonesReporte, java.awt.BorderLayout.NORTH);

        panelGrafico.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafico.setPreferredSize(new java.awt.Dimension(620, 380));
        panelGrafico.setLayout(new java.awt.BorderLayout());
        panelContenido.add(panelGrafico, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));
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

    private void botonGraficoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficoBarrasActionPerformed
        mostrarGraficoBarras();
    }//GEN-LAST:event_botonGraficoBarrasActionPerformed

    private void botonGraficoPastelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficoPastelActionPerformed
        mostrarGraficoPastel();
    }//GEN-LAST:event_botonGraficoPastelActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelBotonesReporte;
    private javax.swing.JButton botonGraficoBarras;
    private javax.swing.JButton botonGraficoPastel;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel panelFranjaInferior;
    // End of variables declaration//GEN-END:variables
}
