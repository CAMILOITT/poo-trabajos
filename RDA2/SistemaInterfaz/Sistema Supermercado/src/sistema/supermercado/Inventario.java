/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.supermercado;
import java.util.ArrayList;
/**
 *
 * @author grupo 1
 */
public class Inventario {
    
    private int numeroPasillo;
    private ArrayList<Producto> listaDeProductos;

    public Inventario(int numeroPasillo) {
        this.numeroPasillo = numeroPasillo;
        this.listaDeProductos = new ArrayList<>();
    }

    public int getNumeroPasillo() {
        return numeroPasillo;
    }

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }
    
    public void insertarProducto(Producto datoProducto)
    {
        listaDeProductos.add(datoProducto);
    }
    
    public boolean retirarProducto(String codigo)
    {
        for (int i = 0; i< listaDeProductos.size(); i++)
        {
            if (codigo.equals(listaDeProductos.get(i).getCodigo()))
            {
                listaDeProductos.remove(i);
                return true;
            }
        }
     return false;   
    }
    
}
