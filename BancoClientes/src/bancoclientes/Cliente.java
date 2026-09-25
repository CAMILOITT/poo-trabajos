package bancoclientes;

/**
 * Representa un cliente del banco con su cedula, nombre y tramite.
 *
 * @author grupo1
 */
public class Cliente {

    private String cedula;
    private String nombre;
    private String tramite;

    /**
     * Crea un cliente con todos sus datos.
     *
     * @param cedula cedula del cliente
     * @param nombre nombre del cliente
     * @param tramite tramite que va a realizar, por ejemplo deposito o retiro
     */
    public Cliente(String cedula, String nombre, String tramite) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tramite = tramite;
    }

    /** @return la cedula del cliente */
    public String getCedula() {
        return this.cedula;
    }

    /** @return el nombre del cliente */
    public String getNombre() {
        return this.nombre;
    }

    /** @return el tramite del cliente */
    public String getTramite() {
        return this.tramite;
    }
}