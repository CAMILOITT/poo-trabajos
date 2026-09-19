/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta_ejercicio;

/**
 * Representa una cuenta bancaria, esta vez SÍ con constructores
 * propios: los valores iniciales se entregan de una sola vez al
 * crear el objeto, en vez de asignarlos uno por uno con setters
 * (a diferencia de Cuenta_sin_constructor).
 *
 * @author grupo 1
 */
public class Cuenta {

   
    private float saldo;
    private int numero_cuenta;

    /**
     * Crea una cuenta con saldo inicial en 0.
     * No asigna numero_cuenta explícitamente, así que ese atributo
     * queda con su valor por defecto (0 para int).
     */
    public Cuenta()
    {
        this.saldo=0;
    }

    /**
     * Crea una cuenta indicando directamente su saldo inicial y su
     * número de cuenta, todo en un solo paso al momento de instanciar
     * el objeto.
     *
     * @param saldo saldo inicial de la cuenta
     * @param numero_cuenta número de cuenta a asignar
     */
    public Cuenta(float saldo, int numero_cuenta )
    {
        this.saldo=saldo;
        this.numero_cuenta= numero_cuenta;

    }

    /**
     * Obtiene el número de cuenta actual.
     * Se usa para validar la identidad del usuario, comparándolo con
     * lo que ingresó por consola.
     *
     * @return el número de cuenta almacenado
     */
    public int getNumero_cuenta() {
        return numero_cuenta;
    }


    /**
     * Intenta retirar un monto del saldo.
     * Devuelve true si el retiro se pudo realizar, false si no había
     * fondos suficientes.
     *
     * @param cantidad monto que se desea retirar
     * @return true si el retiro se realizó con éxito, false si no
     *         había fondos suficientes
     */
    public boolean retirar(float cantidad)
    {

        if (cantidad <= this.saldo)
                {
                   this.saldo = this.saldo - cantidad; 
                   return true;
                }
        else
        {
            return false;
        }
    }

    /**
     * Deposita un monto, sumándolo directamente al saldo actual.
     * No valida que "cantidad" sea positivo: esa validación se hace
     * afuera, en el main, antes de llamar a este método.
     *
     * @param cantidad monto que se desea depositar
     */
    public void depositar (float cantidad)
    {

        this.saldo = this.saldo + cantidad; 

    }

    /**
     * Muestra el saldo actual por consola. No devuelve nada porque
     * su función es solo imprimir, no entregar el dato para usarlo
     * en otro cálculo.
     */
    public void ConsultarSaldo ()
    {
       System.out.println("Su saldo actual es: " + this.saldo + " dolares");
    }

}