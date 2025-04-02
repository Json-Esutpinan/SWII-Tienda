package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.CarritoCompras;
import co.edu.poli.ejemplo.modelo.CarritoConcreto;
import co.edu.poli.ejemplo.modelo.DescuentoDecorador;
import co.edu.poli.ejemplo.modelo.EnvioGratisDecorador;
import co.edu.poli.ejemplo.modelo.PuntosCarritoDecorador;

public class decoratorController {
    
        public static void main(String[] args) {
            CarritoCompras carrito1 = new CarritoConcreto(100.0, "Carrito con 20 productos");
            DescuentoDecorador carritoConDescuento = new DescuentoDecorador(carrito1, 10.0);
            System.out.println("Total con descuento: " + carritoConDescuento.calcularTotal());

            CarritoCompras carrito2 = new CarritoConcreto(200.0, "Carrito con 50 productos");
            EnvioGratisDecorador carritoConEnvioGratis = new EnvioGratisDecorador(carrito2);
            System.out.println("Total con envio gratis: " + carritoConEnvioGratis.calcularTotal());

            CarritoCompras carrito3 = new CarritoConcreto(300.0, "Carrito con 100 productos");
            PuntosCarritoDecorador carritoConPuntos = new PuntosCarritoDecorador(carrito3, 50);
            System.out.println(carritoConPuntos.obtenerDescripcion()+carrito3.calcularTotal()+"- Total con puntos: " + carritoConPuntos.calcularTotal());
        }
}
