package nl.saxion.re.types;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Singleton to hold user data. this makes it possible to pass data trough
 * scenes.
 */

// NOTE: singleton might not be the best way to go about this, but itll work!
public final class State {
	private final static State instance = new State();

	private String username;
	private UserTypes userType;
	private ArrayList<Task> tasks = new ArrayList<>();
	private ArrayList<Quotation> quotations = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private Team userTeam = null; 

	public static void initialise() {
        // add some test teams
		Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Team team3 = new Team("Team 3");
        Team team4 = new Team("Team 4");
		// add some test tasks at random dates

        instance.teams.add(team1);
        instance.teams.add(team2);
        instance.teams.add(team3);
        instance.teams.add(team4);

        instance.userTeam = team1;


		Task teamTask = new Task(LocalDate.now(), "Test Name", "Test Lane 42");
	    //	teamTask.setTeam(team1);

        Task teamTask2 = new Task(LocalDate.now().plusDays(1), "Test Name sdafhksdf", "Test Lane 42");
        teamTask2.setTeam(team1);

		instance.tasks.add(teamTask);
		instance.tasks.add(teamTask2);
        instance.tasks.add(new Task(LocalDate.now(), "Test Name 1", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now(), "Test Name 2", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now(), "Test Name 3", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now().plusDays(5), "Test Name 4", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now().plusDays(4), "Test Name 5", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now().minusDays(3), "Test Name 6", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now().minusDays(4), "Test Name 7", "Test Lane 42"));
		instance.tasks.add(new Task(LocalDate.now().plusWeeks(2), "Test Name 8", "Test Lane 42"));

	}

	public static State getInstance() {
		return instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public ArrayList<Task> getTasksOnDate(LocalDate date) {
		ArrayList<Task> tasksOnDate = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getDate().equals(date)) {
				tasksOnDate.add(task);
			}
		}
		return tasksOnDate;
	}
    public ArrayList<Team> getTeamsOnDate(LocalDate date) {
        ArrayList<Team> teamsOnDate = new ArrayList<>();
        for (Team team : teams) {
            if (team.isFreeOnDate(date)) {
                teamsOnDate.add(team);
            }
        }
        return teamsOnDate;
    }

	public ArrayList<Quotation> getQuotations() {
		return quotations;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void addQuotation(Quotation quotation) {
		quotations.add(quotation);
	}
    
    public Team getTeam(){
        return userTeam; 
    }

    public void setUserTeam(Team team){
        this.userTeam = team;
    }
} 
