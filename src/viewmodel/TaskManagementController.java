package viewmodel;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.jdom2.JDOMException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ControlledScreen;
import model.ScreensController;

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
	
	static LocalDate date ;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	   
		 if(AppToDoListManager.isCurrentTaskInitialized()){ //préchargement des champs
			 System.out.println("TM" + AppToDoListManager.getCurrentTask().toString());
		 	taskNameDisplay.setText(AppToDoListManager.getCurrentTask().getName_task());
		 	try {
				chooseMaker.setText(AppToDoListManager.getCurrentTask().getNameActor(AppToDoListManager.getCurrentTask().getId_actor()));
			} catch (JDOMException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	date = LocalDate.parse(AppToDoListManager.getCurrentTask().getFinal_date_task(), formatter);
		 	endDateDisplay.setValue(date);
		 	choosePriority.getSelectionModel().select(AppToDoListManager.getCurrentTask().getPriority_task());
		 	descriptionText.setText(AppToDoListManager.getCurrentTask().getContent_task());
		 	chooseState.getSelectionModel().select(AppToDoListManager.getCurrentTask().getState_task());
		 }
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
	                //si etat a été modif, vérif si currentUser == actor alros appel à change_task
	            		//--> chooseState.getValue() != apptodoManager.getcurrentTask().getState()
	            		//--> si getcurrentTask.getActor != getcurrentuser
	            	//sinon etat en rouge et pas d'appel
	            	//si idCurrentSUer == id tache alors on peut la supprimer
	            	//si pas de modif d'état appel de change_task
	            	
	            	myController.setScreen(AppToDoListManager.connectID);
	            }
	        });
		 	
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
