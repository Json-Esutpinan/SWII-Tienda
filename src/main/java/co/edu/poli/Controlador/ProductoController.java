package co.edu.poli.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import co.edu.poli.Modelo.Memento;
import co.edu.poli.Modelo.Observer;
import co.edu.poli.Modelo.Producto;
import co.edu.poli.Modelo.Subject;

import java.util.List;
import java.util.UUID;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtFechaCreacion;

    @FXML
    private TableView<Producto> tableViewProductos;

    @FXML
    private TableColumn<Producto, String> colProdNombre;

    @FXML
    private TableColumn<Producto, Double> colProdPrecio;

    @FXML
    private TableColumn<Producto, Void> colSuscribir;

    @FXML
    private TableColumn<Producto, Void> colDesuscribir;

    @FXML
    private TextField txtDescuento;

    @FXML
    private Button btnEnviarDescuento;

    @FXML
    private TableView<Memento> tableHistorial;

    @FXML
    private TableColumn<Memento, String> colNombre;

    @FXML
    private TableColumn<Memento, String> colDescripcion;

    @FXML
    private TableColumn<Memento, Double> colPrecio;

    @FXML
    private TableColumn<Memento, String> colModificado;

    @FXML
    private TableColumn<Memento, Void> colRecuperar;

    private final ObservableList<Producto> productos = FXCollections.observableArrayList();
    private Producto productoSeleccionado;
    private final Subject subject = new Subject(); // Instancia del Subject

    @FXML
    public void initialize() {
        tableViewProductos.setItems(productos);

        // Configurar las columnas de la TableView de Productos
        colProdNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colProdPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // Agregar botones dinámicos de Suscribir y Desuscribir
        agregarBotonesObserver();

        // Listener para la selección de un producto en la tabla principal
        tableViewProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            productoSeleccionado = newVal;
            mostrarHistorial();
        });

        // Configurar las columnas de la TableView de Historial
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colModificado.setCellValueFactory(new PropertyValueFactory<>("modificado"));

        agregarBotonRecuperar();
    }

    private void agregarBotonesObserver() {
        // Columna para el botón Suscribir
        colSuscribir.setCellFactory(param -> new TableCell<>() {
            private final Button btnSuscribir = new Button("Suscribir");
            private Producto productoFila;

            {
                btnSuscribir.setOnAction(event -> {
                    productoFila = getTableView().getItems().get(getIndex());
                    subject.suscribir(productoFila);
                    actualizarEstadoBotones(productoFila);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    productoFila = getTableView().getItems().get(getIndex());
                    setGraphic(btnSuscribir);
                    btnSuscribir.setDisable(subject.getObservers().contains(productoFila));
                }
            }
        });

        // Columna para el botón Desuscribir
        colDesuscribir.setCellFactory(param -> new TableCell<>() {
            private final Button btnDesuscribir = new Button("Desuscribir");
            private Producto productoFila;

            {
                btnDesuscribir.setOnAction(event -> {
                    productoFila = getTableView().getItems().get(getIndex());
                    subject.desuscribir(productoFila);
                    actualizarEstadoBotones(productoFila);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    productoFila = getTableView().getItems().get(getIndex());
                    setGraphic(btnDesuscribir);
                    btnDesuscribir.setDisable(!subject.getObservers().contains(productoFila));
                }
            }
        });
    }

    private void actualizarEstadoBotones(Producto producto) {
        tableViewProductos.refresh();
    }

    private void agregarBotonRecuperar() {
        colRecuperar.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Memento, Void> call(final TableColumn<Memento, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button("Recuperar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            int index = getIndex();
                            Memento m = getTableView().getItems().get(index);
                            if (productoSeleccionado != null) {
                                // Corregido para pasar el índice al método restaurar
                                productoSeleccionado.restaurar(index);
                                mostrarHistorial();
                                tableViewProductos.refresh();

                                // Actualizar los campos de texto
                                txtNombre.setText(productoSeleccionado.getNombre());
                                txtDescripcion.setText(productoSeleccionado.getDescripcion());
                                txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
                                txtFechaCreacion.setText(productoSeleccionado.getFechaCreacion());
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        });
    }

    private void mostrarHistorial() {
        if (productoSeleccionado != null) {
            List<Memento> historial = productoSeleccionado.obtenerHistorial();
            tableHistorial.setItems(FXCollections.observableArrayList(historial));
        } else {
            tableHistorial.setItems(FXCollections.emptyObservableList());
        }
    }

    @FXML
    private void crearProducto(ActionEvent event) {
        try {
            String id = UUID.randomUUID().toString();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            String fecha = txtFechaCreacion.getText();

            Producto nuevo = new Producto(id, nombre, descripcion, precio, fecha);
            productos.add(nuevo);
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Precio inválido. Debe ser un número.");
        }
    }

    @FXML
    private void enviarDescuento(ActionEvent event) {
        try {
            double porcentajeDescuento = Double.parseDouble(txtDescuento.getText());
            subject.notificarDto(porcentajeDescuento);
            mostrarMensaje("Descuento enviado a los observers.");
            txtDescuento.clear();
            tableViewProductos.refresh();
            mostrarHistorial();
        } catch (NumberFormatException e) {
            mostrarAlerta("Porcentaje de descuento inválido. Debe ser un número.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
        txtFechaCreacion.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensaje");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void actualizarProductoSeleccionado() {
        if (productoSeleccionado != null) {
            productoSeleccionado.setNombre(txtNombre.getText());
            productoSeleccionado.setDescripcion(txtDescripcion.getText());
            try {
                double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
                productoSeleccionado.setPrecio(nuevoPrecio);
            } catch (NumberFormatException e) {
                mostrarAlerta("Precio inválido. Debe ser un número.");
                return;
            }
            productoSeleccionado.setFechaCreacion(txtFechaCreacion.getText());
            tableViewProductos.refresh();
        }
    }

    @FXML
    private void guardarCambiosProducto(ActionEvent event) {
        actualizarProductoSeleccionado();
        if (productoSeleccionado != null) {
            productoSeleccionado.guardarEstado();
            limpiarCampos();
            mostrarHistorial();
        }
    }
}