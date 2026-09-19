/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta_ejercicio;

/**
 * Representa una cuenta bancaria simple, sin constructor personalizado:
 * los valores iniciales se asignan uno por uno usando los setters,
 * en vez de recibirlos todos juntos al crear el objeto.
 *
 * @author grupo 1
 */
public class Cuenta_sin_constructor {

    
    private float saldo;
    private int numero_cuenta;

    /**
     * Asigna el saldo de la cuenta.
     *
     * @param saldo nuevo saldo a asignar
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Asigna el número de cuenta.
     * Se usa una sola vez, justo después de crear el objeto, para
     * simular lo que un constructor haría de una sola vez.
     *
     * @param numero_cuenta número de cuenta a asignar
     */
    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    /**
     * Obtiene el número de cuenta actual.
     * Se usa para validar la identidad del usuario al inicio del
     * programa, comparándolo con lo que el usuario ingresó por consola.
     *
     * @return el número de cuenta almacenado
     */
    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    /**
     * Intenta retirar un monto del saldo.
     * Devuelve true si el retiro se pudo realizar, false si no había
     * fondos suficientes. Así, quien llama al método sabe el
     * resultado sin necesidad de consultar el saldo por separado.
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
     * en otro cálculo (si necesitaras el valor para operar con él,
     * necesitarías un getSaldo() aparte que sí retorne float).
     */
    public void ConsultarSaldo ()
    {
       System.out.println("Su saldo actual es: " + this.saldo + " dolares");
    }
}