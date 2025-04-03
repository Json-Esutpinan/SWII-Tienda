package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaPesada extends Mercancia {
    private double peso;
    public CargaPesada(Envio envio, double peso) {
        super(envio);
        this.peso = peso;
    }

    @Override
    public double calcularCosto() {
        return this.peso * 3;
    }
}