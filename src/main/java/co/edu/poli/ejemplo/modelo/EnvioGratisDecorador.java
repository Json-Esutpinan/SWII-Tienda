package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class EnvioGratisDecorador extends CarritoDecorador {

    public EnvioGratisDecorador(CarritoCompras carritoCompra) {
        super(carritoCompra);
    }

    @Override
    public double calcularTotal() {
        return carritoCompra.calcularTotal();
    }

    @Override
    public String obtenerDescripcion() {
        return carritoCompra.obtenerDescripcion() + " con envio gratis";
    }

}