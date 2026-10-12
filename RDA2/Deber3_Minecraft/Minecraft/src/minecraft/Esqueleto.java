/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minecraft;
import java.util.ArrayList;
public class Esqueleto extends Monstruo {
    private String tipoArco; // Atributo único de Esqueleto

    public Esqueleto(String tipoArco, String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.tipoArco = tipoArco;
    }
    
    // Getters y Setters
    public String getTipoArco() { return tipoArco; }
    public void setTipoArco(String tipoArco) { this.tipoArco = tipoArco; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSaludMaxima(double saludMaxima) { this.saludMaxima = saludMaxima; }
    public void setDanioBase(double danioBase) { this.danioBase = danioBase; }
    public void setListaDrops(ArrayList<String> listaDrops) { this.listaDrops = listaDrops; }
}