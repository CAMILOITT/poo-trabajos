/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplosplit;

/**
 *
 * @author grupo 1
 */

    /** Clase de datos: cada línea del archivo se convierte en un objeto de esta clase. */
class Cliente {
 
    private String cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private int puntos;
 
    // Constructor: recibe los datos ya convertidos a su tipo
    public Cliente(String cedula, String nombre, String apellido, String celular, int puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.puntos = puntos;
    }
 
    public String getCedula() {
        return cedula;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public int getPuntos() {
        return puntos;
    }
 
    /** Convierte el objeto de vuelta a una línea de texto plano. */
    public String convierteALinea() {
        return String.join(",", cedula, nombre, apellido, celular, String.valueOf(puntos));
    }
 
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + cedula + ") - " + puntos + " puntos";
    }
    }

