package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaPesada extends Mercancia {

    public CargaPesada(Envio envio, double peso) {
        super(envio, peso);
    }

    @Override
    public double calcularCosto(double peso) {
        
        return peso * 3;
    }
}