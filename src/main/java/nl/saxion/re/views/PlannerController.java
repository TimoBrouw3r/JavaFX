package nl.saxion.re.views;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.saxion.re.components.PlannerTeamDescription;
import nl.saxion.re.components.QuotationDescription;
import nl.saxion.re.components.TaskDescription;
import nl.saxion.re.types.State;
import nl.saxion.re.types.Task;
import nl.saxion.re.types.Team;

/**
 * PlannerController
 */
public class PlannerController {

    @FXML
    DatePicker datePicker;

    @FXML
    VBox tasks;

    @FXML
    VBox teams;

    private ArrayList<TaskDescription> taskDescriptions = new ArrayList<>();
    private ArrayList<PlannerTeamDescription> teamDescriptions = new ArrayList<PlannerTeamDescription>();

    public void initialize() {
    }

    @FXML
    public void onDateChanged() {
    
        update(); 

    }

    @FXML
    public void onAssignTask() {
        TaskDescription selectedTask = null; 
        for(TaskDescription td : taskDescriptions) {
            if(td.isSelected()) {
                selectedTask = td;
                break;
            }
        }

        PlannerTeamDescription selectedTeam = null;
        for(PlannerTeamDescription td : teamDescriptions) {
            if(td.selected) {
                selectedTeam = td;
                break;
            }
        }
       
        if(selectedTask == null || selectedTeam == null) {
            return;
        }

        if(selectedTask.getTask().getTeam() != null) {
            selectedTask.getTask().getTeam().removeTask(selectedTask.getTask());
        }

       selectedTask.getTask().setTeam(selectedTeam.getTeam()); 

        update();    
    }


    public void update(){
        this.tasks.getChildren().clear();
        this.taskDescriptions.clear();

        this.teams.getChildren().clear();
        this.teamDescriptions.clear();


        System.out.println("date changed to " + datePicker.getValue());
        ArrayList<Task> tasks = State.getInstance().getTasksOnDate(datePicker.getValue());
        ArrayList<Team> teams = State.getInstance().getTeamsOnDate(datePicker.getValue());


        if(tasks.size() == 0) {
            Label noTasks = new Label("Geen taken gevonden voor deze datum");
            this.tasks.getChildren().add(noTasks);
            return;
        }


        for(Task t : tasks) {
            TaskDescription td = new TaskDescription(t, t.getTeam() != null);
            this.tasks.getChildren().add(td);
            taskDescriptions.add(td);

        }

        if(teams.size() == 0) {
            Label noTeams = new Label("Geen teams gevonden voor deze datum");
            this.teams.getChildren().add(noTeams);
            return;
        }

        for(Team t : teams) {
            PlannerTeamDescription td = new PlannerTeamDescription(t);
            this.teams.getChildren().add(td);
            teamDescriptions.add(td);
        }
    }
	
}
