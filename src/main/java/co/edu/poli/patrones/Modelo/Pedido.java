package co.edu.poli.patrones.Modelo;

import java.util.List;

public class Pedido{

    private String id;
    private Cliente cliente;
    private double total;
    private List<ProductoReal> listaProductos;
    
    public Pedido(String id, Cliente cliente, List<ProductoReal> listaProductos) {
        this.id = id;
        this.cliente = cliente;
        this.total = listaProductos.stream().mapToDouble(ProductoReal::getPrecio).sum();
        this.listaProductos = listaProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<ProductoReal> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoReal> listaProductos) {
        this.listaProductos = listaProductos;
    }

}