
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
