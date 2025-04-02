package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaLigera extends Mercancia {

    public CargaLigera(Envio envio, double peso) {
        super(envio, peso);
    }

    @Override
    public double calcularCosto(double peso) {
        return peso * 2;
    }
}