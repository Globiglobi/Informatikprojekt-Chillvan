package dalmuti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public static void main(String[] args) throws IOException{
		
		int portNumber = 50000;
		
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
        	System.out.println("Waiting for clients...");
            while (ServerThread.userlist.size() < 4) {
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

}
