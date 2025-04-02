package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Internacional implements Envio {

    /**
     * Default constructor
     */
    public Internacional() {
    }

    /**
     * @param String direccion
     */
    @Override
    public String enviar(String direccion) {
        return "Enviando internacionalmente a la dirección: " + direccion;
    }

}