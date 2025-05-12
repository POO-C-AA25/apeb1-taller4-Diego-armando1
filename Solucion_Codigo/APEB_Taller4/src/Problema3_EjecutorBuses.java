
import java.util.Scanner;
public class Problema3_EjecutorBuses {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int maxEstudiantes = 50, cantEstu = 0, estuRegi, aceptados = 0, rechazados = 0;
        String nombre = " ", grado = " ";
        boolean permisoVigente = false;
        Estudiante []estudiante = new Estudiante[maxEstudiantes];
        System.out.print("Ingrese la cantidad de alumnos a registrar: ");
        estuRegi = tcl.nextInt();
        if (estuRegi > maxEstudiantes){
            System.out.println("El numero ingresadp sobrepasa el max de estudantes permitidos");
        }
        for (int i = 0; i < estuRegi; i++) {
            System.out.println("\nRegistro del estudiante " + (i +1) );
            System.out.println("Ingrese el nombre: ");
            nombre = tcl.next();
            System.out.println("Ingrese el grado: ");
            grado = tcl.next();
            System.out.println("Tiene el permiso vigente(True/False): ");
            permisoVigente = tcl.nextBoolean();
            estudiante[cantEstu++] = new Estudiante(nombre, grado, permisoVigente);
        }
        System.out.println("---Simulacion de ingreso---");
        for (int i = 0; i < cantEstu; i++) {
            System.out.println("Estudiante: " + estudiante[i].getNombre());
            if (estudiante[i].isPermisoVigente()){
                System.out.println("Estado: Aceptado");
                aceptados++;
            }else{
                System.out.println("Estado: Rechazado(no tiene permiso vigente)");
                rechazados++;
            }
        }
        System.out.println("Total de estudiantes registrados: " + cantEstu);
        System.out.println("Estudiantes aceptados: " + aceptados);
        System.out.println("Estudiantes rechazados: " + rechazados);
        for (int i = 0; i < cantEstu; i++) {
            System.out.println(estudiante[i]);
        }
    }
}
class Estudiante{
    public String nombre;
    public String grado;
    public boolean permisoVigente;
    public Estudiante() {
    }
    public Estudiante(String nombre, String grado, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.permisoVigente = permisoVigente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrado() {
        return grado;
    }

    public boolean isPermisoVigente() {
        return permisoVigente;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "Nombre='" + nombre + '\'' +
                ", Grado='" + grado + '\'' +
                ", Permiso Vigente=" + (permisoVigente ? "Si" : "No") +
                '}';
    }
}