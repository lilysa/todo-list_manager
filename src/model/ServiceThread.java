package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceThread extends Thread{
	 protected Socket socket;
	 int counter;

	    public ServiceThread(Socket clientSocket, int clientCounter) {
	        this.socket = clientSocket;
	        counter = clientCounter;
	    }

	    public void run() {
	    	InputStream inStream = null;
			OutputStream outStream = null;
			BufferedReader bufferReader = null;
			String received;
			PrintStream response;
			
	        try {
	        	
				inStream = socket.getInputStream();
				outStream = socket.getOutputStream();
				
				bufferReader = new BufferedReader(new InputStreamReader(inStream));
				
				
				received = bufferReader.readLine();
				response = new PrintStream(outStream);
				response.println("client " + counter + " obtenu : " + received);
				socket.close();
				
	        } catch (IOException e) {
	            return;
	        }
	    }
	
}
