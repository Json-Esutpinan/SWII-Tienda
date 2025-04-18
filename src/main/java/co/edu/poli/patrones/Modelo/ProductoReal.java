package co.edu.poli.patrones.Modelo;

public class ProductoReal implements Producto {
    
    private String descripcion;
    private double precio;
    private Proveedor proveedor;
    private String idProveedor;

    public ProductoReal(String descripcion, double precio, Proveedor proveedor) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.idProveedor = proveedor.getId();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdProveedor() {
        return idProveedor;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public String obenerDetalles() {
        return "Producto: " + this.descripcion + ", Precio: " + this.precio + ", Proveedor: " + this.proveedor.getNombreEmpresa() + ", Contacto: " + this.proveedor.getContacto();
    }

}