package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.Certificacion;
import co.edu.poli.ejemplo.modelo.Proveedor;

public class proveedorController {

    public static void main(String[] args) {
        Certificacion cert = new Certificacion("ISO", "ISO9001");
        try {
            Proveedor prov = new Proveedor.ProveedorBuilder()
                    .setNombre("Juan")
                    .setEmpresa("Nestle")
                    .setContacto("Nestle@hotmail.com")
                    .setCertificacion(cert)
                    .build();
            System.out.println(prov.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}