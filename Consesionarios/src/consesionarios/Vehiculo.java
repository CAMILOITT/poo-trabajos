/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consesionarios;

/**
 * Representa un vehículo dentro del inventario de una concesionaria,
 * con sus datos intrínsecos: marca, modelo, precio, año y placa.
 *
 * @author grupo 1
 */
public class Vehiculo {

    private String Marca;
    private String Modelo;
    private float Precio;
    private String anios;
    private String Placa;

    /**
     * Crea un vehículo con valores por defecto, útil para casos donde
     * todavía no se conocen todos los datos reales del vehículo.
     */
    public Vehiculo() {
        this.Marca = "Sin Marca";
        this.Modelo = "Sin Modelo";
        this.Precio = 0;
        this.anios = "Sin anio";
        this.Placa = "Sin placa";
    }

    /**
     * Crea un vehículo con todos sus datos conocidos.
     *
     * @param Marca marca del vehículo
     * @param Modelo modelo del vehículo
     * @param Precio precio del vehículo
     * @param anios año del vehículo (como texto)
     * @param Placa placa del vehículo
     */
    public Vehiculo(String Marca, String Modelo, float Precio, String anios, String Placa) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Precio = Precio;
        this.anios = anios;
        this.Placa = Placa;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return la marca del vehículo
     */
    public String getMarca() {
        return this.Marca;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return el modelo del vehículo
     */
    public String getModelo() {
        return this.Modelo;
    }

    /**
     * Obtiene el precio del vehículo.
     *
     * @return el precio del vehículo
     */
    public float getPrecio() {
        return this.Precio;
    }

    /**
     * Obtiene el año del vehículo.
     *
     * @return el año del vehículo, como texto
     */
    public String getAnios() {
        return this.anios;
    }

    /**
     * Obtiene la placa del vehículo.
     *
     * @return la placa del vehículo
     */
    public String getPlaca() {
        return this.Placa;
    }

    /**
     * Arma una representación en texto con todos los datos del
     * vehículo, separados por comas para que sea legible.
     *
     * @return una cadena con marca, modelo, placa, año y precio
     */
    public String VerVehiculo()
    {

        String cad = "[" + "Marca: "+ this.Marca +" | "+ "Modelo: "+this.Modelo +" | "+ "Placa: "+this.Placa +" | "+ "Anios: "+this.anios +" | "+ "Precio: "+this.Precio+" dolares"+ " ]";

        return cad;
    }
}
