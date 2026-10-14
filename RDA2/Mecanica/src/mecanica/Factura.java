/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author grupo 1
 */
public class Factura {
    private int numeroFactura;
    private Date fecha;//OJO TIPO DATO FECHA;
    private double total;
    private ArrayList<OrdenTrabajo> listaOrdenes;

    public Factura(int numeroFactura, Date fecha, double total) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.total = total;
        this.listaOrdenes = new ArrayList<>();
    }

    public Factura(int numeroFactura, Date fecha, ArrayList<OrdenTrabajo> ordenes) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.listaOrdenes = ordenes;
        this.total = calcularTotal();
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFehca() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }
    
    public ArrayList<OrdenTrabajo> getListaDeOrdenes() {
        return listaOrdenes;
    }

    public void agregarOrden(OrdenTrabajo orden) {
        listaOrdenes.add(orden);
        total = calcularTotal();
    }

    public double calcularTotal() {
        double suma = 0;
        for (int i = 0; i < listaOrdenes.size(); i++) {
            suma += listaOrdenes.get(i).calcularSubtotal();
        }
        return suma;
    }

    public String imprimirFactura() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder texto = new StringBuilder();

        texto.append(String.format("FACTURA N° F-%03d\n", numeroFactura));
        texto.append("Fecha: ").append(formato.format(fecha)).append("\n");
        texto.append("--------------------------------------------\n");

        for (int i = 0; i < listaOrdenes.size(); i++) {
            OrdenTrabajo orden = listaOrdenes.get(i);
            texto.append("Orden ").append(orden.getNumeroOrden())
                 .append(" (").append(formato.format(orden.getFecha())).append(")\n");

            for (int j = 0; j < orden.getRepuestoUsado().size(); j++) {
                Repuesto r = orden.getRepuestoUsado().get(j);
                texto.append(String.format("  %-8s %-24s %8.2f\n",
                    r.getCodigo(), r.getNombre(), r.getPrecio()));
            }
            texto.append(String.format("  %-33s %8.2f\n", "Subtotal:", orden.calcularSubtotal()));
        }

        texto.append("--------------------------------------------\n");
        texto.append(String.format("TOTAL: $ %.2f", total));
        return texto.toString();
    }  
}
