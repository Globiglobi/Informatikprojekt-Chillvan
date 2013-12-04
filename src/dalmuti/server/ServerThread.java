package dalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket = null;
	protected long userID;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		try{
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			//definition was der server empfangen und senden kann
			//while-schlaufe mit der spiellogik
			
			//syso vom nickname
			Object inputObject;
			//userID = Thread.currentThread().getId();
			try{
				while ((inputObject = in.readObject()) != null) {
				System.out.println(inputObject);
				}
			}catch (ClassNotFoundException cnfException){
				cnfException.printStackTrace();
			}
			
			
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

}
