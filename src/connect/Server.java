package connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static int clientCounter = 0;
	private static boolean disconnect = false;
	
	public static void main(String[] args) {
		Socket socket;
		InputStream inStream;
		OutputStream outStream;
		BufferedReader bufferReader;
		String received;
		PrintStream response;
		try {
			ServerSocket listener = new ServerSocket(4578);
			while(!disconnect){
				socket = listener.accept();
				clientCounter ++;
				new ServiceThread(socket, clientCounter).start();
				inStream = socket.getInputStream();
				outStream = socket.getOutputStream();
				
				bufferReader = new BufferedReader(new InputStreamReader(inStream));
				received = bufferReader.readLine();
				response = new PrintStream(outStream);
				response.println("client " + clientCounter + " obtenu : " + received);
				socket.close();
			}
			System.out.println("Fin connexion");
			listener.close();
		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}



