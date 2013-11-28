package beispielLukas.clientServer;

import java.net.*;
import java.io.*;
 
public class MyServer {
    public static void main(String[] args) throws IOException {
 
        int portNumber = 50000;
        boolean listening = true;
         
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new MyServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}