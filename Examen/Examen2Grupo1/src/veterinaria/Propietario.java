package veterinaria;

import java.util.ArrayList;

public class Propietario extends Persona {

    private ArrayList<Mascota> listaDeMascotas;

    public Propietario(String cedula, String nombre, String apellido, String telefono,
            ArrayList<Mascota> listaDeMascotas) {
        super(cedula, nombre, apellido, telefono);
        this.listaDeMascotas = listaDeMascotas;
    }

    public ArrayList<Mascota> getListaDeMascotas() {
        return listaDeMascotas;
    }

    public void agregarMascota(Mascota mascota) {
        listaDeMascotas.add(mascota);
    }


}
