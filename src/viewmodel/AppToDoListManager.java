package viewmodel;

import view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
			/*Parent root = FXMLLoader.load(getClass().getResource("../view/Authentification.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Connexion");
			stage.setScene(scene);
			stage.show();*/
			
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../view/Authentification.fxml"));

			Pane myPane = (Pane)myLoader.load();

			AuthentificationController controller = (AuthentificationController) myLoader.getController();

			controller.setPrevStage(stage);

		   Scene myScene = new Scene(myPane);        
		   stage.setScene(myScene);
		   stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}

        
		

		   
        
	}

}
