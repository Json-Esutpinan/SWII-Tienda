package co.edu.poli.ejemplo.modelo;
/**
 * Clase para el método de pago Nequi
 */
public class Nequi {

    /**
     * Default constructor
     */
    public Nequi() {
    }

    /**
     * Método para realizar el pago con Nequi
     * @param total El total a pagar
     * @return Un mensaje indicando el pago realizado
     */
    public String pagar(double total) {
        return "Pago por Nequi por un total de: " + total;
    }

}