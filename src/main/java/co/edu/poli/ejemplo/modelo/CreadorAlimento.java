package co.edu.poli.ejemplo.modelo;

/**
 * Factory de productos de tipo alimento
 */
public class CreadorAlimento implements ProductFactory {

    @Override
    public Producto createProduct() {
        return new Alimento(null, null, 0.0, 0.0);
    }

}