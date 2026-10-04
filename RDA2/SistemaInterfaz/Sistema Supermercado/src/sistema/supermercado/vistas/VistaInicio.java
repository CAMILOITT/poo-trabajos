package sistema.supermercado.vistas;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaInicio extends Vista {
  private ArrayList<String> listaNavegacion = new ArrayList<>();

  public VistaInicio(CardLayout layout, JPanel panel, String title) {
    super(title, layout, panel);
    this.initComponente();
  }

  private void initComponente() {
    this.listaNavegacion.add("cliente");
    if (this.listaNavegacion.size() < 1)
      return;

    JPanel panel = new JPanel();

    this.listaNavegacion.forEach(title -> {
      JButton botonNavegacion = new JButton("ir a" + title);
      botonNavegacion.addActionListener(e -> this.layout.show(this.panel, title));
      panel.add(botonNavegacion);
    });

    this.panel.add(panel);
  }

}
