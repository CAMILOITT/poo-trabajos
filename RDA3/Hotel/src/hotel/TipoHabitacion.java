/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.util.ArrayList;

/**
 *
 * @author Batman
 */
public class TipoHabitacion {

    private int idTipo;
    private String nombre;
    private String descripcion;
    private int capacidadPersonas;
    private double precioNoche;
    private boolean incluyeDesayuno;
    private ArrayList<Habitacion> listaDeHabitaciones;

    public TipoHabitacion(int idTipo, String nombre, String descripcion, int capacidadPersonas, double precioNoche, boolean incluyeDesayuno ) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadPersonas = capacidadPersonas;
        this.precioNoche = precioNoche;
        this.incluyeDesayuno = incluyeDesayuno;
        this.listaDeHabitaciones = new ArrayList<>();
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public boolean getIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public ArrayList<Habitacion> getListaDeHabitaciones() {
        return listaDeHabitaciones;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        listaDeHabitaciones.add(habitacion);
    }

}
