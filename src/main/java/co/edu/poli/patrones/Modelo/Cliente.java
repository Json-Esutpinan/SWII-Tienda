package co.edu.poli.patrones.Modelo;

import java.util.Objects;

public class Cliente{

    private String nombre;
    private String apellido;

    public Cliente( String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente that = (Cliente) o;
        return Objects.equals(this.nombre,that.nombre) && Objects.equals(this.apellido, that.apellido) ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, apellido);
    }
}