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

public class AuthentificationController implements Initializable {

	@FXML
	private TextField login;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button connectButton;
	
	@FXML
	private Hyperlink signUpLink;
	
	Stage prevStage;

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 connectButton.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("That was easy, wasn't it?");
	                Stage stage = new Stage();
	                stage.setTitle("Shop Management");
	                Pane myPane = null;
	                try {
						myPane = FXMLLoader.load(getClass().getResource("Connect.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                Scene scene = new Scene(myPane);
	                stage.setScene(scene);

	                prevStage.close();

	                stage.show();
	            }
	        });

	    }
}
