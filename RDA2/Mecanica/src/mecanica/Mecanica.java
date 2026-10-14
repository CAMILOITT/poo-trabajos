/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mecanica;
import java.util.ArrayList;

/**
 *
 * @author grupo 1
 */
public class Mecanica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        ArrayList<Mecanico> listaMecanicos = new ArrayList<>();
        listaMecanicos.add(new Mecanico("Motor", new ArrayList<>(),
            "Pedro", "Loor", "1720000001", "0981111111", "pedro.loor@mail.com"));
        listaMecanicos.add(new Mecanico("Frenos", new ArrayList<>(),
            "Lucía", "Gómez", "1720000002", "0982222222", "lucia.gomez@mail.com"));
        listaMecanicos.add(new Mecanico("Electricidad", new ArrayList<>(),
            "Mario", "Vera", "1720000003", "0983333333", "mario.vera@mail.com"));

        ArrayList<Repuesto> listaRepuestos = new ArrayList<>();
        listaRepuestos.add(new Repuesto("R001", "Filtro de aceite", 8.50f));
        listaRepuestos.add(new Repuesto("R002", "Pastillas de freno", 32.00f));
        listaRepuestos.add(new Repuesto("R003", "Bujía", 4.75f));
        listaRepuestos.add(new Repuesto("R004", "Batería 12V", 95.00f));
        listaRepuestos.add(new Repuesto("R005", "Aceite 10W-30 (1L)", 7.25f));
        listaRepuestos.add(new Repuesto("R006", "Banda de distribución", 45.00f));

        ArrayList<Factura> listaFacturas = new ArrayList<>();

        TallerMenu menu = new TallerMenu(listaClientes, listaMecanicos, listaRepuestos, listaFacturas);       
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
    
}
