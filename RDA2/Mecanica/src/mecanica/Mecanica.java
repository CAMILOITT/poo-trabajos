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
        ArrayList<Cliente> listaClientes = ArchivoDatos.mostrarClientes();
        ArrayList<Mecanico> listaMecanicos = ArchivoDatos.mostrarMecanicos();
        ArrayList<Repuesto> listaRepuestos = ArchivoDatos.mostrarRepuestos();
        ArchivoDatos.mostrarOrdenes(listaClientes, listaMecanicos, listaRepuestos);
        ArrayList<Factura> listaFacturas = ArchivoDatos.mostrarFacturas(listaClientes);

        JFrameTallerMenu menu = new JFrameTallerMenu(listaClientes, listaMecanicos, listaRepuestos, listaFacturas);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
