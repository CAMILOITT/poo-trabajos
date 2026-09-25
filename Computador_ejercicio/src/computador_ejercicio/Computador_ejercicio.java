/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package computador_ejercicio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que gestiona una estructura de dos dimensiones (ArrayList
 * de ArrayList) de 2x2 computadoras, y permite buscar una de ellas
 * por su código en toda la estructura.
 *
 * @author grupo 1
 */
public class Computador_ejercicio {

    /**
     * Busca una computadora dentro de la estructura, recorriendo
     * todos los grupos y, dentro de cada uno, todas sus computadoras.
     *
     * @param computadoras estructura dinámica de dos dimensiones
     *                     donde buscar
     * @param codigo código de la computadora que se desea encontrar
     * @return la computadora encontrada, o null si ninguna coincide
     *         con ese código
     */
    public static Computadora buscarComputadora(ArrayList<ArrayList<Computadora>> computadoras, String codigo)
    {
        for (int i=0; i< computadoras.size(); i++)
        {
            for (int j=0; j< computadoras.get(i).size(); j++)
            {
                if (computadoras.get(i).get(j).getCodigo().equals(codigo))
                {
                    return computadoras.get(i).get(j);
                }
            }
        }
        return null;
    }

    /**
     * Punto de entrada del programa. Llena una estructura de 2x2
     * computadoras pidiendo los datos por teclado, y luego muestra
     * un menú que permite buscar una computadora por su código.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        // Aunque la estructura (ArrayList de ArrayList) es dinámica
        // por naturaleza, este ejercicio pide un tamaño fijo de 2x2,
        ArrayList<ArrayList<Computadora>> computadoras = new ArrayList<ArrayList<Computadora>>();

        System.out.println("Ingreso de datos de las computadoras (2x2)");
        System.out.println();

        for (int i = 0; i < 2; i++)
        {
            computadoras.add(new ArrayList<Computadora>());

            for (int j = 0; j < 2; j++)
            {
                System.out.println("Computadora [" + i + "][" + j + "]");

                Computadora c = new Computadora();

                System.out.print("Marca: ");
                c.setMarca(sc.nextLine());

                System.out.print("Codigo: ");
                c.setCodigo(sc.nextLine());

                System.out.print("Procesador: ");
                c.setProcesador(sc.nextLine());

                System.out.print("Tarjeta grafica: ");
                c.setTarjetaGrafica(sc.nextLine());

                computadoras.get(i).add(c);

                System.out.println();
            }
        }

        // --- Menu para probar la busqueda sobre la estructura ya llena ---
        String opcion = "";

        while (!opcion.equals("FIN"))
        {
            System.out.println();
            System.out.println("Que desea hacer? (escriba el literal correspondiente)");
            System.out.println("Para salir digite: FIN");
            System.out.println();
            System.out.println("1. Buscar una computadora por codigo");
            System.out.println();
            System.out.print("Cual sera su opcion?: ");
            opcion = sc.nextLine();
            System.out.println();

            if (opcion.equals("1"))
            {
                System.out.print("Ingrese el codigo a buscar: ");
                String codigo = sc.nextLine();

                Computadora encontrada = buscarComputadora(computadoras, codigo);

                System.out.println();
                if (encontrada != null)
                {
                    System.out.println("Computadora encontrada:");
                    System.out.println("Marca: " + encontrada.getMarca());
                    System.out.println("Codigo: " + encontrada.getCodigo());
                    System.out.println("Procesador: " + encontrada.getProcesador());
                    System.out.println("Tarjeta grafica: " + encontrada.getTarjetaGrafica());
                }
                else
                {
                    System.out.println("No se encontro ninguna computadora con ese codigo.");
                }
            }
        }

        System.out.println();
        System.out.println("Gracias por usar este programa");

        sc.close();
    }

}