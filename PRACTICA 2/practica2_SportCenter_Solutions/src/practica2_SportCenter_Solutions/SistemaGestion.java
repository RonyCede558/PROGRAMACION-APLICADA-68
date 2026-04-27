package practica2_SportCenter_Solutions;

public class SistemaGestion {

    private Generic<Cancha> listaCanchas = new Generic<>();
    private Generic<Reserva> listaReservas = new Generic<>();
    private int contadorReservas = 1;

    public void agregarCancha(Cancha cancha) {
        listaCanchas.add(cancha);
    }

    public void mostrarCanchas() {
        listaCanchas.showAll();
    }

    public Cancha buscarCancha(String codigo) {
        return listaCanchas.find(c -> c.getCodigo().equals(codigo));
    }

    public boolean reservarCancha(String codigo, String usuario, int horas) {
        Cancha cancha = buscarCancha(codigo);

        if (cancha != null && cancha.isDisponible()) {
            cancha.reservar();
            Reserva r = new Reserva(contadorReservas++, horas, cancha, usuario);
            listaReservas.add(r);
            return true;
        }
        return false;
    }

    public void liberarCancha(String codigo) {
        Cancha cancha = buscarCancha(codigo);
        if (cancha != null) {
            cancha.liberar();
        }
    }

    public void mostrarResumen() {
        int reservadas = 0;

        for (Cancha c : listaCanchas.getList()) {
            if (!c.isDisponible()) {
                reservadas++;
            }
        }

        System.out.println("Total canchas: " + listaCanchas.getList().size());
        System.out.println("Canchas reservadas: " + reservadas);
    }
}