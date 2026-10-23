/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package minecraft;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Lista de Mobs en cuadricula: un cuadrado (imagen) por mob creado
 * y debajo el nombre. Al dar click se abre ventana para modificarlo.
 * Disenio verde/marron de la interfaz.
 *
 * Nota disenador: gridPanel se llena en tiempo de ejecucion
 * (ver cargarCuadricula). En el disenador aparece vacio.
 *
 * @author DET PC
 */
public class JFrame_ListaMobs extends javax.swing.JFrame {

    private ArrayList<Monstruo> bestiarioGlobal;
    private ArrayList<Zombie> listaZombies;
    private ArrayList<Esqueleto> listaEsqueletos;
    private ArrayList<Arania> listaAranias;

    public JFrame_ListaMobs(ArrayList<Monstruo> bestiarioGlobal,
            ArrayList<Zombie> listaZombies,
            ArrayList<Esqueleto> listaEsqueletos,
            ArrayList<Arania> listaAranias) {
        initComponents();
        this.bestiarioGlobal = bestiarioGlobal;
        this.listaZombies = listaZombies;
        this.listaEsqueletos = listaEsqueletos;
        this.listaAranias = listaAranias;
        postInit();
        cargarCuadricula();
    }

    public JFrame_ListaMobs() {
        initComponents();
        this.bestiarioGlobal = new ArrayList<>();
        this.listaZombies = new ArrayList<>();
        this.listaEsqueletos = new ArrayList<>();
        this.listaAranias = new ArrayList<>();
        postInit();
        cargarCuadricula();
    }

    /**
     * Estilos NO gestionados por el diseñador.
     */
    private void postInit() {
        CreeperStyle.error(buttonRegresar);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        setLocationRelativeTo(null);
    }

    private String tipoDe(Monstruo m) {
        if (m instanceof Zombie)
            return "Zombie";
        if (m instanceof Esqueleto)
            return "Esqueleto";
        if (m instanceof Arania)
            return "Arania";
        return "Monstruo";
    }

    private String iconoPara(Monstruo m) {
        if (m instanceof Zombie)
            return "/Incons/zombie.jpeg";
        if (m instanceof Esqueleto)
            return "/Incons/esqueleto.jpeg";
        if (m instanceof Arania)
            return "/Incons/arania.jpeg";
        return "/Incons/whiter.jpeg";
    }

    /** Construye un cuadrado por mob + nombre debajo. Click -> ventana editar. */
    private void cargarCuadricula() {
        gridPanel.removeAll();
        if (bestiarioGlobal != null) {
            for (Monstruo m : bestiarioGlobal) {
                gridPanel.add(crearTarjeta(m));
            }
        }
        if (bestiarioGlobal == null || bestiarioGlobal.isEmpty()) {
            javax.swing.JLabel vacio = new javax.swing.JLabel("No hay mobs creados.");
            vacio.setForeground(java.awt.Color.WHITE);
            gridPanel.add(vacio);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private javax.swing.JPanel crearTarjeta(Monstruo m) {
        javax.swing.JPanel card = new javax.swing.JPanel(new java.awt.BorderLayout(0, 4));
        card.setBackground(new java.awt.Color(42, 32, 24));
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 65, 25), 2));
        card.setPreferredSize(new Dimension(150, 180));

        javax.swing.JButton cuadrado = new javax.swing.JButton();
        cuadrado.setPreferredSize(new Dimension(140, 130));
        cuadrado.setFocusPainted(false);
        cuadrado.setToolTipText(m.getCodigo() + " - " + m.getNombre() + " [" + tipoDe(m) + "]");
        try {
            Image img = new ImageIcon(getClass().getResource(iconoPara(m))).getImage()
                    .getScaledInstance(130, 120, Image.SCALE_SMOOTH);
            cuadrado.setIcon(new ImageIcon(img));
            cuadrado.setText("");
        } catch (Exception ex) {
            cuadrado.setText(tipoDe(m));
        }
        cuadrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadrado.addActionListener(e -> abrirEdicion(m));

        javax.swing.JLabel lblNombre = new javax.swing.JLabel(
                "<html><center>" + m.getCodigo() + "<br>" + m.getNombre() + "</center></html>",
                javax.swing.SwingConstants.CENTER);
        lblNombre.setForeground(java.awt.Color.WHITE);
        lblNombre.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        card.add(cuadrado, java.awt.BorderLayout.CENTER);
        card.add(lblNombre, java.awt.BorderLayout.SOUTH);
        return card;
    }

    private void abrirEdicion(Monstruo m) {
        JFrame_EditarMob editor = new JFrame_EditarMob(m, this::cargarCuadricula);
        editor.setLocationRelativeTo(this);
        editor.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        buttonRegresar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        gridPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Mobs");
        setMinimumSize(new java.awt.Dimension(750, 550));

        jPanel1.setBackground(new java.awt.Color(15, 65, 25));

        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Incons/Minecraft_name_icon.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(name)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE));

        jPanel2.setBackground(new java.awt.Color(74, 55, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        topBar.setOpaque(false);
        topBar.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Mobs creados");
        topBar.add(lblTitulo, java.awt.BorderLayout.WEST);

        buttonRegresar.setBackground(new java.awt.Color(200, 40, 40));
        buttonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        buttonRegresar.setText("Regresar");
        buttonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegresarActionPerformed(evt);
            }
        });
        topBar.add(buttonRegresar, java.awt.BorderLayout.EAST);

        jPanel2.add(topBar, java.awt.BorderLayout.NORTH);

        gridPanel.setBackground(new java.awt.Color(74, 55, 40));
        gridPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 15));
        scroll.setViewportView(gridPanel);
        scroll.setPreferredSize(new java.awt.Dimension(700, 400));

        jPanel2.add(scroll, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 730,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonRegresarActionPerformed
        JFrame_Menu menu = new JFrame_Menu(bestiarioGlobal, listaZombies, listaEsqueletos, listaAranias);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_buttonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegresar;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel name;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
}
