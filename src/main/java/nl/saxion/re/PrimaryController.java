package nl.saxion.re;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToCustom() throws IOException {
        FXApp.setRoot("custom");
    }
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        FXApp.setRoot("secondary");
    }
}