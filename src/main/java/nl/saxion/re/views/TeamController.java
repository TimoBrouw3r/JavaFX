package nl.saxion.re.views;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.saxion.re.components.UpcomingTask;
import nl.saxion.re.types.State;
import nl.saxion.re.types.Task;

/**
 * TeamController
 */
public class TeamController {

	@FXML
	Label taskgreet;

	@FXML
	Label clientName;

	@FXML
	Label clientAddress;

	@FXML
	VBox upList;

	@FXML
	VBox materials;

	Task mainTask;

	public void initialize() {

		mainTask = State.getInstance().getTeam().getTaskOnDay(LocalDate.now());

		taskgreet.setText("Hallo, " + State.getInstance().getUsername() + "! \n Vandaag ga je naar:");

		if (mainTask != null) {

			clientName.setText(mainTask.getClientName());
			clientAddress.setText(mainTask.getClientAddress());

			Label solar = new Label("Solar panel");
			Label solarAmount = new Label(mainTask.getAmountOfSolarPanels() + "x");

			solar.setPrefWidth(350);
			solarAmount.setPrefWidth(350);

			solar.setAlignment(Pos.CENTER);
			solarAmount.setAlignment(Pos.CENTER);

			HBox solarBox = new HBox();

			solarBox.setAlignment(Pos.CENTER);
			solarBox.setPrefWidth(930);
			solarBox.setPrefHeight(75);
			solarBox.setSpacing(50);
			solarBox.setStyle("-fx-background-color: #bbbbbb;");

			solarBox.getChildren().add(solar);
			solarBox.getChildren().add(solarAmount);

			materials.getChildren().add(solarBox);

			HBox transformerBox = new HBox();

			transformerBox.setAlignment(Pos.CENTER);
			transformerBox.setPrefWidth(930);
			transformerBox.setPrefHeight(75);
			transformerBox.setSpacing(50);
			transformerBox.setStyle("-fx-background-color: #aaaaaa;");

			Label transformer = new Label(mainTask.getTransformerType());

			transformer.setPrefWidth(700);
			transformer.setAlignment(Pos.CENTER);

			transformerBox.getChildren().add(transformer);
			materials.getChildren().add(transformerBox);

			if (mainTask.meterChangeNeeded()) {
				HBox meterBox = new HBox();

				meterBox.setAlignment(Pos.CENTER);
				meterBox.setPrefWidth(930);
				meterBox.setPrefHeight(75);
				meterBox.setSpacing(50);
				meterBox.setStyle("-fx-background-color: #bbbbbb;");

				Label meter = new Label("Meterkast aanpassen nodig");

				meter.setPrefWidth(700);
				meter.setAlignment(Pos.CENTER);

				meterBox.getChildren().add(meter);

				materials.getChildren().add(meterBox);
			}
		} else {
			clientName.setText("Geen opdracht vandaag");
		}

		ArrayList<Task> tasksInFuture = State.getInstance().getTeam().getTasksInFuture();

		System.out.println(tasksInFuture.size());

		for (Task task : tasksInFuture) {
			UpcomingTask upTask = new UpcomingTask(task);
			upList.getChildren().add(upTask);
		}

	}
}
