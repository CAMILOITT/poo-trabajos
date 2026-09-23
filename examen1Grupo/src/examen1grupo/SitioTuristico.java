/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1grupo;

/**
 *
 * @author camil
 */
public class SitioTuristico {
    private String director;
    private String nombre;
    private String descripcion;
    private int anioEstreno;
    private String genero;

    public SitioTuristico(String director, String nombre, String decripcion, int anioEstrenoI, String genero) {
        this.director = director;
        this.nombre = nombre;
        this.descripcion = decripcion;
        this.anioEstreno = anioEstrenoI;
        this.genero = genero;
    }

    public String getDirector() {
        return this.director;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getAnioEstreno() {
        return this.anioEstreno;
    }
    public String getGenero()
    {
        return this.genero;
    }

}
