package co.edu.poli.ejemplo.servicio;

import co.edu.poli.ejemplo.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para la ejecución de consultas para el producto
 */
public class ProductoDAO implements CustomQuery<Producto> {

    private Conexion DBinstance;
    private Connection cursor;
    private PreparedStatement stmt;
    private ResultSet rs;

    /**
     * Default constructor
     * Obtener la conexión a la base de datos
     */
    public ProductoDAO() throws SQLException {
        this.DBinstance = Conexion.getInstancia();
        this.cursor = DBinstance.getConexion();
    }

    /**
     * Método para crear un producto en la Base de datos
     * 
     * @param Producto obj
     * @return String
     */
    @Override
    public String create(Producto obj) throws SQLException {
        String sql = "INSERT INTO producto(idProducto, descripcion, precio) VALUES (?,?,?)";
        this.stmt = this.cursor.prepareStatement(sql);
        this.stmt.setObject(1, obj.getId());
        this.stmt.setObject(2, obj.getDescripcion());
        this.stmt.setObject(3, obj.getPrecio());
        this.stmt.executeUpdate();
        return "Registro agregado correctamente";
    }

    /**
     * @return
     */
    @Override
    public List<Producto> readAll() throws SQLException {
        List<Producto> listaProducto = new ArrayList<>();
        String sql = "SELECT * FROM producto;";
        this.stmt = this.cursor.prepareStatement(sql);
        this.rs = this.stmt.executeQuery();
        while (this.rs.next()) {
            Producto prod = new Producto(this.rs.getString("idProducto"), this.rs.getString("descripcion"),
                    this.rs.getDouble("precio"));
            listaProducto.add(prod);
        }
        return listaProducto;
    }

    @Override
    public Producto readById(String id) throws SQLException {
        String sql = "SELECT * FROM producto WHERE idProducto = ?;";
        Producto prod = null;
        this.stmt = this.cursor.prepareStatement(sql);
        this.stmt.setString(1, id);
        this.rs = this.stmt.executeQuery();
        if (this.rs.next()) {
            prod = new Producto(this.rs.getString("idProducto"), this.rs.getString("descripcion"),
                    this.rs.getDouble("precio"));
        }
        return prod;
    }

    @Override
    public String update(String id, Producto obj) throws SQLException {
        String sql = "UPDATE producto SET descripcion = ?, precio ? WHERE idProducto = ?";
        int row = 0;
        if (this.readById(id) != null) {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, obj.getDescripcion());
            this.stmt.setDouble(2, obj.getPrecio());
            this.stmt.setString(3, id);
            row = this.stmt.executeUpdate();
            if (row > 0) {
                return "Actualizado correctamente";
            } else {
                return "No se pudo actualizar el producto";
            }
        } else {
            return "El cliente no existe";
        }
    }

    @Override
    public Producto delete(String id) throws SQLException {
        int row = 0;
        Producto prod = this.readById(id);
        String sql = "DELETE FROM producto WWHERE idProducto = ?";
        if (prod == null) {
            System.out.println("No existe el producto con ID: " + id + ", no se eliminó ningún registro");
        } else {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, id);
            row = this.stmt.executeUpdate();
            if (row > 0) {
                return prod;
            }
            this.stmt.close();
        }
        return prod;
    }

    @Override
    public List<Producto> queryDML(String sql, Object... params) throws SQLException {
        List<Producto> listaProductos = null;
        this.stmt = this.cursor.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            this.stmt.setObject(i + 1, params[i]);
        }
        this.rs = this.stmt.executeQuery();
        listaProductos = new ArrayList<>();
        while (this.rs.next()) {
            listaProductos.add(new Producto(this.rs.getString("idProducto"), this.rs.getString("descripcion"),
                    this.rs.getDouble("precio")));
        }
        return listaProductos;
    }
}