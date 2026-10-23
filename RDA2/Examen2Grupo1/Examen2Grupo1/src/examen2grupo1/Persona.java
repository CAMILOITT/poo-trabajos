package  examen2grupo1;

/**
 * Clase base para cualquier persona del sistema (cliente, mecánico, cajero, docente...).
 * Si el UML tiene subclases, estas heredan de aquí con extends Persona.
 */
public class Persona {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Persona(String cedula, String nombres, String apellidos, String telefono, String correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
}
