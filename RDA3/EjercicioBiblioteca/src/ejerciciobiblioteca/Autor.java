/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciobiblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grupo 1
 */
public class Autor extends Persona{
    
    private String Nacionalidad;
    private ArrayList<Libro> ListaLibros;

    public Autor(String Nacionalidad, ArrayList<Libro> ListaLibros, String Nombre, String Apellido, String CodigoId, Date FechaDeNacimiento) {
        super(Nombre, Apellido, CodigoId, FechaDeNacimiento);
        this.Nacionalidad = Nacionalidad;
        this.ListaLibros = ListaLibros;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public ArrayList<Libro> getListaLibros() {
        return ListaLibros;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public void setListaLibros(ArrayList<Libro> ListaLibros) {
        this.ListaLibros = ListaLibros;
    }
    
    public void aniadirLibro(Libro libro)
    {
        this.ListaLibros.add(libro);
    }
    
}
