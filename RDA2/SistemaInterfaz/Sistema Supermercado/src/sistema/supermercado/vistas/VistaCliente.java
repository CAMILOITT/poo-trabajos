package sistema.supermercado.vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sistema.supermercado.Cliente;
import sistema.supermercado.widgets.Tabla;

public class VistaCliente extends Vista {

  public VistaCliente(CardLayout layout, JPanel panel, String title) {
    super(title, layout, panel);
    setSize(panel.getWidth(), panel.getHeight());
    this.initComponents();
  }

  private void initComponents() {
    this.encabeza();
    this.tabla();
  }

  private void encabeza() {
    JLabel titulo = new JLabel("Cliente");
    JLabel descripcion = new JLabel("Busca los clientes y clasificalos");
    JPanel encabezado = new JPanel();
    titulo.setFont(new Font(this.getFont().getName(), Font.BOLD, 34));
    encabezado.setBackground(new Color(245, 247, 250));
    encabezado.setPreferredSize(new Dimension(this.panel.getWidth(), 100));
    encabezado.setLayout(new GridLayout(2, 1));
    encabezado.add(Box.createVerticalStrut(100));
    // encabezado.setSize(this.panel.getWidth(), this.panel.getHeight());
    encabezado.add(titulo);
    encabezado.add(descripcion);
    add(encabezado);
  }

  private void tabla() {
    // datos de prueba
    ArrayList<Object[]> listaCliente = new ArrayList<>();
    ArrayList<String> listaEncabezado = new ArrayList<>();

    listaEncabezado.add("ID");
    listaEncabezado.add("Nombre");
    listaEncabezado.add("Apellido");
    listaEncabezado.add("Cedula");
    listaEncabezado.add("Telefono");
    listaEncabezado.add("Puntos");

    Cliente itemCliente = new Cliente("1234567890", "Juan Carlos", "Montalvo Lopez", "+593 99 999 999", 0,
        "jmontalvo@correo.com");

    Object[] listaDatos = {
        1, itemCliente.getNombre(), itemCliente.getApellido(), itemCliente.getCedula(),
        itemCliente.getTelefono(), itemCliente.getPuntos()
    };

    listaCliente.add(listaDatos);

    Tabla<Cliente> tablaClientes = new Tabla<Cliente>("Buscar id del cliente", listaEncabezado, listaCliente);

    add(tablaClientes);
  }
}
