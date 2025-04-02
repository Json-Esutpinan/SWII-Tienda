package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.CargaPesada;
import co.edu.poli.ejemplo.modelo.Envio;
import co.edu.poli.ejemplo.modelo.Internacional;
import co.edu.poli.ejemplo.modelo.Mercancia;
import co.edu.poli.ejemplo.modelo.Nacional;

public class bridgeController {
    public static void main(String[] args) {
        Envio nacional = new Nacional();
        Envio internacional = new Internacional();
        Mercancia cargaPesada = new CargaPesada(internacional, 10);
        Mercancia cargaLigera = new CargaPesada(nacional, 5);
        String resultadoNacional = cargaLigera.enviar("Calle 123, Bogotá, Colombia");
        String resultadoInternacional = cargaPesada.enviar("Avenida 456, Nueva York, USA");
        System.out.println("-------------------------------");
        System.out.println(resultadoNacional);
        System.out.println("-------------------------------");
        System.out.println(resultadoInternacional);

    }
}
