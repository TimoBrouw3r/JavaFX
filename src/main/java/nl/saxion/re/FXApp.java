package nl.saxion.re;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.saxion.re.types.State;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class FXApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        State.initialise();
        scene = new Scene(loadFXML("views/login"), 1920, 1080);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            App.class.getResource(fxml + ".fxml")
        );
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
