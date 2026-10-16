/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemacalculadora;

import java.awt.Color;

/**
 *
 * @author grupo1
 */
public class JFrame_Calculadora extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrame_Calculadora.class.getName());
    private char operacionIndicador;
    Calculadora calculadora = new Calculadora();

    public JFrame_Calculadora() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(new Color(77,83,81));
    }

    private double leerNumero() {
        String texto = pantallaResultado.getText().replace(",", ".");
        return Double.parseDouble(texto);
    }

    private String formatearNumero(double numero) {
        java.text.DecimalFormatSymbols simbolos = new java.text.DecimalFormatSymbols();
        simbolos.setDecimalSeparator(',');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("0.##########", simbolos);
        return formato.format(numero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPantallas = new javax.swing.JPanel();
        pantallaOperacion = new javax.swing.JTextField();
        pantallaResultado = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        botonPotencia = new javax.swing.JButton();
        botonDivision = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonNumero7 = new javax.swing.JButton();
        botonNumero8 = new javax.swing.JButton();
        botonNumero9 = new javax.swing.JButton();
        botonMultiplicacion = new javax.swing.JButton();
        botonNumero4 = new javax.swing.JButton();
        botonNumero5 = new javax.swing.JButton();
        botonNumero6 = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        botonNumero1 = new javax.swing.JButton();
        botonNumero2 = new javax.swing.JButton();
        botonNumero3 = new javax.swing.JButton();
        botonSumar = new javax.swing.JButton();
        botonPorcentaje = new javax.swing.JButton();
        botonNumero0 = new javax.swing.JButton();
        botonComa = new javax.swing.JButton();
        botonIgual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setBackground(new java.awt.Color(77, 83, 81));
        setFont(new java.awt.Font("Monocraft", 0, 10)); // NOI18N
        setMinimumSize(new java.awt.Dimension(337, 470));
        setPreferredSize(new java.awt.Dimension(337, 470));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        panelPantallas.setForeground(new java.awt.Color(226, 245, 157));
        panelPantallas.setMaximumSize(new java.awt.Dimension(2147483647, 250));
        panelPantallas.setLayout(new javax.swing.BoxLayout(panelPantallas, javax.swing.BoxLayout.Y_AXIS));

        pantallaOperacion.setEditable(false);
        pantallaOperacion.setBackground(new java.awt.Color(20, 28, 31));
        pantallaOperacion.setFont(new java.awt.Font("Departure Mono", 1, 18)); // NOI18N
        pantallaOperacion.setForeground(new java.awt.Color(223, 114, 55));
        pantallaOperacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pantallaOperacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pantallaOperacion.addActionListener(this::pantallaOperacionActionPerformed);
        panelPantallas.add(pantallaOperacion);

        pantallaResultado.setEditable(false);
        pantallaResultado.setBackground(new java.awt.Color(20, 28, 31));
        pantallaResultado.setFont(new java.awt.Font("Departure Mono", 1, 18)); // NOI18N
        pantallaResultado.setForeground(new java.awt.Color(223, 114, 55));
        pantallaResultado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pantallaResultado.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pantallaResultado.addActionListener(this::pantallaResultadoActionPerformed);
        panelPantallas.add(pantallaResultado);

        getContentPane().add(panelPantallas);

        panelBotones.setBackground(new java.awt.Color(77, 83, 81));
        panelBotones.setForeground(new java.awt.Color(226, 245, 157));
        panelBotones.setMinimumSize(new java.awt.Dimension(250, 250));
        panelBotones.setPreferredSize(new java.awt.Dimension(187, 200));
        panelBotones.setLayout(new java.awt.GridLayout(5, 4, 3, 3));

        botonPotencia.setBackground(new java.awt.Color(229, 224, 193));
        botonPotencia.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonPotencia.setForeground(new java.awt.Color(67, 75, 74));
        botonPotencia.setText("^");
        botonPotencia.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonPotencia.setFocusPainted(false);
        botonPotencia.addActionListener(this::botonPotenciaActionPerformed);
        panelBotones.add(botonPotencia);

        botonDivision.setBackground(new java.awt.Color(229, 224, 193));
        botonDivision.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonDivision.setForeground(new java.awt.Color(67, 75, 74));
        botonDivision.setText("/");
        botonDivision.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonDivision.setFocusPainted(false);
        botonDivision.addActionListener(this::botonDivisionActionPerformed);
        panelBotones.add(botonDivision);

        botonBorrar.setBackground(new java.awt.Color(229, 224, 193));
        botonBorrar.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(67, 75, 74));
        botonBorrar.setText("←");
        botonBorrar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonBorrar.setFocusPainted(false);
        botonBorrar.addActionListener(this::botonBorrarActionPerformed);
        panelBotones.add(botonBorrar);

        botonLimpiar.setBackground(new java.awt.Color(223, 114, 55));
        botonLimpiar.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonLimpiar.setForeground(new java.awt.Color(229, 224, 193));
        botonLimpiar.setText("A/C");
        botonLimpiar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(143, 70, 34)));
        botonLimpiar.setFocusPainted(false);
        botonLimpiar.addActionListener(this::botonLimpiarActionPerformed);
        panelBotones.add(botonLimpiar);

        botonNumero7.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero7.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero7.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero7.setText("7");
        botonNumero7.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero7.setFocusPainted(false);
        botonNumero7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero7.addActionListener(this::botonNumero7ActionPerformed);
        panelBotones.add(botonNumero7);

        botonNumero8.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero8.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero8.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero8.setText("8");
        botonNumero8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero8.setFocusPainted(false);
        botonNumero8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero8.addActionListener(this::botonNumero8ActionPerformed);
        panelBotones.add(botonNumero8);

        botonNumero9.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero9.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero9.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero9.setText("9");
        botonNumero9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero9.setFocusPainted(false);
        botonNumero9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero9.addActionListener(this::botonNumero9ActionPerformed);
        panelBotones.add(botonNumero9);

        botonMultiplicacion.setBackground(new java.awt.Color(229, 224, 193));
        botonMultiplicacion.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonMultiplicacion.setForeground(new java.awt.Color(67, 75, 74));
        botonMultiplicacion.setText("x");
        botonMultiplicacion.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonMultiplicacion.setFocusPainted(false);
        botonMultiplicacion.addActionListener(this::botonMultiplicacionActionPerformed);
        panelBotones.add(botonMultiplicacion);

        botonNumero4.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero4.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero4.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero4.setText("4");
        botonNumero4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero4.setFocusPainted(false);
        botonNumero4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero4.addActionListener(this::botonNumero4ActionPerformed);
        panelBotones.add(botonNumero4);

        botonNumero5.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero5.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero5.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero5.setText("5");
        botonNumero5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero5.setFocusPainted(false);
        botonNumero5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero5.addActionListener(this::botonNumero5ActionPerformed);
        panelBotones.add(botonNumero5);

        botonNumero6.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero6.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero6.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero6.setText("6");
        botonNumero6.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero6.setFocusPainted(false);
        botonNumero6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero6.addActionListener(this::botonNumero6ActionPerformed);
        panelBotones.add(botonNumero6);

        botonMenos.setBackground(new java.awt.Color(229, 224, 193));
        botonMenos.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonMenos.setForeground(new java.awt.Color(67, 75, 74));
        botonMenos.setText("-");
        botonMenos.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonMenos.setFocusPainted(false);
        botonMenos.addActionListener(this::botonMenosActionPerformed);
        panelBotones.add(botonMenos);

        botonNumero1.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero1.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero1.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero1.setText("1");
        botonNumero1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero1.setFocusPainted(false);
        botonNumero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero1.addActionListener(this::botonNumero1ActionPerformed);
        panelBotones.add(botonNumero1);

        botonNumero2.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero2.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero2.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero2.setText("2");
        botonNumero2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero2.setFocusPainted(false);
        botonNumero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero2.addActionListener(this::botonNumero2ActionPerformed);
        panelBotones.add(botonNumero2);

        botonNumero3.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero3.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero3.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero3.setText("3");
        botonNumero3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero3.setFocusPainted(false);
        botonNumero3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero3.addActionListener(this::botonNumero3ActionPerformed);
        panelBotones.add(botonNumero3);

        botonSumar.setBackground(new java.awt.Color(229, 224, 193));
        botonSumar.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonSumar.setForeground(new java.awt.Color(67, 75, 74));
        botonSumar.setText("+");
        botonSumar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonSumar.setFocusPainted(false);
        botonSumar.addActionListener(this::botonSumarActionPerformed);
        panelBotones.add(botonSumar);

        botonPorcentaje.setBackground(new java.awt.Color(229, 224, 193));
        botonPorcentaje.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonPorcentaje.setForeground(new java.awt.Color(67, 75, 74));
        botonPorcentaje.setText("%");
        botonPorcentaje.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(148, 139, 111)));
        botonPorcentaje.setFocusPainted(false);
        botonPorcentaje.addActionListener(this::botonPorcentajeActionPerformed);
        panelBotones.add(botonPorcentaje);

        botonNumero0.setBackground(new java.awt.Color(67, 75, 74));
        botonNumero0.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonNumero0.setForeground(new java.awt.Color(229, 224, 193));
        botonNumero0.setText("0");
        botonNumero0.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonNumero0.setFocusPainted(false);
        botonNumero0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonNumero0.addActionListener(this::botonNumero0ActionPerformed);
        panelBotones.add(botonNumero0);

        botonComa.setBackground(new java.awt.Color(67, 75, 74));
        botonComa.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonComa.setForeground(new java.awt.Color(229, 224, 193));
        botonComa.setText(",");
        botonComa.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(44, 49, 49)));
        botonComa.setFocusPainted(false);
        botonComa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hoverButton(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                unHoverButton(evt);
            }
        });
        botonComa.addActionListener(this::botonComaActionPerformed);
        panelBotones.add(botonComa);

        botonIgual.setBackground(new java.awt.Color(223, 114, 55));
        botonIgual.setFont(new java.awt.Font("Departure Mono", 1, 24)); // NOI18N
        botonIgual.setForeground(new java.awt.Color(229, 224, 193));
        botonIgual.setText("=");
        botonIgual.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 5, 3, 5, new java.awt.Color(143, 70, 34)));
        botonIgual.setFocusPainted(false);
        botonIgual.addActionListener(this::botonIgualActionPerformed);
        panelBotones.add(botonIgual);

        getContentPane().add(panelBotones);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        String texto = pantallaResultado.getText();
        if (!texto.isEmpty()) {
            pantallaResultado.setText(texto.substring(0, texto.length() - 1));
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        pantallaOperacion.setText("");
        pantallaResultado.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonNumero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero3ActionPerformed
        // TODO add your handling code here:

        String textoIngresado = pantallaResultado.getText() + "3";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero3ActionPerformed

    private void botonNumero7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero7ActionPerformed
        //se declara una variable local
        String textoIngresado = pantallaResultado.getText() + "7";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero7ActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        // TODO add your handling code here:
        double texto1 = leerNumero();
        calculadora.setOperado1(texto1);
        operacionIndicador = '+';
        pantallaOperacion.setText(pantallaResultado.getText() + " + ");
        pantallaResultado.setText("");

    }//GEN-LAST:event_botonSumarActionPerformed

    private void botonNumero8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero8ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "8";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero8ActionPerformed

    private void botonNumero9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero9ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "9";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero9ActionPerformed

    private void botonNumero4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero4ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "4";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero4ActionPerformed

    private void botonNumero5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero5ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "5";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero5ActionPerformed

    private void botonNumero6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero6ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "6";
        pantallaResultado.setText(textoIngresado);

    }//GEN-LAST:event_botonNumero6ActionPerformed

    private void botonNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero1ActionPerformed
        // TODO add your handling code here:

        String textoIngresado = pantallaResultado.getText() + "1";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero1ActionPerformed

    private void botonNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero2ActionPerformed
        // TODO add your handling code here:
        String textoIngresado = pantallaResultado.getText() + "2";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero2ActionPerformed

    private void botonNumero0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero0ActionPerformed
        // TODO add your handling code here:

        String textoIngresado = pantallaResultado.getText() + "0";
        pantallaResultado.setText(textoIngresado);
    }//GEN-LAST:event_botonNumero0ActionPerformed

    private void botonMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMultiplicacionActionPerformed

        double textoIngresado = leerNumero();
        calculadora.setOperado1(textoIngresado);
        operacionIndicador = 'x';
        pantallaOperacion.setText(pantallaResultado.getText() + " x ");
        pantallaResultado.setText("");
    }//GEN-LAST:event_botonMultiplicacionActionPerformed

    private void pantallaResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantallaResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pantallaResultadoActionPerformed

    private void pantallaOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantallaOperacionActionPerformed
        // TODO add your handling code here:
        double valorActual = calculadora.getOperado1();
        pantallaResultado.setText(String.valueOf(valorActual));
    }//GEN-LAST:event_pantallaOperacionActionPerformed

    private void botonIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgualActionPerformed
        double valorSegundo = leerNumero();
        calculadora.setOperado2(valorSegundo);
        double resultado = 0;
        switch (operacionIndicador) {
            case '+':
                resultado = calculadora.sumar();
                break;
            case '-':
                resultado = calculadora.restar();
                break;
            case 'x':
                resultado = calculadora.multiplicar();
                break;
            case '/':
                resultado = calculadora.dividir();
                break;
            case '^':
                resultado = calculadora.potencia();
                break;
            case '%':
                resultado = calculadora.porcentaje();
        }
        pantallaOperacion.setText(pantallaOperacion.getText() + pantallaResultado.getText() + " =");
        pantallaResultado.setText(formatearNumero(resultado));
    }//GEN-LAST:event_botonIgualActionPerformed

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
        // TODO add your handling code here:
        double textoIngresado = leerNumero();
        calculadora.setOperado1(textoIngresado);
        operacionIndicador = '-';
        pantallaOperacion.setText(pantallaResultado.getText() + " - ");
        pantallaResultado.setText("");
    }//GEN-LAST:event_botonMenosActionPerformed

    private void botonDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDivisionActionPerformed
        // TODO add your handling code here:
        double textoIngresado = leerNumero();
        calculadora.setOperado1(textoIngresado);
        operacionIndicador = '/';
        pantallaOperacion.setText(pantallaResultado.getText() + " / ");
        pantallaResultado.setText("");
    }//GEN-LAST:event_botonDivisionActionPerformed

    private void botonPotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPotenciaActionPerformed
        // TODO add your handling code here:
        double textoIngresado = leerNumero();
        calculadora.setOperado1(textoIngresado);
        operacionIndicador = '^';
        pantallaOperacion.setText(pantallaResultado.getText() + " ^ ");
        pantallaResultado.setText("");
    }//GEN-LAST:event_botonPotenciaActionPerformed

    private void botonPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPorcentajeActionPerformed
        // TODO add your handling code here:
        double textoIngresado = leerNumero();
        calculadora.setOperado1(textoIngresado);
        operacionIndicador = '%';
        pantallaOperacion.setText(pantallaResultado.getText() + " % ");
        pantallaResultado.setText("");

    }//GEN-LAST:event_botonPorcentajeActionPerformed

    private void botonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComaActionPerformed
        // TODO add your handling code here:
        String texto = pantallaResultado.getText();
        if (texto.isEmpty()) {
            pantallaResultado.setText("0,");
        } else if (!texto.contains(",")) {
            pantallaResultado.setText(texto + ",");
        }
    }//GEN-LAST:event_botonComaActionPerformed

    private void hoverButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoverButton
         javax.swing.JButton btn = (javax.swing.JButton) evt.getSource();
         btn.setBackground(new java.awt.Color(108, 112, 90));
    }//GEN-LAST:event_hoverButton

    private void unHoverButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unHoverButton
        javax.swing.JButton btn = (javax.swing.JButton) evt.getSource();
        btn.setBackground(new java.awt.Color(67, 75, 74));
    }//GEN-LAST:event_unHoverButton

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrame_Calculadora().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonComa;
    private javax.swing.JButton botonDivision;
    private javax.swing.JButton botonIgual;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonMenos;
    private javax.swing.JButton botonMultiplicacion;
    private javax.swing.JButton botonNumero0;
    private javax.swing.JButton botonNumero1;
    private javax.swing.JButton botonNumero2;
    private javax.swing.JButton botonNumero3;
    private javax.swing.JButton botonNumero4;
    private javax.swing.JButton botonNumero5;
    private javax.swing.JButton botonNumero6;
    private javax.swing.JButton botonNumero7;
    private javax.swing.JButton botonNumero8;
    private javax.swing.JButton botonNumero9;
    private javax.swing.JButton botonPorcentaje;
    private javax.swing.JButton botonPotencia;
    private javax.swing.JButton botonSumar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPantallas;
    private javax.swing.JTextField pantallaOperacion;
    private javax.swing.JTextField pantallaResultado;
    // End of variables declaration//GEN-END:variables
}
