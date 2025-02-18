package co.edu.poli.ejemplo.servicio;

import co.edu.poli.ejemplo.modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para la ejecución de consultas para el cliente
 */
public class ClienteService {
    
    private Cliente cliente;
    private Connection conn;
    private String query;
    private ResultSet rs;

    /**
     * Constructor para iniciar la conexión con la base de datos
     */
    public ClienteService() {
        try {
            this.conn = Conexion.getConnection();
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
    
    /**
     * Método para agregar un cliente a la base de datos.
     * @param cliente
     * @return 
     */
    public boolean insertCliente(Cliente cliente){
        boolean agregado = false;
        int registroAgregado=0;
        try {
            this.query = "INSERT INTO cliente VALUES ('?','?')";
            registroAgregado = Conexion.executeUpdate(this.conn, this.query, cliente.getId(),cliente.getNombre());
            agregado = registroAgregado >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return agregado;
    }
    
    /**
     * Obtener todos los clientes de la base de datos.
     * @return List<Cliente>
     */
    public List<Cliente> getCliente(){
        List<Cliente> listaClientes = new ArrayList();
        try {
            this.query = "SELECT * FROM CLIENTE";
            this.rs = Conexion.executeQuery(conn, query, null);
            while(rs.next()){
                this.cliente = new Cliente(rs.getString("idCliente"),rs.getString("nombre"));
                listaClientes.add(this.cliente);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaClientes;
    }
    
    /**
     * Obtener el cliente según el id
     * @param id
     * @return Cliente
     */
    public Cliente getClienteById(String id){
        this.cliente = new Cliente();
        try {
            this.query = "SELECT * FROM cliente WHERE idCliente = ?";
            this.rs = Conexion.executeQuery(this.conn, this.query, id);
            while(rs.next()){
                this.cliente.setId(rs.getString("idCliente"));
                this.cliente.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return this.cliente;
    }
    
    /**
     * Método para eliminar el cliente según el id.
     * @param id 
     */
    public boolean deleteCliente(String id){
        boolean eliminado = false;
        int registrosEliminados=0;
        try {
            this.query = "DELETE FROM cliente WHERE idCliente = ?";
            registrosEliminados = Conexion.executeUpdate(this.conn, this.query, id);
            eliminado = registrosEliminados >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return eliminado;
    }
    
    /**
     * Método para actualizar el cliente
     * @param clinte Cliente
     * @return 
     */
    public boolean updateCliente(Cliente cliente){
        boolean actualizado = false;
        int registroActualizado=0;
        try {
            this.query = "UPDATE cliente SET nombre = ? WHERE idCliente = ?";
            registroActualizado= Conexion.executeUpdate(this.conn, this.query, cliente.getNombre(), cliente.getId());
            actualizado = registroActualizado >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return actualizado;
    }
    
}
