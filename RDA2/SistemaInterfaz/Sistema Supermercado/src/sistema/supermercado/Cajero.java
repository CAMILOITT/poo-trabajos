package sistema.supermercado;

import java.util.ArrayList;

/**
 *
 * @author camiloitt
 */
public class Cajero extends Persona {

    private int numeroCaja;
    private String codigoEmpleado;
    private ArrayList<Compra> listaDeVenta;

    public Cajero(String cedula, String nombre, String apellido, String telefono, int numeroCaja, String codigoEmpleado
            ) {
        super(cedula, nombre, apellido, telefono);
        this.numeroCaja = numeroCaja;
        this.codigoEmpleado = codigoEmpleado;
        this.listaDeVenta = new ArrayList<>();
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }
    
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    
    
    public ArrayList<Compra> getListaDeVenta() {
        return listaDeVenta;
    }
    
    public void registrarVenta(Compra datoVenta) {
        this.listaDeVenta.add(datoVenta);
    }

    public void mostrarDatos() {
        // hace algo 
    }
}
