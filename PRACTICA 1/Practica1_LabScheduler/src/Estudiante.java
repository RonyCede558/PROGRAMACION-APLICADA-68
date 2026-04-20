public class Estudiante {
    private String id;
    private String nombre;
    private String carrera;
    private int nivel;

    public Estudiante(String id, String nombre, String carrera, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Carrera: " + carrera + ", Nivel: " + nivel;
    }
}