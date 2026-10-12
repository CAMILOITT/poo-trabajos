/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minecraft;

import java.util.ArrayList;
public class Arania extends Monstruo{
    private String TipoVeneno;

    public Arania(String TipoVeneno, String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.TipoVeneno = TipoVeneno;
    }

    public String getTipoVeneno() {
        return TipoVeneno;
    }

    public void setTipoVeneno(String TipoVeneno) {
        this.TipoVeneno = TipoVeneno;
    }
    
}
