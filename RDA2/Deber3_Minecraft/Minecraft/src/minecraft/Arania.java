package minecraft;

import java.util.ArrayList;

/**
 *
 * @author DET PC
 */
public class Arania extends Monstruo {
    private String tipoVeneno;

    public Arania(String tipoVeneno, String codigo, String nombre, double saludMaxima, double danioBase, ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.tipoVeneno = tipoVeneno;
    }

    // Getters
    public String getTipoVeneno() {
        return tipoVeneno;
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

    // Setters
    public void setTipoVeneno(String tipoVeneno) {
        this.tipoVeneno = tipoVeneno;
    }

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
}