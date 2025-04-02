package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public abstract class CarritoDecorador implements CarritoCompras {

        protected CarritoCompras carritoCompra;
    
        public CarritoDecorador(CarritoCompras carritoCompra) {
            this.carritoCompra = carritoCompra;
        }
    
        @Override
        public abstract double calcularTotal();
    
        @Override
        public abstract String obtenerDescripcion();


}