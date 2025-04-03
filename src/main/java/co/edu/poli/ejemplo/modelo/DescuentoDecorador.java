package co.edu.poli.ejemplo.modelo;

public class DescuentoDecorador extends CarritoDecorador {
    private double descuento;

    public DescuentoDecorador(CarritoCompras carritoCompra, double descuento) {
        super(carritoCompra);
        this.descuento = descuento;
    }
    @Override
    public double calcularTotal() {
        return carritoCompra.calcularTotal() - (carritoCompra.calcularTotal() * descuento / 100);
    }
    @Override
    public String obtenerDescripcion() {
        return carritoCompra.obtenerDescripcion() + " con descuento del " + descuento + "%";
    }

}