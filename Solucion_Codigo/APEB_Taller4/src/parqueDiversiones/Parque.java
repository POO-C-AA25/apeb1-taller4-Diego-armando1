
package parqueDiversiones;
public class Parque {
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
            System.out.println("No hay más espacio para nuevos visitantes.");
            return false;
        }
    }

    public boolean puedeAcceder(Visitante visitante) {
        return visitante.edad >= 12 && visitante.altura >= 1.40;
    }

    public void mostrarAccesos() {
        for (int i = 0; i < this.cantidadVisitantes; i++) {
            Visitante v = this.visitantes[i];
            System.out.println(v);
            if (puedeAcceder(v)) {
                System.out.println("Puede acceder a todos los juegos.");
            } else {
                System.out.println("No puede acceder a todos los juegos.");
            }
            System.out.println(" ");
        }
    }

    public void mostrarResumen() {
        System.out.println("Total de visitantes que cumplen todos los requisitos: " + this.cumpleRequisitos);
    }
}

