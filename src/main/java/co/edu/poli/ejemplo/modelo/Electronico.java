package co.edu.poli.ejemplo.modelo;

/**
 *
 * @author jeiso
 */
public class Electronico extends Producto{
    private double inputVoltage;

    public Electronico(double inputVoltage, String id, String descripcion, double precio) {
        super(id, descripcion, precio);
        this.inputVoltage = inputVoltage;
    }

    public double getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(double inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    @Override
    public String toString() {
        return "Electronico{" + "inputVoltage=" + inputVoltage + '}';
    }
    
    
}
