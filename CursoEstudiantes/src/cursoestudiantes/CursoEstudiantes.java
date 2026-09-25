/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cursoestudiantes;

import java.util.Scanner;

/**
 *
 * @author grupo1
 */
public class CursoEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del curso: ");
        String nombreCurso = sc.nextLine();
        System.out.print("Paralelo: ");
        String paralelo = sc.nextLine();
        Curso curso = new Curso(nombreCurso, paralelo);

        String opcion = "";

        while (!opcion.equals("5")) {
            System.out.println("\n1) Agregar  2) Buscar  3) Eliminar  4) Mostrar  5) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Cedula: ");
                String cedula = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Nota: ");
                float nota = Float.parseFloat(sc.nextLine());
                curso.agregarEstudiante(new Estudiante(cedula, nombre, apellido, nota));

            } else if (opcion.equals("2")) {
                System.out.print("Cedula a buscar: ");
                Estudiante e = curso.buscarEstudiante(sc.nextLine());
                if (e == null) {
                    System.out.println("No se encontro ese estudiante");
                } else {
                    System.out.println("Encontrado: " + e.getNombre() + " " + e.getApellido());
                }

            } else if (opcion.equals("3")) {
                System.out.print("Cedula a eliminar: ");
                if (curso.eliminarEstudiante(sc.nextLine())) {
                    System.out.println("Estudiante eliminado");
                } else {
                    System.out.println("No se encontro ese estudiante");
                }

            } else if (opcion.equals("4")) {
                curso.mostrarEstudiantes();

            } else if (!opcion.equals("5")) {
                System.out.println("Opcion no valida");
            }
        }

    }

}
