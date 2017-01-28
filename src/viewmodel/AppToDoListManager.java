package viewmodel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ScreensController;

public class AppToDoListManager extends Application {
	
	public static String authentificationID = "LogIn";
    public static String AuthentificationFile = "../view/Authentification.fxml";
    
    public static String signUpID = "SignUp";
    public static String SignUpFile = "../view/SignUp.fxml";
    
    public static String connectID = "Connect";
    public static String ConnectFile = "../view/Connect.fxml";
    
    public static String takManagementID = "TaskManagement";
    public static String TaskManagementFile = "../view/TaskManagement.fxml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		
		try{
			/*Parent root = FXMLLoader.load(getClass().getResource("../view/Authentification.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Connexion");
			stage.setScene(scene);
			stage.show();*/
			
			/*FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../view/Authentification.fxml"));

			Pane myPane = (Pane)myLoader.load();

			AuthentificationController controller = (AuthentificationController) myLoader.getController();
			controller.setPrevStage(stage);
			
			SignUpController controllerSU = (SignUpController) myLoader.getController();
			controllerSU.setPreviousStage(stage);

		   Scene myScene = new Scene(myPane);        
		   stage.setScene(myScene);
		   stage.show();*/
			
		}catch(Exception e){
			e.printStackTrace();
		}

		ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(AppToDoListManager.authentificationID, AppToDoListManager.AuthentificationFile);
        mainContainer.loadScreen(AppToDoListManager.signUpID, AppToDoListManager.SignUpFile);
        mainContainer.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
        mainContainer.loadScreen(AppToDoListManager.takManagementID, AppToDoListManager.TaskManagementFile);
        
        mainContainer.setScreen(AppToDoListManager.authentificationID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
		

		   
        
	}

}
