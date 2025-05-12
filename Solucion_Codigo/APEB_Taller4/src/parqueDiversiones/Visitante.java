package parqueDiversiones;

public class Visitante {

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
