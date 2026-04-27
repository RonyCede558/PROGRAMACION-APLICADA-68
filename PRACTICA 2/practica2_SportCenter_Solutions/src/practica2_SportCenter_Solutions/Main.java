package practica2_SportCenter_Solutions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n=== MENU SPORTCENTER ===");
            System.out.println("1. Registrar cancha");
            System.out.println("2. Mostrar canchas");
            System.out.println("3. Reservar cancha");
            System.out.println("4. Liberar cancha");
            System.out.println("5. Mostrar resumen");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();

                    System.out.print("Costo por hora: ");
                    double costo = sc.nextDouble();

                    sistema.agregarCancha(new Cancha(codigo, tipo, ubicacion, costo));
                    System.out.println("Cancha registrada correctamente.");
                    break;

                case 2:
                    sistema.mostrarCanchas();
                    break;

                case 3:
                    System.out.print("Código de cancha: ");
                    String codRes = sc.nextLine();

                    System.out.print("Nombre usuario: ");
                    String usuario = sc.nextLine();

                    System.out.print("Horas: ");
                    int horas = sc.nextInt();

                    boolean resultado = sistema.reservarCancha(codRes, usuario, horas);

                    if (resultado) {
                        System.out.println("Reserva realizada con éxito.");
                    } else {
                        System.out.println("No se pudo reservar (cancha no existe o está ocupada).");
                    }
                    break;

                case 4:
                    System.out.print("Código de cancha a liberar: ");
                    String codLib = sc.nextLine();

                    sistema.liberarCancha(codLib);
                    System.out.println("Cancha liberada.");
                    break;

                case 5:
                    sistema.mostrarResumen();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}