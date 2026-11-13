/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academic;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Pantalla 2 - Estudiantes: filtra por rango de calificaciones y muestra el resultado en un JTable.
 * El diseño visual está en JF_Estudiante.form (editable con el diseñador de NetBeans).
 *
 * @author DET PC
 */
public class JF_Estudiante extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JF_Estudiante.class.getName());

    private static final Color AZUL_OSCURO = new Color(0x1F3A5F);
    private static final Color FILA_PAR = Color.WHITE;
    private static final Color FILA_IMPAR = new Color(0xF0F4FA);
    private static final Color TEXTO = new Color(0x1E2633);
    private static final Color TEXTO_SUAVE = new Color(0x667085);
    private static final Color ERROR = new Color(0xC0392B);
    private static final Color OK = new Color(0x1E8449);

    private final ConexionAcademico conexion = new ConexionAcademico();

    /**
     * Creates new form JF_Estudiante
     */
    public JF_Estudiante() {
        initComponents();
        personalizarTabla();
        cargarRangoNotas();
        buscar();
    }

    // ---------- Detalles de la tabla (colores de encabezado y filas alternadas) ----------

    private void personalizarTabla() {
        tblEstudiantes.setAutoCreateRowSorter(true);
        tblEstudiantes.getTableHeader().setReorderingAllowed(false);
        tblEstudiantes.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 36));
        tblEstudiantes.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object valor, boolean sel,
                    boolean foco, int fila, int columna) {
                super.getTableCellRendererComponent(t, valor, sel, foco, fila, columna);
                setBackground(AZUL_OSCURO);
                setForeground(Color.WHITE);
                setFont(t.getFont().deriveFont(java.awt.Font.BOLD));
                setHorizontalAlignment(columna >= 5 ? SwingConstants.CENTER : SwingConstants.LEFT);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return this;
            }
        });

        DefaultTableCellRenderer izquierda = crearRenderer(SwingConstants.LEFT);
        DefaultTableCellRenderer centro = crearRenderer(SwingConstants.CENTER);
        for (int i = 0; i < tblEstudiantes.getColumnCount(); i++) {
            tblEstudiantes.getColumnModel().getColumn(i).setCellRenderer(i >= 5 ? centro : izquierda);
        }
        int[] anchos = {90, 110, 130, 130, 220, 80, 110};
        for (int i = 0; i < anchos.length && i < tblEstudiantes.getColumnCount(); i++) {
            tblEstudiantes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    private DefaultTableCellRenderer crearRenderer(int alineacion) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object valor, boolean sel,
                    boolean foco, int fila, int columna) {
                super.getTableCellRendererComponent(t, valor, sel, false, fila, columna);
                setHorizontalAlignment(alineacion);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                if (!sel) {
                    setBackground(fila % 2 == 0 ? FILA_PAR : FILA_IMPAR);
                    setForeground(TEXTO);
                }
                return this;
            }
        };
    }

    // ---------- Lógica (usa la clase de conexión directamente, como el proyecto Hotel) ----------

    /** Llena los combos con las notas que existen en la base (nada escrito a mano). */
    private void cargarRangoNotas() {
        cmbInferior.removeAllItems();
        cmbSuperior.removeAllItems();
        Connection con = conexion.abrirConexion();
        if (con == null) {
            mostrarEstado("No se pudo conectar con la base de datos.", ERROR);
            btnBuscar.setEnabled(false);
            btnMostrarTodos.setEnabled(false);
            return;
        }
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT MIN(Calificacion) AS minimo, MAX(Calificacion) AS maximo FROM lista");
            if (rs.next()) {
                int minimo = rs.getInt("minimo");
                int maximo = rs.getInt("maximo");
                for (int nota = minimo; nota <= maximo; nota++) {
                    cmbInferior.addItem(String.valueOf(nota));
                    cmbSuperior.addItem(String.valueOf(nota));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al leer las notas: " + e.getMessage());
        } finally {
            cerrar(rs, st, con);
        }
        seleccionarRangoCompleto();
    }

    private void seleccionarRangoCompleto() {
        if (cmbInferior.getItemCount() > 0) {
            cmbInferior.setSelectedIndex(0);
            cmbSuperior.setSelectedIndex(cmbSuperior.getItemCount() - 1);
        }
    }

    /** Consulta la tabla "lista" con las notas elegidas y llena el JTable. */
    private void buscar() {
        if (cmbInferior.getSelectedItem() == null || cmbSuperior.getSelectedItem() == null) {
            return;
        }
        int inferior = Integer.parseInt((String) cmbInferior.getSelectedItem());
        int superior = Integer.parseInt((String) cmbSuperior.getSelectedItem());
        if (inferior > superior) {
            mostrarEstado("La nota inferior (" + inferior + ") no puede ser mayor que la superior ("
                    + superior + ").", ERROR);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblEstudiantes.getModel();
        modelo.setRowCount(0);

        Connection con = conexion.abrirConexion();
        if (con == null) {
            return;
        }
        Statement st = null;
        ResultSet rs = null;
        int total = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT idBanner, cedula, nombre, apellido, carrera, NRC, Calificacion "
                    + "FROM lista WHERE Calificacion >= " + inferior + " AND Calificacion <= " + superior
                    + " ORDER BY Calificacion DESC, apellido");
            while (rs.next()) {
                Estudiante e = new Estudiante(
                        rs.getString("idBanner"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("carrera"),
                        rs.getString("NRC"),
                        rs.getInt("Calificacion"));
                modelo.addRow(new Object[]{
                    e.getIdBanner(), e.getCedula(), e.getNombre(), e.getApellido(),
                    e.getCarrera(), e.getNRC(), e.getCalificacion()});
                total++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar los estudiantes: " + ex.getMessage());
        } finally {
            cerrar(rs, st, con);
        }

        if (total == 0) {
            mostrarEstado("No hay estudiantes con nota entre " + inferior + " y " + superior + ".", TEXTO_SUAVE);
        } else {
            mostrarEstado(total + (total == 1 ? " estudiante" : " estudiantes")
                    + " con nota entre " + inferior + " y " + superior + ".", OK);
        }
    }

    /** Cierra el ResultSet, el Statement y la conexión. */
    private void cerrar(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cerrar la conexión: " + e.getMessage());
        }
    }

    private void mostrarEstado(String texto, Color color) {
        lblEstado.setForeground(color);
        lblEstado.setText(texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnEstudiantes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlPagina = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        pnlTextos = new javax.swing.JPanel();
        lblTituloPagina = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlFiltros = new javax.swing.JPanel();
        lblInferior = new javax.swing.JLabel();
        cmbInferior = new javax.swing.JComboBox<>();
        lblSuperior = new javax.swing.JLabel();
        cmbSuperior = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Académico - Estudiantes"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1180, 700));
        setMinimumSize(new java.awt.Dimension(960, 600));
        getContentPane().setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Sistema Académico"); // NOI18N

        lblDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDetalle.setForeground(new java.awt.Color(201, 216, 238));
        lblDetalle.setText("Consulta de calificaciones"); // NOI18N

        pnlEncabezado.setBackground(new java.awt.Color(31, 58, 95));
        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 24, 16, 24));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(0, 72));
        pnlEncabezado.setLayout(new java.awt.BorderLayout());
        pnlEncabezado.add(lblTitulo, java.awt.BorderLayout.WEST);
        pnlEncabezado.add(lblDetalle, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(143, 163, 192));
        lblMenu.setText("MENÚ"); // NOI18N
        lblMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 6, 0));

        btnInicio.setText("Inicio"); // NOI18N
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setBackground(new java.awt.Color(38, 52, 75));
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setOpaque(true);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 14, 11, 14));
        btnInicio.addActionListener(this::btnInicioActionPerformed);

        btnEstudiantes.setText("Estudiantes"); // NOI18N
        btnEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        btnEstudiantes.setBackground(new java.awt.Color(46, 111, 186));
        btnEstudiantes.setBorderPainted(false);
        btnEstudiantes.setContentAreaFilled(false);
        btnEstudiantes.setFocusPainted(false);
        btnEstudiantes.setOpaque(true);
        btnEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstudiantes.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 14, 11, 14));
        btnEstudiantes.addActionListener(this::btnEstudiantesActionPerformed);

        pnlOpciones.setOpaque(false);
        pnlOpciones.setLayout(new java.awt.GridLayout(0, 1));
        pnlOpciones.add(lblMenu);
        pnlOpciones.add(btnInicio);
        pnlOpciones.add(btnEstudiantes);

        btnSalir.setText("Salir"); // NOI18N
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setBackground(new java.awt.Color(142, 59, 70));
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setOpaque(true);
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 14, 11, 14));
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        pnlMenu.setBackground(new java.awt.Color(38, 52, 75));
        pnlMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 12, 18, 12));
        pnlMenu.setPreferredSize(new java.awt.Dimension(230, 0));
        pnlMenu.setLayout(new java.awt.BorderLayout());
        pnlMenu.add(pnlOpciones, java.awt.BorderLayout.NORTH);
        pnlMenu.add(btnSalir, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlMenu, java.awt.BorderLayout.WEST);

        lblTituloPagina.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloPagina.setForeground(new java.awt.Color(31, 58, 95));
        lblTituloPagina.setText("Filtrado de estudiantes por calificación"); // NOI18N

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(102, 112, 133));
        lblSubtitulo.setText("Elige la nota inferior y la nota superior para ver los estudiantes dentro de ese rango."); // NOI18N

        pnlTextos.setOpaque(false);
        pnlTextos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 14, 0));
        pnlTextos.setLayout(new java.awt.BorderLayout());
        pnlTextos.add(lblTituloPagina, java.awt.BorderLayout.NORTH);
        pnlTextos.add(lblSubtitulo, java.awt.BorderLayout.CENTER);

        lblInferior.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInferior.setForeground(new java.awt.Color(30, 38, 51));
        lblInferior.setText("Nota inferior:"); // NOI18N

        cmbInferior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbInferior.setBackground(new java.awt.Color(255, 255, 255));
        cmbInferior.setPreferredSize(new java.awt.Dimension(90, 32));
        cmbInferior.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        lblSuperior.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSuperior.setForeground(new java.awt.Color(30, 38, 51));
        lblSuperior.setText("Nota superior:"); // NOI18N

        cmbSuperior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbSuperior.setBackground(new java.awt.Color(255, 255, 255));
        cmbSuperior.setPreferredSize(new java.awt.Dimension(90, 32));
        cmbSuperior.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        btnBuscar.setText("Buscar"); // NOI18N
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setBackground(new java.awt.Color(46, 111, 186));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setOpaque(true);
        btnBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 14, 11, 14));
        btnBuscar.setPreferredSize(new java.awt.Dimension(120, 34));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnMostrarTodos.setText("Mostrar todos"); // NOI18N
        btnMostrarTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMostrarTodos.setForeground(new java.awt.Color(31, 58, 95));
        btnMostrarTodos.setBackground(new java.awt.Color(232, 240, 251));
        btnMostrarTodos.setBorderPainted(false);
        btnMostrarTodos.setContentAreaFilled(false);
        btnMostrarTodos.setFocusPainted(false);
        btnMostrarTodos.setOpaque(true);
        btnMostrarTodos.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 14, 11, 14));
        btnMostrarTodos.setPreferredSize(new java.awt.Dimension(140, 34));
        btnMostrarTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        pnlFiltros.setBackground(new java.awt.Color(255, 255, 255));
        pnlFiltros.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 14, 10, 14));
        pnlFiltros.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pnlFiltros.add(lblInferior);
        pnlFiltros.add(cmbInferior);
        pnlFiltros.add(lblSuperior);
        pnlFiltros.add(cmbSuperior);
        pnlFiltros.add(btnBuscar);
        pnlFiltros.add(btnMostrarTodos);

        pnlSuperior.setOpaque(false);
        pnlSuperior.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlSuperior.setLayout(new java.awt.BorderLayout());
        pnlSuperior.add(pnlTextos, java.awt.BorderLayout.NORTH);
        pnlSuperior.add(pnlFiltros, java.awt.BorderLayout.CENTER);

        tblEstudiantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblEstudiantes.setForeground(new java.awt.Color(30, 38, 51));
        tblEstudiantes.setGridColor(new java.awt.Color(213, 219, 229));
        tblEstudiantes.setSelectionBackground(new java.awt.Color(46, 111, 186));
        tblEstudiantes.setRowHeight(30);
        tblEstudiantes.setShowVerticalLines(false);
        tblEstudiantes.setFillsViewportHeight(true);
        tblEstudiantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Banner", "Cédula", "Nombre", "Apellido", "Carrera", "NRC", "Calificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        jScrollPane1.setViewportView(tblEstudiantes);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(102, 112, 133));
        lblEstado.setText(" "); // NOI18N
        lblEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 0, 0));

        pnlPagina.setBackground(new java.awt.Color(244, 246, 250));
        pnlPagina.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));
        pnlPagina.setLayout(new java.awt.BorderLayout());
        pnlPagina.add(pnlSuperior, java.awt.BorderLayout.NORTH);
        pnlPagina.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        pnlPagina.add(lblEstado, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlPagina, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        buscar();
    }

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {
        seleccionarRangoCompleto();
        buscar();
    }

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {
        new Jf_Menu().setVisible(true);
        dispose();
    }

    private void btnEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {
        // Ya estás en Estudiantes
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JF_Estudiante ventanaEstudiante = new JF_Estudiante();
        ventanaEstudiante.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEstudiantes;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbInferior;
    private javax.swing.JComboBox<String> cmbSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInferior;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblSuperior;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloPagina;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFiltros;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlPagina;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTextos;
    private javax.swing.JTable tblEstudiantes;
    // End of variables declaration//GEN-END:variables
}
