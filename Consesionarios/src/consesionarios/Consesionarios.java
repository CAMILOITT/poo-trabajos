/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consesionarios;
import java.util.ArrayList;
/**
 *
 * @author mnobo
 */
public class Consesionarios {

    /**
     * @param args the command line arguments
     */
    
    public static float TotalStockEnDinero(Vehiculo arr[][], String marca)
    {
        float stock_dinero = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[j][i].getMarca().equals(marca))
                {
                    stock_dinero += arr[i][j].getPrecio();
                }
            }
        }
        
        return stock_dinero;
    }
    
    public static Vehiculo[] RangoAnios(Vehiculo arr[], int anio1, int anio2)
    {
        int cont=0;
        int cont2=0;
        
        for (int i = 0; i < arr.length; i++)
        {
            if (anio1 <= Integer.parseInt(arr[i].getAnios()) &&  Integer.parseInt(arr[i].getAnios()) <= anio2)
                cont++;
        }
        
        Vehiculo arr2[]= new Vehiculo[cont];
        
        for (int i = 0; i < arr.length; i++)
        {
            if (anio1 <= Integer.parseInt(arr[i].getAnios()) &&  Integer.parseInt(arr[i].getAnios()) <= anio2)
                arr2[cont2++] = arr[i];
        }
        
        return arr2;
    }
    
    public static String BuscarPlaca(Vehiculo arr[][], String placa)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[j][i].getPlaca().equals(placa))
                {
                    return arr[j][i].VerVehiculo();
                }
            }
        }
        return "No se encontro vehiculo, con esa placa";
    }
    
    public static void ImprimirArr(Vehiculo arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i].VerVehiculo());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Vehiculo v = new Vehiculo();
        int preuba = 1;
    }
    
}
