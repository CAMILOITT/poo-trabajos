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
public class Zombie extends Monstruo{
    private ArrayList<String> variante;

    public Zombie(ArrayList<String> variante, String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.variante = variante;
    }

    public ArrayList<String> getVariante() {
        return variante;
    }

    public void setVariante(ArrayList<String> variante) {
        this.variante = variante;
    }
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
