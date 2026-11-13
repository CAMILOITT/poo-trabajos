/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic;

public class Estudiante {
 
    private String idBanner;
    private String cedula;
    private String nombre;
    private String apellido;
    private String carrera;
    private String NRC;
    private int Calificacion;
 
    public Estudiante() {
    }
 
    public Estudiante(String idBanner, String cedula, String nombre, String apellido,
                      String carrera, String NRC, int calificacion) {
        this.idBanner = idBanner;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.NRC = NRC;
        this.Calificacion = calificacion;
    }
 
    public String getIdBanner() {
        return idBanner;
    }
 
    public void setIdBanner(String idBanner) {
        this.idBanner = idBanner;
    }
 
    public String getCedula() {
        return cedula;
    }
 
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellido() {
        return apellido;
    }
 
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
 
    public String getCarrera() {
        return carrera;
    }
 
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
 
    public String getNRC() {
        return NRC;
    }
 
    public void setNRC(String NRC) {
        this.NRC = NRC;
    }
 
    public int getCalificacion() {
        return Calificacion;
    }
 
    public void setCalificacion(int calificacion) {
        this.Calificacion = calificacion;
    }
}