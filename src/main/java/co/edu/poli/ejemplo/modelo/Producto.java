package co.edu.poli.ejemplo.modelo;

/**
 * Clase producto
 */
public class Producto {
    
    private String id;
    private String descripcion;
    private double precio;
    
    /**
     * Método Construtor
     * @param id
     * @param descripcion
     * @param precio 
     */
    public Producto(String id, String descripcion, double precio) {    
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    

    /**
     * Constructor para instanciar sin parámetros
     */
    public Producto() {
    }
    
    /**
     * Obtiene el id del producto.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Cambia el id del producto.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la descripción del producto que puede ser el nombre.
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción del producto
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio del producto
     * @param precio double
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Retorna en formato String los detalles del producto.
     * @return 
     */
    @Override
    public String toString() {
        return "\n{" + "Id= " + id + ", Descripcion= " + descripcion + ", Precio= " + precio + "} \n";
    }
    

}