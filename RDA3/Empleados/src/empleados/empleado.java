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
    private String cargo;
    private float saldo;

    public empleado(String cedula, String nombres, String apellidos, int telefono, String correo, int edad, String cargo, float saldo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.cargo = cargo;
        this.saldo = saldo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
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

    public int getEdad() {
        return edad;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSaldo() {
        return saldo;
    }
   
}
