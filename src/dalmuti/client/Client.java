package dalmuti.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	Login login;
	Spieltisch spieltisch;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;

	//call constructor to set up server, call gui-login, call method
	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out, this.in);
//		spieltisch = new Spieltisch(this.out, this.in);
//		spieltisch.setVisible(false);
		receiveUserObjectFromServer();
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
	
	public void receiveUserObjectFromServer(/*Object user*/){
		//receive the UserObject and do whatever the client has to do...
	}
	
	public static void main(String[] args){         
        String hostName = "localhost";
        int portNumber = 50000;
        new Client(hostName, portNumber);
    }

}
