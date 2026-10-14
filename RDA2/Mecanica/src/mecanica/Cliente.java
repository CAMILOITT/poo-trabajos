/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;

public class Cliente extends Persona {
    
    private ArrayList<OrdenTrabajo> ordenesRealizadas;

    public Cliente(String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
        this.ordenesRealizadas = new ArrayList<>();
    }
    public void solicitarOrden(OrdenTrabajo orden) {
        this.ordenesRealizadas.add(orden);
    }
    
}

   