package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Certificacion {

    private String descripcion;
    private String nombre;

    public Certificacion(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "[descripcion=" + descripcion + ", nombre=" + nombre + "]";
    }

    
}