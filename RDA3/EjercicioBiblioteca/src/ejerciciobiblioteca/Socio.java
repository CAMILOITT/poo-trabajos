/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciobiblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grupo 1
 */
public class Socio extends Persona{
    
    private String Cedula;
    private String Telefono;
    private String Correo;
    private ArrayList<Prestamo> ListaDePrestamos;

    public Socio(String Cedula, String Telefono, String Correo, ArrayList<Prestamo> ListaDePrestamos, String Nombre, String Apellido, String CodigoId, Date FechaDeNacimiento) {
        super(Nombre, Apellido, CodigoId, FechaDeNacimiento);
        this.Cedula = Cedula;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.ListaDePrestamos = ListaDePrestamos;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public ArrayList<Prestamo> getListaDePrestamos() {
        return ListaDePrestamos;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setListaDePrestamos(ArrayList<Prestamo> ListaDePrestamos) {
        this.ListaDePrestamos = ListaDePrestamos;
    }
    
    public void aniadirPrestamo(Prestamo prestamo)
    {
        ListaDePrestamos.add(prestamo);
    }
    
}
