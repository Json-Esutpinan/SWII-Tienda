package co.edu.poli.Modelo;

import java.util.Date;

public class Memento {
    private final String id;
    private final String nombre;
    private final String descripcion;
    private final double precio;
    private final Date modificado;

    public Memento(String id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.modificado = new Date();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getModificado() {
        return modificado;
    }
}