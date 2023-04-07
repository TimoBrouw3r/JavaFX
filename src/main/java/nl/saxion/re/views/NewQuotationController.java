package nl.saxion.re.views;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;
import nl.saxion.re.types.Quotation;
import nl.saxion.re.types.State;
import nl.saxion.re.types.TransformerType;

/**
 * NewQuotationController
 */
public class NewQuotationController {


    @FXML
    Pane newQuotationPane;

    Button nextButton;

    int currentStep = -1;
    int maxSolarPanels = 0;


    int solarPanels = 0;
    int powerLoss = 0; 
    TransformerType transformerType = TransformerType.None;
    String customerName = "";
    String customerAddress = "";
    LocalDate date;
    boolean meterChangeNeeded = false;
    

    public void initialize(){
        nextButton = new Button("Next");
        nextButton.setOnAction(e -> next()); 

        next();

    }


    @FXML
    void handleBack(){

    }


    void next(){
        currentStep++;

        newQuotationPane.getChildren().clear(); 

       System.out.println("Current step: " + currentStep);

       // 3 steps 
        nextButton.setDisable(true);      
    
        if(currentStep == 0){
    
            Region spacer = new Region();
            Region spacer2 = new Region();

            VBox main = new VBox();

            main.prefWidthProperty().bind(newQuotationPane.widthProperty());
        
            VBox top = new VBox();
            top.setAlignment(Pos.CENTER);
            top.setSpacing(10);
            top.prefWidthProperty().bind(newQuotationPane.widthProperty());
            
            HBox inputs = new HBox();
            inputs.setAlignment(Pos.CENTER);
            inputs.getChildren().add(new Label("Afmetingen dak: "));
            inputs.setSpacing(10);
            inputs.setPadding(new Insets(10));

            inputs.prefWidthProperty().bind(main.widthProperty());

            inputs.getChildren().add(spacer); 

             

            TextField width = new TextField();
            TextField height = new TextField();

            width.prefWidth(100.0);
            height.prefWidth(100.0);

            TextFormatter numberFormatter = new TextFormatter<>(new NumberStringConverter()); 
            TextFormatter numberFormatter2 = new TextFormatter<>(new NumberStringConverter());

            width.setTextFormatter(numberFormatter);
            height.setTextFormatter(numberFormatter2);

            inputs.getChildren().add(width);
            inputs.getChildren().add(new Label(" x "));
            inputs.getChildren().add(height);

            


            HBox.setHgrow(spacer, Priority.ALWAYS);

            inputs.getChildren().add(spacer2);
                
            top.getChildren().add(inputs);


            Button calculateSolarPanels = new Button("Bereken zonnepanelen");
           
            Label maxPanels = new Label("Maximaal aantal zonnepanelen nog niet berekened ");

            calculateSolarPanels.setOnAction(e -> {
                int maxPanels1, maxPanels2; 

                int maxPanels1Width = (int) (Double.parseDouble(width.getText()) * 1000 / 1754);
                int maxPanels1Height = (int) (Double.parseDouble(height.getText()) * 1000 / 1096);

                maxPanels1 = maxPanels1Width * maxPanels1Height;

                int maxPanels2Width = (int) (Double.parseDouble(width.getText()) * 1000 / 1096);
                int maxPanels2Height = (int) (Double.parseDouble(height.getText()) * 1000 / 1754);

                maxPanels2 = maxPanels2Width * maxPanels2Height;

                maxSolarPanels = Math.max(maxPanels1, maxPanels2);

                updatePanelLabel(maxPanels);
            });

            top.getChildren().add(calculateSolarPanels);
            top.getChildren().add(maxPanels);

            top.styleProperty().set("-fx-border-colour: black; -fx-border-width: 0 0 1px 0; -fx-border-style: solid;");

            main.getChildren().add(top);

            
            VBox bottom = new VBox();
            bottom.setPadding(new Insets(10, 10, 10, 10));
            bottom.setSpacing(10);
            bottom.setAlignment(Pos.CENTER);

            HBox input = new HBox();
            input.setPadding(new Insets(10, 10, 10, 10));
            input.setSpacing(10);
            input.setAlignment(Pos.CENTER);

            Region amtSolarPanels = new Region();
            Label amtSolarPanelsLabel = new Label("Aantal zonnepanelen: ");
            
            TextFormatter textFormatter = new TextFormatter<>(new NumberStringConverter());

            TextField amtSolarPanelsInput = new TextField();
            amtSolarPanelsInput.setTextFormatter(textFormatter);
            amtSolarPanelsInput.setPrefWidth(50);

            input.getChildren().add(amtSolarPanelsLabel);
            input.getChildren().add(amtSolarPanelsInput);

            Region efficiencyLoss = new Region();

            Label efficiencyLossLabel = new Label("Efficiency verlies: ");
            
            TextFormatter textFormatter2 = new TextFormatter<>(new NumberStringConverter());

            TextField efficiencyLossInput = new TextField();
            efficiencyLossInput.setPrefWidth(50);
            efficiencyLossInput.setTextFormatter(textFormatter2);

            input.getChildren().add(efficiencyLossLabel);
            input.getChildren().add(efficiencyLossInput);

            Button calculateValidity = new Button("Bereken");

            Label errorLabel = new Label();
            errorLabel.setTextFill(Color.RED);
    

            calculateValidity.setOnAction(e -> {
                try {
                    int amtSolarPanelsInt = Integer.parseInt(amtSolarPanelsInput.getText());
                    int efficiencyLossInt = Integer.parseInt(efficiencyLossInput.getText());

                    if (amtSolarPanelsInt < 0 || efficiencyLossInt < 0) {
                        errorLabel.setText("zonnepanelen of energieverlies kan niet negatief zijn");
                        return;
                    }

                    if (efficiencyLossInt > 100) {
                        errorLabel.setText("energieverlies kan niet meer dan 100% zijn");
                        return;
                    }

                    if (amtSolarPanelsInt > maxSolarPanels) {
                    
                        errorLabel.setText("zonnepanelen kan niet meer dan " + maxPanels + " zijn");
                        return;
                    }
                } catch (Exception ex) {
                    errorLabel.setText("ongeldige invoer");
                    return;
                }
                
                errorLabel.setText("");
                solarPanels = Integer.parseInt(amtSolarPanelsInput.getText());
                powerLoss = Integer.parseInt(efficiencyLossInput.getText());
                nextButton.setDisable(false);

            });

            
            bottom.getChildren().add(input);
            bottom.getChildren().add(calculateValidity);
            bottom.getChildren().add(errorLabel);

            main.getChildren().add(bottom);       
            main.getChildren().add(nextButton);
            newQuotationPane.getChildren().add(main);

        }else if(currentStep == 1){
            VBox main = new VBox();


            double totalEnergyGenerated =  (solarPanels * 405)  * (double) ((double) (100 - powerLoss) / (double) 100);

            Label label = new Label("Energie Opbrengst Totaal: "  + totalEnergyGenerated + " watt");
    
            // select transformer type based on totalEnergyGenerated

            if(totalEnergyGenerated <= 2000){
                transformerType = TransformerType.SB2000;
            } 
            else if (totalEnergyGenerated <= 5000){
                transformerType = TransformerType.SB5000;
            } 
            else if (totalEnergyGenerated <= 6000){
                transformerType = TransformerType.SB6000;
            } 
            else if ( totalEnergyGenerated <= 8000){
                transformerType = TransformerType.SB8000;
            } else if (totalEnergyGenerated <= 12000){
                transformerType = TransformerType.SB12000;
            } else{
                transformerType = TransformerType.None;
            }
            
            Label transformerLabel = new Label("Transformator: " + transformerType);
            
            CheckBox checkBox = new CheckBox("Meterkast aanpassing nodig");

            checkBox.setOnAction(e -> {
                meterChangeNeeded = checkBox.isSelected();

            });

            main.getChildren().add(label);
            main.getChildren().add(transformerLabel);
            main.getChildren().add(checkBox);

            nextButton.setDisable(false);

            main.getChildren().add(nextButton);
            newQuotationPane.getChildren().add(main);
            
        }else if(currentStep == 2){
            HBox main = new HBox();
            main.setSpacing(10);
            main.setPadding(new Insets(10, 10, 10, 10));
            main.setAlignment(Pos.CENTER);

            VBox main2 = new VBox();
            main2.setSpacing(10);
            main2.setPadding(new Insets(10, 10, 10, 10));
            main2.setAlignment(Pos.CENTER);

            HBox name = new HBox();
            
            Label nameLabel = new Label("Naam: ");
            TextField nameField = new TextField();

            name.getChildren().add(nameLabel);
            name.getChildren().add(nameField);

            HBox address = new HBox();

            Label addressLabel = new Label("Adres: ");
            TextField addressField = new TextField();

            address.getChildren().add(addressLabel);
            address.getChildren().add(addressField);

            HBox email = new HBox();

            Label emailLabel = new Label("Email: ");
            TextField emailField = new TextField();

            email.getChildren().add(emailLabel);
            email.getChildren().add(emailField);

            HBox date = new HBox();
            DatePicker datePicker = new DatePicker();
            
            date.getChildren().add(datePicker);

            main2.getChildren().add(name);
            main2.getChildren().add(address);
            main2.getChildren().add(email);
            main2.getChildren().add(date);


            Button confirm = new Button("Bevestigen");

            confirm.setOnAction(e -> {
                customerName = nameField.getText();
                customerAddress = addressField.getText();
                this.date = datePicker.getValue();
            
                
            Quotation q = new Quotation(solarPanels, this.date, customerName, customerAddress, meterChangeNeeded);

            State.getInstance().addQuotation(q);

            });


            main.getChildren().add(main2);
            main.getChildren().add(confirm);
            
            newQuotationPane.getChildren().add(main);
        } else {}
    }

    private void updatePanelLabel(Label label){
        label.setText("Maximaal aantal zonnepanelen: " + maxSolarPanels);
    }
} 
