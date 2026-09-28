/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegacajas;

import java.util.Stack;

/**
 *
 * @author grupo1
 */
public class Bodega {

    private String nombre;
    private String ubicacion;
    private Stack<Caja> cajas;

    /**
     * Crea una bodega vacia sin ubicacion conocida.
     *
     * @param nombre nombre de la bodega
     */
    public Bodega(String nombre) {
        this.nombre = nombre;
        this.ubicacion = "Sin ubicacion";
        this.cajas = new Stack<Caja>();
    }

    /**
     * Crea una bodega vacia con su ubicacion.
     *
     * @param nombre nombre de la bodega
     * @param ubicacion lugar donde esta la bodega
     */
    public Bodega(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cajas = new Stack<Caja>();
    }

    /**
     * Coloca una caja encima de la pila.
     *
     * @param c caja que se va a apilar
     */
    public void apilarCaja(Caja c) {
        this.cajas.push(c);
    }

    /**
     * Retira la caja que esta encima de la pila.
     *
     * @return la caja retirada, o null si la bodega esta vacia
     */
    public Caja retirarCaja() {
        if (this.cajas.empty()) {
            return null;
        }
        return this.cajas.pop();
    }

    /**
     * Muestra la caja de encima sin retirarla.
     *
     * @return la caja de encima, o null si la bodega esta vacia
     */
    public Caja verCajaSuperior() {
        if (this.cajas.empty()) {
            return null;
        }
        return this.cajas.peek();
    }

    /**
     * Muestra todas las cajas desde la de encima hasta la de abajo.
     */
    public void mostrarCajas() {
        System.out.println("Bodega: " + this.nombre + " - Ubicacion: " + this.ubicacion);
        for (int i = this.cajas.size() - 1; i >= 0; i--) {
            Caja c = this.cajas.get(i);
            System.out.println(c.getCodigo() + " - " + c.getContenido() + " - " + c.getPeso() + " kg");
        }
        System.out.println("Total: " + this.cajas.size());
    }

}
