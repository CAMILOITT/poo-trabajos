/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.supermercado;

import java.util.ArrayList;

/**
 *
 * @author grupo 1
 */
public class SistemaSupermercado {

    /**
     * @param args the command line arguments
     */
    
    public static Producto buscarProducto(String codigo, ArrayList listaDeProductos)
    {
        for (int i = 0; i< listaDeProductos.size(); i++)
        {
            if (codigo.equals(listaDeProductos.get(i).getCodigo()))
            {
                return listaDeProductos.get(i);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Producto> listaDeProductos = new ArrayList();
    }
    
}
