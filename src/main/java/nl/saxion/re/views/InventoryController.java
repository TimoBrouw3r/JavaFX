package nl.saxion.re.views;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import nl.saxion.re.components.TaskDescription;
import nl.saxion.re.types.State;
import nl.saxion.re.types.Task;

/**
 * InventoryController
 */
public class InventoryController {

 @FXML
 VBox tasks; 

 @FXML 
 DatePicker datePicker;


 ArrayList<Task> taskList;
 ArrayList<TaskDescription> taskDescriptionList = new ArrayList<TaskDescription>();
	
 @FXML
 void onDateChanged(){
    taskList = State.getInstance().getTasksOnDate(datePicker.getValue());

    update();
 }

 @FXML
 void buyMaterials(){
        TaskDescription selected; 

        for(TaskDescription taskDescription : taskDescriptionList){
            if(taskDescription.isSelected()){
                selected = taskDescription;
                selected.getTask().setMaterialsOrdered(true);
            }
        }

        update();
 }


 void update(){
    tasks.getChildren().clear();
    for(Task task : taskList){

        TaskDescription taskDescription = new TaskDescription(task, task.isMaterialsOrdered());
        taskDescriptionList.add(taskDescription);

        tasks.getChildren().add(taskDescription);
    }


 }
}
