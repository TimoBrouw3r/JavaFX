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
		Team team1 = new Team("Team 1", "passw03");
		Team team2 = new Team("Team 2", "passw04");
		Team team3 = new Team("Team 3", "passw05");
		Team team4 = new Team("Team 4", "passw06");
       
        // add some random tasks

        Task task1 = new Task(LocalDate.now(), "John Smith", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task2 = new Task(LocalDate.now(), "Amy Pond", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task3 = new Task(LocalDate.now().plusDays(2), "Rory Williams", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task4 = new Task(LocalDate.now().plusDays(4), "River Song", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task5 = new Task(LocalDate.now().plusDays(1), "Clara Oswald", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task6 = new Task(LocalDate.now().plusDays(5), "Rose Tyler", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task7 = new Task(LocalDate.now().plusDays(2), "Martha Jones", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task8 = new Task(LocalDate.now().plusDays(7), "Donna Noble", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task9 = new Task(LocalDate.now().plusDays(5), "Jack Harkness", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        Task task10 = new Task(LocalDate.now().plusDays(2), "Jeff Winger", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task11 = new Task(LocalDate.now().plusDays(1), "Troy Barnes", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000); 
       Task task12 = new Task(LocalDate.now().plusDays(8), "Britta Perry", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task13 = new Task(LocalDate.now().plusDays(10), "Abed Nadir", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task14 = new Task(LocalDate.now().plusDays(9), "Annie Edison", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task15 = new Task(LocalDate.now().plusDays(3), "Shirley Bennett", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task16 = new Task(LocalDate.now().plusDays(10), "Pierce Hawthorne", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task17 = new Task(LocalDate.now().plusDays(6), "Craig Pelton", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task18 = new Task(LocalDate.now().plusDays(7), "Chidi Anagonye", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task19 = new Task(LocalDate.now().plusDays(5), "Eleanor Shellstrop", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task20 = new Task(LocalDate.now().plusDays(8), "Jason Mendoza", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task21 = new Task(LocalDate.now().plusDays(9), "Tahani Al-Jamil", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task22 = new Task(LocalDate.now().plusDays(3), "Janet", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task23 = new Task(LocalDate.now().plusDays(10), "Michael", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
       Task task24 = new Task(LocalDate.now(), "Derek", "pretweg 1", 1_200_00, 20, false, TransformerType.SB5000);
        getInstance().addTask(task1);
        getInstance().addTask(task2);
        getInstance().addTask(task3);
        getInstance().addTask(task4);
        getInstance().addTask(task5);
        getInstance().addTask(task6);
        getInstance().addTask(task7);
        getInstance().addTask(task8);
        getInstance().addTask(task9);
        getInstance().addTask(task10);
        getInstance().addTask(task11);
        getInstance().addTask(task12);
        getInstance().addTask(task13);
        getInstance().addTask(task14);
        getInstance().addTask(task15);
        getInstance().addTask(task16);
        getInstance().addTask(task17);
        getInstance().addTask(task18);
        getInstance().addTask(task19);
        getInstance().addTask(task20);
        getInstance().addTask(task21);
        getInstance().addTask(task22);
        getInstance().addTask(task23);
        getInstance().addTask(task24);

        task1.setTeam(team1);
        task6.setTeam(team1);
        
        task3.setTeam(team2);
        task4.setTeam(team2);
        task5.setTeam(team2);
        
        team1.addNameToTeam("monteur1");
        team2.addNameToTeam("monteur2");

		instance.teams.add(team1);
		instance.teams.add(team2);
		instance.teams.add(team3);
		instance.teams.add(team4);

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

	public Team getTeam() {
		return userTeam;
	}

	public void setUserTeam(Team team) {
		this.userTeam = team;
	}

	public boolean checkLogin(String username, String password) {
		// check if username in teams

		for (Team team : teams) {
			if (team.nameInTeam(username) && team.getPassword().equals(password)) {
				setUserTeam(team);
				setUserType(UserTypes.INSTALLER);
				setUsername(username);
				return true;
			}
		}

		switch (username) {
			case "adviseur":

				if (password.equals("passw00")) {
					State.getInstance().setUsername("Advisor");
					State.getInstance().setUserType(UserTypes.ADVISOR);
					return true;
				} else {
					return false;
				}

			case "planner":

				if (password.equals("passw01")) {
					State.getInstance().setUsername("passw01");
					State.getInstance().setUserType(UserTypes.PLANNER);
					return true;
				} else {
					return false;
				}

			case "inkoper":

				if (password.equals("passw02")) {
					State.getInstance().setUsername("Inventory");
					State.getInstance().setUserType(UserTypes.INVENTORY);
					return true;
				} else {
					return false;
				}

			default: return false;
		}

	}


    public void quotationToTask(Quotation quotation) {
        Task task = new Task(quotation);
        tasks.add(task);
        quotations.remove(quotation);
    }
}
