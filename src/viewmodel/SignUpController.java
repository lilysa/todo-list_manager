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
import javafx.scene.paint.Paint;
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
	static Paint valueError = Paint.valueOf("EEA9C5");
    static Paint valueValid = Paint.valueOf("AAEE9B");
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 
		 createAccount.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                if(!password.getText().equals(confirmPassword.getText())){
	                	confirmPassword.setStyle("-fx-control-inner-background: #"+valueError.toString().substring(2));
	                }else{
	                	confirmPassword.setStyle("-fx-control-inner-background: #"+valueValid.toString().substring(2));;
	                	String identifiers = userName.getText() + "_" + password.getText();
	                	AppToDoListManager.sendConnectServer("signUp" + "_" + identifiers);
						String response = AppToDoListManager.readAnswerFromServer();
						String[] splitResponse = response.split("_");
						if(splitResponse[0].equals("true")){
							myController.setScreen(AppToDoListManager.authentificationID);
						}else{
							userName.setStyle("-fx-control-inner-background: #"+valueError.toString().substring(2));
						}
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