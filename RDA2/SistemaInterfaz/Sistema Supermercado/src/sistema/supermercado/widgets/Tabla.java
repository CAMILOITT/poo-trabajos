package sistema.supermercado.widgets;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tabla<T> extends JPanel {
  private JTable table;
  private JTextField txtBusqueda;
  private ArrayList<String> listaEncabezados;
  private ArrayList<Object[]> listaItems;

  public Tabla(String txtBusqueda, ArrayList<String> listaEncabezados, ArrayList<Object[]> listaItems) {
    this.txtBusqueda = new JTextField(txtBusqueda);
    this.listaEncabezados = listaEncabezados;
    this.listaItems = listaItems;
    this.initComponente();
  }

  public void initComponente() {
    var modelo = new DefaultTableModel();
    this.table = new JTable(modelo);
    for (String titulo : this.listaEncabezados) {
      modelo.addColumn(titulo);
    }

    for (Object[] dato : this.listaItems) {
      modelo.addRow(dato);
    }

    JScrollPane scroll = new JScrollPane(table);
    add(scroll);
  }
}
