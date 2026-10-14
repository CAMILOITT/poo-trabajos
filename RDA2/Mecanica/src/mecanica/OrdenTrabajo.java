/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
/**
 *
 * @author DET PC
 */
public class OrdenTrabajo {
    private String numeroOrden;
    private String fecha;//OJO ACA TIPO DE DATO FECHA
    private ArrayList<Repuesto> repuestoUsado;
    
    public OrdenTrabajo(String numeroOrden, String fecha) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
    }
    public OrdenTrabajo(String numeroOrden, String fecha, ArrayList<Repuesto> repuestoUsado) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.repuestoUsado = repuestoUsado;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Repuesto> getRepuestoUsado() {
        return repuestoUsado;
    }
    public void agregarRespuesto(Repuesto rep)
    {
        repuestoUsado.add(rep);
    }
    
}
