/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleados_ejercicio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que gestiona una lista dinámica de empleados: permite agregarlos por
 * teclado y buscarlos por su código de identificación.
 *
 * @author grupo 1
 */
public class Empleados_ejercicio {

    /**
     * Busca un empleado dentro de la lista, comparando su código.
     *
     * @param empleados lista de empleados donde buscar
     * @param codigo código del empleado que se desea encontrar
     * @return el empleado encontrado, o null si ningún empleado de la lista
     * tiene ese código
     */
    public static Empleado buscarEmpleado(ArrayList<Empleado> empleados, String codigo) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCodigo().equals(codigo)) {
                return empleados.get(i);
            }
        }
        return null;
    }

    /**
     * Punto de entrada del programa. Muestra un menú que permite agregar
     * empleados nuevos a la lista, o buscar uno existente por su código, hasta
     * que el usuario decida salir.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        // Lista dinámica: no tiene un tamaño fijo como un arreglo,
        // crece automáticamente cada vez que se agrega un empleado.
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        String opcion = "";

        while (!opcion.equals("FIN")) {
            System.out.println();
            System.out.println("Que desea hacer? (escriba el literal correspondiente)");
            System.out.println("Para salir digite: FIN");
            System.out.println();
            System.out.println("1. Agregar un empleado");
            System.out.println("2. Buscar un empleado por código");
            System.out.println();
            System.out.print("Cual sera su opción?: ");
            opcion = sc.nextLine();
            System.out.println();

            if (opcion.equals("1")) {
                // Como Empleado no tiene constructor con parametros,
                // se crea vació y se llena con los setters.
                Empleado e = new Empleado();

                System.out.print("Nombre: ");
                e.setNombre(sc.nextLine());

                System.out.print("Cargo: ");
                e.setCargo(sc.nextLine());

                System.out.print("Codigo: ");
                e.setCodigo(sc.nextLine());

                empleados.add(e);

                System.out.println();
                System.out.println("Empleado agregado correctamente.");
            } else if (opcion.equals("2")) {
                System.out.print("Ingrese el código a buscar: ");
                String codigo = sc.nextLine();

                Empleado encontrado = buscarEmpleado(empleados, codigo);

                System.out.println();
                if (encontrado != null) {
                    System.out.println("Empleado encontrado:");
                    System.out.println("Nombre: " + encontrado.getNombre());
                    System.out.println("Cargo: " + encontrado.getCargo());
                    System.out.println("Código: " + encontrado.getCodigo());
                } else {
                    System.out.println("No se encontró ningún empleado con ese código.");
                }
            }
        }

        System.out.println();
        System.out.println("Gracias por usar este programa");

        sc.close();
    }

}
