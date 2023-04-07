package nl.saxion.re.views;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
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
        System.out.println("back");
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
