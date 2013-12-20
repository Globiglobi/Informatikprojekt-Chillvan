/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * The Class Server
 * This class simulates a basic server. It starts the Server from the main method
 * on port number 5000 and creats a new ServerSocket
 * 
 * @author Marco Mangold
 * 
 */

package dalmuti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public static void main(String[] args) throws IOException{
		
		int portNumber = 50000; // Dynamic Ports from 49152–65535
		
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { // create ServerSocket
        	System.out.println("Waiting for clients..."); // print message on server-side
            while (ServerThread.userlist.size() < 4) { //check size userlist in class ServerThread
                new ServerThread(serverSocket.accept()).start(); // set up connection and start run method
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

}
