/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo {

    public static void main(String[] args) throws IOException {

        RandomAccessFile f = new RandomAccessFile("prueba.dat", "rw");

        // ESCRIBIR
        f.writeUTF("Ana");    // un texto: guarda 2 bytes de longitud + 3 de texto = 5 bytes
        f.writeChar('X');     // un carácter: 2 bytes
        f.writeInt(25);       // un entero: 4 bytes

        System.out.println("Tamanio del archivo: " + f.length() + " bytes");   // 11

        // LEER: volver al inicio y leer en el mismo orden en que se escribió
        f.seek(0);
        String nombre = f.readUTF();
        char letra = f.readChar();
        int numero = f.readInt();
        System.out.println(nombre + " " + letra + " " + numero);              // Ana X 25

        // SEEK: saltar directo al entero (5 + 2 = byte 7)
        f.seek(7);
        System.out.println("Entero leido directo: " + f.readInt());           // 25

        f.close();
    }
}
