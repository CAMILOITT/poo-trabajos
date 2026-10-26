package veterinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameConsultarCitas extends javax.swing.JFrame {

    private javax.swing.JFrame ventanaAnterior;
    private ArrayList<Cita> listaDeCitas;

    public JFrameConsultarCitas(javax.swing.JFrame ventanaAnterior, ArrayList<Cita> listaDeCitas) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        this.listaDeCitas = listaDeCitas;
    }

    private void mostrarEnTabla(ArrayList<Cita> citasMostradas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaCitas.getModel();
        modeloTabla.setRowCount(0);
        for (Cita cita : citasMostradas) {
            modeloTabla.addRow(new Object[]{cita.getIdCita(), cita.getFecha(),
                cita.getHora(), cita.getMascota().getNombre(), cita.getMascota().getPropietario().getNombre() + " "
                + cita.getMascota().getPropietario().getApellido(), cita.getVeterinario().getNombre() + " "
                + cita.getVeterinario().getApellido(), cita.getMotivo(), cita.getDiagnostico()});
        }
    }

    private ArrayList<Cita> buscarPorCedula(String cedula) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : listaDeCitas) {
            if (cita.getMascota().getPropietario().getCedula().equals(cedula)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    private ArrayList<Cita> buscarPorMascota(String nombreMascota) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : listaDeCitas) {
            if (cita.getMascota().getNombre().equalsIgnoreCase(nombreMascota)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    private ArrayList<Cita> buscarPorFecha(String fecha) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : listaDeCitas) {
            if (cita.getFecha().equals(fecha)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    private ArrayList<Cita> buscarCitas(String textoBuscado) {
        int opcion = comboTipoBusqueda.getSelectedIndex();
        if (opcion == 0) {
            return buscarPorCedula(textoBuscado);
        } else if (opcion == 1) {
            return buscarPorMascota(textoBuscado);
        } else {
            return buscarPorFecha(textoBuscado);
        }
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
        panelBusqueda = new javax.swing.JPanel();
        etiquetaBuscarPor = new javax.swing.JLabel();
        comboTipoBusqueda = new javax.swing.JComboBox<>();
        campoBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        scrollCitas = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        panelFranjaInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar citas");
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

        panelBusqueda.setBackground(new java.awt.Color(236, 240, 244));
        panelBusqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 0));

        etiquetaBuscarPor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaBuscarPor.setText("Buscar por");
        panelBusqueda.add(etiquetaBuscarPor);

        comboTipoBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula del propietario", "Nombre de la mascota", "Fecha" }));
        panelBusqueda.add(comboTipoBusqueda);

        campoBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoBusqueda.setColumns(14);
        panelBusqueda.add(campoBusqueda);

        botonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veterinaria/iconos/icono_buscar_chico.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 120, 172)), javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 14)));
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.setOpaque(true);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        panelBusqueda.add(botonBuscar);

        panelContenido.add(panelBusqueda, java.awt.BorderLayout.NORTH);

        scrollCitas.setPreferredSize(new java.awt.Dimension(880, 260));

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
        mostrarEnTabla(listaDeCitas);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        regresar();
    }//GEN-LAST:event_formWindowClosing

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String textoBuscado = campoBusqueda.getText().trim();
        if (textoBuscado.isEmpty()) {
            mostrarEnTabla(listaDeCitas);
            return;
        }
        ArrayList<Cita> encontradas = buscarCitas(textoBuscado);
        if (encontradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron citas");
        }
        mostrarEnTabla(encontradas);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JComboBox<String> comboTipoBusqueda;
    private javax.swing.JLabel etiquetaBuscarPor;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFranjaInferior;
    private javax.swing.JPanel panelFranjaSuperior;
    private javax.swing.JScrollPane scrollCitas;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
