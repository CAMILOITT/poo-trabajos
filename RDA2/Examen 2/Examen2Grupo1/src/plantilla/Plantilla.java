package plantilla;

import java.util.ArrayList;

/**
 * Clase principal. Lee los archivos de texto, carga datos de prueba si están vacíos
 * y abre el menú. Es la que se ejecuta con Run (F6).
 */
public class Plantilla {

    public static void main(String[] args) {
        // Mismo aspecto (Nimbus) que pone NetBeans en los JFrame
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo aplicar Nimbus");
        }

        ArrayList<Persona> listaPersonas = ArchivoTexto.leerPersonas();
        ArrayList<Elemento> listaElementos = ArchivoTexto.leerElementos();

        // Datos de prueba, solo se cargan la primera vez (cuando no hay archivos)
        if (listaPersonas.isEmpty()) {
            listaPersonas.add(new Persona("1712345675", "Ana María", "López", "0991234567", "ana.lopez@gmail.com"));
            listaPersonas.add(new Persona("1709876542", "Carlos", "Pérez", "0987654321", "carlos.perez@gmail.com"));
            listaPersonas.add(new Persona("0911223345", "Lucía", "Andrade", "0998877665", "lucia.andrade@gmail.com"));
            ArchivoTexto.guardarPersonas(listaPersonas);
        }
        if (listaElementos.isEmpty()) {
            listaElementos.add(new Elemento("E001", "Elemento uno", "Categoría A", 12, 4.50));
            listaElementos.add(new Elemento("E002", "Elemento dos", "Categoría A", 5, 10.00));
            listaElementos.add(new Elemento("E003", "Elemento tres", "Categoría B", 20, 2.75));
            listaElementos.add(new Elemento("E004", "Elemento cuatro", "Categoría C", 8, 15.90));
            ArchivoTexto.guardarElementos(listaElementos);
        }

        MenuPrincipal menu = new MenuPrincipal(listaPersonas, listaElementos);
        menu.setVisible(true);
    }
}
