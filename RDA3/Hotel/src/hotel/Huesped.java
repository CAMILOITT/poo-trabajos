/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.util.ArrayList;

/**
 *
 * @author grupo1
 */
public class Huesped {

    private int idHuesped;
    private String documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String nacionalidad;
    private ArrayList<Reserva> listaDeReservas;

    public Huesped(int idHuesped, String documento, String nombre, String apellido, String telefono, String nacionalidad) {
        this.idHuesped = idHuesped;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.listaDeReservas = new ArrayList<>();
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void agregarReserva(Reserva reserva) {
        listaDeReservas.add(reserva);
    }

}
