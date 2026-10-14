/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;

public class Cliente extends Persona {
    
    private ArrayList<OrdenTrabajo> ordenesRealizadas;

    public Cliente(ArrayList<OrdenTrabajo> ordenesRealizadas, String nombre, String apellido, String cedula, String celular, String correo) {
        super(nombre, apellido, cedula, celular, correo);
        this.ordenesRealizadas = ordenesRealizadas;
    }

    public ArrayList<OrdenTrabajo> getOrdenesRealizadas() {
        return ordenesRealizadas;
    }

    
    public void solicitarOrden(OrdenTrabajo orden) {
        this.ordenesRealizadas.add(orden);
    }
    
}

   