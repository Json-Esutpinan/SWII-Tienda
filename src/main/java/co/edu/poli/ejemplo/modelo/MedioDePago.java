package co.edu.poli.ejemplo.modelo;
/**
 * Interfaz que define el método para realizar un pago.
 */
public interface MedioDePago {

    /**
     * @param double total
     * @return Mensaje de pago realizado
     */
    public String realizarPago(double total);

}