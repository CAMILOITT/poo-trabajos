package plantilla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Lee y escribe las listas en archivos de texto.
 * Cada objeto ocupa una línea y sus datos van separados por punto y coma.
 * Los archivos se crean en la carpeta del proyecto.
 */
public class ArchivoTexto {

    private static final String ARCHIVO_PERSONAS = "personas.txt";
    private static final String ARCHIVO_ELEMENTOS = "elementos.txt";
    private static final String SEPARADOR = ";";

    // ---------------- PERSONAS ----------------

    public static void guardarPersonas(ArrayList<Persona> listaPersonas) {
        // try con recursos, el archivo se cierra solo al terminar
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_PERSONAS))) {
            for (Persona persona : listaPersonas) {
                escritor.write(persona.getCedula() + SEPARADOR
                        + persona.getNombres() + SEPARADOR
                        + persona.getApellidos() + SEPARADOR
                        + persona.getTelefono() + SEPARADOR
                        + persona.getCorreo());
                escritor.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo de personas");
        }
    }

    public static ArrayList<Persona> leerPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        File archivo = new File(ARCHIVO_PERSONAS);
        if (!archivo.exists()) {
            return listaPersonas;
        }
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] datos = linea.split(SEPARADOR);
                listaPersonas.add(new Persona(datos[0], datos[1], datos[2], datos[3], datos[4]));
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo de personas");
        }
        return listaPersonas;
    }

    // ---------------- ELEMENTOS ----------------

    public static void guardarElementos(ArrayList<Mascota> listaElementos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_ELEMENTOS))) {
            for (Mascota elemento : listaElementos) {
                escritor.write(elemento.getCodigo() + SEPARADOR
                        + elemento.getNombre() + SEPARADOR
                        + elemento.getCategoria() + SEPARADOR
                        + elemento.getCantidad() + SEPARADOR
                        + elemento.getPrecio());
                escritor.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo de elementos");
        }
    }

    public static ArrayList<Mascota> leerElementos() {
        ArrayList<Mascota> listaElementos = new ArrayList<>();
        File archivo = new File(ARCHIVO_ELEMENTOS);
        if (!archivo.exists()) {
            return listaElementos;
        }
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] datos = linea.split(SEPARADOR);
                // Los números se guardan como texto, por eso hay que convertirlos
                int cantidad = Integer.parseInt(datos[3]);
                double precio = Double.parseDouble(datos[4]);
                listaElementos.add(new Mascota(datos[0], datos[1], datos[2], cantidad, precio));
            }
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo de elementos");
        }
        return listaElementos;
    }
}
