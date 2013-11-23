package dalmuti.WBmarco;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable  {
	
	//Attribute
	private static Server server;
	private static Thread serverThread;
	
	private JTextArea txtAnzeige;
	
	// Konstruktor
	public Server() {
		// Titel Fenster setzen
		super("Server");
		
		// set Layout Manager
		this.setLayout(new BorderLayout());
		
		// Create controls
		txtAnzeige = new JTextArea();
		txtAnzeige.setEnabled(false);
		this.add(txtAnzeige, BorderLayout.CENTER);
		
		// Dynamic layout
		this.pack();
		
		// Show result
		this.setVisible(true);
		
	}


	//Main-Methode
	public static void main(String[] args) {
		Server server = new Server();
		serverThread = new Thread(server, "Listener");
		serverThread.run();

	}


	@Override
	public void run() {
		try{
			//Create the server socket, to listen for incoming request
			ServerSocket listener = new ServerSocket(50018);
			
			while(true){
				// Wait for and accept incoming request
				Socket socket = listener.accept();
				
				//Create reader and writer
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
				
				//read the incoming message and outwrite the incoming message
				String client = reader.readLine();
				txtAnzeige.setText(txtAnzeige.getText());
				
				//write out confirmation (bestätigung für Empfang)
				writer.write("Received your message: " + client);
				writer.flush();
				
				//Clean up
				reader.close();
				writer.close();
				socket.close();
				
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
			
		}
	}

}
