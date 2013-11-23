package dalmuti.WBmarco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	//Attribute
	public static Socket socket;
	public static BufferedReader reader;
	public static OutputStreamWriter writer;
	
	public static String messageClient;
	public static String messageServer;
	
	
	//Methoden
	//Methode zum "irgendetwas" senden (irgendetwas noch nicht komplett weil man noch nicht weiss was genau senden)
	public static void send(){
		//try und catch muss sein, da bei Netzwerkkommuniaktion immer etwas schief gehen kann
		try {
			//socket, reader, writer erstellen
			socket = new Socket("127.0.0.1", 50018);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new OutputStreamWriter(socket.getOutputStream());
			
			//Message senden vom Client
			//w.write(txtNewMessage.getText() + "\n");
			//messageClient = "Hallo";//Login.nickname; // Welche Message soll zum Server gesendet werden?
			writer.write(Login.tfEnterNickname.getText() + "\n"); 
			writer.flush();
			
			//Message lesen vom Server (Was hat der Server zum sagen?)
			String messageIn = reader.readLine();
			messageServer = messageIn;
			System.out.println(messageServer);
			
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
		
		Login l1 = new Login();
		
		//c1.send();
		//Server s1 = new Server();

	}

}
