/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.administrativo;

import java.util.ArrayList;

/**
 *
 * @author mnobo
 */
public class Administrativo extends Empleado{
    
    private String area;

    public Administrativo(String area, float sueldo, String titulo, String nivelDeFormacion, ArrayList<String> listaDeCargos, String cedula, String nombre, String correo, String apellido, String telefono) {
        super(sueldo, titulo, nivelDeFormacion, listaDeCargos, cedula, nombre, correo, apellido, telefono);
        this.area = area;
        this.sueldo = sueldo;
        this.titulo = titulo;
        this.nivelDeFormacion = nivelDeFormacion;
        this.listaDeCargos = listaDeCargos;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
       
}
