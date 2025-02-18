package co.edu.poli.ejemplo.servicio;

import co.edu.poli.ejemplo.modelo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para la ejecución de consultas para el producto
 */
public class ProductoService {
    
    private Producto producto;
    private Connection conn;
    private String query;
    private ResultSet rs;

    /**
     * Constructor para iniciar la conexión con la base de datos
     */
    public ProductoService() {
        try {
            this.conn = Conexion.getConnection();
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
    
    /**
     * Método para agregar al producto, si no se agrega, retorna falso
     * @param producto
     * @return 
     */
    public boolean insertProducto(Producto producto){
        boolean agregado = false;
        int registroAgregado=0;
        try {
            this.query = "INSERT INTO producto VALUES ('?','?',?)";
            registroAgregado = Conexion.executeUpdate(this.conn, this.query, producto.getId(),producto.getDescripcion(),producto.getPrecio());
            agregado = registroAgregado >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return agregado;
    }
    
    /**
     * Obtener todos los productos de la base de datos.
     * @return List<Producto>
     */
    public List<Producto> getProducto(){
        List<Producto> listaProducto = new ArrayList();
        try {
            this.query = "SELECT * FROM producto";
            this.rs = Conexion.executeQuery(conn, query, null);
            while(rs.next()){
                this.producto = new Producto(rs.getString("idProducto"),rs.getString("descripcion"), rs.getDouble("precio"));
                listaProducto.add(this.producto);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaProducto;
    }
    
    /**
     * Obtener el producto según el id
     * @param id
     * @return Producto
     */
    public Producto getProductoById(String id){
        this.producto = new Producto();
        try {
            this.query = "SELECT * FROM producto WHERE idProducto = ?";
            this.rs = Conexion.executeQuery(this.conn, this.query, id);
            while(rs.next()){
                this.producto.setId(rs.getString("idProducto"));
                this.producto.setDescripcion(rs.getString("descripcion"));
                this.producto.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return this.producto;
    }
    
    /**
     * Método para eliminar el producto según el id.
     * @param id 
     */
    public boolean deleteProduct(String id){
        boolean eliminado = false;
        int registrosEliminados=0;
        try {
            this.query = "DELETE FROM producto WHERE idProducto = ?";
            registrosEliminados = Conexion.executeUpdate(this.conn, this.query, id);
            eliminado = registrosEliminados >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return eliminado;
    }
    
    /**
     * Método para actualizar el producto
     * @param clinte Producto
     * @return 
     */
    public boolean updatepRODUCTO(Producto producto){
        boolean actualizado = false;
        int registroActualizado=0;
        try {
            this.query = "UPDATE producto SET descripcion = ?, precio= ? WHERE idProducto = ?";
            registroActualizado= Conexion.executeUpdate(this.conn, this.query, producto.getDescripcion(), producto.getPrecio(), producto.getId());
            actualizado = registroActualizado >0;
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return actualizado;
    }
    
}
