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
public class Factura {
    private int numeroFactura;
    private String fecha;//OJO TIPO DATO FECHA;
    private double total;
    private ArrayList<OrdenTrabajo> listaOrdenes;

    public Factura(int numeroFactura, String fehca, double total, ArrayList<OrdenTrabajo> listaOrdenes) {
        this.numeroFactura = numeroFactura;
        this.fecha = fehca;
        this.total = total;
        this.listaOrdenes = listaOrdenes;
    }

    public Factura(int numeroFactura, String fehca, double total) {
        this.numeroFactura = numeroFactura;
        this.fecha = fehca;
        this.total = total;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getFehca() {
        return fecha;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void imprimirFactura()//OJO
    {
    }
    private double calcularTotal()
    {
        return total;//ojo AGREGADO
    }
  
    
}
