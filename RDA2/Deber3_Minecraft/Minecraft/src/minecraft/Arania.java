package minecraft;

import java.util.ArrayList;

/**
 *
 * @author DET PC
 */
public class Arania extends Monstruo {
    private String tipoVeneno;

    public Arania(String tipoVeneno, String codigo, String nombre, double saludMaxima, double danioBase,
            ArrayList<String> listaDrops) {
        super(codigo, nombre, saludMaxima, danioBase, listaDrops);
        this.tipoVeneno = tipoVeneno;
    }

    public String getTipoVeneno() {
        return tipoVeneno;
    }
}