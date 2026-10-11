/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.administrativo;

import java.util.ArrayList;

/**
 *
 * @author grupo1
 */
public class Docente extends Empleado {

    private String facultadPertenece;
    private ArrayList<String> listaMaterias;

    public Docente(String cedula, String nombre, String apellido, String telefono,
            String correo, float sueldo, String titulo, String nivelDeFormacion,
            ArrayList<String> listaDeCargos, String facultadPertenece,
            ArrayList<String> listaMaterias) {
        super(cedula, nombre, apellido, telefono, correo, listaDeCargos,
                sueldo, nivelDeFormacion, titulo);
        this.facultadPertenece = facultadPertenece;
        this.listaMaterias = listaMaterias;
    }

    public String getFacultadPertenece() {
        return facultadPertenece;
    }

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setFacultadPertenece(String nombreFacultad) {
        this.facultadPertenece = nombreFacultad;
    }

    public void setListaMaterias(ArrayList<String> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public boolean eliminarMateria(String materia) {
        for (int i = 0; i < this.listaMaterias.size(); i++) {
            if (this.listaMaterias.get(i).equals(materia)) {
                this.listaMaterias.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean aniadirMateria(String materia) {
        for (int i = 0; i < this.listaMaterias.size(); i++) {
            if (this.listaMaterias.get(i).equals(materia)) {
                return false;
            }
        }
        this.listaMaterias.add(materia);
        return true;
    }
}
