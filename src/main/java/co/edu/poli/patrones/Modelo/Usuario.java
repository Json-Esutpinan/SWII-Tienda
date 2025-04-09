package co.edu.poli.patrones.Modelo;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String password;
    private String rol;

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return nombre.equals(usuario.nombre) && password.equals(usuario.password);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre, password, rol);
    }
}
