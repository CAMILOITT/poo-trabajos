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
public class Empleado extends Persona{
    protected float sueldo;
    protected String titulo;
    protected String nivelDeFormacion;
    protected ArrayList<String> listaDeCargos;

    public Empleado(float sueldo, String titulo, String nivelDeFormacion, ArrayList<String> listaDeCargos, String cedula, String nombre, String correo, String apellido, String telefono) {
        super(cedula, nombre, correo, apellido, telefono);
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

    public float getSueldo() {
        return sueldo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNivelDeFormacion() {
        return nivelDeFormacion;
    }

    public ArrayList<String> getListaDeCargos() {
        return listaDeCargos;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNivelDeFormacion(String nivelDeFormacion) {
        this.nivelDeFormacion = nivelDeFormacion;
    }

    public void setListaDeCargos(ArrayList<String> listaDeCargos) {
        this.listaDeCargos = listaDeCargos;
    }
    
    public boolean aniadirCargo (String Cargo)
    {
        for (int i = 0;  i < this.listaDeCargos.size(); i++)
        {
            if (this.listaDeCargos.get(i).equals(Cargo))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean eliminarCargo (String nombreCargo)
    {
        for (int i = 0;  i < this.listaDeCargos.size(); i++)
        {
            if (this.listaDeCargos.get(i).equals(nombreCargo))
            {
                listaDeCargos.remove(i);
                return true;
            }
        }
        return false;
    }
    
}
