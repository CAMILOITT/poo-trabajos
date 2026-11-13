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
public class Habitacion {

    private int idHabitacion;
    private String numero;
    private int piso;
    private String estado;
    private boolean permiteMascotas;
    private ArrayList<Reserva> listaDeReservas;

    public Habitacion(int idHabitacion, String numero, int piso, boolean permiteMascotas, String estado) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.permiteMascotas = permiteMascotas;
        this.estado = estado;
        this.listaDeReservas = new ArrayList<>();
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public boolean getPermiteMascotas() {
        return permiteMascotas;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void agregarReserva(Reserva reserva) {
        listaDeReservas.add(reserva);
    }

}
