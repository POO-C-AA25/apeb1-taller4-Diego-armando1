
import java.util.Scanner;

public class Problema1_EjecutorProducto {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        double precio;
        int cantidad;
        System.out.print("Ingrese el precio del producto: ");
        precio = tcl.nextDouble();
        System.out.print("Ingrese la cantidad de productos: ");
        cantidad = tcl.nextInt();
        Producto producto1 = new Producto(precio, cantidad);
        producto1.calcularDescuento(producto1.precioP, producto1.cantidadP);
        producto1.calcularPrecioFinal();
        System.out.println(producto1);
    }
}

class Producto {

    public double precioP;
    public int cantidadP;
    public double descuento;
    public double precioFinal;
    public double montoDescuento;

    public Producto() {
    }

    public Producto(double precioP, int cantidadP) {
        this.precioP = precioP;
        this.cantidadP = cantidadP;
    }

    public double calcularDescuento(double precioP, int cantidadP) {
        if (this.precioP >= 1000 && this.cantidadP >= 10) {
            this.descuento = 10;
        } else {
            if (this.precioP < 1000) {
                this.descuento = 5;
            } else {
                this.descuento = 0;
            }
        }
        return this.montoDescuento = (this.cantidadP * this.precioP) * (this.descuento / 100);
    }

    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadP * this.precioP) - this.montoDescuento;
        return this.precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" + "precioP=" + precioP + ", cantidadP=" + cantidadP + ", descuento=" + descuento + ", precioFinal=" + precioFinal + ", montoDescuento=" + montoDescuento + '}';
    }

}
