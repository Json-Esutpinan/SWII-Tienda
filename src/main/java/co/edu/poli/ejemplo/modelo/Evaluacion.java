package co.edu.poli.ejemplo.modelo;

public class Evaluacion {

    public Evaluacion(String desc){
        this.descripcion = desc;
    }

    private String descripcion;

    @Override
    public String toString() {
        return "Evaluacion [descripcion=" + descripcion + "]";
    }

    

}