package co.edu.poli.ejemplo.servicio;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Singleton para la conexión a la base de datos
 *
 * @author jeiso
 */
public class Conexion {
    private static Conexion instancia;
    private Connection conexion;

    /**
     * Constructor default privado para establecer la conexión
     * 
     * @throws SQLException
     */
    private Conexion() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());
        String url = rb.getString("database.url");
        String user = rb.getString("database.user");
        String password = rb.getString("database.password");
        conexion = DriverManager.getConnection(url, user, password);
    }

    /**
     * Método estático para obtener la instancia de la clase
     * 
     * @return Conexion
     * @throws SQLException
     */
    public static Conexion getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Obtiene la conexión a la base de datos
     * 
     * @return Connection
     */
    @SuppressWarnings("exports")
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Cierra la conexión a la base de datos
     */
    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
