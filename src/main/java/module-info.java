module co.edu.poli.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports co.edu.poli.ejemplo.vista;
    exports co.edu.poli.ejemplo.controlador;
    exports co.edu.poli.ejemplo.modelo;
    exports co.edu.poli.ejemplo.servicio;
    opens co.edu.poli.ejemplo.vista to javafx.fxml;
    opens co.edu.poli.ejemplo.controlador to javafx.fxml;
}
