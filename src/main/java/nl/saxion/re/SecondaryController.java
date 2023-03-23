package nl.saxion.re;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        FXApp.setRoot("primary");
    }
    
    @FXML
    private void switchToCustom() throws IOException {
        FXApp.setRoot("custom");
    }
}