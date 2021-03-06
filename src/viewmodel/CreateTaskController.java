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
import javafx.scene.paint.Paint;
import model.ControlledScreen;
import model.ScreensController;
import model.Task;
import model.User;

public class CreateTaskController implements Initializable, ControlledScreen{

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
	static Paint valueError = Paint.valueOf("EEA9C5");
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 	
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
	            		      
	            	try {
	            		
	            		int idActor;
	            		if (chooseMaker.getText().isEmpty()) {
	            			idActor = -2;
	            		}else {
	            			idActor = User.existActor(chooseMaker.getText());
	            		}
	            		
	            			
	            			String namet = " ";
	            			if (taskNameDisplay.getText().isEmpty()) {
	            				taskNameDisplay.setStyle("-fx-control-inner-background: #"+valueError.toString().substring(2));

	            			} else 
	            				namet  = taskNameDisplay.getText();
	            		
	            			String contenut = descriptionText.getText();
	            			if (descriptionText.getText().isEmpty())
	            				contenut = " ";
	            		
	            			int priorityt ;
	            			String p = choosePriority.getValue();
	            			if(!(p!=null)){
	            				priorityt = 0;
	            			}else
	            				priorityt = Integer.parseInt(choosePriority.getValue());
	            			
	            			String datet = " ";
	            			
	            			if (!(endDateDisplay.getValue()!=null)) {
	            				endDateDisplay.setStyle("-fx-control-inner-background: #"+valueError.toString().substring(2));
	            			} else
	            				datet = endDateDisplay.getValue().toString();
	            		
	            			String statet;
	            			if (!(chooseState.getValue()!=null)) {
	            				statet = "Pr�te";
	            			}else 
	            				statet = chooseState.getValue();
	            		
	            		int idAuthor = AppToDoListManager.getCurrentUser().getId_user();
						
	            		if ((idActor != -1)&&(!namet.equals(" "))&&(!datet.equals(" "))){
							User.create_task(new Task(0, namet, contenut, priorityt, datet, statet,idAuthor,idActor));
							myController.unloadScreen(AppToDoListManager.connectID);
			            	myController.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
			            	myController.setScreen(AppToDoListManager.connectID);
						}else {
							if (idActor == -1) {
							chooseMaker.setStyle("-fx-control-inner-background: #"+valueError.toString().substring(2));
							}
						}
						
					} catch (JDOMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            }
	        });
		 	
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
	
}
