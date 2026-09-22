/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author camil
 */
public class Medico {

    private String nombre;
    private String cedula;
    private String codigo;
    private String especialidad;

    public Medico(String nombre, String cedula, String codigo, String especialidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.codigo = codigo;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

}
