package co.edu.poli.ejemplo.modelo;

/* 
 * Adaptador para el método de pago Nequi
 */
public class NequiAdapter implements MedioDePago {
    private Nequi nequi;
    
    /**
     * Constructor de la clase NequiAdapter
     * @param nequi El objeto Nequi a adaptar
     */
    public NequiAdapter(Nequi nequi) {
        this.nequi = nequi;
    }
    /**
     * Método para realizar el pago con Nequi
     * @param total El total a pagar
     */
    @Override
    public String realizarPago(double total) {
        String mensaje = nequi.pagar(total);
        return mensaje;
    }

}