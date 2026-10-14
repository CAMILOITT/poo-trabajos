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
    private ArrayList<OrdenTrabajo> ordenRegistrada;

    public Mecanico(String especialidad, ArrayList<OrdenTrabajo> ordenRegistrada, String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
        this.especialidad = especialidad;
        this.ordenRegistrada = ordenRegistrada;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<OrdenTrabajo> getOrdenRegistrada() {
        return ordenRegistrada;
    }
    public void registrarOrdenes(OrdenTrabajo orden)
    {
        ordenRegistrada.add(orden);//OJo
    }
    
}
