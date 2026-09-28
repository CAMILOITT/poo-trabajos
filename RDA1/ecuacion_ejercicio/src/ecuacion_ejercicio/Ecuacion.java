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
     * Crea una ecuación con sus tres coeficientes, entregados de una sola
     * vez al momento de instanciar el objeto.
     *
     * @param a coeficiente que acompaña a x² (usado en segundo grado)
     * @param b coeficiente que acompaña a x
     * @param c término independiente
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
     * Calcula la raíz de una ecuación de primer grado: bx + c = 0, despejando
     * x = -c / b.
     *
     * @return la raíz x de la ecuación, o el valor de c si b es 0 (nota: si
     *         b = 0 y c distinto de 0, la ecuación en realidad no tiene
     *         solución, esto es solo una protección contra dividir entre 0)
     */
    /**
     * *Verifica el grado de la ecuaci[on mirando el coeficiente a.
     * Si a es 0, el termino x² desaparece y la ecucion es de primer
     * grado, si a a no es 0, es de segundo grado
     * @return true si la ecuacion es de primer grado, false si es de segundo grado
     */
    public boolean esPrimerGrado() {
        return this.a == 0;
    }
    /**
     * Calcula el discriminante (b² - 4ac) de esta ecuación de segundo grado.
     * Se usa dentro de encontrarRaices() para saber si las
     * raíces van a ser reales o complejas
     *
     * @return el valor del discriminante (b² - 4ac)
     */
    public float calcularDiscriminante() {
        return (float) (Math.pow(this.b, 2) - 4 * this.a * this.c);
    }

    /**
     * Calcula la raíz o raíces de esta ecuación, decidiendo sola,
     * según esPrimerGrado(), si debe resolverla como una ecuación de
     * primer grado (bx + c = 0) o de segundo grado (ax² + bx + c = 0).
     *
     * Si es de primer grado, solo se llena resultado[0] con la única
     * raíz, y resultado[1] queda vacío.
     *
     * Si es de segundo grado, se usa calcularDiscriminante() para
     * decidir si las raíces son reales o complejas, y se llenan
     * ambas posiciones del arreglo.
     *
     * @return un arreglo con la raíz o raíces armadas como texto
     */
    
    public String[] encontrarRaices() {
        String[] resultado = new String[2];
        
        if(this.esPrimerGrado()){
            if(this.b == 0){
                resultado[0] = "" + this.c;
            } else {
                resultado[0] = "" + (-this.c / this.b);
            }
            resultado[1] = "";
            return resultado;
        }
        
        float valorDiscriminante = this.calcularDiscriminante();
        float valorDenominador = 2 * this.a;

        if (valorDiscriminante < 0) {
            float parteImaginaria = (float) (Math.sqrt(-valorDiscriminante) / valorDenominador);
            String valorIzq = "" + -b / valorDenominador;
            String valorDer = "" + parteImaginaria;

            resultado[0] = valorIzq + " + " + valorDer + "i";
            resultado[1] = valorIzq + " - " + valorDer + "i";

            return resultado;
        }

        resultado[0] = " " + (-b + Math.sqrt(valorDiscriminante)) / valorDenominador;
        resultado[1] = " " + (-b - Math.sqrt(valorDiscriminante)) / valorDenominador;

        return resultado;
    }

    

}
