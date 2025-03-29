package co.edu.poli.ejemplo.modelo;

/**
 *
 * @author jeiso
 */
public class Alimento extends Producto implements ProductPrototype {
    private double aporteCalorico;

    public Alimento(String id, String descripcion, double precio, double aporteCalorico) {
        super(id, descripcion, precio);
        this.aporteCalorico = aporteCalorico;
    }

    public Alimento(double aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    public double getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(double aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    public String toString() {
        return super.toString() + " Aporte Calorico: " + aporteCalorico;
    }

    @Override
    public ProductPrototype clone() {
        return new Alimento(getId(), getDescripcion(), getPrecio(), getAporteCalorico());
    }
}
