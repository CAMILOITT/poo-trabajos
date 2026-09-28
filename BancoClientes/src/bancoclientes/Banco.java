package bancoclientes;

import java.util.ArrayDeque;

/**
 * Representa un banco que atiende a sus clientes en una cola por orden de llegada.
 *
 * @author grupo1
 */
public class Banco {

    private String nombre;
    private String sucursal;
    private ArrayDeque<Cliente> clientes;

    /**
     * Crea un banco con la fila vacia.
     *
     * @param nombre nombre del banco
     * @param sucursal sucursal del banco
     */
    public Banco(String nombre, String sucursal) {
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.clientes = new ArrayDeque<Cliente>();
    }

    /**
     * Crea un banco con la fila vacia y una capacidad inicial.
     *
     * @param nombre nombre del banco
     * @param sucursal sucursal del banco
     * @param capacidadInicial cantidad de clientes que se espera atender
     */
    public Banco(String nombre, String sucursal, int capacidadInicial) {
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.clientes = new ArrayDeque<Cliente>(capacidadInicial);
    }

    /**
     * Forma a un cliente al final de la fila.
     *
     * @param c cliente que llega al banco
     */
    public void llegarCliente(Cliente c) {
        this.clientes.offer(c);
    }

    /**
     * Atiende y saca de la fila al primer cliente.
     *
     * @return el cliente atendido, o null si la fila esta vacia
     */
    public Cliente atenderCliente() {
        return this.clientes.poll();
    }

    /**
     * Muestra quien es el siguiente en ser atendido sin sacarlo de la fila.
     *
     * @return el primer cliente de la fila, o null si esta vacia
     */
    public Cliente verSiguiente() {
        return this.clientes.peek();
    }

    /**
     * Muestra todos los clientes de la fila en orden de llegada.
     */
    public void mostrarFila() {
        System.out.println("Banco: " + this.nombre + " - Sucursal: " + this.sucursal);
        for (Cliente c : this.clientes) {
            System.out.println(c.getCedula() + " - " + c.getNombre() + " - " + c.getTramite());
        }
        System.out.println("Total en fila: " + this.clientes.size());
    }
}