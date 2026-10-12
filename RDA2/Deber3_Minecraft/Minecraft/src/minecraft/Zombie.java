/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minecraft;
import java.util.ArrayList;

/**
 *
 * @author DET PC
 */
public class Zombie extends Monstruo {
    private ArrayList<String> variante;

    public Zombie(ArrayList<String> variante, String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.variante = variante;
    }

    public ArrayList<String> getVariante() {
        return variante;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaludMaxima() {
        return saludMaxima;
    }

    public double getDanioBase() {
        return danioBase;
    }

    public ArrayList<String> getListaDrops() {
        return listaDrops;
    }

    public void setVariante(ArrayList<String> variante) {
        this.variante = variante;
    }

    // --- AGREGA ESTOS SETTERS QUE FALTABAN ---
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaludMaxima(double saludMaxima) {
        this.saludMaxima = saludMaxima;
    }

    public void setDanioBase(double danioBase) {
        this.danioBase = danioBase;
    }

    public void setListaDrops(ArrayList<String> listaDrops) {
        this.listaDrops = listaDrops;
    }
    // ------------------------------------------

    public boolean aniadirTipoZombie(String tipo) {
        if (tipo != null && !tipo.trim().isEmpty()) {
            return this.variante.add(tipo);
        }
        return false;
    }

    public boolean eliminarTipoZombie(String tipo) {
        return this.variante.remove(tipo);
    }

    public boolean verificarTipoZombie(String tipo) {
        return this.variante.contains(tipo);
    }
}