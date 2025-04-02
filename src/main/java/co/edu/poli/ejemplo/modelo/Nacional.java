package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Nacional implements Envio {

    /**
     * Default constructor
     */
    public Nacional() {
    }

    /**
     * @param String direccion
     */
    @Override
    public String enviar(String direccion) {
        return "Enviando nacionalmente a la dirección: " + direccion;
    }

}