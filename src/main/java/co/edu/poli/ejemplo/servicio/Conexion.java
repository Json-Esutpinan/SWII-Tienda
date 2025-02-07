package co.edu.poli.ejemplo.servicio;
import java.sql.*;

public class Conexion {
    private static final String db_url = System.getenv("DB_URL")+"tienda"+"?serverTimezone=America/Bogota";
    private static final String db_user = System.getenv("DB_USER");
    private static final String pass = System.getenv("DB_PASS");
    
    /**
     * Inicia la conexión con la base de datos
     * @return None
     */
    public static Connection getConnection(){
         Connection connection= null;
         try{
            connection = DriverManager.getConnection(db_url, db_user, pass);
         }catch(SQLException e){
             System.out.println("Error: "+e);
         }
         return connection;
    }
    
    /**
     * Cierra la conexión a la base de datos.
     * @param conn 
     */
     public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Método para ejecutar la consulta a la base de datos con los parámetros necesarios.
     * @param conn
     * @param query
     * @param params
     * @return 
     */
    public static ResultSet executeQuery(Connection conn, String query, Object... params) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            if(params == null){
                rs = stmt.executeQuery();
            }else{
                for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
        /**
         * Método para ejecutar actualizaciones o eliminaciones.
         * @param conn
         * @param query
         * @param params null
         * @return 
         */
        public static int executeUpdate(Connection conn, String query, Object... params) {
        int result = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            if(params == null){
                result = stmt.executeUpdate();
            }else{
                for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            result = stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
