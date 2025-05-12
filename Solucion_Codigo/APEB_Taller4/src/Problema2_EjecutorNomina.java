
import java.util.Scanner;
public class Problema2_EjecutorNomina {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int maxEmpleados = 100, cont, opcion;
        Empleado []empleado = new Empleado[maxEmpleados];
        cont = 0;
        do {
            System.out.println("---Menu de gestion de empleados---");
            System.out.println("1. Agregar empleados");
            System.out.println("2. Mostrar informacion de empleado");
            System.out.println("3. Calcular aumento salarial");
            System.out.println("4. Salir");
            opcion = tcl.nextInt();
            switch (opcion){
                case 1:
                    if (cont < maxEmpleados){
                        empleado[cont]= agregarEmpleado(tcl);
                        cont++;
                    }else{
                        System.out.println("No se puede agregar mas empleados ");
                    }
                    break;
                case 2:
                    mostrarEmpleados(empleado, cont);
                    break;
                case 3:
                    calcularAumento(tcl, empleado, cont);
                    break;
                case 4:
                    System.out.println("Saliendo del programa..");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente");
            }
        } while (opcion != 4);
    }
    public static Empleado agregarEmpleado(Scanner tcl){
        String nombre;
        double salario;
        int edad;
        System.out.print("Ingrese el nombre del empleado: ");
        nombre = tcl.next();
        System.out.print("Ingrese el salario del empleado: ");
        salario = tcl.nextDouble();
        System.out.println("Ingrese la edad del empleado: ");
        edad = tcl.nextInt();
        return new Empleado(nombre, salario, edad);
    }
    public static void mostrarEmpleados(Empleado[] empleado, int cantidad){
        if (cantidad == 0){
            System.out.println("No hay empleados");
        }else{
            System.out.println("\nLista de empleados");
            for (int i = 0; i < cantidad; i++) {
                System.out.print(empleado[i]);
            }
        }
    }
    public static void calcularAumento(Scanner tcl, Empleado []empleado, int cantidad){
        if (cantidad == 0){
            System.out.println("No hay empleados!!");
        }
        double sumaSalarios = 0;
        for (int i = 0; i < cantidad; i++) {
            sumaSalarios += empleado[i].getSalario();
        }

        double salarioPromedio = sumaSalarios / cantidad;
        System.out.printf("El salario promedio es: %.2f\n", salarioPromedio);

        System.out.print("Ingrese el porcentaje de aumento salarial: ");
        double porcentajeAumento = tcl.nextDouble();

        System.out.println("\nAplicando aumento salarial a empleados con salario menor al promedio...");
        for (int i = 0; i < cantidad; i++) {
            if (empleado[i].getSalario() < salarioPromedio) {
                double aumento = empleado[i].getSalario() * (porcentajeAumento / 100);
                empleado[i].setSalario(empleado[i].getSalario() + aumento);
                System.out.println("Nuevo salario de " + empleado[i].getNombre() + ": $" + String.format("%.2f", empleado[i].getSalario()));
            }
        }
    }
}
class Empleado{
    public String nombre;
    public double salario;
    public int edad;
    public Empleado() {
    }
    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double getSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", edad=" + edad + '}';
    }
    
}