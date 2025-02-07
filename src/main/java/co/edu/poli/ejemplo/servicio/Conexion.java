package co.edu.poli.ejemplo.servicio;
import java.sql.*;

public class Conexion {
    private static final String db_url = System.getenv("DB_URL")+"tienda"+"?serverTimezone=America/Bogota";
    private static final String db_user = System.getenv("DB_USER");
    private static final String pass = System.getenv("DB_PASS");
    
    public static Connection getConnection(){
         Connection connection= null;
         try{
            connection = DriverManager.getConnection(db_url, db_user, pass);
         }catch(SQLException e){
             System.out.println("Error: "+e);
         }
         return connection;
    }
    
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
     
    public static ResultSet executeQuery(Connection conn,String query, Object... params) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
