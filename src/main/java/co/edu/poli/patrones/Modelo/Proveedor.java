package co.edu.poli.patrones.Modelo;
import java.util.Objects;

public class Proveedor {

    private String nombreEmpresa;
    private String id;
    private String contacto;

    public Proveedor(String id, String nombreEmpresa, String contacto) {
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor that = (Proveedor) o;
        return nombreEmpresa.equals(that.nombreEmpresa) && Objects.equals(contacto, that.contacto) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nombreEmpresa, contacto);
    }

}