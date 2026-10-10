/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.administrativo;

/**
 *
 * @author mnobo
 */
public class Estudiante extends Persona{
    
    private String nivel;
    private String codigo;

    public Estudiante(String nivel, String codigo, String cedula, String nombre, String correo, String apellido, String telefono) {
        super(cedula, nombre, correo, apellido, telefono);
        this.nivel = nivel;
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public String Correo() {
        return correo;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
}
