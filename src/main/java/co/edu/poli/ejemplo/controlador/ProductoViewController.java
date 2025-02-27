package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.excepcion.DBConexionExcepcion;
import co.edu.poli.ejemplo.modelo.CreadorAlimento;
import co.edu.poli.ejemplo.modelo.CreadorElectronico;
import co.edu.poli.ejemplo.modelo.Electronico;
import co.edu.poli.ejemplo.servicio.CustomQuery;
import co.edu.poli.ejemplo.servicio.ProductoDAO;
import co.edu.poli.ejemplo.modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.poli.ejemplo.modelo.ProductFactory;

public class ProductoViewController {
    public static void main(String[] args) throws DBConexionExcepcion {
        try {
            /* 
             * Polimorfismo nuevo método de la clase ProductoDAO
             * que permite realizar consultas personalizadas a la base de datos
             */
            CustomQuery<Producto> service = new ProductoDAO();
            Producto electronic = new Producto("12", "Tira Led", 45000.0);
            System.out.println(electronic.toString());
            String sql = "SELECT * FROM producto WHERE precio BETWEEN ? AND ?";
            List<Object> a = new ArrayList<>();
            a.add(0.0);
            a.add(10000.0);
            System.out.println(service.queryDML(sql, a.toArray()));

            /* 
             * Factory Method Pattern Electronico
             */
            ProductFactory productoFactory = new CreadorElectronico();
            Electronico electronico = (Electronico) productoFactory.createProduct();
            electronico.setInputVoltage(110.0);
            electronico.setId("12");
            electronico.setDescripcion("Tira Led");
            electronico.setPrecio(45000.0);
            System.out.println(electronico.toString());

            /* 
             * Factory Method Pattern Alimento
             */
            ProductFactory productoFactory2 = new CreadorAlimento();
            Producto alimento = productoFactory2.createProduct();
            alimento.setId("13");
            alimento.setDescripcion("Galletas");
            alimento.setPrecio(5000.0);
            System.out.println(alimento.toString());
        } catch (SQLException e) {
            e.getMessage();
        }

    }
}
