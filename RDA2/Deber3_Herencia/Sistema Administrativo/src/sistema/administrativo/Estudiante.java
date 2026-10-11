/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.administrativo;

/**
 *
 * @author grupo1
 */
public class Estudiante extends Persona {

    private String nivel;
    private String codigo;

    public Estudiante(String cedula, String nombre, String apellido, String telefono,
            String correo, String nivel, String codigo) {
        super(cedula, nombre, apellido, correo, telefono);
        this.nivel = nivel;
        this.codigo = codigo;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCodigo() {
        return codigo;
    }
}
