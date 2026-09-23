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
    private String nombrePelicula;
    private String descripcion;
    private float anioEstreno;

    public SitioTuristico(String nombreDirectorI, String nombrePeliculaI, String descripcionI, float anioEstrenoI) {
        this.director = nombreDirectorI;
        this.nombrePelicula = nombrePeliculaI;
        this.descripcion = descripcionI;
        this.anioEstreno = anioEstrenoI;
    }

    public String getDirector() {
        return this.director;
    }

    public String getNombrePelicula() {
        return this.nombrePelicula;
    }

    public String getDescripcion() {
        return this.descripcion;
    }   

    public Float getCosto() {
        return this.anioEstreno;
    }

}
