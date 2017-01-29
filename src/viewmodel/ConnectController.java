package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.ControlledScreen;
import model.ScreensController;
import model.Task;
import model.User;

public class ConnectController implements Initializable, ControlledScreen {
	ScreensController myController; 
	
	@FXML	VBox en_cours;
	@FXML	VBox urgentes;
	@FXML	VBox finies;
	@FXML	VBox non_attribuees;
	@FXML	VBox vos_taches;
	@FXML	VBox pretes;
	@FXML	Button createTask;
	@FXML	Button sortByEndDate;
	@FXML	Button sortByDoer;
	@FXML	Button sortByPriority;
	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 createTask.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	            	/*Task t = new Task(0, "connectcon", "roller", 3, "01/02/2017", "en_cours", new User(1, "Jon Snow", "secret"), new User(2, "Peter Pan", "clochette"));
	                AppToDoListManager.setCurrentTask(t);
	                AppToDoListManager.test.setName_task("bouh");
	                AppToDoListManager.test.setPriority_task(4);
	                AppToDoListManager.setCurrentTask(t);*/
	                myController.setScreen(AppToDoListManager.takManagementID);
	            }
	        });
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
