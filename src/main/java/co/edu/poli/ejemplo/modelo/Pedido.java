package co.edu.poli.ejemplo.modelo;
import java.util.*;

public class Pedido {

    private String numero;
    private String fecha;
    private Cliente cliente;
    private List<Producto> producto;
    
    /**
     * 
     * @param numero
     * @param fecha
     * @param cliente
     * @param producto 
     */
    public Pedido(String numero, String fecha, Cliente cliente, List<Producto> producto) {    
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
    }

    /**
     * Método constructor para iniciar el pedido sin variables
     */
    public Pedido() {
    }
    
    
    /**
     * Obtiene el número de pedido
     * @return String
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Cambiar el número del pedido
     * @param numero String
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la fecha en la que se creó el pedido.
     * Se utiliza un String debido a que no  se usa la fecha para operaciones.
     * @return String
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Cambia la fecha del pedido
     * @param fecha String
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene los datos del cliente
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Cambia los datos del cliente
     * @param cliente Cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la lista de los productos
     * @return 
     */
    public List<Producto> getProducto() {
        return producto;
    }

    /**
     * Cambia la lista de todos los productos del pedido.
     * @param producto 
     */
    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    /**
     * Retorna el pedido con todos sus detalles
     * @return String
     */
    @Override
    public String toString() {
        return "" + "Pedido Numero= " + numero + ", Fecha= " + fecha + ": \nCliente=" + cliente + ", \nProducto= " + producto + '}';
    }
    
}