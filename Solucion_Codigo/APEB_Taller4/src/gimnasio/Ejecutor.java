
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
            gimnasio.registrarCliente(cliente);

            System.out.print("\n¿Desea registrar otro cliente? (si/no): ");
            continuar = tcl.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        gimnasio.mostrarResumen();
    }
}
