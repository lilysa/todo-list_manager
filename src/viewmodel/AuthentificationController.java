package viewmodel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ControlledScreen;
import model.ScreensController;

public class AuthentificationController implements Initializable, 	ControlledScreen {

	@FXML
	private TextField login;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button connectButton;
	
	@FXML
	private Hyperlink signUpLink;
	
	Stage prevStage;
	ScreensController myController; 

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
	
    public void changeView(ActionEvent event, String nextView) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Connect");
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource(nextView));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

        prevStage.close();

        stage.show();
     }
    
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 connectButton.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("That was easy, wasn't it?");
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
