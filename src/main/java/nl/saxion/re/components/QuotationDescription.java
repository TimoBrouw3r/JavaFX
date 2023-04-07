package nl.saxion.re.components;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import nl.saxion.re.types.Quotation;
import nl.saxion.re.types.Task;

/**
 * TestController
 */
public class QuotationDescription extends HBox {

    @FXML
    Label name;

    @FXML
    Label address;

    @FXML
    Pane quotationDescriptionPane;

    private static ArrayList<QuotationDescription> taskDescriptions = new ArrayList<>();
    private Quotation quotation; 
    boolean selected = false;
    
    public QuotationDescription(Quotation quotation) {
        this.quotation = quotation;
        taskDescriptions.add(this);
    

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuotationDescription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(QuotationDescription.this);

        this.onMouseClickedProperty().set(e -> handleMouseClick(e));
        
        try {
            fxmlLoader.load();
            System.out.println("loaded xml!");
        } catch (Exception e){
            System.err.println(e);
        }


        name.setText(quotation.getClientName());
        address.setText(quotation.getClientAddress());
        // teamAssigned.setSelected(task.getTeam() != null);

    }

    private void handleMouseClick(MouseEvent e){
        System.out.println("clicked");

        for (QuotationDescription quotationDescription : taskDescriptions){
            if(quotationDescription != this){
                quotationDescription.selected = false;
            } else { 
                quotationDescription.selected = true;
            }

            quotationDescription.update();
        }
    }

    public void update(){
        if(selected){
            quotationDescriptionPane.setStyle("-fx-background-color: #aaaaaa");
        } else {
            quotationDescriptionPane.setStyle("-fx-background-color: #ffffff");
        }
    }

    public boolean isSelected() {
        return selected;
    }

    // NOTE: REMOVE, ONLY FOR TESTING
    public String getName() {
        return name.getText();
    }

    public Quotation getQuotation() {
        return quotation;
    }
}
