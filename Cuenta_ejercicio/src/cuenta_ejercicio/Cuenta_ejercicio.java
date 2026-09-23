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
    public static void main(String[] args)
     {

        // crear constructor
        System.out.println("PROGRAMA CONSTRUCTOR Y NO CONSTRUCTOR");
        System.out.println("Ingreso");
        if(opcion == 'si')
            cuenta_ejercicio cuenta = new Cuenta_ejercicio(23423, "erwer");
        else 
            cuenta_ejercicio cuenta = new Cuenta_ejercicio();   



        Scanner scan = new Scanner(System.in);
        Cuenta_sin_constructor cuentaUsuario = new Cuenta_sin_constructor();
        System.out.println("BIENVENIDO, Ingresar su numero de cuenta: ");
        String numCuentaIngreso=scan.nextLine();
        String numCuenta="896569";
        cuentaUsuario.setNumeroCuenta(numCuenta);
        cuentaUsuario.setSaldo(100);
        String respuesta="";
        if (cuentaUsuario.getNumeroCuenta().equals(numCuentaIngreso))
        {
            while (!respuesta.equals("FIN"))
            {
                System.out.println("""
                        
                    Para seleccionar una opcion , escriba el numero correspondiente a la misma
                    Para salir digite :FIN
                    1.Consular saldo
                    2.Realizar un deposito
                    3.Realizar un retiro

                    cual sera su opcion?
                        """);
                respuesta = scan.nextLine();
                switch (respuesta) 
                {
                    case "1":
                    cuentaUsuario.consultarSaldo();
                        break;
                    case "2":
                        System.out.print("Ingrese el valor a depositar:  ");
                        float deposito = scan.nextFloat();
                        scan.nextLine();
                        if (deposito>0)
                        {
                            cuentaUsuario.depositar(deposito);
                            System.out.println("deposito exitoso ");
                        }
                        else
                        {
                            System.out.println("Ingrese un valor valido porfavor");   
                        }
                        
                        break;
                    case "3":
                        System.out.print("cual sera su monto a retirar?.. ");
                        float retiro = scan.nextFloat();
                        scan.nextLine();
                        if (cuentaUsuario.retirar(retiro))
                        {
                            System.out.println("Retiro Exitoso! ");
                        }
                        else
                        {
                            System.out.println("ERROR!  Tus fondos son insuficientes ");
                        }
                        break;
                        case "FIN":
                        System.out.println("Cerrando el sistema...");
                        break;
                    default: 
                        cuentaUsuario.consultarSaldo();
                        break;
                 }
            }
        }
        else
        {
           System.out.println("ERROR! Numero de cuenta Incorrecto "); 
        }
        scan.close();
        }
    }

    