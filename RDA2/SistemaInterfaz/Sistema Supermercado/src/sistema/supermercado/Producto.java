/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.supermercado;

/**
 *
 * @author grupo 1
 */
public class Producto {
    private int stock;
    private float precio;
    private String codigo;
    private String nombreProducto;
    private String categoria;
    
    public Producto(int stock, float precio, String codigo, String nombreProducto, String categoria) {
        this.stock = stock;
        this.precio = precio;
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
    }
public int getStock() {
    return stock;
}
public float getPrecio() {
    return precio;
}
public String getCodigo() {
    return codigo;
}
public String getNombreProducto() {
    return nombreProducto;
}
public boolean verificarStockDisponible(int cantidad) {
    return stock >= cantidad;
}
public void descontarStock(int cantidad) {
    if(cantidad > 0 && verificarStockDisponible(cantidad)) {
        stock -= cantidad;
    }
}
    
}
