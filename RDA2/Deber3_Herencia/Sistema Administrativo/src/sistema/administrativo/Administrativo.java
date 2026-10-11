/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.administrativo;

import java.util.ArrayList;

/**
 *
 * @author grupo1
 */
public class Administrativo extends Empleado {

    private String area;

    public Administrativo(String cedula, String nombre, String apellido, String telefono,
            String correo, float sueldo, String nivelDeFormacion, String titulo,
            ArrayList<String> listaDeCargos, String area) {
        super(cedula, nombre, apellido, telefono, correo, listaDeCargos,
                sueldo, nivelDeFormacion, titulo);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String nuevaArea) {
        this.area = nuevaArea;
    }
}
