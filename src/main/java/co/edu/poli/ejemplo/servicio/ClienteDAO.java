package co.edu.poli.ejemplo.servicio;

import java.util.List;
import co.edu.poli.ejemplo.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio para la ejecución de consultas para el cliente
 */
public class ClienteDAO implements crudDAO<Cliente> {

    private Conexion DBinstance;
    private Connection cursor;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDAO() {
        this.DBinstance = Conexion.getInstancia();
        this.cursor = DBinstance.getConexion();
    }
    
    @Override
    public String create(Cliente obj) {
        String sql = "INSERT INTO cliente(idCliente, nombre) VALUES (?,?)";
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, obj.getId());
            this.stmt.setString(2, obj.getNombre());
            this.stmt.executeUpdate();
            return "Agregado";
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            try {
                this.stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            while (this.rs.next()) {
                Cliente cliente = new Cliente(this.rs.getString("idCliente"), this.rs.getString("nombre"));
                listaCliente.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                this.stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCliente;
    }

    @Override
    public Cliente readById(String id) {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?;";
        Cliente cliente = null;
        try {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, id);
            this.rs = this.stmt.executeQuery();
            if (this.rs.next()) {
                cliente = new Cliente(this.rs.getString("idCliente"), this.rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                this.stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    @Override
    public String update(String id, Cliente obj) {
        String sql = "UPDATE cliente SET nombre = ? WHERE idCliente = ?";
        int row = 0;
        if (this.readById(id) != null) {
            try {
                this.stmt = this.cursor.prepareStatement(sql);
                this.stmt.setString(1, obj.getNombre());
                this.stmt.setString(2, id);
                row = this.stmt.executeUpdate();
                if (row > 0) {
                    return "Actualizado";
                } else {
                    return "No se pudo actualizar el cliente";
                }
            } catch (SQLException ex) {
                return "Error:" + ex.getMessage();
            } finally {
                try {
                    this.stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            return "El cliente no existe";
        }
    }

    @Override
    public Cliente delete(String id) {
        int row = 0;
        Cliente cli = null;
        cli = this.readById(id);
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        if (cli == null) {
            System.out.println("No existe el cliente con ID: " + id + ", no se eliminó ningún registro");
        } else {
            try {
                this.stmt = this.cursor.prepareStatement(sql);
                this.stmt.setString(1, id);
                row = this.stmt.executeUpdate();
                if (row > 0) {
                    return cli;
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                try {
                    this.stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cli;
    }
}
