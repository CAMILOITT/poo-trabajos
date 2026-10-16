/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosplit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/**
 *
 * @author grupo 1
 */
public class EjemploSplit {

    /**
     * @param args the command line arguments
     */
    
    /** Escribe cada Cliente como una línea, con los campos separados por comas. */
    static void guardarClientes(ArrayList<Cliente> lista, String ruta) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, StandardCharsets.UTF_8))) {
            for (int i = 0; i < lista.size(); i++) {
                escritor.write(lista.get(i).convierteALinea());
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo escribir el archivo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Cliente> clientes = leerClientes("clientes.txt");
 
        System.out.println("Clientes leídos: " + clientes.size());
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("  " + clientes.get(i));
        }
 
        guardarClientes(clientes, "clientes_copia.txt");
        System.out.println("Archivo clientes_copia.txt generado.");
    }
 
    /** Lee el archivo y convierte cada línea válida en un objeto Cliente. */
    static ArrayList<Cliente> leerClientes(String ruta) {
        ArrayList<Cliente> lista = new ArrayList<>();
 
        // try-with-resources: cierra el archivo automáticamente al terminar
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta, StandardCharsets.UTF_8))) {
            String linea;
 
            while ((linea = lector.readLine()) != null) {   // readLine() devuelve null al llegar al final
                if (linea.trim().isEmpty()) {
                    continue;                               // ignora líneas en blanco
                }
 
                // split(",", -1): el -1 conserva los campos vacíos del final
                String[] campos = linea.split(",", -1);
 
                if (campos.length != 5) {
                    System.out.println("Línea ignorada (se esperaban 5 campos): " + linea);
                    continue;
                }
 
                try {
                    String cedula = campos[0].trim();
                    String nombre = campos[1].trim();
                    String apellido = campos[2].trim();
                    String celular = campos[3].trim();
                    int puntos = Integer.parseInt(campos[4].trim());   // texto -> int
 
                    lista.add(new Cliente(cedula, nombre, apellido, celular, puntos));
 
                } catch (NumberFormatException e) {
                    System.out.println("Línea ignorada (puntos no numéricos): " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
 
        return lista;
    }
}
 