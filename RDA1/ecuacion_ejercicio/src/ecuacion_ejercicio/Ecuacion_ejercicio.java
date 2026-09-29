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
 * @author grupo1
 */
public class Ecuacion_ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a, b, c;
 
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese las variables:");
        System.out.println();
        System.out.print("Ingrese a: ");
        a = sc.nextFloat();
        sc.nextLine();

        System.out.print("Ingrse b: ");
        b = sc.nextFloat();
        sc.nextLine();

        System.out.print("Ingrese c: ");
        c = sc.nextFloat();
        sc.nextLine();

        Ecuacion ec = new Ecuacion(a, b, c);
        String[] resultado = ec.encontrarRaices();
        
        if(ec.esPrimerGrado()){
            System.out.println();
            System.out.println("Es una ecuacion de primer grado");
            System.out.println("El resultado es: " + resultado[0]);
        }else {
            System.out.println();
            System.out.println("Es una ecuacion de segundo grado");
            System.out.println("X1 = " + resultado[0]);
            System.out.println("X2 = " + resultado[1]);
           
        }
        sc.close();
    }
}
    