package co.edu.poli.patrones.Controlador;

import java.io.IOException;
import java.util.List;
import co.edu.poli.patrones.Modelo.ProductoProxy;
import co.edu.poli.patrones.Modelo.Proveedor;
import co.edu.poli.patrones.Modelo.ProveedorFactory;
import co.edu.poli.patrones.Modelo.Producto;
import co.edu.poli.patrones.Modelo.Usuario;
import co.edu.poli.patrones.Vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class proxyController {

    @FXML
    private Button btnFacade;
    @FXML
    private Button btnFlyweight;
    @FXML
    private Button logIn;
    @FXML
    private TextField txtNombre;
    @FXML
    private PasswordField txtPass;

    private Alert alert;
    private List<Usuario> listaUsuario;

    @FXML
    void initialize() {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        Usuario usuario2 = new Usuario("Jeison", "1234", "admin");
        Usuario usuario3 = new Usuario("Gerardo", "1234", "user");

        this.listaUsuario = List.of(usuario2, usuario3);
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        Proveedor proveedor = ProveedorFactory.getProveedor("2541", "Nestle", "1234");

        Usuario usuario = new Usuario(txtNombre.getText(), txtPass.getText(), "");
        if (this.listaUsuario.contains(usuario)) {
            usuario.setRol(this.listaUsuario.get(this.listaUsuario.indexOf(usuario)).getRol());
        }
        Producto productoProxy = new ProductoProxy("Cerveza", 2000, usuario, this.listaUsuario, proveedor);
        String resultado = productoProxy.obenerDetalles();
        if (resultado.equals("Usuario no autorizado")) {
            alert.setAlertType(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(resultado);
            alert.showAndWait();
        } else if (resultado.equals("Usuario sin privilegios")) {
            alert.setAlertType(AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText(resultado);
            alert.showAndWait();
        } else {
            alert.setAlertType(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resultado);
            alert.showAndWait();
        }
    }

    @FXML
    void cambiarVista(ActionEvent event) throws IOException {
        if (event.getSource() == btnFacade) {
            App.setRoot("facadeView", 925, 620);
        } else if (event.getSource() == btnFlyweight) {
            App.setRoot("flyweightView", 900, 600);
        }
    }

}
