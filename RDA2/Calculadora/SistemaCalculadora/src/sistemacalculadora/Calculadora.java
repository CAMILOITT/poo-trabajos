/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacalculadora;


public class Calculadora {
    private double operado1;
    private double operado2;

    public Calculadora() {
    }

    public double getOperado1() {
        return operado1;
    }

    public double getOperado2() {
        return operado2;
    }

    public void setOperado1(double valor){
        this.operado1 = valor;
    }

    public void setOperado2(double valor) {
        this.operado2 = valor;
    }
    public double sumar()
    {
        return this.operado1+this.operado2;
    }
    public double restar()
    {
        return this.operado1-this.operado2;
    }
    public double multiplicar()
    {
        return this.operado1*this.operado2;
    }
    public double dividir()
    {
        return this.operado1/this.operado2;
    }
    public double potencia()
    {
        return Math.pow(operado1, operado1);
    }
    public double radicacion()
    {
        return Math.pow(this.operado1,1.0/this.operado2);
    }
    
    
}
