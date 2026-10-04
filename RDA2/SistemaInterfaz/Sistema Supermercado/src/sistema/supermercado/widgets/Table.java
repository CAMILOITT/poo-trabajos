package sistema.supermercado.widgets;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Table<T> extends JPanel {
  private JTable table;
  private JTextField txtBusqueda;
  private ArrayList<T> listaEncabezados;
  private ArrayList<T> listaItems;

  public Table(String txtBusqueda, ArrayList<T> listaEncabezados, ArrayList<T> listaItems) {
    this.txtBusqueda = new JTextField(txtBusqueda);
    this.listaEncabezados = listaEncabezados;
    this.listaItems = listaItems;
    this.initComponente();
  }

  public void initComponente() {

  }
}
