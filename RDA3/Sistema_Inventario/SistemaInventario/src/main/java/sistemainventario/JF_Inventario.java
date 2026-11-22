package sistemainventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DET PC
 */
public class JF_Inventario extends javax.swing.JFrame {

    /**
     * Creates new form JF_Inventario
     */
    public JF_Inventario() {
        initComponents();
        configurarConsultas();
        configurarEventos();
    }

    // ------------------------------------------------------------------
    // Consultas (SQL)
    // ------------------------------------------------------------------
    private static final String SQL_STOCK
            = "SELECT a.codigo AS \"Codigo\", a.nombre AS \"Articulo\", "
            + "COALESCE(SUM(CASE m.tipo WHEN 'COMPRA' THEN m.cantidad "
            + "WHEN 'VENTA' THEN -m.cantidad END), 0) AS \"Existencias\" "
            + "FROM articulos a LEFT JOIN movimientos m ON m.id_articulo = a.id_articulo "
            + "GROUP BY a.id_articulo, a.codigo, a.nombre ORDER BY a.codigo";

    private static final String SQL_STOCK_BAJO_MINIMO
            = "SELECT a.codigo AS \"Codigo\", a.nombre AS \"Articulo\", "
            + "COALESCE(SUM(CASE m.tipo WHEN 'COMPRA' THEN m.cantidad "
            + "WHEN 'VENTA' THEN -m.cantidad END), 0) AS \"Existencias\", "
            + "a.stock_minimo AS \"Stock minimo\" "
            + "FROM articulos a LEFT JOIN movimientos m ON m.id_articulo = a.id_articulo "
            + "GROUP BY a.id_articulo, a.codigo, a.nombre, a.stock_minimo "
            + "HAVING COALESCE(SUM(CASE m.tipo WHEN 'COMPRA' THEN m.cantidad "
            + "WHEN 'VENTA' THEN -m.cantidad END), 0) < a.stock_minimo "
            + "ORDER BY a.codigo";

    private static final String SQL_COMPRAS_PROVEEDOR
            = "SELECT p.nombre AS \"Proveedor\", SUM(m.cantidad) AS \"Unidades compradas\" "
            + "FROM proveedores p "
            + "JOIN articulos a ON a.id_proveedor = p.id_proveedor "
            + "JOIN movimientos m ON m.id_articulo = a.id_articulo "
            + "WHERE m.tipo = 'COMPRA' "
            + "GROUP BY p.nombre HAVING SUM(m.cantidad) > 50 "
            + "ORDER BY p.nombre";

    private static final String SQL_ESTADISTICAS_TIPO
            = "SELECT tipo AS \"Tipo\", COUNT(*) AS \"N. de movimientos\", "
            + "SUM(cantidad) AS \"Total de unidades\", "
            + "SUM(cantidad * precio_unitario) AS \"Monto total\" "
            + "FROM movimientos GROUP BY tipo ORDER BY tipo";

    // ------------------------------------------------------------------
    // Configuracion (sin tocar el diseño generado)
    // ------------------------------------------------------------------
    private void configurarConsultas() {
        jcbConsulta.setModel(new DefaultComboBoxModel<>(new String[]{
            "3.1 Existencias por articulo",
            "3.2 Articulos bajo el stock minimo",
            "3.3 Proveedores con mas de 50 unidades compradas",
            "3.4 Estadisticas de movimientos por tipo"}));
    }

    private void configurarEventos() {
        btnEjecutar.addActionListener(e -> ejecutarConsultaSeleccionada());
        btnSalir.addActionListener(e -> dispose());
    }

    // ------------------------------------------------------------------
    // Funciones atomicas
    // ------------------------------------------------------------------
    /** Elige la consulta segun el item del combo y muestra el resultado. */
    private void ejecutarConsultaSeleccionada() {
        try {
            DefaultTableModel modelo;
            switch (jcbConsulta.getSelectedIndex()) {
                case 0:
                    modelo = calcularStock();
                    break;
                case 1:
                    modelo = listarStockBajoMinimo();
                    break;
                case 2:
                    modelo = totalizarComprasPorProveedor();
                    break;
                default:
                    modelo = estadisticasMovimientosPorTipo();
                    break;
            }
            mostrarEnTabla(modelo);
            mostrarEstado("Consulta ejecutada: " + modelo.getRowCount() + " fila(s)");
        } catch (SQLException ex) {
            mostrarEstado("Error de base de datos: " + ex.getMessage());
        }
    }

    /** 3.1 Existencias de cada articulo (compras - ventas). */
    private DefaultTableModel calcularStock() throws SQLException {
        return consultar(SQL_STOCK);
    }

    /** 3.2 Articulos cuyas existencias estan por debajo del stock minimo. */
    private DefaultTableModel listarStockBajoMinimo() throws SQLException {
        return consultar(SQL_STOCK_BAJO_MINIMO);
    }

    /** 3.3 Proveedores con mas de 50 unidades compradas. */
    private DefaultTableModel totalizarComprasPorProveedor() throws SQLException {
        return consultar(SQL_COMPRAS_PROVEEDOR);
    }

    /** 3.4 Cantidad, unidades y monto de movimientos agrupados por tipo. */
    private DefaultTableModel estadisticasMovimientosPorTipo() throws SQLException {
        return consultar(SQL_ESTADISTICAS_TIPO);
    }

    /** Pasos 2 a 7: conecta, ejecuta el query, procesa y cierra todo. */
    private DefaultTableModel consultar(String sql) throws SQLException {
        try (Connection conexion = abrirConexion();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()) {
            return crearModelo(resultado);
        }
    }

    private Connection abrirConexion() throws SQLException {
        return ConnectionDataBase.getConexion();
    }

    /** Paso 5: procesa el ResultSet con while y next(). */
    private DefaultTableModel crearModelo(ResultSet resultado) throws SQLException {
        ResultSetMetaData meta = resultado.getMetaData();
        int columnas = meta.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        for (int i = 1; i <= columnas; i++) {
            modelo.addColumn(meta.getColumnLabel(i));
        }
        while (resultado.next()) {
            Object[] fila = new Object[columnas];
            for (int i = 0; i < columnas; i++) {
                fila[i] = resultado.getObject(i + 1);
            }
            modelo.addRow(fila);
        }
        return modelo;
    }

    private void mostrarEnTabla(DefaultTableModel modelo) {
        tblResultados.setModel(modelo);
    }

    private void mostrarEstado(String mensaje) {
        lblEstado.setText("Estado: " + mensaje);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado_BorderLayout = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlCentro_BorderLayout = new javax.swing.JPanel();
        pnlConsulta_BorderLayout = new javax.swing.JPanel();
        lblConsulta = new javax.swing.JLabel();
        jcbConsulta = new javax.swing.JComboBox<>();
        btnEjecutar = new javax.swing.JButton();
        scpResultados = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        pnlInferior_BorderLayout = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        pnlBotones_FlowLayout = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario");

        pnlEncabezado_BorderLayout.setBackground(new java.awt.Color(13, 71, 161));
        pnlEncabezado_BorderLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 22, 14, 22));
        pnlEncabezado_BorderLayout.setMinimumSize(new java.awt.Dimension(824, 64));
        pnlEncabezado_BorderLayout.setPreferredSize(new java.awt.Dimension(800, 64));
        pnlEncabezado_BorderLayout.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Inventario");
        pnlEncabezado_BorderLayout.add(lblTitulo, java.awt.BorderLayout.WEST);

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(187, 222, 251));
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtitulo.setText("Consultas de movimientos y existencias");
        pnlEncabezado_BorderLayout.add(lblSubtitulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlEncabezado_BorderLayout, java.awt.BorderLayout.NORTH);

        pnlCentro_BorderLayout.setBackground(new java.awt.Color(255, 255, 255));
        pnlCentro_BorderLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 22, 8, 22));
        pnlCentro_BorderLayout.setLayout(new java.awt.BorderLayout());

        pnlConsulta_BorderLayout.setBackground(new java.awt.Color(227, 242, 253));
        pnlConsulta_BorderLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14));
        pnlConsulta_BorderLayout.setLayout(new java.awt.BorderLayout());

        lblConsulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConsulta.setForeground(new java.awt.Color(13, 71, 161));
        lblConsulta.setText("Consulta:");
        lblConsulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        pnlConsulta_BorderLayout.add(lblConsulta, java.awt.BorderLayout.WEST);

        jcbConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlConsulta_BorderLayout.add(jcbConsulta, java.awt.BorderLayout.CENTER);

        btnEjecutar.setBackground(new java.awt.Color(21, 101, 192));
        btnEjecutar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setFocusPainted(false);
        pnlConsulta_BorderLayout.add(btnEjecutar, java.awt.BorderLayout.EAST);

        pnlCentro_BorderLayout.add(pnlConsulta_BorderLayout, java.awt.BorderLayout.NORTH);

        tblResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "N. de movimientos", "Total de unidades", "Monto total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultados.setRowHeight(28);
        tblResultados.setSelectionBackground(new java.awt.Color(144, 202, 249));
        tblResultados.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblResultados.setFillsViewportHeight(true);
        scpResultados.setViewportView(tblResultados);

        pnlCentro_BorderLayout.add(scpResultados, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro_BorderLayout, java.awt.BorderLayout.CENTER);

        pnlInferior_BorderLayout.setBackground(new java.awt.Color(227, 242, 253));
        pnlInferior_BorderLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 22, 8, 22));
        pnlInferior_BorderLayout.setLayout(new java.awt.BorderLayout());

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(13, 71, 161));
        lblEstado.setText("Estado: listo para ejecutar una consulta");
        pnlInferior_BorderLayout.add(lblEstado, java.awt.BorderLayout.CENTER);

        pnlBotones_FlowLayout.setOpaque(false);
        pnlBotones_FlowLayout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSalir.setBackground(new java.awt.Color(96, 125, 139));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setFocusPainted(false);
        pnlBotones_FlowLayout.add(btnSalir);

        pnlInferior_BorderLayout.add(pnlBotones_FlowLayout, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlInferior_BorderLayout, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jcbConsulta;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones_FlowLayout;
    private javax.swing.JPanel pnlCentro_BorderLayout;
    private javax.swing.JPanel pnlConsulta_BorderLayout;
    private javax.swing.JPanel pnlEncabezado_BorderLayout;
    private javax.swing.JPanel pnlInferior_BorderLayout;
    private javax.swing.JScrollPane scpResultados;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables
}
