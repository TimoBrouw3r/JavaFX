package nl.saxion.re.types;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Team
 */
public class Team {

	private String name;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private ArrayList<String> names = new ArrayList<String>();
    private String password;

    public boolean isFreeOnDate(LocalDate date) {
        for (Task task : tasks) {
            if (task.getDate().equals(date)) {
                return false;
            }
        }
        return true;
    }

    public void addTask(Task task) {
    

        if (!isFreeOnDate(task.getDate())){
            // remove task currently at that date from list 

            for (Task t : tasks) {
                if (t.getDate().equals(task.getDate())) {
                    tasks.remove(t);
                    break;
                }
            }
        }

        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<Task> getTasksInFuture() {
        ArrayList<Task> tasksInFuture = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getDate().isAfter(LocalDate.now())) {
                tasksInFuture.add(task);
            }
        }
        return tasksInFuture;
    }

    public Team(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Task getTaskOnDay(LocalDate date) {
        for (Task task : tasks) {
            if (task.getDate().equals(date)) {
                return task;
            }
        }
        return null;
    }
    
    public void addNameToTeam(String name) {
    	names.add(name);
    }

    public boolean nameInTeam(String name) {
    	return names.contains(name);
    }

}
