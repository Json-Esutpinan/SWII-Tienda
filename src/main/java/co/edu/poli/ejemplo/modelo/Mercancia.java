package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public abstract class Mercancia {
    
    private Envio envio;
    
    public Mercancia(Envio envio) {
        this.envio = envio;
    }
    
    public abstract double calcularCosto();

    public String enviar(String direccion) {
        return envio.enviar(direccion);
    }
}