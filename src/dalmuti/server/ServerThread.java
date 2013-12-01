package dalmuti.server;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
	private Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		){
			//definition was der server empfangen und senden kann
			//while-schlaufe mit der spiellogik
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

}
