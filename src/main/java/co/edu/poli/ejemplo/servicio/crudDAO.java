package co.edu.poli.ejemplo.servicio;

import java.util.List;

/**
 * Método CRUD General
 * @author jeiso
 */
public interface crudDAO <T>{
    /**
     * Método para crear un registro en la base de datos
     * @param obj Se debe especificar la clase
     * @return T
     */
    public String create(T obj);
    
    /**
     * Método para leer todos los registros de la base de datos del objeto que se especifique
     * @return List<T>
     */
    public List<T> readAll();
    
    /**
     * Método para buscar un registro específico en la base de datos
     * @param id String
     * @return Object type T
     */
    public T readById(String id);
    
    /**
     * Método para actualzar un registro en la base de datos
     * @param id String
     * @param obj T
     * @return T
     */
    public String update(String id, T obj);
    
    /**
     * Método para eliminar un registro
     * @param id String
     * @return T
     */
    public T delete(String id);
    
}
