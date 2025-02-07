package co.edu.poli.ejemplo.modelo;

/**
 * Clase producto
 */
public class Producto {
    
    private String id;
    private String descripcion;
    private double precio;
    
    public Producto(String id, String descripcion, double precio) {    
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "\n{" + "Id= " + id + ", Descripcion= " + descripcion + ", Precio= " + precio + "} \n";
    }
    

}