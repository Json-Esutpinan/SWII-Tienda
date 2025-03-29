package co.edu.poli.ejemplo.modelo;

public class PoliticaEntrega {

    private String descripcion;

    public PoliticaEntrega(String desc) {
        this.descripcion = desc;
    }

    @Override
    public String toString() {
        return "PoliticaEntrega [descripcion=" + this.descripcion + "]";
    }

}