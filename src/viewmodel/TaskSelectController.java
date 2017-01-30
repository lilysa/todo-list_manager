package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskSelectController implements Initializable {
	
	@FXML Button edit;
	@FXML Button delete;
	@FXML Label nameLabel;
	@FXML Label actorLabel;
	@FXML Label endDateLabel;
	@FXML Label contentLabel;
	@FXML Label priorityLabel;
	@FXML Label stateLabel;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO
            }
        });
		delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO
            }
        });
		
		nameLabel.setText(AppToDoListManager.getCurrentTask().getName_task());
		contentLabel.setText(AppToDoListManager.getCurrentTask().getContent_task());
		priorityLabel.setText(Integer.toString(AppToDoListManager.getCurrentTask().getPriority_task()));
		endDateLabel.setText(AppToDoListManager.getCurrentTask().getFinal_date_task());
		stateLabel.setText(AppToDoListManager.getCurrentTask().getState_task());
		//actorLabel.setText(AppToDoListManager.getCurrentTask().getId_actor());
		
		
		
		
	}

}
