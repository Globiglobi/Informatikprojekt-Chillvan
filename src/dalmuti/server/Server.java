package dalmuti.server;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException{
		
		int portNumber = 50000;
		boolean listening = true;
		ArrayList<ServerSocket> ssList;
		
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new ServerThread(serverSocket.accept()).start();
                ssList = new ArrayList<ServerSocket>();
                ssList.add(serverSocket);
                System.out.println(ssList.get(0).toString());
                
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

}
