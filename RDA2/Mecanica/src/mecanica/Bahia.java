/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
/**
 *
 * @author grupo 1
 */
public class Bahia {
    private String codigoBahia;
    private String tipo;
    private ArrayList<Herramienta> listaHerramientas;

    public Bahia(String codigoBahia, String tipo, ArrayList<Herramienta> listaHerramientas) {
        this.codigoBahia = codigoBahia;
        this.tipo = tipo;
        this.listaHerramientas = listaHerramientas;
    }

    public String getCodigoBahia() {
        return codigoBahia;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<Herramienta> getListaHerramientas() {
        return listaHerramientas;
    }
    
    
    
}
