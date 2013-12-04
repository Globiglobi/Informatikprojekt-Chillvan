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
		
		try/*(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		)*/{
			ObjectOutputStream outobj = new ObjectOutputStream(socket.getOutputStream());
			outobj.flush();
			ObjectInputStream inobj = new ObjectInputStream(socket.getInputStream());
			//definition was der server empfangen und senden kann
			//while-schlaufe mit der spiellogik
			
			//syso vom nickname
			Object inputLine;
			//userID = Thread.currentThread().getId();
			try{
				while ((inputLine = inobj.readObject()) != null) {
				System.out.println(inputLine);
				}
			}catch (ClassNotFoundException cnfe){
				cnfe.printStackTrace();
			}
			
			
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

}
