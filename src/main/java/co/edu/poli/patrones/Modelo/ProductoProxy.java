package co.edu.poli.patrones.Modelo;

import java.util.List;

/**
 * Clase que comunica al cliente con el producto real
 */
public class ProductoProxy implements Producto {

    private ProductoReal productoReal;
    private Usuario usuario;
    private List<Usuario> listaUsuario;


    /**
     * @param descripcion 
     * @param precio 
     * @param usuario 
     */
    public ProductoProxy(String descripcion, double precio, Usuario usuario, List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
        this.productoReal = new ProductoReal(descripcion, precio);
        this.usuario = usuario;
    }

    /**
     * @param usuario 
     * @param password 
     * @return
     */
    public boolean autenticarUsuario() {
        if (this.listaUsuario.contains(this.usuario)) {
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    public String obenerDetalles() {
        if (this.autenticarUsuario() && this.usuario.getRol().equals("admin")) {
            return this.productoReal.obenerDetalles();
        }else if (this.autenticarUsuario() && this.usuario.getRol().equals("user")) {
            return "Usuario sin privilegios";
        }
        return "Usuario no autorizado";
    }

}