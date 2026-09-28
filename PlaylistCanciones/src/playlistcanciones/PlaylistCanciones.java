/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playlistcanciones;

import java.util.Scanner;

/**
 *
 * @author grupo1
 */
public class PlaylistCanciones {
        /**
     * Pide al usuario los datos de una canción y la crea.
     *
     * @param leer scanner para leer los datos
     * @return la canción creada
     */
    public static Cancion leerCancion(Scanner leer) {
        System.out.print("Titulo: ");
        String titulo = leer.nextLine();
        System.out.print("Artista: ");
        String artista = leer.nextLine();
        System.out.print("Genero: ");
        String genero = leer.nextLine();
        System.out.print("Duracion (ej. 3:40): ");
        String duracion = leer.nextLine();
        return new Cancion(titulo, artista, genero, duracion);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist("Mis favoritas", "Grupo1");
        String opcion = "";

        while (!opcion.equals("6")) {
            System.out.println("\n1) Agregar al inicio  2) Agregar al final  3) Eliminar primera");
            System.out.println("4) Eliminar ultima  5) Mostrar  6) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                playlist.agregarAlInicio(leerCancion(sc));

            } else if (opcion.equals("2")) {
                playlist.agregarAlFinal(leerCancion(sc));

            } else if (opcion.equals("3") || opcion.equals("4")) {
                Cancion c;
                if (opcion.equals("3")) {
                    c = playlist.eliminarPrimera();
                } else {
                    c = playlist.eliminarUltima();
                }
                if (c == null) {
                    System.out.println("La playlist esta vacia");
                } else {
                    System.out.println("Se elimino: " + c.getTitulo());
                }

            } else if (opcion.equals("5")) {
                playlist.mostrarCanciones();

            } else if (!opcion.equals("6")) {
                System.out.println("Opcion no valida");
            }
        }
    }
}
