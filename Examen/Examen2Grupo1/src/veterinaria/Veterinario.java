package veterinaria;

import java.util.ArrayList;

public class Veterinario extends Persona {

    private String idVeterinario;
    private String especialidad;
    private ArrayList<Cita> listaDeCitas;

    public Veterinario(String idVeterinario, String especialidad, ArrayList<Cita> listaDeCitas,
            String cedula, String nombre, String apellido, String telefono) {
        super(cedula, nombre, apellido, telefono);
        this.idVeterinario = idVeterinario;
        this.especialidad = especialidad;
        this.listaDeCitas = listaDeCitas;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<Cita> getListaDeCitas() {
        return listaDeCitas;
    }
}
