package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TaskController implements Initializable {

	@FXML Label nameLabel;
	@FXML Label actorLabel;
	@FXML Label endDateLabel;
	@FXML Label priorityLabel;
	
	@FXML public void handleTaskClicked(MouseEvent arg0){
		//Ici ou dans le connectController ?
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Comment initialiser ??
		
	}
	

}
