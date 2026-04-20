import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Sistema {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Laboratorio> laboratorios;
    private ArrayList<Reserva> reservas;
    private Queue<Estudiante> listaEspera;

    public Sistema() {
        estudiantes = new ArrayList<>();
        laboratorios = new ArrayList<>();
        reservas = new ArrayList<>();
        listaEspera = new LinkedList<>();
    }

    // Registrar estudiante sin duplicados
    public void registrarEstudiante(Estudiante e) {
        for (Estudiante est : estudiantes) {
            if (est.getId().equals(e.getId())) {
                System.out.println("Estudiante ya registrado.");
                return;
            }
        }
        estudiantes.add(e);
        System.out.println("Estudiante registrado.");
    }

    public void agregarLaboratorio(Laboratorio l) {
        laboratorios.add(l);
    }

    // Reservar
    public void reservar(Estudiante e, Laboratorio l, String horario) {
        if (l.getEquiposDisponibles() > 0) {
            l.ocuparEquipo();
            reservas.add(new Reserva(e, l, horario));
            System.out.println("Reserva realizada.");
        } else {
            listaEspera.add(e);
            System.out.println("No hay equipos. Añadido a lista de espera.");
        }
    }

    // Cancelar reserva
    public void cancelarReserva(String idEstudiante) {
        for (Reserva r : reservas) {
            if (r.getEstudiante().getId().equals(idEstudiante)) {
                r.getLaboratorio().liberarEquipo();
                reservas.remove(r);
                System.out.println("Reserva cancelada.");

                // Atender lista de espera
                if (!listaEspera.isEmpty()) {
                    Estudiante siguiente = listaEspera.poll();
                    reservar(siguiente, r.getLaboratorio(), "Asignado automático");
                }
                return;
            }
        }
        System.out.println("Reserva no encontrada.");
    }

    public void mostrarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public void mostrarLaboratorios() {
        for (Laboratorio l : laboratorios) {
            System.out.println(l);
        }
    }
}