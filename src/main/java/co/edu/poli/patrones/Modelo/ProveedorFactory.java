package co.edu.poli.patrones.Modelo;

import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProveedorFactory {

    private static final Map<String,Proveedor> proveedores = new HashMap<>();

    public static Proveedor getProveedor(String id, String nombreEmpresa, String contacto) {
        Proveedor proveedor = new Proveedor(id, nombreEmpresa, contacto);

        if (!proveedores.containsKey(id)) {
            proveedores.put(id, proveedor);
        }
        return proveedores.get(id);
    }

    public static void clearProveedores() {
        proveedores.clear();
    }

    public static List<Proveedor> getProveedores() {
        return new ArrayList<>(proveedores.values());
    }
}