package nl.saxion.re.views;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import nl.saxion.re.types.State;

/**
 * MainController
 */
public class MainController {

    @FXML
	Text nametext;

    public void initialize() {
        String username = State.getInstance().getUsername();
        nametext.setText("Hello " + username);
    }
}
