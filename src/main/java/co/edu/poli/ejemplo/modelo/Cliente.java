package co.edu.poli.ejemplo.modelo;

public class Cliente {

    private String id;
    private String nombre;
    /**
     * Constructor de la clase Cliente, recibe dos parámetros del tipo String
     * @param id String
     * @param nombre String
     */
    public Cliente(String id, String nombre) {    
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Generación de constructor vacío para instanciar al cliente.
     */
    public Cliente() {
    }

    /**
     * Obtener el id del Cliente
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Cambiar el id del cliente
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtener el nombbre del cliente
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre del cliente
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener los datos del Cliente en un formato compacto
     * @return String
     */
    @Override
    public String toString() {
        return "{" + "Id= " + id + ", Nombre= " + nombre + '}';
    }
}