package veterinaria;

public class Cita {

    private String idCita;
    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private Mascota mascota;
    private Veterinario veterinario;

    public Cita(String idCita, String fecha, String hora, String motivo, String diagnostico,
            Mascota mascota, Veterinario veterinario) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public String getIdCita() {
        return idCita;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
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
