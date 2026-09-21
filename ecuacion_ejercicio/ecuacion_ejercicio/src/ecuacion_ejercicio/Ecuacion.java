/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecuacion_ejercicio;

/**
 * Representa una ecuación con hasta tres coeficientes (a, b, c), usados según
 * se trate de una ecuación de primer grado (bx + c = 0) o de segundo grado (ax²
 * + bx + c = 0).
 *
 *
 * @author grupo 1
 */
public class Ecuacion {

    private float a;
    private float b;
    private float c;

    /**
     * Crea una ecuación vacía, con todos los coeficientes en 0.
     */
    public Ecuacion(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Asigna el coeficiente a (término x², usado en segundo grado).
     *
     * @param a nuevo valor del coeficiente a
     */
    public void setA(float a) {
        this.a = a;
 
    }

    /**
     * Asigna el coeficiente b (término x).
     *
     * @param b nuevo valor del coeficiente b
     */
    public void setB(float b) {
        this.b = b;
    }

    /**
     * Asigna el coeficiente c (término independiente).
     *
     * @param c nuevo valor del coeficiente c
     */
    public void setC(float c) {
        this.c = c;
    }

    /**
     * Obtiene el coeficiente a.
     *
     * @return el valor actual del coeficiente a
     */
    public float getA() {
        return a;
    }

    /**
     * Obtiene el coeficiente b.
     *
     * @return el valor actual del coeficiente b
     */
    public float getB() {
        return b;
    }

    /**
     * Obtiene el coeficiente c.
     *
     * @return el valor actual del coeficiente c
     */
    public float getC() {
        return c;
    }

    /**
     * Calcula la raíz de una ecuación de primer grado: bx + c = 0, despejando x
     * = -c / b.
     *
     * @param b coeficiente que acompaña a x
     * @param c término independiente
     * @return la raíz x de la ecuación, o el valor de c si b es 0 (nota: si b =
     * 0 y c distinto de 0.
     */
    public float encontrarRaiz() {
        if (this.b == 0) {
            return c;
        }
        return (-this.c / this.b);
    }

    /**
     * Calcula la raíz x1 (usando el "+" de la fórmula general) de una ecuación
     * de segundo grado: ax² + bx + c = 0.
     *
     * x1 = (-b + √(b² - 4ac)) / (2a)
     *
     * @return la raíz x1, calculada con el discriminante en positivo
     *
     */
    public String[] encontrarRaices2Grado() {
        String[] resultado = new String[2];

        if (a == 0) {
            return resultado;
        }

        float valorDiscriminante = this.calcularDiscriminante();
        float valorDenominador = 2 * this.a;

        if (valorDiscriminante < 0) {
                float nImaginario = valorDiscriminante;
            String valorIzq = "" + -b / valorDenominador;
            String valorDer = "" + valorDiscriminante / valorDenominador;

            resultado[0] = valorIzq + " + " + valorDer;
            resultado[1] = valorIzq + " - " + valorDer;

            return resultado;
        }

        resultado[0] = "X1 = " + (-b + Math.sqrt(valorDiscriminante)) / valorDenominador;
        resultado[1] = "X2 = " + (-b - Math.sqrt(valorDiscriminante)) / valorDenominador;

        return resultado;
    }

    /**
     * Calcula el discriminante (b² - 4ac) de una ecuación de segundo grado. Se
     * usa para saber, ANTES de llamar a encontrar_raices_2do_grado_mas/menos,
     * si las raíces van a ser reales (discriminante >= 0) o complejas
     * (discriminante < 0), evitando así que esos métodos devuelvan NaN sin que
     * el programa lo detecte. @param a coeficiente que acompaña a x² @param b
     * coeficiente que acompaña a x
     *
     * @
     * p
     * aram c término independiente
     * @return el valor del discriminante (b² - 4ac)
     */
    public float calcularDiscriminante() {
        return (float) (Math.pow(this.b, 2) - 4 * this.a * this.c);
    }

}
