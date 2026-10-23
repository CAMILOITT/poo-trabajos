package  examen2grupo1;

public class Cita {
    private String idConsulta;
    private String fecha;
    private String motivo;
    private String diagostico;
    private Mascota mascota;
    private Veterinario veterinario;

    public Cita(String idConsulta, String fecha, String motivo, String diagostico, Mascota mascota, Veterinario veterinario) {
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagostico = diagostico;
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

    public String getDiagostico() {
        return diagostico;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    
    
}
