/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
/**
 *
 * @author DET PC
 */
public class Mecanico extends Persona {
    private String especialidad;
    private ArrayList<OrdenTrabajo> listaOrdenes;

    public Mecanico(String especialidad, ArrayList<OrdenTrabajo> listaOrdenes, String nombre, String apellido, String cedula, String celular, String correo) {
        super(nombre, apellido, cedula, celular, correo);
        this.especialidad = especialidad;
        this.listaOrdenes = listaOrdenes;
    }

    public Mecanico(String especialidad, String nombre, String apellido, String cedula, String celular, String correo) {
        super(nombre, apellido, cedula, celular, correo);
        this.especialidad = especialidad;
    }

    

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<OrdenTrabajo> getOrdenRegistrada() {
        return listaOrdenes;
    }
    public void registrarOrdenes(OrdenTrabajo orden)
    {
        listaOrdenes.add(orden);//OJo
    }
    
}
