/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.administrativo;

import java.util.ArrayList;

/**
 *
 * @author grupo1
 */
public class SistemaAdministrativo {

    static int numeroDeDocentesConMaestriaODoctorado(String nivelDeFormacion, ArrayList<Docente> listaDocentes) {
        int contador = 0;

        for (int i = 0; i < listaDocentes.size(); i++) {
            if (listaDocentes.get(i).getNivelDeFormacion().equals(nivelDeFormacion)) {
                contador++;
            }
        }

        return contador;
    }

    private static ArrayList<String> crearLista(String... elementos) {
        ArrayList<String> lista = new ArrayList<>();
        for (String elemento : elementos) {
            lista.add(elemento);
        }
        return lista;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Docente> listaDocentes = new ArrayList<>();

        ArrayList<String> listaMaterias = crearLista("Programación I", "Estructuras de Datos", "Bases de Datos");
        ArrayList<String> listaDeCargos = crearLista("Director de Carrera", "Coordinador de Área", "Jefe de Laboratorio");

        // ---------- Docente 1 ----------
        listaDocentes.add(new Docente("1730000001", "Carlos", "Mendoza", "0991010101",
                "carlos.mendoza@mail.com", 1800.0f, "Ingeniero de Sistemas", "Maestria",
                crearLista(listaDeCargos.get(0)),
                "Ingeniería",
                crearLista(listaMaterias.get(0), listaMaterias.get(1))));

        // ---------- Docente 2 ----------
        listaDocentes.add(new Docente("1730000002", "Andrés", "Salazar", "0993030303",
                "andres.salazar@mail.com", 2800.0f, "PhD en Computación", "Doctorado",
                crearLista(listaDeCargos.get(1)),
                "Ingeniería",
                crearLista(listaMaterias.get(2))));

        // ---------- Docente 3 (sin materias ni cargos) ----------
        listaDocentes.add(new Docente("1730000003", "Marcela", "Ortega", "0994040404",
                "marcela.ortega@mail.com", 1500.0f, "Ingeniera Industrial", "Maestria",
                crearLista(),
                "Ingeniería",
                crearLista()));

        JFrame_SistemaAdministrativo menu = new JFrame_SistemaAdministrativo(listaDocentes, listaMaterias, listaDeCargos);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
