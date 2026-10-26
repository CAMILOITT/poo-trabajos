package veterinaria;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFrameReportes extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Mascota> listaDeMascotas;

    public JFrameReportes(javax.swing.JFrame ventanaAnterior, ArrayList<Mascota> listaDeMascotas) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaDeMascotas = listaDeMascotas;
    }

    private DefaultCategoryDataset contarPerrosPorRaza() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (Mascota mascota : listaDeMascotas) {
            if (mascota.getEspecie().equalsIgnoreCase("Perro")) {
                String raza = mascota.getRaza();
                if (datos.getColumnKeys().contains(raza)) {
                    int cantidad = datos.getValue("Perros", raza).intValue();
                    datos.setValue(cantidad + 1, "Perros", raza);
                } else {
                    datos.setValue(1, "Perros", raza);
                }
            }
        }
        return datos;
    }

    private JFreeChart crearGraficoBarras(DefaultCategoryDataset datos) {
        JFreeChart grafico = ChartFactory.createBarChart("Perros por raza", "Raza", "Cantidad de perros", datos);
        CategoryPlot area = grafico.getCategoryPlot();
        area.setBackgroundPaint(Color.WHITE);
        area.setRangeGridlinePaint(Color.LIGHT_GRAY);
        BarRenderer barras = (BarRenderer) area.getRenderer();
        barras.setBarPainter(new StandardBarPainter());
        barras.setShadowVisible(false);
        barras.setSeriesPaint(0, new Color(64, 120, 172));
        NumberAxis ejeCantidad = (NumberAxis) area.getRangeAxis();
        ejeCantidad.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return grafico;
    }

    private void mostrarGrafico(JFreeChart grafico) {
        panelGrafico.removeAll();
        panelGrafico.add(new ChartPanel(grafico), java.awt.BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    private void regresar() {
        ventanaAnterior.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelGrafico = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelFranjaSuperior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
        panelContenido.setLayout(new java.awt.BorderLayout(0, 15));

        panelGrafico.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafico.setPreferredSize(new java.awt.Dimension(640, 380));
        panelGrafico.setLayout(new java.awt.BorderLayout());
        panelContenido.add(panelGrafico, java.awt.BorderLayout.CENTER);

        panelBotones.setBackground(new java.awt.Color(236, 240, 244));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_regresar.png"))); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
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

        panelFranjaInferior.setBackground(new java.awt.Color(120, 172, 214));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostrarGrafico(crearGraficoBarras(contarPerrosPorRaza()));
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables
}
