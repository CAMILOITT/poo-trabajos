/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciobiblioteca;

/**
 *
 * @author grupo 1
 */
public class Libro {
    
    private String IdLibro;
    private String Titulo;
    private String Editorial;
    private int AnioDePublicacion;
    private String GeneroLiterario;

    public Libro(String IdLibro, String Titulo, String Editorial, int AnioDePublicacion, String GeneroLiterario) {
        this.IdLibro = IdLibro;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.AnioDePublicacion = AnioDePublicacion;
        this.GeneroLiterario = GeneroLiterario;
    }

    public String getIdLibro() {
        return IdLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public int getAnioDePublicacion() {
        return AnioDePublicacion;
    }

    public String getGeneroLiterario() {
        return GeneroLiterario;
    }

    public void setIdLibro(String IdLibro) {
        this.IdLibro = IdLibro;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public void setAnioDePublicacion(int AnioDePublicacion) {
        this.AnioDePublicacion = AnioDePublicacion;
    }

    public void setGeneroLiterario(String GeneroLiterario) {
        this.GeneroLiterario = GeneroLiterario;
    }

}
