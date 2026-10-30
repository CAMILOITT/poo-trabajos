/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author grupo1
 */
public class empleado {

    private String cedula;
    private String nombres;
    private String apellidos;
    private int telefono;
    private String correo;
    private int edad;

    public empleado(String cedula, String nombres, int edad, String apellidos, int telefono, String correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}
