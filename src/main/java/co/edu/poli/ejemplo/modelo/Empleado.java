package co.edu.poli.ejemplo.modelo;

/**
 * Clase que representa un empleado en la empresa.
 * Implementa la interfaz ComponenteDepartamento.
 */
public class Empleado implements ComponenteDepartamento {

    private String nombre;
    private String cargo;

    /**
     * Constructor de la clase Empleado.
     *
     * @param nombre Nombre del empleado.
     * @param cargo  Cargo del empleado.
     */
    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    /**
     * Método que muestra los detalles del empleado.
     */
    @Override
    public void mostrarDeatalles() {
        System.out.println("Empleado: " + nombre + ", Cargo: " + cargo);
    }

}