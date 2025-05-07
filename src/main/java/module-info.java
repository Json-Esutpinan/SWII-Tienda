module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.Modelo to javafx.fxml;
    opens co.edu.poli.Controlador to javafx.fxml;
    opens co.edu.poli.Vista to javafx.fxml;
    exports co.edu.poli.Modelo;
    exports co.edu.poli.Controlador;
    exports co.edu.poli.Vista;
}
