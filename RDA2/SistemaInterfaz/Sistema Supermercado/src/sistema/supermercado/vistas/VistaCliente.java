package sistema.supermercado.vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaCliente extends Vista {

  public VistaCliente(CardLayout layout, JPanel panel, String title) {
    super(title, layout, panel);
    setSize(panel.getWidth(), panel.getHeight());
    this.initComponents();
  }

  private void initComponents() {
    this.encabeza();
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

}
