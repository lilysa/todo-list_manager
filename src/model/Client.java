package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static Socket socket = null;
	public static Thread t1;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private static PrintWriter out = null;
	private static BufferedReader in = null;
	private static boolean connect = false;
	
	public static void main(String[] args) {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
		
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
		
		while(!connect){
			
		}
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

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