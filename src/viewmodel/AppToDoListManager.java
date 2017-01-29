package viewmodel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ScreensController;
import model.Task;
import model.User;

public class AppToDoListManager extends Application {
	
	public static String authentificationID = "LogIn";
    public static String AuthentificationFile = "../view/Authentification.fxml";
    
    public static String signUpID = "SignUp";
    public static String SignUpFile = "../view/SignUp.fxml";
    
    public static String connectID = "Connect";
    public static String ConnectFile = "../view/Connect.fxml";
    
    public static String takManagementID = "TaskManagement";
    public static String TaskManagementFile = "../view/TaskManagement.fxml";
    
    //private static Task currentTask = new Task(0, "app", "todolist", 0, "25/02/2017", "finie", new User(1, "Rex", "toutou"), new User(2, "stich", "lilo"));
    public static Task test = new Task(0, "app2", "totodolsit", 2, "01/05/2017", "prete", new User(3, "Kirikou", "secret"), new User(4, "Sorciere", "clochette"));
    private static User currentUser = new User(9, "Dr. Acula", "Vlad");
    private static Task currentTask = null;
	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		AppToDoListManager.currentUser = currentUser;
	}

	public static void setCurrentTask(Task t){
		/*AppToDoListManager.currentTask.setActor_task(t.getActor_task());
    	AppToDoListManager.currentTask.setAuthor_task(t.getAuthor_task());
    	AppToDoListManager.currentTask.setContent_task(t.getContent_task());
    	AppToDoListManager.currentTask.setFinal_date_task(t.getFinal_date_task());
    	AppToDoListManager.currentTask.setId_task(t.getId_task());
    	AppToDoListManager.currentTask.setName_task(t.getName_task());
    	AppToDoListManager.currentTask.setPriority_task(t.getPriority_task());
    	AppToDoListManager.currentTask.setState_task(t.getState_task());*/
		currentTask = t;
    }
    
    public static Task getCurrentTask(){
    	return currentTask;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		
		ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(AppToDoListManager.authentificationID, AppToDoListManager.AuthentificationFile);
        mainContainer.loadScreen(AppToDoListManager.signUpID, AppToDoListManager.SignUpFile);
        //mainContainer.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
        //mainContainer.loadScreen(AppToDoListManager.takManagementID, AppToDoListManager.TaskManagementFile);
        
        mainContainer.setScreen(AppToDoListManager.authentificationID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

		   
        
	}

}
