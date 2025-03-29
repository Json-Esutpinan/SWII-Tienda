package co.edu.poli.ejemplo.modelo;
/**
 * Adaptador para el método de pago Paypal
 */

public class PaypalAdpater implements MedioDePago {

    private Paypal paypal;

    public PaypalAdpater(Paypal paypal) {
        this.paypal = paypal;
    }


    @Override
    public String realizarPago(double total) {
        String mensaje = paypal.pagar(total);
        return mensaje;
    }

}