import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gimnasio miGimnasio = new Gimnasio();
        boolean salir = false;

        System.out.println("¡Bienvenido al Sistema de Gestión del Gimnasio!");

        miGimnasio.agregarEntrenador(new Entrenador("Carlos Perez", "E01"));
        miGimnasio.agregarEntrenador(new Entrenador("Ana Lopez", "E02"));
        miGimnasio.agregarRutina(new Rutina("Cardio Intensivo", "Focalizada en resistencia cardiovascular."));
        miGimnasio.agregarRutina(new Rutina("Fuerza Total", "Rutina para desarrollo de masa muscular."));

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Nuevo Miembro");
            System.out.println("2. Registrar Nuevo Entrenador");
            System.out.println("3. Crear Nueva Rutina");
            System.out.println("4. Asignar Entrenador a Miembro");
            System.out.println("5. Asignar Rutina a Miembro");
            System.out.println("6. Ver Reportes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarMiembro(scanner, miGimnasio);
                        break;
                    case 2:
                        registrarEntrenador(scanner, miGimnasio);
                        break;
                    case 3:
                        crearRutina(scanner, miGimnasio);
                        break;
                    case 4:
                        asignarEntrenador(scanner, miGimnasio);
                        break;
                    case 5:
                        asignarRutina(scanner, miGimnasio);
                        break;
                    case 6:
                        mostrarReportes(miGimnasio);
                        break;
                    case 7:
                        salir = true;
                        System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void registrarMiembro(Scanner scanner, Gimnasio gym) {
        System.out.println("\n--- Registro de Nuevo Miembro ---");
        System.out.print("Ingrese el nombre del miembro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del miembro (ej. M01): ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el tipo de membresía (ej. Básica, Premium): ");
        String membresia = scanner.nextLine();

        Miembro nuevoMiembro = new Miembro(nombre, id, membresia);
        gym.agregarMiembro(nuevoMiembro);
        System.out.println("¡Miembro '" + nombre + "' registrado con éxito!");
    }
    
    public static void registrarEntrenador(Scanner scanner, Gimnasio gym) {
        System.out.println("\n--- Registro de Nuevo Entrenador ---");
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del entrenador (ej. E01): ");
        String id = scanner.nextLine();
        
        Entrenador nuevoEntrenador = new Entrenador(nombre, id);
        gym.agregarEntrenador(nuevoEntrenador);
        System.out.println("¡Entrenador '" + nombre + "' registrado con éxito!");
    }

    public static void crearRutina(Scanner scanner, Gimnasio gym) {
        System.out.println("\n--- Creación de Nueva Rutina ---");
        System.out.print("Ingrese el nombre de la rutina: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese una breve descripción de la rutina: ");
        String descripcion = scanner.nextLine();

        Rutina nuevaRutina = new Rutina(nombre, descripcion);
        gym.agregarRutina(nuevaRutina);
        System.out.println("¡Rutina '" + nombre + "' creada con éxito!");
    }

    public static void asignarEntrenador(Scanner scanner, Gimnasio gym) {
        System.out.println("\n--- Asignar Entrenador a Miembro ---");
        
        System.out.println("Miembros disponibles:");
        for(Miembro m : gym.getMiembros()) {
            System.out.println(" - " + m);
        }
        System.out.print("Ingrese el ID del miembro: ");
        String idMiembro = scanner.nextLine();
        Miembro miembro = gym.buscarMiembroPorId(idMiembro);

        if (miembro == null) {
            System.out.println("Error: No se encontró un miembro con ese ID.");
            return;
        }

        System.out.println("\nEntrenadores disponibles:");
        for(Entrenador e : gym.getEntrenadores()) {
            System.out.println(" - " + e);
        }
        System.out.print("Ingrese el ID del entrenador a asignar: ");
        String idEntrenador = scanner.nextLine();
        Entrenador entrenador = gym.buscarEntrenadorPorId(idEntrenador);

        if (entrenador == null) {
            System.out.println("Error: No se encontró un entrenador con ese ID.");
            return;
        }

        miembro.setEntrenador(entrenador);
        System.out.println("¡Se asignó a '" + entrenador.getNombre() + "' al miembro '" + miembro.getNombre() + "' con éxito!");
    }

    public static void asignarRutina(Scanner scanner, Gimnasio gym) {
        System.out.println("\n--- Asignar Rutina a Miembro ---");
        
        System.out.println("Miembros disponibles:");
        for(Miembro m : gym.getMiembros()) {
            System.out.println(" - " + m);
        }
        System.out.print("Ingrese el ID del miembro: ");
        String idMiembro = scanner.nextLine();
        Miembro miembro = gym.buscarMiembroPorId(idMiembro);

        if (miembro == null) {
            System.out.println("Error: No se encontró un miembro con ese ID.");
            return;
        }

        System.out.println("\nRutinas disponibles:");
        for(Rutina r : gym.getRutinas()) {
            System.out.println(" - " + r);
        }
        System.out.print("Ingrese el nombre de la rutina a asignar: ");
        String nombreRutina = scanner.nextLine();
        Rutina rutina = gym.buscarRutinaPorNombre(nombreRutina);

        if (rutina == null) {
            System.out.println("Error: No se encontró una rutina con ese nombre.");
            return;
        }
        
        miembro.setRutina(rutina);
        System.out.println("¡Se asignó la rutina '" + rutina.getNombre() + "' al miembro '" + miembro.getNombre() + "' con éxito!");
    }
    
    public static void mostrarReportes(Gimnasio gym) {
        System.out.println("\n--- REPORTES DEL GIMNASIO ---");
        System.out.println("1. Rutina más popular");
        System.out.println("2. Total de rutinas activas");
        System.out.println("3. Entrenador con más miembros");
        System.out.print("Seleccione el reporte que desea ver: ");
        
        Scanner scanner = new Scanner(System.in);
        try {
            int opcionReporte = scanner.nextInt();
            scanner.nextLine();

            switch(opcionReporte) {
                case 1:
                    System.out.println("Reporte: " + gym.getReporteRutinaMasPopular());
                    break;
                case 2:
                    System.out.println("Reporte: " + gym.getReporteTotalRutinasActivas());
                    break;
                case 3:
                    System.out.println("Reporte: " + gym.getReporteEntrenadorConMasMiembros());
                    break;
                default:
                    System.out.println("Opción de reporte no válida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número.");
        }
    }
}