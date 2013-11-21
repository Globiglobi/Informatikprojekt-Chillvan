package dalmuti.WBmarco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	//Attribute
	Socket socket;
	BufferedReader reader;
	OutputStreamWriter writer;
	
	String messageClient;
	String messageServer;
	
	
	//Methoden
	//Methode zum "irgendetwas" senden (irgendetwas noch nicht komplett weil man noch nicht weiss was genau senden)
	public void send(){
		//try und catch muss sein, da bei Netzwerkkommuniaktion immer etwas schief gehen kann
		try {
			//socket, reader, writer erstellen
			socket = new Socket("127.0.0.1", 50000);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new OutputStreamWriter(socket.getOutputStream());
			//"irgendetwas definieren"
			
			//message senden vom Client
			messageClient = " "; //bei " " muss irgendetwas stehen (message die man senden möchte definieren)
			writer.write(messageClient); 
			writer.flush();
			////message lesen vom Server (Was hat der Server zum sagen?)
			String messageIn = reader.readLine();
			messageServer = messageIn; //statt eine String Bootschaft kann es auch etwas anderes sein
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

	}

}
