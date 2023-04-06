package nl.saxion.re.views;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nl.saxion.re.App;
import nl.saxion.re.types.State;
import nl.saxion.re.types.UserTypes;

public class LoginController {

	@FXML
	TextField username;

	@FXML
	TextField password;

	@FXML
	Text statusMessage;

	public void login() {
		System.out.println("Logging in....");
		System.out.println(username.getText());
		System.out.println(password.getText());

        boolean validPass = checkPassword(password.getText(), username.getText());

        if(!validPass){
            err();
            return;
        }

		switch (username.getText().toLowerCase()) {
			case "advisor":
				State.getInstance().setUsername("Advisor");
				State.getInstance().setUserType(UserTypes.ADVISOR);
				ok();
				break;
			case "planner":
				State.getInstance().setUsername("Planner");
				State.getInstance().setUserType(UserTypes.PLANNER);
				ok();
				break;
			case "installer":
				State.getInstance().setUsername("Installer");
				State.getInstance().setUserType(UserTypes.INSTALLER);
				ok();
				break;
			case "inventory":
				State.getInstance().setUsername("Inventory");
				State.getInstance().setUserType(UserTypes.INVENTORY);
				ok();
				break;
			default:
				err();
				break;
		}

	}

	private void ok() {
		statusMessage.setText("Logged in!");
		statusMessage.setFill(Color.web("#00ff00"));

		Stage stage = (Stage) username.getScene().getWindow();

		int width = 1920;
		int height = 1080;

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(State.getInstance().getUserType().getFile()));
		Scene scene;
		try {
			scene = new Scene(fxmlLoader.load(), width, height);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		scene.getStylesheets().add(Objects.requireNonNull(App.class.getResource("style.css")).toExternalForm());

		stage.setScene(scene);
		stage.show(); 
	}

	private void err() {
		statusMessage.setText("Login Failed! please try again!");
		statusMessage.setFill(Color.web("#ff0000"));
	}

    private boolean checkPassword(String password, String username) {
        // check password for all UserTypes 

        switch(username){
            case "advisor":
                return password.equals("advisor");
            case "planner":
                return password.equals("planner");
            case "installer":
                return password.equals("installer");
            case "inventory":
                return password.equals("inventory");
            default:
                return false;
        }
    }
}
