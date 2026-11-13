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
public class Prestamo {
    
    private String IdPrestamo;
    private String Estado;
    private Date FechaPrestamo;
    private ArrayList<Libro> ListaDeLibros;

    public Prestamo(String IdPrestamo, String Estado, Date FechaPrestamo, ArrayList<Libro> ListaDeLibros) {
        this.IdPrestamo = IdPrestamo;
        this.Estado = Estado;
        this.FechaPrestamo = FechaPrestamo;
        this.ListaDeLibros = ListaDeLibros;
    }

    public String getIdPrestamo() {
        return IdPrestamo;
    }

    public String getEstado() {
        return Estado;
    }

    public Date getFechaPrestamo() {
        return FechaPrestamo;
    }

    public ArrayList<Libro> getListaDeLibros() {
        return ListaDeLibros;
    }

    public void setIdPrestamo(String IdPrestamo) {
        this.IdPrestamo = IdPrestamo;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setFechaPrestamo(Date FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }

    public void setListaDeLibros(ArrayList<Libro> ListaDeLibros) {
        this.ListaDeLibros = ListaDeLibros;
    }
    
    public void aniadirLibro(Libro libro)
    {
        ListaDeLibros.add(libro);
    }
    
}
