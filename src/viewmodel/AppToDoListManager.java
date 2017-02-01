package viewmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.jdom2.JDOMException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.JDOMLectureTasks;
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
    
    public static String createTaskID = "CreateTask";
    public static String CreateTaskFile = "../view/CreateTask.fxml";
    
    
    //Client variables
    public static Socket socket = null;
	public static Thread t1;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private static PrintWriter out = null;
	private static BufferedReader in = null;
	private static boolean connect = false;
    private static boolean currentTaskInitialized = false;
    
    private static User currentUser = new User();
    private static Task currentTask = new Task();

	public static void setCurrentUser(User currentUser) {
		AppToDoListManager.currentUser = currentUser;
	}
	public static User getCurrentUser(){
		return currentUser;
	}
	
	public static void setCurrentTask(Task t){
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
			socket = new Socket("127.0.0.1",2010);
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

	public static boolean isCurrentTaskInitialized() {
		return currentTaskInitialized;
	}

	public static void setCurrentTaskInitialized(boolean bool) {
		currentTaskInitialized = bool;
	}
	
	public static Task getTaskFromId(String taskNameDisplay){
		String[] splitS = taskNameDisplay.split("_");
		try {
			Task t = JDOMLectureTasks.obtainTask(splitS[1]);
			return t;
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
