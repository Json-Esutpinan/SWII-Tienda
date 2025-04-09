module co.edu.poli.patrones {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens co.edu.poli.patrones.Modelo to javafx.fxml;
    opens co.edu.poli.patrones.Controlador to javafx.fxml;
    opens co.edu.poli.patrones.Vista to javafx.fxml;
    exports co.edu.poli.patrones.Vista;
    exports co.edu.poli.patrones.Controlador;
}
