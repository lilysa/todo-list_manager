package model;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ConnectionClient implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	public ConnectionClient(Socket s){
		
		socket = s;
	}
	
	public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
	
		
		while(!connect ){
		
		System.out.println(in.readLine()); //lit message du serveur
		login = sc.nextLine(); //lit entrée au clavier
		out.println(login); //envoie login au serveur
		out.flush();
		
		System.out.println(in.readLine()); //lit message du serveur
		pass = sc.nextLine(); //lit entrée au clavier
		out.println(pass); //envoie mdp serveur
		out.flush();
		
		if(in.readLine().equals("connecte")){
			
		System.out.println("Je suis connecté "); 
		connect = true;
		  }
		
		else {
			System.err.println("Vos informations de connexion sont incorrectes "); 
		  }
		
	}		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
	}

}
