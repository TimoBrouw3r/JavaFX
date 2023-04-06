package nl.saxion.re.components;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import nl.saxion.re.types.Task;
import nl.saxion.re.types.Team;

/**
 * PlannerTeamDescription
 */
public class PlannerTeamDescription extends HBox{

    @FXML
   Label teamName;

    static ArrayList<PlannerTeamDescription> teamDescriptions = new ArrayList<PlannerTeamDescription>();
    public boolean selected = false;
    private Team team; 

    public PlannerTeamDescription(Team team) {
        this.team = team;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlannerTeamDescription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.setOnMouseClicked(this::handleMouseClick);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
       
        teamName.setText(team.getName());


        teamDescriptions.add(this);


    }


    public void handleMouseClick(MouseEvent event) {
        for(PlannerTeamDescription teamDescription : teamDescriptions) {
            if(teamDescription != this) {
                teamDescription.selected = false;
                teamDescription.update();
            } else{
                teamDescription.selected = true;
                teamDescription.update();
            }
        }
    }

    public void update(){
        if(selected){
            setStyle("-fx-background-color: #aaaaaa;");
        } else {
            setStyle("-fx-background-color: #ffffff;");
        }
    }
    
    public Team getTeam(){
        return team;
    }
} 
