package sistema.supermercado;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaCliente extends JPanel {
  private JButton btnBuscar;
  private JLabel title;

  public VentanaCliente(String title) {
    this.title = new JLabel(title);
    // this.title.setText(title);
    // setTitle("Cliente");
    setSize(400, 200);
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // setLocationRelativeTo(null);
    this.initComponents();
  }
  
  private void initComponents() {
        setLayout(new FlowLayout());

        // title = new JLabel("Presiona el botón");
        btnBuscar = new JButton("Saludar");

        // Evento con expresión Lambda
        // btnBuscar.addActionListener(e -> layout.show());

        // Agregar al contenedor
        add(btnBuscar);
        add(title);
  }
  public static void main(String[] args) {
        // Ejecutar en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new VentanaCliente("").setVisible(true);
        });
    }
}
