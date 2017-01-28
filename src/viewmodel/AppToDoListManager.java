package viewmodel;

import view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppToDoListManager extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 launch(args);
	}

	@Override
	public void start(Stage stage){
		// TODO Auto-generated method stub
		
		try{
			Parent root = FXMLLoader.load(getClass().getResource("../view/Authentification.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Connexion");
			stage.setScene(scene);
			stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}

        
        
        
	}

}
