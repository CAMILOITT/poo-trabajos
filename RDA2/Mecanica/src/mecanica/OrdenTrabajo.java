/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author grupo 1
 */
public class OrdenTrabajo {
    private String numeroOrden;
    private Date fecha;
    private ArrayList<Repuesto> repuestoUsado;
    
    public OrdenTrabajo(String numeroOrden, Date fecha) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.repuestoUsado = new ArrayList<>();
    }
    public OrdenTrabajo(String numeroOrden, Date fecha, ArrayList<Repuesto> repuestoUsado) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.repuestoUsado = repuestoUsado;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<Repuesto> getRepuestoUsado() {
        return repuestoUsado;
    }
    
    public void agregarRepuesto(Repuesto rep)
    {
        repuestoUsado.add(rep);
    }
    

    public double calcularSubtotal() {
        double suma = 0;
        for (int i = 0; i < this.repuestoUsado.size(); i++) {
            suma += this.repuestoUsado.get(i).getPrecio();
        }
        return suma;
    }
    
}
    

