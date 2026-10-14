/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
/**
 *
 * @author grupo1
 */
public class Taller {
    private String nombre;
    private String direccion;
    private ArrayList<Mecanico> listaMecanico;
    private ArrayList<Bahia> listaBahia;

    public Taller(String nombre, String direccion, ArrayList<Mecanico> listaMecanico, ArrayList<Bahia> listaBahia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaMecanico = listaMecanico;
        this.listaBahia = listaBahia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Mecanico> getListaMecanico() {
        return listaMecanico;
    }

    public ArrayList<Bahia> getListaBahia() {
        return listaBahia;
    }
    public void contratarMecanico(Mecanico mecanico)
    {
        listaMecanico.add(mecanico);
    }
    
}
