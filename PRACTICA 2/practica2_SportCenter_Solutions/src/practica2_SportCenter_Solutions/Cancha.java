package practica2_SportCenter_Solutions;

public class Cancha {
    private String codigo;
    private String tipo;
    private String ubicacion;
    private double costoHora;
    private boolean disponible;

    public Cancha(String codigo, String tipo, String ubicacion, double costoHora) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.costoHora = costoHora;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               ", Tipo: " + tipo +
               ", Ubicación: " + ubicacion +
               ", Costo/Hora: " + costoHora +
               ", Disponible: " + disponible;
    }
}