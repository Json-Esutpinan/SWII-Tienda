package co.edu.poli.patrones.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ClienteFacade {

    private Cliente infoCliente;
    private Pedido infoPedido;
    private MetodoPago infoMetodoPago;
    private List<Pedido> listaPedidos = new ArrayList<>();
    private List<MetodoPago> listaMetodosPago = new ArrayList<>();
    
    public ClienteFacade( Cliente infoCliente, Pedido infoPedido, MetodoPago infoMetodoPago) {
        this.listaMetodosPago.add(infoMetodoPago);
        this.listaPedidos.add(infoPedido);
        this.infoCliente = infoCliente;
        this.infoPedido = infoPedido;
        this.infoMetodoPago = infoMetodoPago;
    }

    public String obtenerDatosCli() {
        return infoCliente.toString();
    }

    public Cliente actualizarDatosCli(String nombre, String apellido) {
        infoCliente.setApellido(apellido);
        infoCliente.setNombre(nombre);
        return infoCliente;
    }

    public List<Pedido> mostrarPedidos() {
        return this.listaPedidos;
    }

    public void hacerPedido(String id, Cliente cliente, List<ProductoReal> productos) {
        List<ProductoReal> copia = new ArrayList<>(productos);
        hitorialPedidos(new Pedido(id, cliente, copia));
    }

    public void hitorialPedidos(Pedido pedido) {
        this.listaPedidos.add(pedido);
    }

    public List<MetodoPago> verMetodoPago() {
        return this.listaMetodosPago;
    }

    public void agregarMetodoPago(MetodoPago metodo) {
        MetodoPago nuevoMetodo = new MetodoPago(metodo.getDescripcion(), metodo.isEstado());
        this.listaMetodosPago.add(nuevoMetodo);
    }

    public String activarMetodoPago(MetodoPago metodo) {
        if(this.listaMetodosPago.contains(metodo)){
            metodo.setEstado(true);
            return "Activado";
        }
        return "Metodo de pago no encontrado";
    }

    public String bloquearMetodoPago(MetodoPago metodo) {
        if(this.listaMetodosPago.contains(metodo)){
            metodo.setEstado(false);
            return "Bloqueado";
        }
        return "Metodo de pago no encontrado";
    }

}