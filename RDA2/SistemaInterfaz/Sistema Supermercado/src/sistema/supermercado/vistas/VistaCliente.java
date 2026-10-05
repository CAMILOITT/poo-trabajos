package sistema.supermercado.vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sistema.supermercado.Cliente;
import sistema.supermercado.widgets.Tabla;

public class VistaCliente extends Vista {

  public VistaCliente(CardLayout layout, JPanel panel, String title) {
    super(title, layout, panel);
    setLayout(new BorderLayout());
    this.initComponents();
  }

  private void initComponents() {
    add(crearBanner(), BorderLayout.NORTH);
    add(crearContenidoTabla(), BorderLayout.CENTER);
  }

  private JPanel crearBanner() {
    JPanel banner = new JPanel();
    banner.setLayout(new BoxLayout(banner, BoxLayout.Y_AXIS));
    banner.setBackground(new Color(30, 64, 175)); // azul corporativo
    banner.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

    JLabel titulo = new JLabel("Gestión de Clientes");
    titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
    titulo.setForeground(Color.WHITE);

    JButton btnRegresar = new JButton("<-");
    btnRegresar.setBackground(Color.gray);
    btnRegresar.setBounds(10, 10, 12, 12);

    titulo.setAlignmentX(LEFT_ALIGNMENT);
    // descripcion.setAlignmentX(LEFT_ALIGNMENT);

    banner.add(titulo);
    banner.add(Box.createVerticalStrut(6));
    banner.add(btnRegresar);

    return banner;
  }

  private JPanel crearContenidoTabla() {
    JPanel contenido = new JPanel(new BorderLayout());
    contenido.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
    contenido.setBackground(new Color(245, 247, 250));

    Tabla<Cliente> tablaClientes = new Tabla<Cliente>("Buscar por cédula...", datosDePrueba());
    contenido.add(tablaClientes, BorderLayout.CENTER);

    return contenido;
  }

  private ArrayList<Map<String, Object>> datosDePrueba() {
    ArrayList<Map<String, Object>> listaDatos = new ArrayList<>();

    Cliente[] clientes = {
        new Cliente("1799999999", "Juan Carlos", "Montalvo Lopez", "+593 99 999 999", 120, "jmontalvo@correo.com"),
        new Cliente("1723456784", "María", "Pérez Andrade", "+593 98 765 432", 45, "mperez@correo.com"),
        new Cliente("0912345678", "Pedro", "Gómez Ruiz", "+593 97 111 222", 0, "pgomez@correo.com"),
    };

    int id = 1;
    for (Cliente c : clientes) {
      Map<String, Object> fila = new LinkedHashMap<>();
      fila.put("id", id++);
      fila.put("Nombre", c.getNombre());
      fila.put("Apellido", c.getApellido());
      fila.put("Cedula", c.getCedula());
      fila.put("Telefono", c.getTelefono());
      fila.put("Puntos", c.getPuntos());
      listaDatos.add(fila);
    }

    return listaDatos;
  }
}
