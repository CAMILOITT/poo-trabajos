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
    private ArrayList<String> listaMaterias;

    public Docente(String facultadPertenece, ArrayList<String> listaMaterias, float sueldo, String titulo, String nivelDeFormacion, ArrayList<String> listaDeCargos, String cedula, String nombre, String correo, String apellido, String telefono) {
        super(sueldo, titulo, nivelDeFormacion, listaDeCargos, cedula, nombre, correo, apellido, telefono);
        this.facultadPertenece = facultadPertenece;
        this.listaMaterias = listaMaterias;
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

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setFacultadPertenece(String facultadPertenece) {
        this.facultadPertenece = facultadPertenece;
    }

    public void setListaMateriales(ArrayList<String> listaMateriales) {
        this.listaMaterias = listaMateriales;
    }
    
    public boolean eliminarMateria(String materia)
    {
        for (int i = 0;  i < this.listaMaterias.size(); i++)
        {
            if (this.listaMaterias.get(i).equals(materia))
            {
                listaMaterias.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean aniadirMateria (String materia)
    {
        for (int i = 0;  i < this.listaMaterias.size(); i++)
        {
            if (this.listaMaterias.get(i).equals(materia))
            {
                return false;
            }
        }
        return true;
    }
    
}
