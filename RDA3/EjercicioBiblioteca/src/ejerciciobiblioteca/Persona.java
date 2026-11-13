/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciobiblioteca;
import java.util.Date;
/**
 *
 * @author grupo 1
 */
public class Persona {
    
    protected String Nombre;
    protected String Apellido;
    protected String CodigoId;
    protected Date FechaDeNacimiento;

    public Persona(String Nombre, String Apellido, String CodigoId, Date FechaDeNacimiento) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CodigoId = CodigoId;
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCodigoId() {
        return CodigoId;
    }

    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCodigoId(String CodigoId) {
        this.CodigoId = CodigoId;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }
    
    
    
}
