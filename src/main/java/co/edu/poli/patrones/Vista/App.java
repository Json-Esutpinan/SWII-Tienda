package co.edu.poli.patrones.Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("facadeView"), 920, 580);
        stage.setTitle("Patrones de Diseño");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml, double width,double height ) throws IOException {
        scene.setRoot(loadFXML(fxml));
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}