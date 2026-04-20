import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);

        // Datos de prueba
        Laboratorio lab1 = new Laboratorio("L1", "Lab Computo", 2);
        sistema.agregarLaboratorio(lab1);

        int opcion;

        do {
            System.out.println("\n1. Registrar estudiante");
            System.out.println("2. Reservar laboratorio");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Mostrar reservas");
            System.out.println("5. Mostrar laboratorios");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();
                    System.out.print("Nivel: ");
                    int nivel = sc.nextInt();

                    sistema.registrarEstudiante(new Estudiante(id, nombre, carrera, nivel));
                    break;

                case 2:
                    System.out.print("ID estudiante: ");
                    String idRes = sc.nextLine();

                    Estudiante est = new Estudiante(idRes, "Temp", "Temp", 1);
                    System.out.print("Horario: ");
                    String horario = sc.nextLine();

                    sistema.reservar(est, lab1, horario);
                    break;

                case 3:
                    System.out.print("ID estudiante: ");
                    String idCan = sc.nextLine();
                    sistema.cancelarReserva(idCan);
                    break;

                case 4:
                    sistema.mostrarReservas();
                    break;

                case 5:
                    sistema.mostrarLaboratorios();
                    break;
            }

        } while (opcion != 0);
    }
}