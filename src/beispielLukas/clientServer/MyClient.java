package beispielLukas.clientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 
public class MyClient{
	
	MyClientGUI clientGUI;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	
	public MyClient(String hostName, int portNumber){
		init(hostName, portNumber);
		clientGUI = new MyClientGUI(this.out);
		receiveFromServer();
	}
	
	public void init(String hostName, int portNumber){
		try{
	            socket = new Socket(hostName, portNumber);
	            out = new PrintWriter(socket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    } catch (Exception e){
	    	System.out.println(e.toString());
	    	System.exit(1);
	    }
	}
	
	public void receiveFromServer(){
        String fromServer;
        try{
        	while ((fromServer = this.in.readLine()) != null) {
        		clientGUI.writeText(fromServer);
        		if (fromServer.equals("Bye.")){
        			break;
        		}
        	}
        }
        catch(Exception e){
        	System.out.println(e.toString());
        	System.exit(1);
        }
	}
	
	
	public static void main(String[] args){         
        String hostName = "localhost";
        int portNumber = 50000;
        new MyClient(hostName, portNumber);
    }
}
