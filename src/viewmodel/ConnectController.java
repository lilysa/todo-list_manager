package viewmodel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import model.ControlledScreen;
import model.ScreensController;

public class ConnectController implements Initializable, ControlledScreen {
	ScreensController myController; 
	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
