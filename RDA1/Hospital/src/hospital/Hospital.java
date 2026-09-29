/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Medico> listaMedico = new ArrayList<Medico>();
    }

    public static List<Medico> obtenerEspecialidadMedicos(List<Medico> listaMedicos, String especialidad) {
        List<Medico> listaMedico = new ArrayList<>();
        for (Medico itemMedico : listaMedicos) {
            if (itemMedico.getEspecialidad().equals(especialidad)) {
                listaMedico.add(itemMedico);
            }
        }

        return listaMedico;
    }

    public static int obtenerCantidadDeEspecialidad(List<Medico> listaMedicos, String especialidad) {
        return obtenerEspecialidadMedicos(listaMedicos, especialidad).size();
    }

    public static Medico obtenerMedico(List<Medico> listaMedicos, String codigo) {
        for (Medico itemMedico : listaMedicos) {
            if (itemMedico.getCedula().equals(codigo) || itemMedico.getCodigo().equals(codigo)) {
                return itemMedico;
            }
        }
    }
}
