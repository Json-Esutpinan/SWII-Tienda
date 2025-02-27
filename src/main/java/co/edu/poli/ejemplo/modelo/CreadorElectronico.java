package co.edu.poli.ejemplo.modelo;

/**
 * Factory de productos electrónicos
 */
public class CreadorElectronico implements ProductFactory {

    /**
     * @return
     */
    @Override
    public Producto createProduct() {
        return new Electronico(0.0,null,null,0.0);
    }

}