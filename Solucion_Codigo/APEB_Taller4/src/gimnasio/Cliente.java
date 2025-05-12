package gimnasio;

public class Cliente {

    public String nombre;
    public String tipoEjercicio;
    public int duracion; 
    public boolean rutinaCompletada;

    public Cliente() {
    }

    public Cliente(String nombre, String tipoEjercicio, int duracion, boolean rutinaCompletada) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.rutinaCompletada = rutinaCompletada;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + this.nombre + '\'' +
                ", Tipo de Ejercicio='" + this.tipoEjercicio + '\'' +
                ", Duración=" + this.duracion + " minutos" +
                ", Rutina Completada=" + (this.rutinaCompletada ? "Sí" : "No") +
                '}';
    }
}
