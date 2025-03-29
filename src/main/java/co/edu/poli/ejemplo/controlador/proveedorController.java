package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.Certificacion;
import co.edu.poli.ejemplo.modelo.Evaluacion;
import co.edu.poli.ejemplo.modelo.PoliticaEntrega;
import co.edu.poli.ejemplo.modelo.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class proveedorController {

    @FXML
    private CheckBox chkCertificacion;

    @FXML
    private CheckBox chkEvaluacion;

    @FXML
    private CheckBox chkPolitica;
    @FXML
    private Button btnAgregar;

    @FXML
    private TextField fldContacto;

    @FXML
    private TextField fldDescCert;

    @FXML
    private TextField fldEmpresa;

    @FXML
    private TextField fldEvaluacion;

    @FXML
    private TextField fldNomCert;

    @FXML
    private TextField fldNomProv;

    @FXML
    private TextField fldPolitica;


    private Proveedor proveedor;
    private Certificacion cert;
    private Evaluacion ev;
    private PoliticaEntrega pol;

    private Alert alerta;

    @FXML
    public void initialize() {
        this.fldEvaluacion.disableProperty().bind(chkEvaluacion.selectedProperty().not());
        this.fldNomCert.disableProperty().bind(chkCertificacion.selectedProperty().not());
        this.fldDescCert.disableProperty().bind(chkCertificacion.selectedProperty().not());
        this.fldPolitica.disableProperty().bind(chkPolitica.selectedProperty().not());
    }

    @FXML
    void agregarProveedor(ActionEvent event) {
        if ((this.chkCertificacion.isSelected() && this.fldDescCert.getText().trim().isEmpty()) ||
                (this.chkCertificacion.isSelected() && this.fldNomCert.getText().trim().isEmpty()) ||
                (this.chkEvaluacion.isSelected() && this.fldEvaluacion.getText().trim().isEmpty()) ||
                (this.chkPolitica.isSelected() && this.fldPolitica.getText().trim().isEmpty())) {

            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor complete todos los campos requeridos.");
            alerta.showAndWait();
        } else {
            try {

                Proveedor.ProveedorBuilder build = new Proveedor.ProveedorBuilder()
                        .setNombre(this.fldNomProv.getText())
                        .setEmpresa(this.fldEmpresa.getText())
                        .setContacto(this.fldContacto.getText());
                if (this.chkCertificacion.isSelected())
                    build.setCertificacion(this.cert = new Certificacion(this.fldDescCert.getText(), this.fldNomCert.getText()));
                if (this.chkPolitica.isSelected())
                    build.setPolitica(this.pol = new PoliticaEntrega(this.fldPolitica.getText()));
                if (this.chkEvaluacion.isSelected())
                    build.setEvaluacion(this.ev = new Evaluacion(this.fldEvaluacion.getText()));
                
                this.proveedor = build.build();

                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Proveedor agregado");
                alerta.setHeaderText(null);
                alerta.setContentText("Proveedor agregado correctamente." + this.proveedor.toString());
                alerta.showAndWait();

            } catch (Exception e) {
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }
        }
    }

}
