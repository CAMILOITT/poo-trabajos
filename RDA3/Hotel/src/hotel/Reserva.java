/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.util.Date;

/**
 *
 * @author grupo1
 */
public class Reserva {

    private int idReserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double total;

    public Reserva(int idReserva, Date fechaEntrada, Date fechaSalida, double total) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.total = total;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public double getTotal() {
        return total;
    }
}
