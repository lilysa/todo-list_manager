package viewmodel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ControlledScreen;
import model.ScreensController;
import model.Task;
import model.User;

public class TaskManagementController implements Initializable, ControlledScreen {
	ScreensController myController; 
	
	@FXML Button saveButton;
	@FXML Button cancelButton;
	@FXML TextField taskNameDisplay;
	@FXML TextArea descriptionText;
	@FXML DatePicker endDateDisplay;
	@FXML ComboBox<String> choosePriority;
	@FXML ComboBox<String> chooseState;
	@FXML TextField chooseMaker;
	
	static LocalDate date;
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
		 	//taskNameDisplay.setText(AppToDoListManager.getCurrentTask().getName_task());
		 	//chooseMaker.setText(AppToDoListManager.getCurrentTask().getId_actor().getName_user());
		 	//endDateDisplay.setValue(date.parse(AppToDoListManager.getCurrentTask().getFinal_date_task()));
		 	//choosePriority.getSelectionModel().select(AppToDoListManager.getCurrentTask().getPriority_task());
		 	//descriptionText.setText(AppToDoListManager.getCurrentTask().getContent_task());
		 	//chooseState.getSelectionModel().select(AppToDoListManager.getCurrentTask().getState_task());
		 	
		 	/*Button Action Definitions*/
		 	cancelButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                myController.setScreen(AppToDoListManager.connectID);
	            }
	        });
		 	
		 	saveButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	//AppToDoListManager.setCurrentTask(new Task(7, taskNameDisplay.getText(), descriptionText.getText(), Integer.parseInt(choosePriority.getValue()), endDateDisplay.getValue().toString(),chooseState.getPromptText(), u, AppToDoListManager.getCurrentUser()));
	            		//potentiellement ici on unloaderait connect screen pour le reloader pour "actualiser"
	                myController.setScreen(AppToDoListManager.connectID);
	            }
	        });
		 	
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
