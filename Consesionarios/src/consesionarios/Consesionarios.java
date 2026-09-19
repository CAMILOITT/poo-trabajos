/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consesionarios;

import java.util.Scanner;

/**
 * Contiene las funciones no miembro (estáticas) que operan sobre el
 * inventario de vehículos de la concesionaria, representado como una
 * matriz de 3x3 de objetos Vehiculo.
 *
 * @author grupo 1
 */
public class Consesionarios {

    /**
     * Suma el precio de todos los vehículos de una marca específica,
     * recorriendo la matriz completa del inventario.
     *
     * @param arr matriz 3x3 con el inventario de vehículos
     * @param marca marca por la cual filtrar
     * @return la suma total en dinero de los vehículos de esa marca
     */
    public static float TotalStockEnDinero(Vehiculo arr[][], String marca)
    {
        float stock_dinero = 0;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[i][j].getMarca().equals(marca))
                {
                    stock_dinero += arr[i][j].getPrecio();
                }
            }
        }

        return stock_dinero;
    }

    /**
     * Busca todos los vehículos cuyo año está dentro de un rango
     * dado (inclusive), recorriendo la matriz completa del
     * inventario, y los devuelve en un arreglo nuevo.
     *
     * Se recorre la matriz dos veces: la primera solo para contar
     * cuántos vehículos califican (y así saber el tamaño exacto que
     * necesita el arreglo de resultado), y la segunda para llenarlo.
     *
     * @param arr matriz 3x3 con el inventario de vehículos
     * @param anio1 año inicial del rango (inclusive)
     * @param anio2 año final del rango (inclusive)
     * @return un arreglo con los vehículos cuyo año está entre
     *         anio1 y anio2
     */
    public static Vehiculo[] RangoAnios(Vehiculo arr[][], int anio1, int anio2)
    {
        
        int cont = 0;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                int anioVehiculo = Integer.parseInt(arr[i][j].getAnios());
                if (anio1 <= anioVehiculo && anioVehiculo <= anio2)
                {
                    cont++;
                }
            }
        }

        Vehiculo arr2[] = new Vehiculo[cont];
        int cont2 = 0;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                int anioVehiculo = Integer.parseInt(arr[i][j].getAnios());
                if (anio1 <= anioVehiculo && anioVehiculo <= anio2)
                {
                    arr2[cont2++] = arr[i][j];
                }
            }
        }

        return arr2;
    }

    /**
     * Busca un vehículo por su placa, recorriendo la matriz completa
     * del inventario.
     *
     * @param arr matriz 3x3 con el inventario de vehículos
     * @param placa placa que se desea buscar
     * @return la representación en texto del vehículo encontrado, o
     *         un mensaje indicando que no se encontró ninguno
     */
    public static String BuscarPlaca(Vehiculo arr[][], String placa)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {

                if (arr[i][j].getPlaca().equals(placa))
                {
                    return arr[i][j].VerVehiculo();
                }
            }
        }
        return "No se encontro vehiculo, con esa placa";
    }

    /**
     * Imprime por consola la representación de cada vehículo de un
     * arreglo (pensado para mostrar, por ejemplo, el resultado de
     * RangoAnios).
     *
     * @param arr arreglo de vehículos a imprimir
     */
    /**
     * Punto de entrada del programa. Llena un inventario de 3x3
     * vehículos pidiendo los datos por teclado, y luego muestra un
     * menú que permite probar las tres funciones no miembro
     * (TotalStockEnDinero, RangoAnios y BuscarPlaca) sobre ese
     * inventario.
     *
     * @param args the command line arguments
     */
    public static void ImprimirArr(Vehiculo arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i].VerVehiculo());
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // El inventario de la concesionaria: una matriz fija de 3x3,
        // tal como pide el enunciado.
        Vehiculo[][] inventario = new Vehiculo[3][3];

        // --- Ingreso de datos por teclado: se llenan los 9 vehículos ---
        System.out.println("Ingreso de datos del inventario (3x3 vehiculos)");
        System.out.println();

        for (int i = 0; i < inventario.length; i++)
        {
            for (int j = 0; j < inventario[i].length; j++)
            {
                System.out.println("Vehiculo [" + i + "][" + j + "]");

                System.out.print("Marca: ");
                String marca = sc.nextLine();

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();

                System.out.print("Precio: ");
                float precio = sc.nextFloat();
                sc.nextLine(); // limpia el salto de linea pendiente de nextFloat()

                System.out.print("Anio: ");
                String anio = sc.nextLine();

                System.out.print("Placa: ");
                String placa = sc.nextLine();

                inventario[i][j] = new Vehiculo(marca, modelo, precio, anio, placa);

                System.out.println();
            }
        }

        // --- Menu para probar las funciones sobre el inventario ya lleno ---
        String opcion = "";

        while (!opcion.equals("FIN"))
        {
            System.out.println();
            System.out.println("Que desea hacer? (escriba el literal correspondiente)");
            System.out.println("Para salir digite: FIN");
            System.out.println();
            System.out.println("1. Consultar el total en stock en dinero de una marca");
            System.out.println("2. Buscar vehiculos por rango de anios");
            System.out.println("3. Buscar un vehiculo por placa");
            System.out.println();
            System.out.print("Cual sera su opcion?: ");
            opcion = sc.nextLine();
            System.out.println();

            if (opcion.equals("1"))
            {
                System.out.print("Ingrese la marca a consultar: ");
                String marcaBuscada = sc.nextLine();

                float total = TotalStockEnDinero(inventario, marcaBuscada);
                System.out.println("El total en stock de la marca " + marcaBuscada + " es: " + total);
            }
            else if (opcion.equals("2"))
            {
                System.out.print("Ingrese el anio inicial del rango: ");
                int anio1 = sc.nextInt();
                sc.nextLine(); // limpia el salto de linea pendiente de nextInt()

                System.out.print("Ingrese el anio final del rango: ");
                int anio2 = sc.nextInt();
                sc.nextLine();

                Vehiculo[] encontrados = RangoAnios(inventario, anio1, anio2);

                System.out.println();
                System.out.println("Vehiculos encontrados en ese rango de anios:");
                ImprimirArr(encontrados);
            }
            else if (opcion.equals("3"))
            {
                System.out.print("Ingrese la placa a buscar: ");
                String placaBuscada = sc.nextLine();

                String resultado = BuscarPlaca(inventario, placaBuscada);
                System.out.println(resultado);
            }
        }

        System.out.println();
        System.out.println("Gracias por usar este programa");

        sc.close();
    }
}