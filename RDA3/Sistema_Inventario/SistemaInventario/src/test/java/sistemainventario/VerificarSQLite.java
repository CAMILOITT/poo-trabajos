package sistemainventario;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/** Verificacion rapida de las 4 consultas contra SQLite. */
public class VerificarSQLite {

    public static void main(String[] args) throws SQLException {
        ConsultasInventario c = new ConsultasInventario();
        String[] nombres = {"3.1 Stock", "3.2 Stock bajo minimo",
                            "3.3 Compras por proveedor", "3.4 Estadisticas"};
        DefaultTableModel[] modelos = {
            c.calcularStock(),
            c.listarStockBajoMinimo(),
            c.totalizarComprasPorProveedor(),
            c.estadisticasMovimientosPorTipo()
        };
        for (int i = 0; i < modelos.length; i++) {
            DefaultTableModel m = modelos[i];
            System.out.println("== " + nombres[i] + " ==");
            StringBuilder cab = new StringBuilder();
            for (int col = 0; col < m.getColumnCount(); col++) {
                if (col > 0) cab.append(" | ");
                cab.append(m.getColumnName(col));
            }
            System.out.println(cab);
            for (int fila = 0; fila < m.getRowCount(); fila++) {
                StringBuilder ln = new StringBuilder();
                for (int col = 0; col < m.getColumnCount(); col++) {
                    if (col > 0) ln.append(" | ");
                    ln.append(m.getValueAt(fila, col));
                }
                System.out.println(ln);
            }
        }
    }
}
