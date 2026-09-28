package bancoclientes;

import java.util.Scanner;

/**
 * Clase principal que prueba el banco con ArrayDeque mediante un menu.
 *
 * @author grupo1
 */
public class BancoClientes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del banco: ");
        String nombreBanco = sc.nextLine();
        System.out.print("Sucursal: ");
        String sucursal = sc.nextLine();
        Banco banco = new Banco(nombreBanco, sucursal);

        String opcion = "";

        while (!opcion.equals("5")) {
            System.out.println("\n1) Llega cliente  2) Atender cliente  3) Ver siguiente  4) Mostrar fila  5) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Cedula: ");
                String cedula = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Tramite: ");
                String tramite = sc.nextLine();
                banco.llegarCliente(new Cliente(cedula, nombre, tramite));

            } else if (opcion.equals("2")) {
                Cliente c = banco.atenderCliente();
                if (c == null) {
                    System.out.println("No hay clientes en la fila");
                } else {
                    System.out.println("Se atendio a: " + c.getNombre() + " - " + c.getTramite());
                }

            } else if (opcion.equals("3")) {
                Cliente c = banco.verSiguiente();
                if (c == null) {
                    System.out.println("No hay clientes en la fila");
                } else {
                    System.out.println("Siguiente: " + c.getNombre());
                }

            } else if (opcion.equals("4")) {
                banco.mostrarFila();

            } else if (!opcion.equals("5")) {
                System.out.println("Opcion no valida");
            }
        }
    }
}