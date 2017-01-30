package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import model.ControlledScreen;
import model.ScreensController;
import model.User;

public class AuthentificationController implements Initializable, 	ControlledScreen {

	@FXML
	private TextField login;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button connectButton;
	
	@FXML
	private Hyperlink signUpLink;
	
	ScreensController myController; 


	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 
		 connectButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
	                //si l'user et mdp sont corrects
	                	AppToDoListManager.setCurrentUser(new User(5, login.getText(), password.getText()));
	                	myController.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
	                	myController.setScreen(AppToDoListManager.connectID);
	            }
	        });

		 signUpLink.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("That was easy, wasn't it?");
	                myController.setScreen(AppToDoListManager.signUpID);
	            }
	        });
		 
	    }
	 
		public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
