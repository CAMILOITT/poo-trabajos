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
public class Empleado extends Persona {

    protected float sueldo;
    protected String titulo;
    protected String nivelDeFormacion;
    protected ArrayList<String> listaDeCargos;

    public Empleado(String cedula, String nombre, String apellido, String telefono,
            String correo, ArrayList<String> listaDeCargos, float sueldo,
            String nivelDeFormacion, String titulo) {
        super(cedula, nombre, apellido, correo, telefono);
        this.listaDeCargos = listaDeCargos;
        this.sueldo = sueldo;
        this.nivelDeFormacion = nivelDeFormacion;
        this.titulo = titulo;
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

    public void setSueldo(float nuevoSueldo) {
        this.sueldo = nuevoSueldo;
    }

    public void setTitulo(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
    }

    public void setNivelDeFormacion(String nivelFormacion) {
        this.nivelDeFormacion = nivelFormacion;
    }

    public void setListaDeCargos(ArrayList<String> nuevaListaDeCargos) {
        this.listaDeCargos = nuevaListaDeCargos;
    }

    public boolean verificarCargo(String cargo) {
        for (int i = 0; i < this.listaDeCargos.size(); i++) {
            if (this.listaDeCargos.get(i).equals(cargo)) {
                return true;
            }
        }
        return false;
    }

    public boolean aniadirCargo(String cargo) {
        if (verificarCargo(cargo)) {
            return false;
        }
        this.listaDeCargos.add(cargo);
        return true;
    }

    public boolean eliminarCargo(String nombreCargo) {
        for (int i = 0; i < this.listaDeCargos.size(); i++) {
            if (this.listaDeCargos.get(i).equals(nombreCargo)) {
                this.listaDeCargos.remove(i);
                return true;
            }
        }
        return false;
    }
}
