public class Laboratorio {
    private String id;
    private String nombre;
    private int equiposDisponibles;

    public Laboratorio(String id, String nombre, int equiposDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.equiposDisponibles = equiposDisponibles;
    }

    public int getEquiposDisponibles() {
        return equiposDisponibles;
    }

    public void ocuparEquipo() {
        if (equiposDisponibles > 0) {
            equiposDisponibles--;
        }
    }

    public void liberarEquipo() {
        equiposDisponibles++;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Lab: " + nombre + " | Equipos disponibles: " + equiposDisponibles;
    }
}
