package sistema.supermercado;

import java.util.ArrayList;

/**
 *
 * @author camiloitt
 */
public class Cajero extends Persona {

    private int numeroCaja;
    private String codigoEmpleado;

    public Cajero(String cedula, String nombre, String apellido, String telefono, int numeroCaja, String codigoEmpleado
            ) {
        super(cedula, nombre, apellido, telefono);
        this.numeroCaja = numeroCaja;
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }
    
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    

    public void mostrarDatos() {
        // hace algo 
    }
}
