package sistemainventario;

public class Articulo {

    private int idArticulo;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String unidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int stockMinimo;
    private String estado;

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public String getEstado() {
        return estado;
    }
}
