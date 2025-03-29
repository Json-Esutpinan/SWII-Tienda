package co.edu.poli.ejemplo.controlador;
import co.edu.poli.ejemplo.modelo.Departamento;
import co.edu.poli.ejemplo.modelo.Empleado;

public class departamentoController {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", "Tecnico");
        Empleado empleado2 = new Empleado("Maria", "Analista");
        Empleado empleado3 = new Empleado("Pedro", "Gerente");
        Empleado empleado4 = new Empleado("Ana", "Desarrollador");
        Departamento departamentoPrincipal = new Departamento("Gerencia");
        Departamento departamentoSecundario = new Departamento("Desarrollo");
        
        departamentoPrincipal.agregarComponente(empleado3);
        departamentoSecundario.agregarComponente(empleado1);
        departamentoSecundario.agregarComponente(empleado2);
        departamentoSecundario.agregarComponente(empleado4);
        departamentoPrincipal.agregarComponente(departamentoSecundario);
        System.out.println("Detalles del departamento principal:");
        departamentoPrincipal.mostrarDeatalles();
    }
}
