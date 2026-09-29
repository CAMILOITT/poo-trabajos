/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1grupo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Examen1Grupo1 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner readline = new Scanner(System.in);
    List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

    System.out.println("PROGRAMA PRUEBA RDA1 -GRUPO 1-");
    while (true) {
      System.out.println("""
          =================================
                          MENU
          =================================
          1)Agregar Pelicula
          2)Buscar por Autor
          3)Buscar por anio
          4)Salir
                                      """);
      System.out.println("Ingrese la opcion: ");
      String respuestaI = readline.nextLine();
      if (respuestaI.equals("4")) {
        break;
      }
      if (respuestaI.equals("1")) {
        Pelicula item = crearPelicula(readline);
        listaPeliculas.add(item);
        continue;
      }

      if (respuestaI.equals("2")) {
        System.out.println("Ingrese el autor:");
        String autor = readline.nextLine();
        if (autor.equals("")) {
          System.out.println("Autor no valido.");
          continue;
        }
        List<Pelicula> peliculasPorAutor = buscarPeliculaPorAutor(listaPeliculas, autor);
        imprimirLista(peliculasPorAutor);
        continue;
      }

      if (respuestaI.equals("3")) {
        System.out.println("Ingrese el anio:");
        int anioBuscar = (int) readline.nextInt();
        List<Pelicula> listaPeliculasPorAnio = buscarPeliculaPorAnio(listaPeliculas, anioBuscar);
        imprimirLista(listaPeliculasPorAnio);
        continue;
      }

      System.out.println("ERROR! EL dato ingresado no es valido");
    }

    readline.close();
  }

  public static Pelicula crearPelicula(Scanner readline) {

    System.out.println("Ingrese el nombre:");
    String nombre = readline.nextLine();
    System.out.println("Ingrese el descripcion:");
    String descripcion = readline.nextLine();
    System.out.println("Ingrese el director:");
    String director = readline.nextLine();
    System.out.println("Ingrese el genero:");
    String genero = readline.nextLine();
    System.out.println("Ingrese el anio:");
    int anio = readline.nextInt();

    return new Pelicula(director, nombre, descripcion, genero, anio);
  }

  public static void imprimirLista(List<Pelicula> listaPelicula) {
    for (Pelicula item : listaPelicula) {
      System.out.println("Nombre:" + item.getNombre());
      System.out.println("Anio:" + item.getAnio());
      System.out.println("Director:" + item.getDirector());
      System.out.println();
    }
  }

  public static List<Pelicula> buscarPeliculaPorAutor(List<Pelicula> listaPeliculas, String ciudad) {
    List<Pelicula> listaFiltrada = new ArrayList<Pelicula>();
    for (Pelicula Pelicula : listaPeliculas) {
      if (Pelicula.getDirector().equals(ciudad)) {
        listaFiltrada.add(Pelicula);
      }
    }
    return listaFiltrada;
  }

  public static List<Pelicula> buscarPeliculaPorAnio(List<Pelicula> listaPeliculas,
      int anio) {
    List<Pelicula> listaFiltrada = new ArrayList<Pelicula>();
    for (Pelicula Pelicula : listaPeliculas) {
      if (Pelicula.getAnio() == anio) {
        listaFiltrada.add(Pelicula);
      }
    }
    return listaFiltrada;
  }

}
