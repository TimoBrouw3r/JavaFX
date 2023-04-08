package nl.saxion.re.components;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nl.saxion.re.App;
import nl.saxion.re.types.State;

/**
 * NavBar
 */
public class NavBar extends HBox{


    @FXML
    Label username;

    @FXML
    public void logout(){
        System.out.println("Logout");
        State.getInstance().setUsername(null);
        State.getInstance().setUserType(null);
        State.getInstance().setUserTeam(null);

        Stage stage = (Stage) this.getScene().getWindow();

        int width = (int) stage.getWidth();
        int height = (int) stage.getHeight();

        FXMLLoader loader = new FXMLLoader(App.class.getResource("views/login.fxml"));

        Scene scene;

        try {
            scene = new Scene(loader.load(), width, height);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

    }

    public NavBar(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        username.setText(State.getInstance().getUsername());

    }
    


} 
