/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistcanciones;

/**
 *
 * @author grupo1
 */
public class Cancion {

    private String titulo;
    private String artista;
    private String genero;
    private String duracion;

    /**
     * Crea una canción con todos sus datos.
     *
     * @param titulo título de la canción
     * @param artista artista de la canción
     * @param genero género musical
     * @param duracion duración en formato minutos:segundos
     */
    public Cancion(String titulo, String artista, String genero, String duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
    }

    /**
     * @return el título de la canción
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @return el artista de la canción
     */
    public String getArtista() {
        return this.artista;
    }

    /**
     * @return el género de la canción
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * @return la duración de la canción
     */
    public String getDuracion() {
        return this.duracion;
    }

}
