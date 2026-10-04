package sistema.supermercado.vistas;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class Vista extends JPanel {
  protected String title;
  protected CardLayout layout;
  protected JPanel panel;

  public Vista(String title, CardLayout layout, JPanel panel) {
    this.title = title;
    this.layout = layout;
    this.panel = panel;
  }

}
