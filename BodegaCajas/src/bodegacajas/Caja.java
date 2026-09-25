/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegacajas;

/**
 * Representa una caja con su codigo, contenido y peso.
 *
 * @author grupo1
 */
public class Caja {

    private String codigo;
    private String contenido;
    private float peso;

    /**
     * Crea una caja con todos sus datos.
     *
     * @param codigo codigo de la caja
     * @param contenido lo que contiene la caja
     * @param peso peso de la caja en kilos
     */
    public Caja(String codigo, String contenido, float peso) {
        this.codigo = codigo;
        this.contenido = contenido;
        this.peso = peso;
    }

    /**
     * @return el codigo de la caja
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * @return el contenido de la caja
     */
    public String getContenido() {
        return this.contenido;
    }

    /**
     * @return el peso de la caja
     */
    public double getPeso() {
        return this.peso;
    }

}
