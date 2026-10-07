/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.supermercado;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Batman
 */
public class Compra {
    private int numeroCompra;
    private LocalDateTime fechaCompra;
    private ArrayList<Producto> listaDeProductosComprados;
    
public Compra(int numeroCompra, LocalDateTime fechaCompra) {
    this.numeroCompra = numeroCompra;
    this.fechaCompra = fechaCompra;
    this.listaDeProductosComprados = new ArrayList<>();
}
public int getNumeroCompra() {
    return numeroCompra;
}
public LocalDateTime getFechaCompra() {
    return fechaCompra;
}
public ArrayList<Producto> getListaDeProductosComprados() {
    return listaDeProductosComprados;
}
public void agregarProducto(Producto datoProducto) {
    this.listaDeProductosComprados.add(datoProducto);
}
public float calcularTotal() {
    float total = 0;
    for(Producto productoComprado : listaDeProductosComprados) {
        total += productoComprado.getPrecio();
    }
    return total;
   
}
    
}



