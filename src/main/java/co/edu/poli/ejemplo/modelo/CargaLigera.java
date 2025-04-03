package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaLigera extends Mercancia {
    private double peso;
    public CargaLigera(Envio envio, double peso) {
        super(envio);
        this.peso = peso;
    }

    @Override
    public double calcularCosto() {
        return  this.peso * 2;
    }
}