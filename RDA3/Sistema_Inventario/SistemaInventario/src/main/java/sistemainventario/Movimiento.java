package sistemainventario;

import java.time.LocalDate;

public class Movimiento {

    private int idMovimiento;
    private String tipo;
    private int cantidad;
    private double precioUnitario;
    private LocalDate fecha;
    private String documento;
    private String observacion;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public String getObservacion() {
        return observacion;
    }
}
