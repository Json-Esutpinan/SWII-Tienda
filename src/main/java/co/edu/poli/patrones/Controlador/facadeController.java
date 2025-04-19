package co.edu.poli.patrones.Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.poli.patrones.Modelo.Cliente;
import co.edu.poli.patrones.Modelo.ClienteFacade;
import co.edu.poli.patrones.Modelo.MetodoPago;
import co.edu.poli.patrones.Modelo.Pedido;
import co.edu.poli.patrones.Modelo.ProductoReal;
import co.edu.poli.patrones.Modelo.Proveedor;
import co.edu.poli.patrones.Modelo.ProveedorFactory;
import co.edu.poli.patrones.Vista.App;
import javafx.scene.control.Alert;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class facadeController {

    @FXML
    private Button btnActCli;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnFlyweight;
    @FXML
    private Button btnHacerPedido;
    @FXML
    private Button btnProxy;
    @FXML
    private Button btnClearProd;
    @FXML
    private TableColumn<MetodoPago, Void> clmActivarPago;
    @FXML
    private TableColumn<MetodoPago, Void> clmBloquearPago;
    @FXML
    private TableColumn<MetodoPago, Boolean> clmEstadoPago;
    @FXML
    private TableColumn<MetodoPago, String> clmDescripcionPago;
    @FXML
    private TableColumn<Pedido, Integer> clmIdPedido;
    @FXML
    private TableColumn<Pedido, Double> clmTotal;
    @FXML
    private TableColumn<Pedido, String> clmProductos;
    @FXML
    private ListView<ProductoReal> lvProductos;
    @FXML
    private ListView<ProductoReal> lvProductoSeleccionado;
    @FXML
    private TableView<MetodoPago> tblMetodosPago;
    @FXML
    private TableView<Pedido> tblPedidos;
    @FXML
    private Text txaContent;
    @FXML
    private TextField txfApellido;
    @FXML
    private TextField txfNombre;
    @FXML
    private TextField txfActApeCli;
    @FXML
    private TextField txfActNomCli;

    private Proveedor proveedor1, proveedor2;
    private ProductoReal producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8,
            producto9, producto10;
    private MetodoPago metodoPago1, metodoPago2;
    private List<ProductoReal> listaProductos;
    private HashMap<Cliente, ClienteFacade> listaClientesFacade;
    private ClienteFacade clienteFacade1, clienteFacade2, clienteFacade3;
    private Cliente cliente1, cliente2, cliente3;
    private Pedido pedido1, pedido2, pedido3;
    private Alert alert;

    public facadeController() {
        this.proveedor1 = ProveedorFactory.getProveedor("1", "hp", "1234");
        this.proveedor2 = ProveedorFactory.getProveedor("2", "dell", "5678");
        this.producto1 = new ProductoReal("Laptop", 2000000.00, proveedor1);
        this.producto2 = new ProductoReal("Pantalla", 400000.00, proveedor1);
        this.producto3 = new ProductoReal("Mouse", 30000.00, proveedor1);
        this.producto4 = new ProductoReal("Teclado", 50000.00, proveedor1);
        this.producto5 = new ProductoReal("Impresora", 150000.00, proveedor2);
        this.producto6 = new ProductoReal("Escáner", 200000.00, proveedor2);
        this.producto7 = new ProductoReal("Proyector", 800000.00, proveedor2);
        this.producto8 = new ProductoReal("Monitor", 600000.00, proveedor2);
        this.producto9 = new ProductoReal("Altavoces", 200000.00, proveedor2);
        this.producto10 = new ProductoReal("Webcam", 100000.00, proveedor2);
        this.listaProductos = List.of(this.producto1, this.producto2, this.producto3, this.producto4, this.producto5,
                this.producto6, this.producto7, this.producto8,
                this.producto9, this.producto10);
        this.metodoPago1 = new MetodoPago("Tarjeta de crédito", true);
        this.metodoPago2 = new MetodoPago("Efectivo", false);
        List<ProductoReal> listaProductos1 = List.of(this.producto1, this.producto2, this.producto3, this.producto4);
        List<ProductoReal> listaProductos2 = List.of(this.producto5, this.producto6, this.producto7, this.producto8,
                this.producto9, this.producto10);
        List<ProductoReal> listaProductos3 = List.of(this.producto1, this.producto3, this.producto5, this.producto7,
                this.producto9);
        this.cliente1 = new Cliente("Juan", "Perez");
        this.cliente2 = new Cliente("Ana", "Gomez");
        this.cliente3 = new Cliente("Luis", "Martinez");
        this.pedido1 = new Pedido("AAA1", cliente1, listaProductos1);
        this.pedido2 = new Pedido("AAA2", cliente2, listaProductos2);
        this.pedido3 = new Pedido("AAA3", cliente3, listaProductos3);
        this.clienteFacade1 = new ClienteFacade(cliente1, pedido1, metodoPago1);
        this.clienteFacade1.agregarMetodoPago(metodoPago2);
        this.clienteFacade2 = new ClienteFacade(cliente2, pedido2, metodoPago2);
        this.clienteFacade3 = new ClienteFacade(cliente3, pedido3, metodoPago1);
        this.listaClientesFacade = new HashMap<>();
        this.listaClientesFacade.put(cliente1, clienteFacade1);
        this.listaClientesFacade.put(cliente2, clienteFacade2);
        this.listaClientesFacade.put(cliente3, clienteFacade3);
        this.lvProductos = new ListView<>();
        this.lvProductoSeleccionado = new ListView<>();
    }

    @FXML
    void initialize() {

        this.lvProductos.getItems().addAll(listaProductos);

        listViewProductos(this.lvProductoSeleccionado, ProductoReal::getDescripcion);
        listViewProductos(this.lvProductos, ProductoReal::getDescripcion);
        this.clmEstadoPago.setCellValueFactory(new PropertyValueFactory<>("estado"));
        this.clmDescripcionPago.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        this.clmActivarPago.setCellFactory(param -> new TableCell<MetodoPago, Void>() {
            private final Button btn = new Button("Activar");

            {
                btn.setOnAction(event -> {
                    MetodoPago metodo = tblMetodosPago.getItems().get(getIndex());
                    metodo.setEstado(true);
                    tblMetodosPago.refresh();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        this.clmBloquearPago.setCellFactory(param -> new TableCell<MetodoPago, Void>() {
            private final Button btn = new Button("Bloquear");

            {
                btn.setOnAction(event -> {
                    MetodoPago metodo = tblMetodosPago.getItems().get(getIndex());
                    metodo.setEstado(false);
                    tblMetodosPago.refresh();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        this.clmIdPedido.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.clmTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        this.clmProductos.setCellValueFactory(cellData -> {
            Pedido pedido = cellData.getValue();
            String productos = pedido.getListaProductos().stream()
                    .map(ProductoReal::getDescripcion)
                    .collect(Collectors.joining(", "));
            return new SimpleStringProperty(productos);
        });

        this.lvProductos.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        this.lvProductoSeleccionado.getItems().addAll(newValue);
                    }
                });
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        String nombre, apellido;
        nombre = txfNombre.getText().strip();
        apellido = txfApellido.getText().strip();
        if (!validarCampos()) {
            showAlert("Complete todos los campos ", Alert.AlertType.INFORMATION);
            // limpiarPantalla();
            return;
        }
        Cliente cliente = new Cliente(nombre, apellido);
        if (!obtenerCliente(listaClientesFacade, cliente)) {
            showAlert("Cliente no existe", Alert.AlertType.WARNING);
            // limpiarPantalla();
            return;
        }
        this.txaContent.setText(this.listaClientesFacade.get(cliente).obtenerDatosCli());
        this.tblMetodosPago.getItems().clear();
        this.tblMetodosPago.getItems().addAll(this.listaClientesFacade.get(cliente).verMetodoPago());
        this.tblPedidos.getItems().clear();
        this.tblPedidos.getItems().addAll(this.listaClientesFacade.get(cliente).mostrarPedidos());
        this.txfActNomCli.setText(nombre);
        this.txfActApeCli.setText(apellido);
    }

    @FXML
    void hacerPedido(ActionEvent event) {
        String nombre, apellido;
        nombre = txfNombre.getText().strip();
        apellido = txfApellido.getText().strip();
        Cliente cliente = new Cliente(nombre, apellido);
        if (!validarCampos()) {
            showAlert("Por favor, ingrese el nombre y apellido del cliente.", Alert.AlertType.WARNING);
            return;
        } else if (!obtenerCliente(listaClientesFacade, cliente)) {
            showAlert("El cliente no existe", Alert.AlertType.WARNING);
            // limpiarPantalla();
            return;
        } else if (lvProductoSeleccionado.getItems().isEmpty()) {
            showAlert("Por favor, seleccione al menos un producto.", Alert.AlertType.WARNING);
            return;
        }

        List<ProductoReal> products = this.lvProductoSeleccionado.getItems();
        this.listaClientesFacade.get(cliente).hacerPedido(generarIdAleatorio(4), cliente,
                products);
        this.tblPedidos.getItems().clear();
        this.lvProductoSeleccionado.getItems().clear();
        this.tblPedidos.getItems().addAll(this.listaClientesFacade.get(cliente).mostrarPedidos());
        this.tblPedidos.refresh();

    }

    void showAlert(String mensaje, Alert.AlertType tipo) {
        alert = new Alert(tipo);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    boolean validarCampos() {
        if (txfNombre.getText().strip().isEmpty() || txfApellido.getText().strip().isEmpty()) {
            return false;
        }
        return true;
    }

    boolean obtenerCliente(HashMap<Cliente, ClienteFacade> listaClientesFacade, Cliente cliente) {
        if (!listaClientesFacade.containsKey(cliente)) {
            return false;
        }
        return true;
    }

    private String generarIdAleatorio(int length) {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * alphanumeric.length());
            id.append(alphanumeric.charAt(index));
        }
        return id.toString();
    }

    public static <T> void listViewProductos(ListView<T> listView,
            java.util.function.Function<T, String> obtenerDescripcion) {
        listView.setCellFactory(param -> new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : obtenerDescripcion.apply(item));
            }
        });
    }

    @FXML
    void limpiarProdSelec(ActionEvent event) {
        lvProductoSeleccionado.getItems().clear();
    }

    @FXML
    void cambiarVista(ActionEvent event) throws IOException {
        if (event.getSource() == btnFlyweight) {
            App.setRoot("flyweightView", 900, 600);
        } else if (event.getSource() == btnProxy) {
            App.setRoot("proxyView", 250, 320);
        }
    }

    @FXML
    void actualizarCliente(ActionEvent event) {

        String nombre, apellido, nuevoNom, nuevoApe;

        nombre = txfNombre.getText().strip();
        apellido = txfApellido.getText().strip();
        nuevoNom = txfActNomCli.getText().strip();
        nuevoApe = txfActApeCli.getText().strip();
        if (!validarCampos() || nuevoApe.isEmpty() || nuevoNom.isEmpty()) {
            showAlert("Complete todos los campos para actualizar el cliente",
                    Alert.AlertType.INFORMATION);
            return;
        }
        Cliente cli = new Cliente(nombre, apellido);
        ClienteFacade clienteF = this.listaClientesFacade.get(cli);
        clienteF.actualizarDatosCli(nuevoNom, nuevoApe);
        this.listaClientesFacade.remove(cli);
        this.txfNombre.setText(nuevoNom);
        this.txfApellido.setText(nuevoApe);
        this.txaContent.setText(clienteF.obtenerDatosCli());
        Cliente clienteNuevo = new Cliente(nuevoNom, nuevoApe);
        this.listaClientesFacade.put(clienteNuevo, clienteF);

    }

    void limpiarPantalla() {
        this.tblMetodosPago.getItems().clear();
        this.tblPedidos.getItems().clear();
        this.txaContent.setText("Busque un cliente");
        this.txfActApeCli.clear();
        this.txfActNomCli.clear();
        this.txfApellido.clear();
        this.txfNombre.clear();
    }

}