package co.edu.poli.patrones.Modelo;

import java.util.List;

public class ProductoProxy implements Producto {

    private ProductoReal productoReal;
    private Usuario usuario;
    private List<Usuario> listaUsuario;

    public ProductoProxy(String descripcion, double precio, Usuario usuario, List<Usuario> listaUsuario,Proveedor proveedor) {
        this.listaUsuario = listaUsuario;
        this.productoReal = new ProductoReal(descripcion, precio, proveedor);
        this.usuario = usuario;
    }

    public boolean autenticarUsuario() {
        if (this.listaUsuario.contains(this.usuario)) {
            return true;
        }
        return false;
    }

    public String obenerDetalles() {
        if (this.autenticarUsuario() && this.usuario.getRol().equals("admin")) {
            return this.productoReal.obenerDetalles();
        }else if (this.autenticarUsuario() && this.usuario.getRol().equals("user")) {
            return "Usuario sin privilegios";
        }
        return "Usuario no autorizado";
    }

}