package co.edu.poli.ejemplo.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo.modelo.Alimento;
import co.edu.poli.ejemplo.vista.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoViewController {


    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Alimento, Double> aporteColumn;

    @FXML
    private TextField aporteField;

    @FXML
    private Button coneButton;

    @FXML
    private TableColumn<Alimento, String> idColumn;

    @FXML
    private TextField idField;

    @FXML
    private TableColumn<Alimento,String> nameColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TableColumn<Alimento, Double> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private TableView<Alimento> tableAlimento;

    @FXML
    private Button vistaButton;

    private ObservableList<Alimento> observableList;


    List<Alimento> alimentos = new ArrayList<>();
    Alimento alimento;


    @FXML
    public void initialize(){
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.aporteColumn.setCellValueFactory(new PropertyValueFactory<>("aporteCalorico"));
    }

    @FXML
    void agregarProducto(ActionEvent event) {
        String id = this.idField.getText();
        String description = this.nameField.getText();
        double precio = Double.parseDouble(priceField.getText());
        double aporte = Double.parseDouble(aporteField.getText());
        this.alimento = new Alimento(id, description, precio, aporte);
        this.alimentos.add(this.alimento );
        this.observableList = FXCollections.observableArrayList(this.alimentos);
        this.tableAlimento.setItems(this.observableList);

    }

    @FXML
    void clonar(ActionEvent event) {
        Alimento alimento2 = (Alimento) this.alimento.clone();
        this.alimentos.add(alimento2);
        this.observableList = FXCollections.observableArrayList(this.alimentos);
        this.tableAlimento.setItems(this.observableList);
    }

    @FXML
    void cambiarVista(ActionEvent event) throws IOException {
        App.setRoot("ClienteView");
    }

}
