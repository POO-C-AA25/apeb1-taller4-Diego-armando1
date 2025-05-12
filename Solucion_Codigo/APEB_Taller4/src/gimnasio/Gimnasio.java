
package gimnasio;
public class Gimnasio {
    public Cliente[] clientes;
    public int cantidadClientes;
    public Gimnasio() {
    }
    public Gimnasio(int maxClientes) {
        clientes = new Cliente[maxClientes];
        this.cantidadClientes = 0;
    }
    public boolean registrarCliente(Cliente cliente) {
        if (this.cantidadClientes < this.clientes.length) {
            this.clientes[this.cantidadClientes] = cliente;
            this.cantidadClientes++;
            return true;
        } else {
            System.out.println("No hay más espacio para registrar clientes.");
            return false;
        }
    }
    public void mostrarResumen() {
        int totalCompletados = 0;
        int totalDuracion = 0;
        System.out.println("\n=== Registro de Clientes ===");
        for (int i = 0; i < this.cantidadClientes; i++) {
            Cliente c = this.clientes[i];
            System.out.println(c);
            totalDuracion += c.duracion;
            if (c.rutinaCompletada) {
                totalCompletados++;
            }
        }
        double promedioTiempo = (this.cantidadClientes > 0) ? (double) totalDuracion / this.cantidadClientes : 0;

        System.out.println("\n=== Resumen del Día ===");
        System.out.println("Clientes que completaron su rutina: " + totalCompletados);
        System.out.println("Tiempo promedio invertido: " + String.format("%.2f", promedioTiempo) + " minutos");
    }
}
