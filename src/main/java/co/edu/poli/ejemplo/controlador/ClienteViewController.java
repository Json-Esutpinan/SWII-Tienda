package co.edu.poli.ejemplo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import co.edu.poli.ejemplo.modelo.Cliente;
import co.edu.poli.ejemplo.servicio.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteViewController {

    @FXML
    private Tab TabCliente;

    @FXML
    private Button btAddCliente;

    @FXML
    private TableColumn<Cliente, String> columnId;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private TableColumn<Cliente, String> colClienteId;

    @FXML
    private TableColumn<Cliente, String> colClienteNombre;

    @FXML
    private Button deleteBttn;

    @FXML
    private TextField fieldDeleteCliente;

    @FXML
    private TextField fieldSearchCliente;

    @FXML
    private Button searchAllBttn;

    @FXML
    private Button searchBttn;

    @FXML
    private TableView<Cliente> tablaCliente;

    @FXML
    private TableView<Cliente> tablaClienteId;

    @FXML
    private TextField txtIdCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField fieldSearchCliente1;

    @FXML
    private TextField fieldUpdateClienteId;

    @FXML
    private TextField fieldUpdateClienteNombre;

    @FXML
    private Button updateBttn;

    @FXML
    private Button searchBttn1;

    private Cliente cliente;

    private ClienteDAO service = new ClienteDAO();

    private ObservableList<Cliente> listCliente;

    private Alert alerta = new Alert(Alert.AlertType.NONE);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @FXML
    public void initialize() {
        this.columnId.setCellValueFactory(new PropertyValueFactory("id"));
        this.columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colClienteId.setCellValueFactory(new PropertyValueFactory("id"));
        this.colClienteNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
    }

    @FXML
    private void agregarCliente(ActionEvent event) {
        String id = this.txtIdCliente.getText();
        String nombre = this.txtNombreCliente.getText();
        this.cliente = new Cliente(id, nombre);
        String message = this.service.create(this.cliente);
        this.alerta.setAlertType(AlertType.INFORMATION);
        this.alerta.setHeaderText(null);
        this.alerta.setContentText(message);
        this.alerta.showAndWait();
        if (message.equals("Agregado")) {
            this.txtIdCliente.setText(null);
            this.txtNombreCliente.setText(null);
        }
    }

    @FXML
    private void leerCliente(ActionEvent event) {
        List<Cliente> todoCliente = new ArrayList<>();

        todoCliente = this.service.readAll();

        if (!todoCliente.isEmpty()) {
            this.listCliente = FXCollections.observableArrayList(todoCliente);
            this.tablaCliente.setItems(this.listCliente);
        } else {
            System.out.println("No hay elementos en la lista");
        }
    }

    @FXML
    private void leerClienteId(ActionEvent event) {
        String id = this.fieldSearchCliente.getText().trim();
        this.cliente = this.service.readById(id);

        if (this.cliente != null) {
            this.listCliente = FXCollections.observableArrayList();
            this.listCliente.add(this.cliente);
            this.tablaClienteId.setItems(this.listCliente);
        } else {
            String message = "Cliente no existe";
            this.alerta.setAlertType(AlertType.ERROR);
            this.alerta.setHeaderText(null);
            this.alerta.setContentText(message);
            this.alerta.showAndWait();
        }
    }

    @FXML
    private void eliminarCliente(ActionEvent event) {
        this.alerta.setAlertType(AlertType.CONFIRMATION);
        String id = this.fieldDeleteCliente.getText().trim();
        this.cliente = this.service.readById(id);
        if (this.cliente != null) {
            String message = "¿Está seguro que desa eliminar al cliente " + this.cliente.getId() + " "
                    + this.cliente.getNombre() + "?";
            this.alerta.setHeaderText(null);
            this.alerta.setContentText(message);
            Optional<ButtonType> result = this.alerta.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                this.cliente = this.service.delete(id);
                this.alerta.setAlertType(AlertType.INFORMATION);
                this.alerta.setContentText(
                        "Se eliminó al cliente " + this.cliente.getId() + " " + this.cliente.getNombre());
                this.alerta.showAndWait();
                this.fieldDeleteCliente.setText(null);
            }
        } else {
            this.alerta.setAlertType(AlertType.ERROR);
            this.alerta.setContentText("El usuario con " + id + " no existe");
            this.alerta.showAndWait();
        }
    }

    @FXML
    private void actulizarCliente(ActionEvent event) {
        String id = this.fieldSearchCliente1.getText().trim();
        this.cliente = this.service.readById(id);
        if (id != null && (this.fieldUpdateClienteId.getText().isEmpty() || this.fieldUpdateClienteId.getText() == null)
                && this.fieldUpdateClienteNombre.getText().isEmpty() && this.cliente != null) {
            this.fieldUpdateClienteId.setText(this.cliente.getId());
            this.fieldUpdateClienteNombre.setText(this.cliente.getNombre());
            this.fieldSearchCliente1.setEditable(false);
        } else if (this.cliente == null) {
            this.alerta.setAlertType(AlertType.ERROR);
            this.alerta.setHeaderText(null);
            this.alerta.setContentText("El Cliente no existe");
            this.alerta.showAndWait();
        } else {
            this.cliente.setNombre(this.fieldUpdateClienteNombre.getText().trim());
            String message = this.service.update(id, this.cliente);
            if (message.equals("Actualizado")) {
                this.alerta.setAlertType(AlertType.INFORMATION);
                this.alerta.setHeaderText(null);
                this.alerta.setContentText(message + " correctamente");
                this.alerta.showAndWait();
                this.fieldSearchCliente1.setEditable(true);
                this.fieldSearchCliente1.setText("");
                this.fieldUpdateClienteId.setText("");
                this.fieldUpdateClienteNombre.setText("");
            } else {
                this.alerta.setAlertType(AlertType.ERROR);
                this.alerta.setContentText(message);
                this.alerta.setHeaderText(null);
                this.alerta.showAndWait();
            }
        }

    }
}
