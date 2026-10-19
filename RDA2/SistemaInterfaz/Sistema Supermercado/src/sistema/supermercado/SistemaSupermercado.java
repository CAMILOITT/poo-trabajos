package sistema.supermercado;

import java.util.ArrayList;

/**
 *
 * @author grupo 1
 */
public class SistemaSupermercado {

    public static void main(String[] args) {

        // ---------- CARGAR DATOS DE LOS ARCHIVOS ----------
        ArrayList<Inventario> inventarios = new ArrayList<>();
        ArrayList<Producto> productos = ArchivoDatos.cargarProductos(inventarios);
        ArrayList<Cliente> clientes = ArchivoDatos.cargarClientes();
        ArrayList<Cajero> cajeros = ArchivoDatos.cargarCajeros();
        ArchivoDatos.cargarCompras(clientes, cajeros, productos);

        // ---------- ABRIR EL MENU ----------
        Jframe_Menu menu = new Jframe_Menu(clientes, productos, cajeros, inventarios);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}