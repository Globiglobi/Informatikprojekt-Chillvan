package dalmuti.WBmarco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	//Attribute
	static Socket socket;
	static BufferedReader reader;
	static OutputStreamWriter writer;
	
	public static String messageClient;
	static String messageServer;
	
	public static String userNickname;
	
	
	//Methoden
	//Methode zum senden Daten
	public static void send(){
		//try und catch muss sein, da bei Netzwerkkommuniaktion immer etwas schief gehen kann
		try {
			//socket, reader, writer erstellen
			socket = new Socket("127.0.0.1", 50005);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new OutputStreamWriter(socket.getOutputStream());
			
			//message senden vom Client
			messageClient = userNickname; //Welche message möchte ich senden?
			writer.write(messageClient);
			writer.flush();
			
			////message lesen vom Server (Was hat der Server zum sagen?)
			String messageIn = reader.readLine();
			messageServer = messageIn; 
			
			//clean up
			socket.close();
			reader.close();
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
	}
	

	//Main-Methode
	public static void main(String[] args) {
		
		Login login1 = new Login();
		userNickname = login1.nickname;
		
		Client client1 = new Client();
		Server server = new Server();
		

	}

}
