package viewmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
    
    public static String taskManagementID = "TaskManagement";
    public static String TaskManagementFile = "../view/TaskManagement.fxml";
    
    //Client variables
    public static Socket socket = null;
	public static Thread t1;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private static PrintWriter out = null;
	private static BufferedReader in = null;
	private static boolean connect = false;
    
    
    //private static Task currentTask = new Task(0, "app", "todolist", 0, "25/02/2017", "finie", new User(1, "Rex", "toutou"), new User(2, "stich", "lilo"));
    //public static Task test = new Task(0, "app2", "totodolsit", 2, "01/05/2017", "prete", new User(3, "Kirikou", "secret"), new User(4, "Sorciere", "clochette"));
    //private static User currentUser = new User(9, "Dr. Acula", "Vlad");
    private static User currentUser = null;
    private static Task currentTask = null;
    
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
		
		//Client connection
		try {
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1",2009);
			System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
			
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
			
		} catch (UnknownHostException e) {
		  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
		  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}
		
		ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(AppToDoListManager.authentificationID, AppToDoListManager.AuthentificationFile);
        mainContainer.loadScreen(AppToDoListManager.signUpID, AppToDoListManager.SignUpFile);
        //mainContainer.loadScreen(AppToDoListManager.connectID, AppToDoListManager.ConnectFile);
        //mainContainer.loadScreen(AppToDoListManager.taskManagementID, AppToDoListManager.TaskManagementFile);
        
        mainContainer.setScreen(AppToDoListManager.authentificationID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

		   
        
	}
	
	public static void sendConnectServer(String msgToSend){
		out.println(msgToSend);
		out.flush();
	}
	
	
	public static String readAnswerFromServer(){
		try{
			return in.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return "echec de lecture";
	}

}
