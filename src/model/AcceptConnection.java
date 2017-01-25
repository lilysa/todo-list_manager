package model;


import java.io.*;
import java.net.*;


public class AcceptConnection implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;

	public Thread t1;
	public AcceptConnection(ServerSocket ss){
	 socketserver = ss;
	}
	
	public void run() {
		
		try {
			while(true){
				
			socket = socketserver.accept();
			System.out.println("Un utilisateur veut se connecter  ");
			
			t1 = new Thread(new Authentification(socket));
			t1.start();
			
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}
