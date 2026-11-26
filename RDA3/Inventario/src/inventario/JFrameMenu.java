package inventario;

public class JFrameMenu extends javax.swing.JFrame {

    public JFrameMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFranjaSuperior = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelEncabezado = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaSubtitulo = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        botonProveedores = new javax.swing.JButton();
        botonCategorias = new javax.swing.JButton();
        botonArticulos = new javax.swing.JButton();
        botonMovimientos = new javax.swing.JButton();
        botonConsultas = new javax.swing.JButton();
        panelInferior = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario - Menu principal");

        panelFranjaSuperior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaSuperior.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(panelFranjaSuperior, java.awt.BorderLayout.NORTH);

        panelContenido.setBackground(new java.awt.Color(236, 240, 244));
        panelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 15, 30));
        panelContenido.setLayout(new java.awt.BorderLayout(0, 18));

        panelEncabezado.setBackground(new java.awt.Color(236, 240, 244));
        panelEncabezado.setLayout(new java.awt.GridLayout(2, 1, 0, 4));

        etiquetaTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(31, 58, 95));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Sistema de Inventario");
        panelEncabezado.add(etiquetaTitulo);

        etiquetaSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaSubtitulo.setForeground(new java.awt.Color(80, 90, 110));
        etiquetaSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaSubtitulo.setText("Elija la opcion con la que desea trabajar");
        panelEncabezado.add(etiquetaSubtitulo);

        panelContenido.add(panelEncabezado, java.awt.BorderLayout.NORTH);

        panelOpciones.setBackground(new java.awt.Color(236, 240, 244));
        panelOpciones.setLayout(new java.awt.GridLayout(2, 3, 15, 15));

        botonProveedores.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_propietario.png"))); // NOI18N
        botonProveedores.setText("Proveedores");
        botonProveedores.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonProveedores.setContentAreaFilled(false);
        botonProveedores.setOpaque(true);
        botonProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonProveedores.setIconTextGap(8);
        botonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedoresActionPerformed(evt);
            }
        });
        panelOpciones.add(botonProveedores);

        botonCategorias.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_carrera.png"))); // NOI18N
        botonCategorias.setText("Categorias");
        botonCategorias.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonCategorias.setContentAreaFilled(false);
        botonCategorias.setOpaque(true);
        botonCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCategorias.setIconTextGap(8);
        botonCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCategoriasActionPerformed(evt);
            }
        });
        panelOpciones.add(botonCategorias);

        botonArticulos.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_asignatura.png"))); // NOI18N
        botonArticulos.setText("Articulos");
        botonArticulos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonArticulos.setContentAreaFilled(false);
        botonArticulos.setOpaque(true);
        botonArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonArticulos.setIconTextGap(8);
        botonArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArticulosActionPerformed(evt);
            }
        });
        panelOpciones.add(botonArticulos);

        botonMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_agendar.png"))); // NOI18N
        botonMovimientos.setText("Movimientos");
        botonMovimientos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonMovimientos.setContentAreaFilled(false);
        botonMovimientos.setOpaque(true);
        botonMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonMovimientos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonMovimientos.setIconTextGap(8);
        botonMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMovimientosActionPerformed(evt);
            }
        });
        panelOpciones.add(botonMovimientos);

        botonConsultas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_consulta.png"))); // NOI18N
        botonConsultas.setText("Consultas y graficos");
        botonConsultas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonConsultas.setContentAreaFilled(false);
        botonConsultas.setOpaque(true);
        botonConsultas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonConsultas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonConsultas.setIconTextGap(8);
        botonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultasActionPerformed(evt);
            }
        });
        panelOpciones.add(botonConsultas);

        panelContenido.add(panelOpciones, java.awt.BorderLayout.CENTER);

        panelInferior.setBackground(new java.awt.Color(236, 240, 244));
        panelInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        botonSalir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario/iconos/icono_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonSalir.setContentAreaFilled(false);
        botonSalir.setOpaque(true);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelInferior.add(botonSalir);

        panelContenido.add(panelInferior, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

        panelFranjaInferior.setBackground(new java.awt.Color(31, 58, 95));
        panelFranjaInferior.setPreferredSize(new java.awt.Dimension(100, 22));
        getContentPane().add(panelFranjaInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedoresActionPerformed
        abrirVentana(new JFrameProveedores());
    }//GEN-LAST:event_botonProveedoresActionPerformed

    private void botonCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCategoriasActionPerformed
        abrirVentana(new JFrameCategorias());
    }//GEN-LAST:event_botonCategoriasActionPerformed

    private void botonArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArticulosActionPerformed
        abrirVentana(new JFrameArticulos());
    }//GEN-LAST:event_botonArticulosActionPerformed

    private void botonMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMovimientosActionPerformed
        abrirVentana(new JFrameMovimientos());
    }//GEN-LAST:event_botonMovimientosActionPerformed

    private void botonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultasActionPerformed
        abrirVentana(new JFrameConsultas());
    }//GEN-LAST:event_botonConsultasActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void abrirVentana(javax.swing.JFrame ventana) {
        ventana.setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonArticulos;
    private javax.swing.JButton botonCategorias;
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonMovimientos;
    private javax.swing.JButton botonProveedores;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetaSubtitulo;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelEncabezado;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelOpciones;
    // End of variables declaration//GEN-END:variables
}
