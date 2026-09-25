/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursoestudiantes;

/**
 *
 * @author grupo1
 */
public class Estudiante {

    private String cedula;
    private String nombre;
    private String apellido;
    private float nota;

    /**
     * Crea un estudiante con todos sus datos.
     *
     * @param cedula cédula del estudiante
     * @param nombre nombre del estudiante
     * @param apellido apellido del estudiante
     * @param nota nota del estudiante
     */
    public Estudiante(String cedula, String nombre, String apellido, float nota) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    /**
     * Obtiene la cédula del estudiante.
     *
     * @return la cédula del estudiante
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return el nombre del estudiante
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return el apellido del estudiante
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Obtiene la nota del estudiante.
     *
     * @return la nota del estudiante
     */
    public double getNota() {
        return this.nota;
    }

}
