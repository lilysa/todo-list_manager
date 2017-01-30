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
	                if(!password.getText().equals(confirmPassword.getText())){
	                	confirmPassword.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));;
	                	//aussi : check si user existe déjà dans fichier
	                }else{
	                	String identifiers = userName.getText() + "_" + password.getText();
	                	AppToDoListManager.sendConnectServer("signUp" + "_" + identifiers);
						String response = AppToDoListManager.readAnswerFromServer();
						String[] splitResponse = response.split("_");
						if(splitResponse[0].equals("true")){
							myController.setScreen(AppToDoListManager.authentificationID);
						}else{
							userName.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));;
						}
	                	//myController.setScreen(AppToDoListManager.connectID);
	                }
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