package co.edu.poli.ejemplo.servicio;

import java.sql.*;

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
     */
    private Conexion() {
        try {
            // Obtener datos de conexión de variables de entorno
            String url = System.getenv("DB_URL")+"tienda"+"?serverTimezone=America/Bogota";
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASS");

            // Establecer la conexión
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a MySQL establecida.");

        } catch (SQLException e) {
            System.err.println("Error al conectar a MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método estático para obtener la instancia de la clase
     * @return Conexion
     */
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Obtiene la conexión a la base de datos
     * @return Connection
     */
    @SuppressWarnings("exports")
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Cierra la conexión a la base de datos
     */
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión a MySQL cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
