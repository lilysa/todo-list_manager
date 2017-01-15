package connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		InputStream inStream;
		OutputStream outStream;
		BufferedReader bufferReader;
		
		try {
			socket = new Socket("localhost", 4578);
			inStream = socket.getInputStream();
			outStream = socket.getOutputStream();
			
			/* --- Ce qu'on envoie au serveur --- */
			PrintStream ps = new PrintStream(outStream);
			ps.println("connexation ");
			
			bufferReader = new BufferedReader(new InputStreamReader(inStream));
			String response = bufferReader.readLine();
			System.out.println("reponse du serveur : "+ response);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

}
