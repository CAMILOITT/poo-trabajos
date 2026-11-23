package sistemainventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Consultas SQL del sistema de inventario.
 * Ejecuta los queries contra la base de datos y devuelve el resultado
 * listo para mostrar en la tabla de la interfaz.
 */
public class ConsultasInventario {

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

    /** 3.1 Existencias de cada articulo (compras - ventas). */
    public DefaultTableModel calcularStock() throws SQLException {
        return consultar(SQL_STOCK);
    }

    /** 3.2 Articulos cuyas existencias estan por debajo del stock minimo. */
    public DefaultTableModel listarStockBajoMinimo() throws SQLException {
        return consultar(SQL_STOCK_BAJO_MINIMO);
    }

    /** 3.3 Proveedores con mas de 50 unidades compradas. */
    public DefaultTableModel totalizarComprasPorProveedor() throws SQLException {
        return consultar(SQL_COMPRAS_PROVEEDOR);
    }

    /** 3.4 Cantidad, unidades y monto de movimientos agrupados por tipo. */
    public DefaultTableModel estadisticasMovimientosPorTipo() throws SQLException {
        return consultar(SQL_ESTADISTICAS_TIPO);
    }

    /** Conecta, ejecuta el query, procesa y cierra todo. */
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

    /** Procesa el ResultSet con while y next(). */
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
}
