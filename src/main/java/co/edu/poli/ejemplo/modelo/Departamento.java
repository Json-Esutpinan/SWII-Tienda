package co.edu.poli.ejemplo.modelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un departamento en la empresa.
 * Implementa la interfaz ComponenteDepartamento.
 */
public class Departamento implements ComponenteDepartamento {

    private String nombre;
    private List<ComponenteDepartamento> componentes = new ArrayList<>();
    
    /**
     * Constructor de la clase Departamento.
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para agregar un componente al departamento.
     * @param componente Componente a agregar.
     */
    public void agregarComponente(ComponenteDepartamento componente) {
        this.componentes.add(componente);
    }

    /**
     * Método para eliminar un componente del departamento.
     * @param componente Componente a eliminar.
     */
    public void eliminarComponente(ComponenteDepartamento componente) {
        this.componentes.remove(componente);
    }

    /**
     * Método para obtener los detalles del departamento.
     */
    @Override
    public void mostrarDeatalles() {
        System.out.println("Departamento: " + nombre);
        for (ComponenteDepartamento componente : componentes) {
            componente.mostrarDeatalles();
        }
    }

}