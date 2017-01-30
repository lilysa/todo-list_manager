package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
	            	String identifiers = login.getText() + "_" +password.getText();
	            	AppToDoListManager.sendConnectServer("connection" + "_" +identifiers);
					String response = AppToDoListManager.readAnswerFromServer();
	            	String[] splitResponse = response.split("_");
	            	
	            	if(splitResponse[0].equals("true")){
	            		System.out.println(splitResponse[1] + " " + splitResponse[2]);
	            		AppToDoListManager.setCurrentUser(new User(Integer.parseInt(splitResponse[2]), splitResponse[1], "x"));
	                	myController.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
	                	myController.setScreen(AppToDoListManager.connectID);
	            	}else{
	            		password.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));;
	                	login.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));;
	            	}
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
