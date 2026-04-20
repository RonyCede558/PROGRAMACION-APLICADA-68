public class Reserva {
    private Estudiante estudiante;
    private Laboratorio laboratorio;
    private String horario;

    public Reserva(Estudiante estudiante, Laboratorio laboratorio, String horario) {
        this.estudiante = estudiante;
        this.laboratorio = laboratorio;
        this.horario = horario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public String getHorario() {
        return horario;
    }

    public String toString() {
        return estudiante.getNombre() + " - " + laboratorio.getNombre() + " - " + horario;
    }
}