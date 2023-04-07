package nl.saxion.re.views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nl.saxion.re.App;
import nl.saxion.re.types.State;

/**
 * AdvisorController
 */
public class AdvisorController {
    
    @FXML
    Label greet; 

    

    public void initialize() {
        greet.setText("Hallo " + State.getInstance().getUsername() + "!");
    }

    @FXML 
    void newQuotation() {
    
    // show new quotation screen
    
    setScene("newQuotation.fxml");
     
    }

    @FXML
    void showQuotations() {
        setScene("allQuotations.fxml");
    }


    void setScene(String sceneName){
        Stage stage = (Stage) greet.getScene().getWindow();
    
        int width = (int) stage.getWidth();
        int height = (int) stage.getHeight();
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
    
        Scene scene = null;
    
        try {
            scene = new Scene(loader.load(), width, height);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
    
        stage.setScene(scene);
    
        stage.show();
    }
}
