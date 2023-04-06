package nl.saxion.re.components;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import nl.saxion.re.types.Task;

/**
 * TestController
 */
public class TaskDescription extends HBox {

    @FXML
    Label name;

    @FXML
    Label address;

    @FXML
    CheckBox teamAssigned;

    @FXML
    Pane taskDescriptionPane;

    private static ArrayList<TaskDescription> taskDescriptions = new ArrayList<>();
    private Task task; 
    boolean selected = false;
    
    public TaskDescription(Task task, boolean selected) {
        this.task = task;
        taskDescriptions.add(this);
    

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskDescription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(TaskDescription.this);

        this.onMouseClickedProperty().set(e -> handleMouseClick(e));
        
        try {
            fxmlLoader.load();
            System.out.println("loaded xml!");
        } catch (Exception e){
            System.err.println(e);
        }

        teamAssigned.setDisable(true);

        name.setText(task.getClientName());
        address.setText(task.getClientAddress());
        // teamAssigned.setSelected(task.getTeam() != null);
        teamAssigned.setSelected(selected);

    }

    private void handleMouseClick(MouseEvent e){
        System.out.println("clicked");

        for (TaskDescription taskDescription : taskDescriptions){
            if(taskDescription != this){
                taskDescription.selected = false;
            } else { 
                taskDescription.selected = true;
            }

            taskDescription.update();
        }
    }

    public void update(){
        if(selected){
            taskDescriptionPane.setStyle("-fx-background-color: #aaaaaa");
        } else {
            taskDescriptionPane.setStyle("-fx-background-color: #ffffff");
        }
    }

    public boolean isSelected() {
        return selected;
    }

    // NOTE: REMOVE, ONLY FOR TESTING
    public String getName() {
        return name.getText();
    }

    public Task getTask() {
        return task;
    }
}
