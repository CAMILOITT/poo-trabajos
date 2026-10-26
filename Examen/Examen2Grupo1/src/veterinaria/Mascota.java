package veterinaria;

public class Mascota {

    private String codigo;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private Propietario propietario;

    public Mascota(String codigo, String nombre, String especie, String raza, int edad, Propietario propietario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.propietario = propietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public Propietario getPropietario() {
        return propietario;
    }
}
