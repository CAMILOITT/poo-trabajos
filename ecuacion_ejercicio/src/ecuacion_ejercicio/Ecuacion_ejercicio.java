/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecuacion_ejercicio;

import java.util.Scanner;

/**
 * Programa que resuelve ecuaciones de primer o segundo grado por consola,
 * pidiendo al usuario los coeficientes necesarios según el tipo de ecuación que
 * elija.
 *
 * @author mnobo
 */
public class Ecuacion_ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a, b, c;

        // Guarda qué tipo de ecuación eligió el usuario: 1 (primer
        // grado) o 2 (segundo grado).
        int opcion;

        Scanner sc = new Scanner(System.in);

        // Se crea con el constructor vacío; los coeficientes se van
        // asignando después con los setters, según lo que el usuario
        // vaya respondiendo.
        System.out.println("""
            Ingrese las siguiente variables:

            Cual sera a?: 
        """);
        a = sc.nextFloat();
        sc.nextLine();

        System.out.print("Cual sera b?: ");
        b = sc.nextFloat();
        sc.nextLine();

        System.out.print("Cual sera c?: ");
        c = sc.nextFloat();
        sc.nextLine();

        System.out.println("""
            Selecione la ecuacion que desea resolver (escriba el literal correspondiente)
            1. Ecuacion de primer grado
            2. Ecuacion de segundo grado

            Ingrese su opcion:

            """);
        opcion = sc.nextInt();

        Ecuacion ec = new Ecuacion(a, b, c);

        if (opcion > 2 || opcion < 0) {
            System.out.print("La opcion no es valida");
        }

        if (opcion == 1) {
            System.out.print("su resultado es: " + ec.encontrarRaiz());
        }

        if (opcion == 2) {
            String[] respuesta = ec.encontrarRaices2Grado();
            System.out.println("[ "+ respuesta[0]+ ", "+ respuesta[1]+ " ]");
        }

    }
}
