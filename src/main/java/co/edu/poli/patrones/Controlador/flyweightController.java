package co.edu.poli.patrones.Controlador;

import java.io.IOException;

import co.edu.poli.patrones.Modelo.ProductoReal;
import co.edu.poli.patrones.Modelo.Proveedor;
import co.edu.poli.patrones.Modelo.ProveedorFactory;
import co.edu.poli.patrones.Vista.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class flyweightController {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnFacade;

    @FXML
    private Button btnProxy;

    @FXML
    private TableColumn<Proveedor, String> clmContacto;

    @FXML
    private TableColumn<ProductoReal, String> clmDescripcionProd;

    @FXML
    private TableColumn<Proveedor, String> clmEmpresa;

    @FXML
    private TableColumn<Proveedor, String> clmId;

    @FXML
    private TableColumn<ProductoReal, String> clmIdProveedor;

    @FXML
    private TableColumn<ProductoReal, Double> clmPrecio;

    @FXML
    private TextField txfContacto;

    @FXML
    private TextField txfDescripcion;

    @FXML
    private TextField txfEmpresa;

    @FXML
    private TextField txfId;

    @FXML
    private TextField txfPrecio;

    @FXML
    private TableView<ProductoReal> tblProducto;

    @FXML
    private TableView<Proveedor> tblProveedor;

    private ObservableList<Proveedor> observableListProveedores;
    private ObservableList<ProductoReal> observableListProductos = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        
        this.clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmEmpresa.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresa"));
        this.clmContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        
        this.clmDescripcionProd.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.clmPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.clmIdProveedor.setCellValueFactory(new PropertyValueFactory<>("idProveedor"));
    }

    @FXML
    void agregarRegistro(ActionEvent event) {
        String idProveedor = txfId.getText();
        String nombreEmpresa = txfEmpresa.getText();
        String contactoProveedor = txfContacto.getText();
        String descripcionProducto = txfDescripcion.getText();
        String precioTexto = txfPrecio.getText();

        if (idProveedor.isEmpty() || nombreEmpresa.isEmpty() || contactoProveedor.isEmpty() || descripcionProducto.isEmpty() || precioTexto.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
        }

        try {
            double precio = Double.parseDouble(precioTexto);
            Proveedor proveedor = ProveedorFactory.getProveedor(idProveedor,nombreEmpresa, contactoProveedor);            
            ProductoReal producto = new ProductoReal(descripcionProducto, precio, proveedor);
            actualizarTablaProductos(producto);
            actualizarTablaProveedores();
        } catch (RuntimeException e) {
            e.getMessage();
        }

    }

    @FXML
    void cambiarVista(ActionEvent event) throws IOException {
        if (event.getSource() == btnFacade) {
            App.setRoot("facadeView", 925, 620);
        } else if (event.getSource() == btnProxy) {
            App.setRoot("proxyView", 250, 320);
        }
    }

    void actualizarTablaProveedores() {
        this.observableListProveedores = FXCollections.observableArrayList(ProveedorFactory.getProveedores());
        this.tblProveedor.setItems(this.observableListProveedores);
    }

    void actualizarTablaProductos(ProductoReal producto) {
        this.observableListProductos.add(producto);
        this.tblProducto.setItems(this.observableListProductos);
    }
}
