package co.edu.poli.Modelo;

import java.util.*;

public class Producto extends Subject implements Observer {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String fechaCreacion;
    private Map<String, List<Memento>> mementos = new HashMap<>();

    public Producto(String id, String nombre, String descripcion, double precio, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        guardarEstado();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Map<String, List<Memento>> getMementos() {
        return mementos;
    }

    public void setMementos(Map<String, List<Memento>> mementos) {
        this.mementos = mementos;
    }

    public Memento guardarEstado() {
        Memento estado = new Memento(id, nombre, descripcion, precio);
        mementos.computeIfAbsent(id, k -> new ArrayList<>()).add(estado);
        return estado;
    }

    public void restaurar(int index) {
        List<Memento> historial = mementos.get(id);
        if (historial != null && historial.get(index) != null) {
            this.nombre = historial.get(index).getNombre();
            this.descripcion = historial.get(index).getDescripcion();
            this.precio = historial.get(index).getPrecio();
        }
    }
    
    public List<Memento> obtenerHistorial() {
        return mementos.getOrDefault(id, new ArrayList<>());
    }

    @Override
    public void actualizarPrecio(double porcentaje) {
        double descuento = precio * (porcentaje / 100.0);
        precio -= descuento;
        guardarEstado();
    }

}
