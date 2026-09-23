/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1grupo1;

/**
 *
 * @author mnobo
 */
public class Pelicula {
    private String director;
    private String nombre;
    private String descripcion;
    private String genero;
    private int anio;

    public Pelicula(String director, String nombre, String descripcion, String genero, int anio) {
        this.director = director;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }
}
