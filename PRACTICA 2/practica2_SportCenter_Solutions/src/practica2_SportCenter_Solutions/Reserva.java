package practica2_SportCenter_Solutions;

public class Reserva {
    private int codigoReserva;
    private int horas;
    private Cancha cancha;
    private String nombreUsuario;

    public Reserva(int codigoReserva, int horas, Cancha cancha, String nombreUsuario) {
        this.codigoReserva = codigoReserva;
        this.horas = horas;
        this.cancha = cancha;
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Reserva #" + codigoReserva +
               ", Usuario: " + nombreUsuario +
               ", Horas: " + horas +
               ", Cancha: " + cancha.getCodigo();
    }
}