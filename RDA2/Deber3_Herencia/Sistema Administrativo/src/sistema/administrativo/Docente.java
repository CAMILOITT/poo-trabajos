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
public class Docente extends Empleado{
    
    private String facultadPertenece;
    private ArrayList<String> listaMateriales;

    public Docente(String facultadPertenece, ArrayList<String> listaMateriales, float sueldo, String titulo, String nivelDeFormacion, ArrayList<String> listaDeCargos, String cedula, String nombre, String correo, String apellido, String telefono) {
        super(sueldo, titulo, nivelDeFormacion, listaDeCargos, cedula, nombre, correo, apellido, telefono);
        this.facultadPertenece = facultadPertenece;
        this.listaMateriales = listaMateriales;
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

    public String getFacultadPertenece() {
        return facultadPertenece;
    }

    public ArrayList<String> getListaMateriales() {
        return listaMateriales;
    }

    public void setFacultadPertenece(String facultadPertenece) {
        this.facultadPertenece = facultadPertenece;
    }

    public void setListaMateriales(ArrayList<String> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }
    
    public boolean eliminarMateria(String materia)
    {
        for (int i = 0;  i < this.listaMateriales.size(); i++)
        {
            if (this.listaMateriales.get(i).equals(materia))
            {
                listaMateriales.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean aniadirMateria (String materia)
    {
        for (int i = 0;  i < this.listaMateriales.size(); i++)
        {
            if (this.listaMateriales.get(i).equals(materia))
            {
                return false;
            }
        }
        return true;
    }
    
}
