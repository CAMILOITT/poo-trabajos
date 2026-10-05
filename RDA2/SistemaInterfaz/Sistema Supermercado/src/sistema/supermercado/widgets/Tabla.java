package sistema.supermercado.widgets;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tabla<T> extends JPanel {
  private JTable table;
  private DefaultTableModel modelo;
  private TableRowSorter<DefaultTableModel> sorter;
  private JTextField txtBusqueda;
  private JComboBox<String> cmbFiltro;
  private String placeholder;

  public Tabla(String placeholder, ArrayList<Map<String, Object>> listaDatos) {
    // super(new BorderLayout(0, 8));
    this.placeholder = placeholder;
    this.initComponente(listaDatos);
  }

  public void initComponente(ArrayList<Map<String, Object>> listaDatos) {
    this.crearBuscador();
    this.crearTabla(listaDatos);
  }

  public void crearBuscador() {
    JPanel panelBuscador = new JPanel();

    JLabel lblBuscar = new JLabel("Buscar por cédula:");
    txtBusqueda = new JTextField(20);
    txtBusqueda.setToolTipText(placeholder != null ? placeholder : "Buscar por cédula...");

    String[] opcionesFiltro = { "Todos", "Cédula", "Nombre", "Apellido", "Teléfono", "Puntos" };
    cmbFiltro = new JComboBox<>(opcionesFiltro);
    cmbFiltro.setSelectedItem("Cédula");
    cmbFiltro.setToolTipText("Filtrar por");

    JButton btnBuscar = new JButton("Buscar");
    JButton btnLimpiar = new JButton("Limpiar");

    btnBuscar.addActionListener((e) -> aplicarFiltro());
    txtBusqueda.addActionListener((e) -> aplicarFiltro());
    txtBusqueda.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
      public void insertUpdate(javax.swing.event.DocumentEvent e) {
        aplicarFiltro();
      }

      public void removeUpdate(javax.swing.event.DocumentEvent e) {
        aplicarFiltro();
      }

      public void changedUpdate(javax.swing.event.DocumentEvent e) {
        aplicarFiltro();
      }
    });
    cmbFiltro.addActionListener((e) -> aplicarFiltro());

    btnLimpiar.addActionListener((e) -> {
      txtBusqueda.setText("");
      cmbFiltro.setSelectedItem("Cédula");
      if (sorter != null)
        sorter.setRowFilter(null);
    });

    panelBuscador.add(lblBuscar);
    panelBuscador.add(txtBusqueda);
    panelBuscador.add(new JLabel("Filtrar por:"));
    panelBuscador.add(cmbFiltro);
    panelBuscador.add(btnBuscar);
    panelBuscador.add(btnLimpiar);

    add(panelBuscador);
  }

  public void crearTabla(ArrayList<Map<String, Object>> listaDatos) {
    modelo = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    if (listaDatos != null && !listaDatos.isEmpty()) {
      for (String columna : listaDatos.get(0).keySet()) {
        modelo.addColumn(columna);
      }
      for (Map<String, Object> fila : listaDatos) {
        modelo.addRow(fila.values().toArray());
      }
    }

    table = new JTable(modelo);
    table.setFillsViewportHeight(true);
    table.getTableHeader().setReorderingAllowed(false);

    sorter = new TableRowSorter<>(modelo);
    table.setRowSorter(sorter);

    JScrollPane scrollTable = new JScrollPane(table);
    add(scrollTable);
  }

  private void aplicarFiltro() {
    if (sorter == null)
      return;
    String texto = txtBusqueda.getText() == null ? "" : txtBusqueda.getText().trim();
    if (texto.isEmpty() || texto.equals(placeholder)) {
      sorter.setRowFilter(null);
      return;
    }

    String filtro = (String) cmbFiltro.getSelectedItem();
    int colCedula = modelo.findColumn("Cedula");
    int colNombre = modelo.findColumn("Nombre");
    int colApellido = modelo.findColumn("Apellido");
    int colTelefono = modelo.findColumn("Telefono");
    int colPuntos = modelo.findColumn("Puntos");

    String regex = "(?i)" + Pattern.quote(texto);

    try {
      if ("Cédula".equals(filtro) && colCedula >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter(regex, colCedula));
      } else if ("Nombre".equals(filtro) && colNombre >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter(regex, colNombre));
      } else if ("Apellido".equals(filtro) && colApellido >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter(regex, colApellido));
      } else if ("Teléfono".equals(filtro) && colTelefono >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter(regex, colTelefono));
      } else if ("Puntos".equals(filtro) && colPuntos >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter(regex, colPuntos));
      } else {
        sorter.setRowFilter(RowFilter.regexFilter(regex));
      }
    } catch (Exception ex) {
      sorter.setRowFilter(null);
    }
  }
}
