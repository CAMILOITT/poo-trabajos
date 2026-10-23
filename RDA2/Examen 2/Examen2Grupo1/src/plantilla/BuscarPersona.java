package plantilla;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Busca una persona por su cédula y muestra sus datos sin dejar editarlos.
 */
public class BuscarPersona extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Persona> listaPersonas;

    public BuscarPersona(javax.swing.JFrame ventanaAnterior, ArrayList<Persona> listaPersonas) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaPersonas = listaPersonas;
    }

    private void limpiarCampos() {
        campoBuscarCedula.setText("");
        campoNombres.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoBuscarCedula.requestFocus();
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
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscarCedula = new javax.swing.JLabel();
        campoBuscarCedula = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        panelResultado = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        etiquetaNombres = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaCorreo = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoNombres = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoCorreo = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar persona");
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
        panelBusqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 0));
        etiquetaBuscarCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaBuscarCedula.setText("Cédula");
        panelBusqueda.add(etiquetaBuscarCedula);

        campoBuscarCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoBuscarCedula.setColumns(14);
        panelBusqueda.add(campoBuscarCedula);

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plantilla/iconos/icono_buscar_chico.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 1), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.setOpaque(true);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        panelBusqueda.add(botonBuscar);

        panelContenido.add(panelBusqueda, java.awt.BorderLayout.NORTH);

        panelResultado.setLayout(new java.awt.BorderLayout(10, 0));
        panelEtiquetas.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        etiquetaNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaNombres.setText("Nombres");
        panelEtiquetas.add(etiquetaNombres);

        etiquetaApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaApellidos.setText("Apellidos");
        panelEtiquetas.add(etiquetaApellidos);

        etiquetaTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaTelefono.setText("Teléfono");
        panelEtiquetas.add(etiquetaTelefono);

        etiquetaCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCorreo.setText("Correo");
        panelEtiquetas.add(etiquetaCorreo);

        panelResultado.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setPreferredSize(new java.awt.Dimension(300, 160));
        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        campoNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombres.setEditable(false);
        panelCampos.add(campoNombres);

        campoApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoApellidos.setEditable(false);
        panelCampos.add(campoApellidos);

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoTelefono.setEditable(false);
        panelCampos.add(campoTelefono);

        campoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCorreo.setEditable(false);
        panelCampos.add(campoCorreo);

        panelResultado.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelResultado, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));
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

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String cedulaBuscada = campoBuscarCedula.getText().trim();
        if (Validaciones.estaVacio(cedulaBuscada)) {
            JOptionPane.showMessageDialog(this, "Escribe la cédula que quieres buscar");
            return;
        }
        for (Persona persona : listaPersonas) {
            if (persona.getCedula().equals(cedulaBuscada)) {
                campoNombres.setText(persona.getNombres());
                campoApellidos.setText(persona.getApellidos());
                campoTelefono.setText(persona.getTelefono());
                campoCorreo.setText(persona.getCorreo());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró ninguna persona con esa cédula");
        limpiarCampos();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JLabel etiquetaBuscarCedula;
    private javax.swing.JTextField campoBuscarCedula;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JPanel panelResultado;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JLabel etiquetaNombres;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JLabel etiquetaCorreo;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel panelFranjaInferior;
    // End of variables declaration//GEN-END:variables
}
