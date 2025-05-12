

package parqueDiversiones;
import java.util.Scanner;
public class Ejecutor {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String nombre, continuar;
        int edad;
        double altura;
        System.out.print("Ingrese el numero maximo de visitantes: ");
        int maxVisitantes = tcl.nextInt();
        tcl.nextLine(); 
        Parque parque = new Parque(maxVisitantes);
        do {
            System.out.print("Ingrese nombre del visitante: ");
            nombre = tcl.nextLine();
            System.out.print("Ingrese edad del visitante: ");
            edad = tcl.nextInt();
            System.out.print("Ingrese altura del visitante en metros: ");
            altura = tcl.nextDouble();
            tcl.nextLine();
            Visitante visitante = new Visitante(nombre, edad, altura);
            if (parque.registrarVisitante(visitante)) {
                System.out.println("Visitante registrado exitosamente.");
            } else {
                System.out.println("No hay más espacio para nuevos visitantes.");
            }

            System.out.print("¿Desea registrar otro visitante? (si/no): ");
            continuar = tcl.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("\n=== Acceso a Juegos ===");
        String[] accesos = parque.obtenerAcceso();
        for (String acceso : accesos) {
            System.out.println(acceso);
            System.out.println();
        }
    }
}
