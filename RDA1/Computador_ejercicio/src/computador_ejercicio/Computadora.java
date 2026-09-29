package computador_ejercicio;

/**
 * Representa una computadora, con sus datos intrínsecos: marca,
 * código de identificación, procesador y tarjeta gráfica.
 *
 * Nota: esta clase no declara ningún constructor propio, así que
 * Java le da automáticamente un constructor vacío por defecto. Por
 * eso, para crear una computadora con datos, primero se instancia
 * vacía y luego se llenan sus atributos con los setters.
 *
 * @author grupo 1
 */
public class Computadora {

    private String marca;
    private String codigo;
    private String procesador;
    private String tarjetaGrafica;

    /**
     * Asigna la marca de la computadora.
     *
     * @param marca marca a asignar
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Asigna el código de identificación de la computadora.
     *
     * @param codigo código a asignar
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Asigna el procesador de la computadora.
     *
     * @param procesador procesador a asignar
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Asigna la tarjeta gráfica de la computadora.
     *
     * @param tarjetaGrafica tarjeta gráfica a asignar
     */
    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Obtiene la marca de la computadora.
     *
     * @return la marca de la computadora
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el código de identificación de la computadora.
     *
     * @return el código de la computadora
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el procesador de la computadora.
     *
     * @return el procesador de la computadora
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Obtiene la tarjeta gráfica de la computadora.
     *
     * @return la tarjeta gráfica de la computadora
     */
    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

}