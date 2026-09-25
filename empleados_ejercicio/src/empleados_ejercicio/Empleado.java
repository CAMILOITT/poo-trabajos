package empleados_ejercicio;

/**
 * Representa un empleado, con sus datos intrínsecos: nombre, cargo
 * y código de identificación.
 *
 * Nota: esta clase no declara ningún constructor propio, así que
 * Java le da automáticamente un constructor vacío por defecto
 * (equivalente a "public Empleado() {}"). Por eso, para crear un
 * empleado con datos, primero se instancia vacío y luego se llenan
 * sus atributos uno por uno con los setters.
 *
 * @author mnobo
 */
public class Empleado {

    private String Nombre;
    private String Cargo;
    private String Codigo;

    /**
     * Asigna el nombre del empleado.
     *
     * @param Nombre nombre a asignar
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Asigna el cargo del empleado.
     *
     * @param Cargo cargo a asignar
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    /**
     * Asigna el código de identificación del empleado.
     *
     * @param Codigo código a asignar
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return el nombre del empleado
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Obtiene el cargo del empleado.
     *
     * @return el cargo del empleado
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * Obtiene el código de identificación del empleado.
     *
     * @return el código del empleado
     */
    public String getCodigo() {
        return Codigo;
    }

}