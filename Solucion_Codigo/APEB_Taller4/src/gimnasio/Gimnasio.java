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
            return false;
        }
    }

    public Cliente[] obtenerClientes() {
        return clientes;
    }

    public int obtenerCantidadClientes() {
        return cantidadClientes;
    }

    public int completaronRutina() {
        int total = 0;
        for (int i = 0; i < this.cantidadClientes; i++) {
            if (clientes[i].rutinaCompletada) {
                total++;
            }
        }
        return total;
    }

    public double calcularTiempoPromedio() {
        if (cantidadClientes == 0) {
            return 0;
        }
        int suma = 0;
        for (int i = 0; i < cantidadClientes; i++) {
            suma += clientes[i].duracion;
        }
        return (double) suma / cantidadClientes;
    }
}
