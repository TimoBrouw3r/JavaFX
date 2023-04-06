package nl.saxion.re.components;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.saxion.re.types.Task;

/**
 * UpcomingTask
 */
public class UpcomingTask extends VBox {

    @FXML
    Label address;

    @FXML
    Label date;

    public UpcomingTask(Task task) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpcomingTask.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.setStyle("-fx-background-color: #D9D9D9; "+
                "-fx-border-insets: 0 0 0 50px;" +
                "-fx-pref-width: 500px;"+
                "-fx-padding: 10px;");

        address.setText(task.getClientAddress());


        date.setText(task.getDate().toString());
    }
	
}
