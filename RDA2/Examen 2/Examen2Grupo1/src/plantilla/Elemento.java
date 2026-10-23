package plantilla;

/**
 * Clase genérica para lo que el sistema registra (producto, repuesto, libro, medicamento...).
 * Cambia el nombre de la clase y de los atributos según el UML del examen.
 */
public class Elemento {

    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;

    public Elemento(String codigo, String nombre, String categoria, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
