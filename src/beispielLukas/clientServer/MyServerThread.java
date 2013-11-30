package beispielLukas.clientServer;

import java.net.*;
import java.io.*;
 
public class MyServerThread extends Thread {
    private Socket socket = null;
 
    public MyServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }
     
    public void run() {
 
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        	 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            String inputLine;
            String outputLine;
            MyProtocol protocol = new MyProtocol();
 
            while ((inputLine = in.readLine()) != null) {
                outputLine = protocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
