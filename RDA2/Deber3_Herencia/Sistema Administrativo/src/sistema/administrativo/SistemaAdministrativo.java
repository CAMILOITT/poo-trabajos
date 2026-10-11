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

    static ArrayList<Administrativo> obtenerAdministrativosPorCargo(String cargo, ArrayList<Administrativo> listaAdministrativos) {
        ArrayList<Administrativo> administrativosConCargo = new ArrayList<>();

        for (int i = 0; i < listaAdministrativos.size(); i++) {
            if (listaAdministrativos.get(i).verificarCargo(cargo)) {
                administrativosConCargo.add(listaAdministrativos.get(i));
            }
        }

        return administrativosConCargo;
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
        ArrayList<String> listaDeCargos = crearLista("Director de Carrera", "Coordinador de Área", "Jefe de Laboratorio",
                "Secretario General", "Asistente Administrativo");
        // ---------- Docente 1 ----------
        listaDocentes.add(new Docente("1730000001", "Carlos", "Mendoza", "0991010101",
                "carlos.mendoza@mail.com", 1800.0f, "Ingeniero de Sistemas", "Maestría",
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
                "marcela.ortega@mail.com", 1500.0f, "Ingeniera Industrial", "Maestría",
                crearLista(),
                "Ingeniería",
                crearLista()));

        ArrayList<Administrativo> listaAdministrativos = new ArrayList<>();

        // ---------- Administrativo 1 ----------
        listaAdministrativos.add(new Administrativo("1730000004", "Lucía", "Paredes", "0995050505",
                "lucia.paredes@mail.com", 1400.0f, "Maestría", "Licenciada en Administración",
                crearLista(listaDeCargos.get(3)),
                "Secretaría"));

        // ---------- Administrativo 2 ----------
        listaAdministrativos.add(new Administrativo("1730000005", "Jorge", "Vaca", "0996060606",
                "jorge.vaca@mail.com", 950.0f, "Sin nivel de formación", "Ingeniero Comercial",
                crearLista(listaDeCargos.get(4)),
                "Talento Humano"));

        // ---------- Administrativo 3 ----------
        listaAdministrativos.add(new Administrativo("1730000006", "Sofía", "Cevallos", "0997070707",
                "sofia.cevallos@mail.com", 1100.0f, "Maestría", "Psicóloga",
                crearLista(listaDeCargos.get(4), listaDeCargos.get(1)),
                "Bienestar Estudiantil"));

        JFrame_SistemaAdministrativo menu = new JFrame_SistemaAdministrativo(listaDocentes, listaMaterias, listaDeCargos, listaAdministrativos);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
