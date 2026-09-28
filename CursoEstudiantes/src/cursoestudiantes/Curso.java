/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursoestudiantes;

import java.util.ArrayList;

/**
 *
 * @author grupo1
 */
public class Curso {

    private String nombre;
    private String paralelo;
    private ArrayList<Estudiante> estudiantes;

    /**
     * Crea un curso con una lista de estudiantes vacía.
     *
     * @param nombre nombre del curso
     * @param paralelo del curso
     */
    public Curso(String nombre, String paralelo) {
        this.nombre = nombre;
        this.paralelo = paralelo;
        this.estudiantes = new ArrayList<Estudiante>();
    }

    /**
     * Crea un curso con una lista de estudiantes vacía y una capacidad inicial.
     *
     * @param nombre nombre del curso
     * @param paralelo paralelo del curso
     * @param capacidadInicial cantidad de estudiantes que se espera tener
     */
    public Curso(String nombre, String paralelo, int capacidadInicial) {
        this.nombre = nombre;
        this.paralelo = paralelo;
        this.estudiantes = new ArrayList<Estudiante>(capacidadInicial);
    }

    /**
     * Agrega un estudiante al final de la lista.
     *
     * @param e estudiante que se va a agregar
     */
    public void agregarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }

    /**
     * Busca un estudiante por su cédula.
     *
     * @param cedula cédula del estudiante que se busca
     * @return el estudiante encontrado, o null si no existe
     */
    public Estudiante buscarEstudiante(String cedula) {
        for (Estudiante e : this.estudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Elimina un estudiante de la lista usando su cédula.
     *
     * @param cedula cédula del estudiante que se va a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean eliminarEstudiante(String cedula) {
        Estudiante e = buscarEstudiante(cedula);
        if (e == null) {
            return false;
        }
        this.estudiantes.remove(e);
        return true;
    }

    /**
     * Muestra el nombre del curso y todos sus estudiantes.
     */
    public void mostrarEstudiantes() {
        System.out.println("Curso: " + this.nombre + " - Paralelo: " + this.paralelo);
        for (Estudiante e : this.estudiantes) {
            System.out.println(e.getCedula() + " - " + e.getNombre() + " "
                    + e.getApellido() + " /nota: " + e.getNota());
        }
        System.out.println("Total: " + this.estudiantes.size());
    }
}
