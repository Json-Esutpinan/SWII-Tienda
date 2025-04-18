package co.edu.poli.patrones.Modelo;

import java.util.List;

/**
 * 
 */
public class ClienteFacade {

    private Cliente infoCliente;
    private Pedido infoPedido;
    private MetodoPago infoMetodoPago;
    
    public ClienteFacade( Cliente infoCliente, Pedido infoPedido, MetodoPago infoMetodoPago) {
        this.infoCliente = infoCliente;
        this.infoPedido = infoPedido;
        this.infoMetodoPago = infoMetodoPago;
    }

    public String obtenerDatosCli() {
        return "";
    }

    public Cliente actualizarDatosCli(String nombre, String apellido) {
        return null;
    }

    public List<Pedido> mostrarPedidos() {
        return null;
    }

    public Pedido hacerPedido(Pedido pedido) {
        return null;
    }

    public List<MetodoPago> verMetodoPago() {
        return null;
    }

    public String activarMetodoPago(MetodoPago metodo) {
        return "";
    }

    public String bloquearMetodoPago(MetodoPago metodo) {
        return "";
    }

}