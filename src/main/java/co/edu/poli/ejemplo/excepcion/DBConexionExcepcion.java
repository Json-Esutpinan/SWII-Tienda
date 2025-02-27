package co.edu.poli.ejemplo.excepcion;

public class DBConexionExcepcion extends Exception {
    public DBConexionExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public DBConexionExcepcion(String message) {
        super(message);
    }
}