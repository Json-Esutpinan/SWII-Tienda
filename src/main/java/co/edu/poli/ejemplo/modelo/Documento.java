package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Documento extends Mercancia {

    private double peso;
    /**
     * Default constructor
     */
    public Documento(Envio envio, double peso) {
        super(envio);
        this.peso = peso;
        
    }

    @Override
    public double calcularCosto() {
        return this.peso * 1;
    }

}