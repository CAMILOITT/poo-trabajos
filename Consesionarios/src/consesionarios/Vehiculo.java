/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consesionarios;

/**
 *
 * @author mnobo
 */
public class Vehiculo {
    private String Marca;
    private String Modelo;
    private float Precio;
    private String anios;
    private String Placa;

    public Vehiculo() {
        this.Marca = "Sin Marca";
        this.Modelo = "Sin Modelo";
        this.Precio = 0;
        this.anios = "Sin anio";
        this.Placa = "Sin placa";
    }

    public Vehiculo(String Marca, String Modelo, float Precio, String anios, String Placa) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Precio = Precio;
        this.anios = anios;
        this.Placa = Placa;
    }

    public String getMarca() {
        return this.Marca;
    }

    public String getModelo() {
        return this.Modelo;
    }

    public float getPrecio() {
        return this.Precio;
    }

    public String getAnios() {
        return this.anios;
    }

    public String getPlaca() {
        return this.Placa;
    }
    
    public String VerVehiculo()
    {
        String cad = "[" + this.Marca + this.Modelo + this.Placa + this.anios + this.Precio+ " ]";
        
        return cad;
    }

    
    
    

}
