package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.*;
import co.edu.poli.ejemplo.servicio.ClienteService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main (String [] args){
        Cliente cliente1 = new Cliente("1", "Jeison");
        Producto producto1 = new Producto("1", "Oreo", 1500);
        Producto producto2 = new Producto("2", "Coca- Cola", 3500);
        Producto producto3 = new Producto("3", "Pan Bimbo", 6500);
        Producto producto4 = new Producto("4", "Agua", 2000);
        
        List<Producto> listaProductos = new ArrayList();
        
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        
        Pedido pedido = new Pedido("1001", "05-02-2025", cliente1, listaProductos);
        System.out.println(pedido.toString());
        
        ClienteService cli = new ClienteService();
        Cliente cli1 = cli.getClienteById("1");
        
        boolean eliminar = false;
        eliminar = cli.updateCliente(cliente1);
        if(eliminar){
            System.out.println("Se actualizó el registro correctamente");
        }else{
            System.out.println("No se eliminó el registro del usuario");
        }
        List<Cliente> listaClientes = new ArrayList();
        listaClientes = cli.getCliente();
        System.out.println("El cliente en la DB es: "+cli1.toString());
        System.out.println("Los clientes en la DB son: "+listaClientes.toString());
        
    }
}