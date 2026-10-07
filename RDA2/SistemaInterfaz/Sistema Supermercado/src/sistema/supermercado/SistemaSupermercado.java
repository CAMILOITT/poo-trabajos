/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.supermercado;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import sistema.supermercado.vistas.VistaCliente;
import sistema.supermercado.vistas.VistaInicio;

/**
 *
 * @author grupo 1
 */
public class SistemaSupermercado extends JFrame {

 

    public static void main(String[] args) {

        
   
            // ---------- PRODUCTOS ----------
    ArrayList<Producto> productos = new ArrayList<>();
    productos.add(new Producto(50, 1.25f, "P001", "Arroz 1kg", "Granos"));
    productos.add(new Producto(30, 2.80f, "P002", "Aceite 1L", "Abarrotes"));
    productos.add(new Producto(40, 1.10f, "P003", "Leche entera 1L", "Lacteos"));
    productos.add(new Producto(25, 0.45f, "P004", "Pan de agua", "Panaderia"));
    productos.add(new Producto(60, 0.90f, "P005", "Atun en lata", "Enlatados"));
    productos.add(new Producto(35, 2.15f, "P006", "Huevos (12 unidades)", "Lacteos"));
    productos.add(new Producto(20, 3.40f, "P007", "Detergente 1kg", "Limpieza"));
    productos.add(new Producto(45, 0.75f, "P008", "Gaseosa 500ml", "Bebidas"));

    // ---------- CLIENTES ----------
    Cliente ana    = new Cliente("1710000001", "Ana", "Torres", "0991111111",78 ,"ana.torres@mail.com");
    Cliente luis   = new Cliente("1710000002", "Luis", "Mera", "0992222222", 98 ,"luis.mera@mail.com");
    Cliente maria  = new Cliente("1710000003", "Maria", "Perez", "0993333333", 8 ,"maria.perez@mail.com");
    Cliente carlos = new Cliente("1710000004", "Carlos", "Andrade", "0994444444", 58 ,"carlos.andrade@mail.com");
    Cliente sofia  = new Cliente("1710000005", "Sofia", "Villacis", "0995555555", 7 ,"sofia.villacis@mail.com");

    // ---------- COMPRAS ----------
    // Ana: 2 compras
    Compra c1 = new Compra(1, LocalDateTime.of(2026, 9, 28, 10, 15));
    c1.agregarProducto(productos.get(0));
    c1.agregarProducto(productos.get(1));
    ana.agregarCompra(c1);

    Compra c2 = new Compra(2, LocalDateTime.of(2026, 10, 2, 17, 40));
    c2.agregarProducto(productos.get(2));
    c2.agregarProducto(productos.get(3));
    ana.agregarCompra(c2);

    // Luis: 1 compra
    Compra c3 = new Compra(3, LocalDateTime.of(2026, 10, 1, 12, 5));
    c3.agregarProducto(productos.get(4));
    c3.agregarProducto(productos.get(7));
    luis.agregarCompra(c3);

    // Maria: 1 compra
    Compra c4 = new Compra(4, LocalDateTime.of(2026, 10, 3, 9, 30));
    c4.agregarProducto(productos.get(5));
    c4.agregarProducto(productos.get(6));
    c4.agregarProducto(productos.get(0));
    maria.agregarCompra(c4);

    // Carlos: sin compras (para probar la lista vacia)

    // Sofia: 1 compra
    Compra c5 = new Compra(5, LocalDateTime.of(2026, 10, 4, 18, 20));
    c5.agregarProducto(productos.get(2));
    c5.agregarProducto(productos.get(7));
    sofia.agregarCompra(c5);

    ArrayList<Cliente> clientes = new ArrayList<>();
    clientes.add(ana);
    clientes.add(luis);
    clientes.add(maria);
    clientes.add(carlos);
    clientes.add(sofia);

    // ---------- CAJEROS ----------
    ArrayList<Cajero> cajeros = new ArrayList<>();
    cajeros.add(new Cajero("1720000001", "Pedro", "Loor", "0981111111", 1, "E001"));
    cajeros.add(new Cajero("1720000002", "Lucia", "Gomez", "0982222222", 2, "E002"));

    // ---------- ABRIR EL MENU ----------
    ArrayList<Inventario> inventarios = new ArrayList<>();

    Inventario pasillo1 = new Inventario(1);
    pasillo1.insertarProducto(productos.get(0)); // Arroz
    pasillo1.insertarProducto(productos.get(1)); // Aceite
    pasillo1.insertarProducto(productos.get(4)); // Atun

    Inventario pasillo2 = new Inventario(2);
    pasillo2.insertarProducto(productos.get(2)); // Leche
    pasillo2.insertarProducto(productos.get(3)); // Pan
    pasillo2.insertarProducto(productos.get(5)); // Huevos

    Inventario pasillo3 = new Inventario(3);
    pasillo3.insertarProducto(productos.get(6)); // Detergente
    pasillo3.insertarProducto(productos.get(7)); // Gaseosa

    inventarios.add(pasillo1);
    inventarios.add(pasillo2);
    inventarios.add(pasillo3);
    
    // ---------- ABRIR EL MENU ----------
    Jframe_Menu menu = new Jframe_Menu(clientes, productos, cajeros, inventarios);
    menu.setLocationRelativeTo(null);
    menu.setVisible(true);
    }

}
