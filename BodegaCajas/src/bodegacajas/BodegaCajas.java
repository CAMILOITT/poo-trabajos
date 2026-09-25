/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bodegacajas;
import java.util.Scanner;

/**
 *
 * @author grupo1
 */
public class BodegaCajas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de la bodega: ");
        String nombreBodega = sc.nextLine();
        System.out.print("Ubicacion: ");
        String ubicacion = sc.nextLine();
        Bodega bodega = new Bodega(nombreBodega, ubicacion);

        String opcion = "";

        while (!opcion.equals("5")) {
            System.out.println("\n1) Apilar caja  2) Retirar caja  3) Ver caja de encima  4) Mostrar  5) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Codigo: ");
                String codigo = sc.nextLine();
                System.out.print("Contenido: ");
                String contenido = sc.nextLine();
                System.out.print("Peso en kg: ");
                float peso = Float.parseFloat(sc.nextLine());
                bodega.apilarCaja(new Caja(codigo, contenido, peso));

            } else if (opcion.equals("2")) {
                Caja c = bodega.retirarCaja();
                if (c == null) {
                    System.out.println("La bodega esta vacia");
                } else {
                    System.out.println("Se retiro la caja: " + c.getCodigo());
                }

            } else if (opcion.equals("3")) {
                Caja c = bodega.verCajaSuperior();
                if (c == null) {
                    System.out.println("La bodega esta vacia");
                } else {
                    System.out.println("Caja de encima: " + c.getCodigo() + " - " + c.getContenido());
                }

            } else if (opcion.equals("4")) {
                bodega.mostrarCajas();

            } else if (!opcion.equals("5")) {
                System.out.println("Opcion no valida");
            }
        }
    }

}
