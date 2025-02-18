package co.edu.poli.ejemplo.servicio;

import co.edu.poli.ejemplo.modelo.Pedido;
import co.edu.poli.ejemplo.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio para la ejecución de consultas para el producto
 */
public class ProductoDAO implements crudDAO <Producto>{

    private Conexion DBinstance;
    private Connection cursor;
    private PreparedStatement stmt;
    private ResultSet rs;
    /**
     * Default constructor
     * Obtener la conexión a la base de datos
     */
    public ProductoDAO() {
        this.DBinstance = Conexion.getInstancia();
        this.cursor = DBinstance.getConexion();
    }

    /**
     * Método para crear un producto en la Base de datos
     * @param Producto obj
     * @return String
     */
    @Override
    public String create(Producto obj) {
        String sql = "INSERT INTO producto(idProducto, descripcion, precio) VALUES (?,?,?)";
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setObject(1,obj.getId());
            this.stmt.setObject(2,obj.getDescripcion());
            this.stmt.setObject(3,obj.getPrecio());
            this.stmt.executeUpdate();
            return "Registro agregado correctamente";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    /**
     * @return
     */
        @Override
    public List<Producto> readAll() {
        List<Producto> listaProducto = new ArrayList<>();
        String sql = "SELECT * FROM producto;";
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            while (this.rs.next()) {
                Producto prod = new Producto(this.rs.getString("idProducto"), this.rs.getString("descripcion"), this.rs.getDouble("precio"));
                listaProducto.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                this.stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProducto;
    }

    @Override
    public Producto readById(String id) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?;";
        Producto prod = null;
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, id);
            this.rs = this.stmt.executeQuery();
            if (this.rs.next()) {
                prod = new Producto(this.rs.getString("idProducto"), this.rs.getString("descripcion"),this.rs.getDouble("precio"));
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                this.stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prod;
    }

    @Override
    public String update(String id, Producto obj) {
        String sql = "UPDATE producto SET descripcion = ?, precio ? WHERE idProducto = ?";
        int row = 0;
        if (this.readById(id) != null) {
            try {
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
            } catch (SQLException ex) {
                return "Error:" + ex.getMessage();
            } finally {
                try {
                    this.stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            return "El cliente no existe";
        }
    }

    @Override
    public Producto delete(String id) {
        int row = 0;
        Producto prod = this.readById(id);
        String sql = "DELETE FROM producto WWHERE idProducto = ?";
        if (prod == null) {
            System.out.println("No existe el producto con ID: " + id + ", no se eliminó ningún registro");
        } else {
            try {
                this.stmt = this.cursor.prepareStatement(sql);
                this.stmt.setString(1, id);
                row = this.stmt.executeUpdate();
                if (row > 0) {
                    return prod;
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                try {
                    this.stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return prod;
    }
}