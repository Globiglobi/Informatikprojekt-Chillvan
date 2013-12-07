package dalmuti.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dalmuti.shared.Masterobject;

public class Client {

	Login login;
	Playtable playtable;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	Masterobject mo;

	//call constructor to set up server, call gui-login, call method
	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out, this.in);
//		spieltisch = new Spieltisch(this.out, this.in);
//		spieltisch.setVisible(false);
		receiveObjectFromServer();
		
	}

	//set up connection to server
	public void init(String hostName, int portNumber) {
		try {
			socket = new Socket(hostName, portNumber);
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
			
			
		
			
		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
	public void receiveObjectFromServer(/*Object user*/){
		//receive the UserObject and do whatever the client has to do...
		try{
			while ((inputObject = in.readObject()) != null) {
				if (inputObject instanceof Masterobject) {
				    mo = (Masterobject) inputObject;
				    
//				    System.out.println(mo.activeusers.get(0).getNickname());
//				    System.out.println(mo.activeusers.get(0).getHand().get(0).getName());
//				    //...
				}
				
				else {
				    System.out.println("Unexpected object type:  " + inputObject.getClass().getName());
				}
			}
		}catch (ClassNotFoundException | IOException cnfException) {
			cnfException.printStackTrace();
		}
	}
	
	public static void main(String[] args){         
        String hostName = "localhost";
        int portNumber = 50000;
        new Client(hostName, portNumber);
    }

}
