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

public class SignUpController implements Initializable, ControlledScreen {
	@FXML
	private TextField userName;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField confirmPassword;
	
	@FXML
	private Button createAccount;
	
	@FXML
	private Hyperlink home;
	
	ScreensController myController; 
    
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 createAccount.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	                
	                myController.setScreen(AppToDoListManager.connectID);
	            }
	        });

		 home.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	                
	                myController.setScreen(AppToDoListManager.authentificationID);
	            }
	        });
		 
	    }
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}