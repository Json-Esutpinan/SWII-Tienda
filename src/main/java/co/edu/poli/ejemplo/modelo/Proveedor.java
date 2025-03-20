package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Proveedor {

    
    private String nombre;
    private String empresa;
    private String contacto;
    private PoliticaEntrega politica;
    private Evaluacion evaluacion;
    private Certificacion certificacion;
    
    private Proveedor(ProveedorBuilder prov) {
        this.nombre = prov.nombre;
        this.contacto = prov.contacto;
        this.certificacion = prov.certificacion;
        this.empresa = prov.empresa;
        this.evaluacion = prov.evaluacion;
        this.politica = prov.politica;
    }
    

    @Override
    public String toString() {
        return "Proveedor [nombre=" + nombre + ", empresa=" + empresa + ", contacto=" + contacto + ", politica="
                + politica + ", evaluacion=" + evaluacion + ", certificacion=" + certificacion.toString() + "]";
    }



    public static class ProveedorBuilder {
        private String nombre;
        private String empresa;
        private String contacto;
        private PoliticaEntrega politica;
        private Evaluacion evaluacion;
        private Certificacion certificacion;

        public ProveedorBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ProveedorBuilder setEmpresa(String empresa) {
            this.empresa = empresa;
            return this;
        }

        public ProveedorBuilder setContacto(String contacto) {
            this.contacto = contacto;
            return this;
        }

        
        public ProveedorBuilder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

    
        public ProveedorBuilder setPolitica(PoliticaEntrega politica) {
            this.politica = politica;
            return this;
        }

        
        public ProveedorBuilder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }

        public Proveedor build() {
            return new Proveedor(this);
        }

    }

}