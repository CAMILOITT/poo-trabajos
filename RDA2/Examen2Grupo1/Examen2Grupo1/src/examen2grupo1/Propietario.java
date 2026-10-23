/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2grupo1;

/**
 *
 * @author DET PC
 */
public class Propietario extends Persona {
    private String idConsulta;
    private String fecha;
    private String motivo;
    private String diagnostico;
    private Mascota mascota;
    private Veterinario veterinario;

    public Propietario(String idConsulta, String fecha, String motivo, String diagnostico, Mascota mascota, Veterinario veterinario, String cedula, String nombres, String apellidos, String telefono, String correo) {
        super(cedula, nombres, apellidos, telefono, correo);
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    
}
