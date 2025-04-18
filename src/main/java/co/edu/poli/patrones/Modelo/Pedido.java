package co.edu.poli.patrones.Modelo;

import java.util.List;

public class Pedido{

    private Cliente cliente;
    private String descripcion;
    private double precio;
    private List<ProductoReal> listaProductos;
    
    public Pedido( Cliente cliente, String descripcion, double precio, List<ProductoReal> listaProductos) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.precio = precio;
        this.listaProductos = listaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ProductoReal> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoReal> listaProductos) {
        this.listaProductos = listaProductos;
    }

}