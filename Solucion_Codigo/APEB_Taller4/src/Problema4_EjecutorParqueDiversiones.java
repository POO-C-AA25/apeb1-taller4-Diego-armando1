
import java.util.Scanner;
public class Problema4_EjecutorParqueDiversiones {
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
class Visitante {

    public String nombre;
    public int edad;
    public double altura;

    public Visitante() {
    }

    public Visitante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Visitante{"
                + "nombre='" + this.nombre + '\''
                + ", edad=" + this.edad
                + ", altura=" + this.altura
                + '}';
    }
}

class Parque {
    public Visitante[] visitantes;
    public int cantidadVisitantes;
    public int cumpleRequisitos;

    public Parque() {
    }

    public Parque(Visitante[] visitantes, int cantidadVisitantes, int cumpleRequisitos) {
        this.visitantes = visitantes;
        this.cantidadVisitantes = cantidadVisitantes;
        this.cumpleRequisitos = cumpleRequisitos;
    }
    public Parque(int maxVisitantes) {
        this.visitantes = new Visitante[maxVisitantes];
        this.cantidadVisitantes = 0;
        this.cumpleRequisitos = 0;
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (this.cantidadVisitantes < this.visitantes.length) {
            this.visitantes[this.cantidadVisitantes] = visitante;
            this.cantidadVisitantes++;

            if (puedeAcceder(visitante)) {
                this.cumpleRequisitos++;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean puedeAcceder(Visitante visitante) {
        return visitante.edad >= 12 && visitante.altura >= 1.40;
    }

    public String[] obtenerAcceso() {
        String[] accesos = new String[this.cantidadVisitantes];
        for (int i = 0; i < this.cantidadVisitantes; i++) {
            Visitante v = this.visitantes[i];
            if (puedeAcceder(v)){
                accesos[i] = v.toString() + "\nPuede acceder a tods los juegos.";
            }else{
                accesos[i] = v.toString() + "\nNo puede acceder a todos los juegos.";            }
        }
        return accesos;
    }
    public int cumpleRequesitos(){
        return this.cumpleRequisitos;
    }
}


