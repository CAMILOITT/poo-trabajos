/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuenta_ejercicio;
import java.util.Scanner;
/**
 *
 * @author mnobo
 */
public class Cuenta_ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String respuesta = "";

        Scanner sc = new Scanner(System.in);
        //Cuenta c = new Cuenta (0,11223344);
        Cuenta_sin_constructor c = new Cuenta_sin_constructor();
        c.setNumero_cuenta(11223344);
        
        System.out.print("Bienvenido, para ingresar, digite su nuemro de cuenta porfavor: ");
        int numero_cuenta = sc.nextInt();
        sc.nextLine();
        
        if (c.getNumero_cuenta() == numero_cuenta)
        {
            while (!respuesta.equals("FIN"))
            {
                
                System.out.println();
                System.out.println("Para selecionar una opcion, escriba el numero correspondiente a la misma");
                System.out.println("Para salir digite: FIN");
                System.out.println();
                System.out.println("1. consultar saldo");
                System.out.println("2. Realizar un deposito");
                System.out.println("3. Realizar un retiro");
                System.out.println();
                System.out.print("cual sera su opcion?.. ");
                respuesta = sc.nextLine();
                System.out.println();

                if (respuesta.equals("1"))
                {
                    c.ConsultarSaldo();
                }
                else if(respuesta.equals("2"))
                {
                    System.out.print("cual sera su monto a depositar?.. ");

                    float deposito = sc.nextFloat();
                    sc.nextLine();

                    if (deposito <= 0)
                    {
                     System.out.println("ingrese un valor valido porfavor");   
                    }
                    else
                    {
                        c.depositar(deposito);
                        System.out.println("deposito exitoso ");
                    }
                }
                else if(respuesta.equals("3"))
                {
                    System.out.print("cual sera su monto a retirar?.. ");

                    float retiro = sc.nextFloat();
                    sc.nextLine();

                    if (c.retirar(retiro))
                    {
                        System.out.println("retiro exitoso ");
                    }
                    else
                    {
                        System.out.println("fondos insuficientes ");
                    }
                }
                System.out.println();
            }
        }
        else
        {
           System.out.println("numero de cuenta incorrecto"); 
        }
        
        System.out.println();
        System.out.println("Gracias por usar este programa"); 

        sc.close();
        
    }
    
}
