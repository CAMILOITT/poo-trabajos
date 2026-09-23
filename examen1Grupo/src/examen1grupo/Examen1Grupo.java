/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1grupo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Examen1Grupo {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner readline = new Scanner(System.in);
    List<SitioTuristico> listaSitios = new ArrayList<SitioTuristico>();

    // realizar el menu para el ingreso de datos
    System.out.println("PROGRAMA PRUEBA RDA1 -GRUPO 1-");
    while (true) {
      System.out.println("""
          =================================
                          MENU
          =================================
          1)Agregar un Sitio Turistico
          2)Buscar (Por Ciudad)
          3)Buscar (Por rango de costos)
          4)Salir
                                      """);
      System.out.println("Ingrese la opcion: ");
      String respuestaI = readline.nextLine();
      if (respuestaI.equals("4")) {
        break;
      }
      if (respuestaI.equals("1")) {
        // agragar sitio
        continue;
      }
      if (respuestaI.equals("2")) {
        System.out.println("");
        String palabraBuscar = buscarSitiosTuristicosPorCiudad(listaSitios, respuestaI);
        continue;
      }
      if (respuestaI.equals("3")) {
        continue;
      }
      System.out.println("ERROR! EL dato ingresado no es valido");

    }
  }

  public static List<SitioTuristico> buscarSitiosTuristicosPorCiudad(List<SitioTuristico> listaSitios, String ciudad) {
    List<SitioTuristico> listaFiltrada = new ArrayList<SitioTuristico>();

    for (SitioTuristico sitioTuristico : listaSitios) {
      if (sitioTuristico.getDirector().equals(ciudad)) {
        listaFiltrada.add(sitioTuristico);
      }
    }
    return listaFiltrada;
  }

  public static List<SitioTuristico> buscarSitiosTurisiticosPorRangoDeCosto(List<SitioTuristico> listaSitios,
      double costoInferior, double costoSuperior) {

    List<SitioTuristico> listaFiltrada = new ArrayList<SitioTuristico>();
    for (SitioTuristico sitioTuristico : listaSitios) {
      if (costoInferior <= sitioTuristico.getCosto() && sitioTuristico.getCosto() <= costoSuperior) {
        listaFiltrada.add(sitioTuristico);
      }
    }
    return listaFiltrada;
  }

}
