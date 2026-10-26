package veterinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameGestionarCitas extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArchivoTexto archivoTexto;
    private ArrayList<Cita> listaDeCitas;
    private ArrayList<Mascota> listaDeMascotas;
    private ArrayList<Veterinario> listaDeVeterinarios;

    public JFrameGestionarCitas(javax.swing.JFrame ventanaAnterior, ArchivoTexto archivoTexto,
            ArrayList<Cita> listaDeCitas, ArrayList<Mascota> listaDeMascotas,
            ArrayList<Veterinario> listaDeVeterinarios) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.archivoTexto = archivoTexto;
        this.listaDeCitas = listaDeCitas;
        this.listaDeMascotas = listaDeMascotas;
        this.listaDeVeterinarios = listaDeVeterinarios;
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaCitas.getModel();
        modeloTabla.setRowCount(0);
        for (Cita cita : listaDeCitas) {
            modeloTabla.addRow(new Object[]{cita.getIdCita(), cita.getFecha(),
                cita.getHora(), cita.getMascota().getNombre(), cita.getMascota().getPropietario().getNombre() + " "
                + cita.getMascota().getPropietario().getApellido(), cita.getVeterinario().getNombre() + " "
                + cita.getVeterinario().getApellido(), cita.getMotivo(), cita.getDiagnostico()});
        }
    }

    private void cargarComboMascotas() {
        comboMascota.removeAllItems();
        for (Mascota mascota : listaDeMascotas) {
            comboMascota.addItem(mascota.getCodigo() + " - " + mascota.getNombre() + " ("
                    + mascota.getPropietario().getNombre() + " " + mascota.getPropietario().getApellido() + ")");
        }
    }

    private void cargarComboVeterinarios() {
        comboVeterinario.removeAllItems();
        for (Veterinario veterinario : listaDeVeterinarios) {
            comboVeterinario.addItem(veterinario.getNombre() + " " + veterinario.getApellido() + " - "
                    + veterinario.getEspecialidad());
        }
    }

    private boolean existeCita(String idCita) {
        for (Cita cita : listaDeCitas) {
            if (cita.getIdCita().equals(idCita)) {
                return true;
            }
        }
        return false;
    }

    private String generarIdCita() {
        int numero = listaDeCitas.size() + 1;
        while (existeCita("C" + numero)) {
            numero++;
        }
        return "C" + numero;
    }

    private void limpiarCampos() {
        campoIdCita.setText(generarIdCita());
        campoFecha.setText("");
        comboHora.setSelectedIndex(0);
        campoMotivo.setText("");
        campoDiagnostico.setText("");
        tablaCitas.clearSelection();
        campoFecha.requestFocus();
    }

    private boolean validarCampos() {
        if (listaDeMascotas.isEmpty() || listaDeVeterinarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero registra mascotas y veterinarios");
            return false;
        }
        if (campoFecha.getText().trim().isEmpty() || campoMotivo.getText().trim().isEmpty()
                || campoDiagnostico.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llena la fecha, el motivo y el diagnóstico");
            return false;
        }
        return true;
    }

    private void agendarCita() {
        Mascota mascota = listaDeMascotas.get(comboMascota.getSelectedIndex());
        Veterinario veterinario = listaDeVeterinarios.get(comboVeterinario.getSelectedIndex());
        Cita cita = new Cita(campoIdCita.getText(), campoFecha.getText().trim(),
                comboHora.getSelectedItem().toString(), campoMotivo.getText().trim(), campoDiagnostico.getText().trim(), mascota, veterinario);
        listaDeCitas.add(cita);
        veterinario.getListaDeCitas().add(cita);
        JOptionPane.showMessageDialog(this, "Cita agendada");
    }

    private void cancelarCita(Cita cita) {
        listaDeCitas.remove(cita);
        cita.getVeterinario().getListaDeCitas().remove(cita);
        JOptionPane.showMessageDialog(this, "Cita cancelada");
    }

    private boolean confirmarCancelacion(Cita cita) {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cancelar la cita "
                + cita.getIdCita() + "?", "Cancelar cita", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
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
        panelDatos = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        etiquetaIdCita = new javax.swing.JLabel();
        etiquetaMascota = new javax.swing.JLabel();
        etiquetaVeterinario = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        etiquetaHora = new javax.swing.JLabel();
        etiquetaMotivo = new javax.swing.JLabel();
        etiquetaDiagnostico = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        campoIdCita = new javax.swing.JTextField();
        comboMascota = new javax.swing.JComboBox<>();
        comboVeterinario = new javax.swing.JComboBox<>();
        campoFecha = new javax.swing.JTextField();
        comboHora = new javax.swing.JComboBox<>();
        campoMotivo = new javax.swing.JTextField();
        campoDiagnostico = new javax.swing.JTextField();
        scrollCitas = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonAgendar = new javax.swing.JButton();
        botonCancelarCita = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendar y cancelar citas");
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

        panelDatos.setBackground(new java.awt.Color(236, 240, 244));
        panelDatos.setLayout(new java.awt.BorderLayout(10, 0));

        panelEtiquetas.setBackground(new java.awt.Color(236, 240, 244));
        panelEtiquetas.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        etiquetaIdCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaIdCita.setText("ID cita");
        panelEtiquetas.add(etiquetaIdCita);

        etiquetaMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaMascota.setText("Mascota");
        panelEtiquetas.add(etiquetaMascota);

        etiquetaVeterinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaVeterinario.setText("Veterinario");
        panelEtiquetas.add(etiquetaVeterinario);

        etiquetaFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaFecha.setText("Fecha (dd/mm/aaaa)");
        panelEtiquetas.add(etiquetaFecha);

        etiquetaHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaHora.setText("Hora");
        panelEtiquetas.add(etiquetaHora);

        etiquetaMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaMotivo.setText("Motivo");
        panelEtiquetas.add(etiquetaMotivo);

        etiquetaDiagnostico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaDiagnostico.setText("Diagnóstico");
        panelEtiquetas.add(etiquetaDiagnostico);

        panelDatos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setBackground(new java.awt.Color(236, 240, 244));
        panelCampos.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        campoIdCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoIdCita.setEditable(false);
        panelCampos.add(campoIdCita);

        comboMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin mascotas " }));
        panelCampos.add(comboMascota);

        comboVeterinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboVeterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin veterinarios" }));
        panelCampos.add(comboVeterinario);

        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoFecha);

        comboHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));
        panelCampos.add(comboHora);

        campoMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoMotivo);

        campoDiagnostico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelCampos.add(campoDiagnostico);

        panelDatos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelContenido.add(panelDatos, java.awt.BorderLayout.NORTH);

        scrollCitas.setPreferredSize(new java.awt.Dimension(880, 180));

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Hora", "Mascota", "Propietario", "Veterinario", "Motivo", "Diagnóstico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollCitas.setViewportView(tablaCitas);

        panelContenido.add(scrollCitas, java.awt.BorderLayout.CENTER);

        panelBotones.setBackground(new java.awt.Color(236, 240, 244));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        botonAgendar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_agendar.png"))); // NOI18N
        botonAgendar.setText("Agendar");
        botonAgendar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonAgendar.setContentAreaFilled(false);
        botonAgendar.setOpaque(true);
        botonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgendarActionPerformed(evt);
            }
        });
        panelBotones.add(botonAgendar);

        botonCancelarCita.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonCancelarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_cancelar.png"))); // NOI18N
        botonCancelarCita.setText("Cancelar cita");
        botonCancelarCita.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonCancelarCita.setContentAreaFilled(false);
        botonCancelarCita.setOpaque(true);
        botonCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarCitaActionPerformed(evt);
            }
        });
        panelBotones.add(botonCancelarCita);

        botonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_limpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonLimpiar.setContentAreaFilled(false);
        botonLimpiar.setOpaque(true);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(botonLimpiar);

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
        cargarComboMascotas();
        cargarComboVeterinarios();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void botonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgendarActionPerformed
        if (!validarCampos()) {
            return;
        }
        agendarCita();
        archivoTexto.guardarDatos();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_botonAgendarActionPerformed

    private void botonCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarCitaActionPerformed
        int filaElegida = tablaCitas.getSelectedRow();
        if (filaElegida == -1) {
            JOptionPane.showMessageDialog(this, "Primero elige una cita en la tabla");
            return;
        }
        Cita cita = listaDeCitas.get(filaElegida);
        if (confirmarCancelacion(cita)) {
            cancelarCita(cita);
            archivoTexto.guardarDatos();
            cargarTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_botonCancelarCitaActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgendar;
    private javax.swing.JButton botonCancelarCita;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoDiagnostico;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoIdCita;
    private javax.swing.JTextField campoMotivo;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox<String> comboMascota;
    private javax.swing.JComboBox<String> comboVeterinario;
    private javax.swing.JLabel etiquetaDiagnostico;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaHora;
    private javax.swing.JLabel etiquetaIdCita;
    private javax.swing.JLabel etiquetaMascota;
    private javax.swing.JLabel etiquetaMotivo;
    private javax.swing.JLabel etiquetaVeterinario;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JScrollPane scrollCitas;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
