package co.edu.poli.ejemplo.modelo;

public class PuntosCarritoDecorador extends CarritoDecorador {
    
    private int puntos;
    
    public PuntosCarritoDecorador(CarritoCompras carritoCompra, int puntos) {
        super(carritoCompra);
        this.puntos = puntos;
    }

    
    @Override
    public double calcularTotal() {
        return carritoCompra.calcularTotal() - (puntos * 0.01);
    }

    @Override
    public String obtenerDescripcion() {
        return carritoCompra.obtenerDescripcion() + " con " + puntos + " puntos";
    }

}