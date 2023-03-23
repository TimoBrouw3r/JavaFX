package nl.saxion.re;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class CustomController {

    @FXML
    private Pane picturePane;
    
    @FXML
    private void next() throws IOException {
        String path = "/cat.jpg";

        picturePane.getChildren().clear();
        picturePane.getChildren().add(new ImageView(path));
    }

    @FXML
    private void prev() throws IOException {
        String path = "/dog.jpg";

        picturePane.getChildren().clear();
        picturePane.getChildren().add(new ImageView(path));
    }
}
