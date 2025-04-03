package co.edu.poli.ejemplo.modelo;

public class CarritoConcreto implements CarritoCompras {

    private double total;
    private String descripcion;

    public CarritoConcreto(double total, String descripcion) {
        this.total = total;
        this.descripcion = descripcion;
    }

    public double calcularTotal() {
        return this.total;
    }

    public String obtenerDescripcion() {
        return this.descripcion;
    }

}