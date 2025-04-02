package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Documento extends Mercancia {

    /**
     * Default constructor
     */
    public Documento(Envio envio, double peso) {
        super(envio, peso);
        
    }

    @Override
    public double calcularCosto(double peso) {
        return peso * 1;
    }

}