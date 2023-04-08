package nl.saxion.re.views;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.saxion.re.App;
import nl.saxion.re.components.QuotationDescription;
import nl.saxion.re.types.Quotation;
import nl.saxion.re.types.State;

/**
 * AllQuotationsController
 */
public class AllQuotationsController {

    @FXML
    VBox quotations;
	
    ArrayList<Quotation> quotationsList;
    ArrayList<QuotationDescription> quotationDescriptions = new ArrayList<QuotationDescription>();

    public void initialize() {
       quotationsList = State.getInstance().getQuotations();
       update();
    }

    @FXML
    public void handleBack() {

        Stage stage = (Stage) quotations.getScene().getWindow();
    
        int width = (int) stage.getWidth();
        int height = (int) stage.getHeight();
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("advisor.fxml"));
    
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
    
    public void update() {
        quotations.getChildren().clear();

        for (Quotation quotation : quotationsList) {
            QuotationDescription quotationDescription = new QuotationDescription(quotation);
            quotations.getChildren().add(quotationDescription);
            quotationDescriptions.add(quotationDescription);
        }
    }
    
    @FXML
    public void newTask(){

        for (QuotationDescription quotationDescription : quotationDescriptions) {
            if (quotationDescription.isSelected()) {
                State.getInstance().quotationToTask(quotationDescription.getQuotation());
                break;
            }
        }
        update();
    }
}
