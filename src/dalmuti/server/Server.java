package dalmuti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	static ArrayList<Socket> ssList = new ArrayList<Socket>(4);
	
	public static void main(String[] args) throws IOException{
		
		int portNumber = 50000;
		boolean listening = true;
		
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
        	System.out.println("Waiting for clients...");
            while (listening) {
                new ServerThread(serverSocket.accept()).start();
/*                ssList = new ArrayList<ServerSocket>();
                ssList.add(serverSocket);
                System.out.println(ssList.get(0).toString());
*/                
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

}
