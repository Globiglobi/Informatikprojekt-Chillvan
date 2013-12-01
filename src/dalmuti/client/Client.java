package dalmuti.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import dalmuti.gui.*;

public class Client {

	Login login;
	Socket socket;
	PrintWriter out;
	BufferedReader in;

	//call constructor to set up server, call gui-login, call method
	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out);
		receiveUserObjectFromServer();
	}

	//set up connection to server
	public void init(String hostName, int portNumber) {
		try {
			socket = new Socket(hostName, portNumber);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
