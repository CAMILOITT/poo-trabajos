/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1grupo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class Examen1Grupo {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		List<SitioTuristico> listaSitios = new ArrayList<SitioTuristico>();

		// realizar el menu para el ingreso de datos

		// realizar el menu para escoger la opcion (debe de tener la opcion para salir
		// del programa)

	}

	public static List<SitioTuristico> buscarSitiosTuristicosPorCiudad(List<SitioTuristico> listaSitios, String ciudad) {
		List<SitioTuristico> listaFiltrada = new ArrayList<SitioTuristico>();

		for (SitioTuristico sitioTuristico : listaSitios) {
			if (sitioTuristico.getCiudad().equals(ciudad)) {
				listaFiltrada.add(sitioTuristico)
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
