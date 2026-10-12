/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package minecraft;
import java.util.ArrayList;

public class Monstruo {
    protected String codigo;
    protected String nombre;
    protected double saludMaxima;
    protected double danioBase;
    protected ArrayList<String> listaDrops;

    public Monstruo(String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        this.danioBase = danioBase;
        this.listaDrops = listaDrops;
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
    
    public boolean aniadirDrop(String itemDrop)
    {
        if(itemDrop !=null && itemDrop.trim().isEmpty())
        {
            return this.listaDrops.add(itemDrop);
        }
        return false;
    }
    public boolean eliminarDrop(String nombreDrop) {
        return this.listaDrops.remove(nombreDrop);
    }
    public boolean verificarDrop(String itemDrop)
    {
        return this.listaDrops.contains(itemDrop);
    }
}

