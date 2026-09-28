/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistcanciones;

import java.util.LinkedList;

/**
 *
 * @author grupo1
 */
public class Playlist {

    private String nombre;
    private String creador;
    private LinkedList<Cancion> canciones;

    /**
     * Crea una playlist vacía sin creador conocido.
     *
     * @param nombre nombre de la playlist
     */
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.creador = "Anonimo";
        this.canciones = new LinkedList<Cancion>();
    }

    /**
     * Crea una playlist vacía con su creador.
     *
     * @param nombre nombre de la playlist
     * @param creador nombre de quien creó la playlist
     */
    public Playlist(String nombre, String creador) {
        this.nombre = nombre;
        this.creador = creador;
        this.canciones = new LinkedList<Cancion>();
    }

    /**
     * Agrega una canción al inicio de la playlist.
     *
     * @param c canción que se va a agregar
     */
    public void agregarAlInicio(Cancion c) {
        this.canciones.addFirst(c);
    }

    /**
     * Agrega una canción al final de la playlist.
     *
     * @param c canción que se va a agregar
     */
    public void agregarAlFinal(Cancion c) {
        this.canciones.addLast(c);

    }

    /**
     * Elimina la primera canción de la playlist.
     *
     * @return la canción eliminada, o null si la playlist está vacía
     */
    public Cancion eliminarPrimera() {
        if (this.canciones.isEmpty()) {
            return null;
        }
        return this.canciones.removeFirst();
    }

    /**
     * Elimina la última canción de la playlist.
     *
     * @return la canción eliminada, o null si la playlist está vacía
     */

    public Cancion eliminarUltima() {
        if (this.canciones.isEmpty()) {
            return null;
        }
        return this.canciones.removeLast();
    }

    /**
     * Muestra el nombre de la playlist, su creador y todas sus canciones.
     */
    public void mostrarCanciones() {
        System.out.println("Playlist: " + this.nombre + " - Creador: " + this.creador);
        for (Cancion c : this.canciones) {
            System.out.println(c.getTitulo() + " - " + c.getArtista() + " -"
                    + c.getGenero() + " - " + c.getDuracion());
        }
        System.out.println("TOtal: " + this.canciones.size());
    }

}
