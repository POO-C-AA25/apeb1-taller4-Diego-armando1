
package gimnasio;
import java.util.Scanner;
public class Ejecutor {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String nombre, tipoEjercicio, cumplio, continuar;
        int duracion, maxClientes;
        System.out.print("Ingrese el numero maximo de clientes: ");
        maxClientes = tcl.nextInt();
        tcl.nextLine(); 
        Gimnasio gimnasio = new Gimnasio(maxClientes);
        do {
            System.out.print("\nNombre del cliente: ");
            nombre = tcl.nextLine();
            System.out.print("Tipo de ejercicio (Cardio/Fuerza/Estiramiento): ");
            tipoEjercicio = tcl.nextLine();
            System.out.print("Duración del ejercicio (en minutos): ");
            duracion = tcl.nextInt();
            System.out.print("¿Completo su rutina? (si/no): ");
            tcl.nextLine();
            cumplio = tcl.nextLine();

            boolean rutinaCompletada = cumplio.equalsIgnoreCase("si");
            Cliente cliente = new Cliente(nombre, tipoEjercicio, duracion, rutinaCompletada);
            if (gimnasio.registrarCliente(cliente)) {
                System.out.println("Cliente registrado exitosamente.");
            } else {
                System.out.println("No hay más espacio para nuevos clientes.");
            }

            System.out.print("\n¿Desea registrar otro cliente? (si/no): ");
            continuar = tcl.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("\n=== Registro de Clientes ===");
        Cliente[] listaClientes = gimnasio.obtenerClientes();
        for (int i = 0; i < gimnasio.obtenerCantidadClientes(); i++) {
            System.out.println(listaClientes[i]);
        }

        System.out.println("\n=== Resumen del Día ===");
        System.out.println("Clientes que completaron su rutina: " + gimnasio.completaronRutina());
        System.out.println("Tiempo promedio invertido: " + String.format("%.2f", gimnasio.calcularTiempoPromedio()) + " minutos");
    }
}