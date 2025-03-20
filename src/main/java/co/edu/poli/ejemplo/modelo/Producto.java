package co.edu.poli.ejemplo.modelo;

/**
 * Clase producto
 * @autor jeiso
 */
public abstract class Producto{

    private String id;
    private String descripcion;
    private double precio;
    
    /**
     * Método Construtor
<<<<<<< HEAD
     * @param id String
     * @param descripcion String
     * @param precio  String
=======
     * @param id
     * @param descripcion
     * @param precio 
>>>>>>> e7f05925ef0a7813e92fde4f75d35f0dcab8b658
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
<<<<<<< HEAD
     * @param descripcion  String
=======
     * @param descripcion 
>>>>>>> e7f05925ef0a7813e92fde4f75d35f0dcab8b658
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