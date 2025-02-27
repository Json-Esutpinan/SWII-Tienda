package co.edu.poli.ejemplo.servicio;

import java.util.List;
import co.edu.poli.ejemplo.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servicio para la ejecución de consultas para el cliente
 */
public class ClienteDAO implements CrudDAO<Cliente> {

    private Conexion DBinstance;
    private Connection cursor;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDAO() throws SQLException{
        this.DBinstance = Conexion.getInstancia();
        this.cursor = DBinstance.getConexion();
    }

    @Override
    public String create(Cliente obj) throws SQLException {
        String sql = "INSERT INTO cliente(idCliente, nombre) VALUES (?,?)";
        this.stmt = this.cursor.prepareStatement(sql);
        this.stmt.setString(1, obj.getId());
        this.stmt.setString(2, obj.getNombre());
        this.stmt.executeUpdate();
        return "Agregado";
    }

    @Override
    public List<Cliente> readAll() throws SQLException {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";
        this.stmt = this.cursor.prepareStatement(sql);
        this.rs = this.stmt.executeQuery();
        while (this.rs.next()) {
            Cliente cliente = new Cliente(this.rs.getString("idCliente"), this.rs.getString("nombre"));
            listaCliente.add(cliente);
        }
        return listaCliente;
    }

    @Override
    public Cliente readById(String id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?;";
        Cliente cliente = null;
        this.stmt = this.cursor.prepareStatement(sql);
        this.stmt.setString(1, id);
        this.rs = this.stmt.executeQuery();
        if (this.rs.next()) {
            cliente = new Cliente(this.rs.getString("idCliente"), this.rs.getString("nombre"));
        }
        return cliente;
    }

    @Override
    public String update(String id, Cliente obj) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ? WHERE idCliente = ?";
        int row = 0;
        if (this.readById(id) != null) {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, obj.getNombre());
            this.stmt.setString(2, id);
            row = this.stmt.executeUpdate();
            if (row > 0) {
                return "Actualizado";
            } else {
                return "No se pudo actualizar el cliente";
            }
        } else {
            return "El cliente no existe";
        }
    }

    @Override
    public Cliente delete(String id) throws SQLException {
        int row = 0;
        Cliente cli = null;
        cli = this.readById(id);
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        if (cli == null) {
            return cli;
        } else {
            this.stmt = this.cursor.prepareStatement(sql);
            this.stmt.setString(1, id);
            row = this.stmt.executeUpdate();
            if (row > 0) {
                return cli;
            }
        }
        return cli;
    }
}
