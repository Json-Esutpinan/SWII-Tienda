package co.edu.poli.ejemplo.modelo;

public class Express implements Envio {

    public Express() {
    }

    @Override
    public String enviar(String direccion) {
        return "Envío express a " + direccion + " con entrega en 24 horas.";
    }
    
}
