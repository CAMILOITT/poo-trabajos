package universidad;

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
        botonCarreras = new javax.swing.JButton();
        botonEstudiantes = new javax.swing.JButton();
        botonAsignaturas = new javax.swing.JButton();
        botonMatriculas = new javax.swing.JButton();
        botonCalificaciones = new javax.swing.JButton();
        botonConsultas = new javax.swing.JButton();
        panelInferior = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Academico - Menu principal");

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
        etiquetaTitulo.setText("Sistema Academico");
        panelEncabezado.add(etiquetaTitulo);

        etiquetaSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaSubtitulo.setForeground(new java.awt.Color(80, 90, 110));
        etiquetaSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaSubtitulo.setText("Elija la opcion con la que desea trabajar");
        panelEncabezado.add(etiquetaSubtitulo);

        panelContenido.add(panelEncabezado, java.awt.BorderLayout.NORTH);

        panelOpciones.setBackground(new java.awt.Color(236, 240, 244));
        panelOpciones.setLayout(new java.awt.GridLayout(2, 3, 15, 15));

        botonCarreras.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonCarreras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_carrera.png"))); // NOI18N
        botonCarreras.setText("Carreras");
        botonCarreras.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonCarreras.setContentAreaFilled(false);
        botonCarreras.setOpaque(true);
        botonCarreras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCarreras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCarreras.setIconTextGap(8);
        botonCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarrerasActionPerformed(evt);
            }
        });
        panelOpciones.add(botonCarreras);

        botonEstudiantes.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_propietario.png"))); // NOI18N
        botonEstudiantes.setText("Estudiantes");
        botonEstudiantes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonEstudiantes.setContentAreaFilled(false);
        botonEstudiantes.setOpaque(true);
        botonEstudiantes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEstudiantes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEstudiantes.setIconTextGap(8);
        botonEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstudiantesActionPerformed(evt);
            }
        });
        panelOpciones.add(botonEstudiantes);

        botonAsignaturas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonAsignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_asignatura.png"))); // NOI18N
        botonAsignaturas.setText("Asignaturas");
        botonAsignaturas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonAsignaturas.setContentAreaFilled(false);
        botonAsignaturas.setOpaque(true);
        botonAsignaturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAsignaturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAsignaturas.setIconTextGap(8);
        botonAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignaturasActionPerformed(evt);
            }
        });
        panelOpciones.add(botonAsignaturas);

        botonMatriculas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonMatriculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_agendar.png"))); // NOI18N
        botonMatriculas.setText("Matriculas");
        botonMatriculas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonMatriculas.setContentAreaFilled(false);
        botonMatriculas.setOpaque(true);
        botonMatriculas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonMatriculas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonMatriculas.setIconTextGap(8);
        botonMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMatriculasActionPerformed(evt);
            }
        });
        panelOpciones.add(botonMatriculas);

        botonCalificaciones.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonCalificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_nota.png"))); // NOI18N
        botonCalificaciones.setText("Calificaciones");
        botonCalificaciones.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 58, 95)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonCalificaciones.setContentAreaFilled(false);
        botonCalificaciones.setOpaque(true);
        botonCalificaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCalificaciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCalificaciones.setIconTextGap(8);
        botonCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalificacionesActionPerformed(evt);
            }
        });
        panelOpciones.add(botonCalificaciones);

        botonConsultas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botonConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_consulta.png"))); // NOI18N
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
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/iconos/icono_salir.png"))); // NOI18N
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

    private void botonCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarrerasActionPerformed
        abrirVentana(new JFrameCarreras());
    }//GEN-LAST:event_botonCarrerasActionPerformed

    private void botonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstudiantesActionPerformed
        abrirVentana(new JFrameEstudiantes());
    }//GEN-LAST:event_botonEstudiantesActionPerformed

    private void botonAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignaturasActionPerformed
        abrirVentana(new JFrameAsignaturas());
    }//GEN-LAST:event_botonAsignaturasActionPerformed

    private void botonMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMatriculasActionPerformed
        abrirVentana(new JFrameMatriculas());
    }//GEN-LAST:event_botonMatriculasActionPerformed

    private void botonCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalificacionesActionPerformed
        abrirVentana(new JFrameCalificaciones());
    }//GEN-LAST:event_botonCalificacionesActionPerformed

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
    private javax.swing.JButton botonAsignaturas;
    private javax.swing.JButton botonCalificaciones;
    private javax.swing.JButton botonCarreras;
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonEstudiantes;
    private javax.swing.JButton botonMatriculas;
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
