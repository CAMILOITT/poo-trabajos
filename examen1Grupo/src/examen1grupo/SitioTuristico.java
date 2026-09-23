/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1grupo;

/**
 *
 * @author camil
 */
public class SitioTuristico {
  private String ciudad;
  private String nombre;
  private String descripcion;
  private float costos;

  public SitioTuristico(String ciudad, String nombre, String descripcion, float costo) {
    this.ciudad = ciudad;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.costos = costo;
  }

  public String getCiudad() {
    return this.ciudad;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public Float getCosto() {
    return this.costos;
  }

}
