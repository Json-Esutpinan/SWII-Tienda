package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.CargaPesada;
import co.edu.poli.ejemplo.modelo.CargaLigera;
import co.edu.poli.ejemplo.modelo.Envio;
import co.edu.poli.ejemplo.modelo.Express;
import co.edu.poli.ejemplo.modelo.Internacional;
import co.edu.poli.ejemplo.modelo.Mercancia;
import co.edu.poli.ejemplo.modelo.Nacional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class bridgeController {


    @FXML
    private RadioButton chkCargaLigera;

    @FXML
    private RadioButton chkCargaPesada;

    @FXML
    private RadioButton chkDocumento;

    @FXML
    private RadioButton chkExpress;

    @FXML
    private RadioButton chkInternacional;

    @FXML
    private RadioButton chkNacional;

    @FXML
    private Button createBridge;

    @FXML
    private TextField txtDireccion;

        @FXML
    public void initialize() {
        // Grupo para Documento, Carga Pesada y Carga Ligera
        ToggleGroup grupo1 = new ToggleGroup();
        chkDocumento.setToggleGroup(grupo1);
        chkCargaPesada.setToggleGroup(grupo1);
        chkCargaLigera.setToggleGroup(grupo1);

        // Grupo para Express, Internacional y Nacional
        ToggleGroup grupo2 = new ToggleGroup();
        chkExpress.setToggleGroup(grupo2);
        chkInternacional.setToggleGroup(grupo2);
        chkNacional.setToggleGroup(grupo2);
    }

    @FXML
    private void crearEnvio(ActionEvent event) {

        RadioButton tipoCargaSeleccionado = (RadioButton) obtenerSeleccionado(chkDocumento.getToggleGroup());
        RadioButton tipoEnvioSeleccionado = (RadioButton) obtenerSeleccionado(chkExpress.getToggleGroup());
        String direccion = txtDireccion.getText();
        Envio envio = null;
        String mensaje = null;

        
        if (tipoCargaSeleccionado != null && tipoEnvioSeleccionado != null && !direccion.isEmpty()) {
            switch (tipoEnvioSeleccionado.getText()) {
                case "Express":
                    envio = new Express();
                    break;
                case "Internacional":
                    envio = new Internacional();
                    break;
                case "Nacional":
                    envio = new Nacional();
                    break;
                default:
                    break;
            }
            
            switch (tipoCargaSeleccionado.getText()) {
                case "Documento":
                    Mercancia carga = new CargaLigera(envio, 1.0);
                    mensaje = carga.enviar(direccion);
                    break;
                case "Carga Pesada":
                    carga = new CargaPesada(envio, 10.0);
                    mensaje = carga.enviar(direccion);
                    break;
                case "Carga Ligera":
                    carga = new CargaLigera(envio, 1.0);
                    mensaje = carga.enviar(direccion);
                    break;
                default:
                    break;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado del Envío");
            alert.setHeaderText(null);
            alert.setContentText(mensaje + "\nTipo de carga: " + tipoCargaSeleccionado.getText() + "\nTipo de envío: " + tipoEnvioSeleccionado.getText() + "\nDirección: " + direccion);
            alert.showAndWait();
        } else {
            
            System.out.println("Por favor, seleccione un tipo de carga, un tipo de envío y proporcione una dirección.");
        }
    }

    // Método auxiliar para obtener el RadioButton seleccionado de un ToggleGroup
    private RadioButton obtenerSeleccionado(ToggleGroup grupo) {
        if (grupo.getSelectedToggle() != null) {
            return (RadioButton) grupo.getSelectedToggle();
        }
        return null;
    }

}