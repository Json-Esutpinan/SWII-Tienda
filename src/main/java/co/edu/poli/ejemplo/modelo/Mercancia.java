package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public abstract class Mercancia {

    private double peso;
    private Envio envio;
    
    public Mercancia(Envio envio, double peso) {
        this.envio = envio;
        this.peso = peso;
    }
    
    public abstract double calcularCosto(double peso);

    public String enviar(String direccion) {
        return envio.enviar(direccion);
    }
}