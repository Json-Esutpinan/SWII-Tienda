package co.edu.poli.patrones.Modelo;

public class ProductoReal implements Producto {
    
    private String descripcion;
    private double precio;

    public ProductoReal(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }


    /**
     * @return
     */
    public String obenerDetalles() {
        return "Producto: " + this.descripcion + ", Precio: " + this.precio;
    }

}