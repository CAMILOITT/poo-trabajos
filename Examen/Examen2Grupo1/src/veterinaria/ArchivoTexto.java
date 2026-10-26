package veterinaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArchivoTexto {

    private ArrayList<Propietario> listaDePropietarios;
    private ArrayList<Veterinario> listaDeVeterinarios;
    private ArrayList<Mascota> listaDeMascotas;
    private ArrayList<Cita> listaDeCitas;

    public ArchivoTexto(ArrayList<Propietario> listaDePropietarios, ArrayList<Veterinario> listaDeVeterinarios,
            ArrayList<Mascota> listaDeMascotas, ArrayList<Cita> listaDeCitas) {
        this.listaDePropietarios = listaDePropietarios;
        this.listaDeVeterinarios = listaDeVeterinarios;
        this.listaDeMascotas = listaDeMascotas;
        this.listaDeCitas = listaDeCitas;
    }

    public static Propietario buscarPropietario(ArrayList<Propietario> listaDePropietarios, String cedula) {
        for (Propietario propietario : listaDePropietarios) {
            if (propietario.getCedula().equals(cedula)) {
                return propietario;
            }
        }
        return null;
    }

    public static Veterinario buscarVeterinario(ArrayList<Veterinario> listaDeVeterinarios, String idVeterinario) {
        for (Veterinario veterinario : listaDeVeterinarios) {
            if (veterinario.getIdVeterinario().equals(idVeterinario)) {
                return veterinario;
            }
        }
        return null;
    }

    public static Mascota buscarMascota(ArrayList<Mascota> listaDeMascotas, String codigo) {
        for (Mascota mascota : listaDeMascotas) {
            if (mascota.getCodigo().equals(codigo)) {
                return mascota;
            }
        }
        return null;
    }

    private void agregarPropietario(String[] datos) {
        Propietario propietario = new Propietario(datos[1], datos[2], datos[3], datos[4], new ArrayList<>());
        listaDePropietarios.add(propietario);
    }

    private void agregarVeterinario(String[] datos) {
        Veterinario veterinario = new Veterinario(datos[1], datos[6], new ArrayList<>(),
                datos[2], datos[3], datos[4], datos[5]);
        listaDeVeterinarios.add(veterinario);
    }

    private void agregarMascota(String[] datos) {
        Propietario propietario = buscarPropietario(listaDePropietarios, datos[6]);
        if (propietario != null) {
            int edad = Integer.parseInt(datos[5]);
            Mascota mascota = new Mascota(datos[1], datos[2], datos[3], datos[4], edad, propietario);
            listaDeMascotas.add(mascota);
            propietario.agregarMascota(mascota);
        }
    }

    private void agregarCita(String[] datos) {
        Mascota mascota = buscarMascota(listaDeMascotas, datos[6]);
        Veterinario veterinario = buscarVeterinario(listaDeVeterinarios, datos[7]);
        if (mascota != null && veterinario != null) {
            Cita cita = new Cita(datos[1], datos[2], datos[3], datos[4], datos[5], mascota, veterinario);
            listaDeCitas.add(cita);
            veterinario.getListaDeCitas().add(cita);
        }
    }

    private void leerLinea(String linea) {
        String[] datos = linea.split(";");
        if (datos[0].equals("PROPIETARIO")) {
            agregarPropietario(datos);
        } else if (datos[0].equals("VETERINARIO")) {
            agregarVeterinario(datos);
        } else if (datos[0].equals("MASCOTA")) {
            agregarMascota(datos);
        } else if (datos[0].equals("CITA")) {
            agregarCita(datos);
        }
    }

    public void guardarDatos() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("citas.txt", StandardCharsets.UTF_8));
            for (Propietario propietario : listaDePropietarios) {
                escritor.write("PROPIETARIO;" + propietario.getCedula() + ";" + propietario.getNombre() + ";"
                        + propietario.getApellido() + ";" + propietario.getTelefono());
                escritor.newLine();
            }
            for (Veterinario veterinario : listaDeVeterinarios) {
                escritor.write("VETERINARIO;" + veterinario.getIdVeterinario() + ";" + veterinario.getCedula() + ";"
                        + veterinario.getNombre() + ";" + veterinario.getApellido() + ";"
                        + veterinario.getTelefono() + ";" + veterinario.getEspecialidad());
                escritor.newLine();
            }
            for (Mascota mascota : listaDeMascotas) {
                escritor.write("MASCOTA;" + mascota.getCodigo() + ";" + mascota.getNombre() + ";"
                        + mascota.getEspecie() + ";" + mascota.getRaza() + ";" + mascota.getEdad() + ";"
                        + mascota.getPropietario().getCedula());
                escritor.newLine();
            }
            for (Cita cita : listaDeCitas) {
                escritor.write("CITA;" + cita.getIdCita() + ";" + cita.getFecha() + ";"
                        + cita.getHora() + ";" + cita.getMotivo() + ";" + cita.getDiagnostico() + ";"
                        + cita.getMascota().getCodigo() + ";" + cita.getVeterinario().getIdVeterinario());
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo citas.txt");
        }
    }

    public void recuperarDatos() {
        File archivo = new File("citas.txt");
        if (!archivo.exists()) {
            return;
        }
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8));
            String linea = lector.readLine();
            while (linea != null) {
                if (!linea.isEmpty()) {
                    leerLinea(linea);
                }
                linea = lector.readLine();
            }
            lector.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo citas.txt");
        }
    }
}
