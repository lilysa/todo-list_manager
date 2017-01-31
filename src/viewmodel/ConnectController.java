package viewmodel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.ControlledScreen;
import model.ScreensController;
import model.Task;
import model.User;

public class ConnectController implements Initializable, ControlledScreen {
	ScreensController myController; 
	
	@FXML	ContextMenu encours;
	@FXML	ContextMenu urgentes;
	@FXML	ContextMenu finies;
	@FXML	ContextMenu nonAttribuees;
	@FXML	ContextMenu vosTaches;
	@FXML	Accordion pretes;
	@FXML	Button createTask;
	@FXML	Button sortByEndDate;
	@FXML	Button sortByDoer;
	@FXML	Button sortByPriority;
	@FXML	Text todaysDate;
	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 todaysDate.setText(LocalDate.now().toString());
		 createTask.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	//Task t = new Task(0, "connectcon", "roller", 2, "2017-02-23", "en_cours", new User(1, "Jon Snow", "secret"), new User(2, "Peter Pan", "clochette"));
	                //if(!(AppToDoListManager.getCurrentTask() !=null))
	                		//AppToDoListManager.setCurrentTask(t);
	            	
	            	myController.loadScreen(AppToDoListManager.createTaskID, AppToDoListManager.CreateTaskFile);
	                myController.setScreen(AppToDoListManager.createTaskID);
	            }
	        });
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
