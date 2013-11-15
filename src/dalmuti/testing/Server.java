package dalmuti.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	
	//Globals
	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static ArrayList<String> currentUsers = new ArrayList<String>();
	
	//Main-Method
	public static void main(String[] args)
	{
		
		try
		{
			final int port = 50002;
			ServerSocket server = new ServerSocket(port);
			System.out.println("Waiting for clients...");
			
			while(true)
			{
				Socket sock = server.accept();
				connectionArray.add(sock);
				
				System.out.println("Client connected from: " + sock.getLocalAddress().getHostName());
				
				AddUserName(sock);
				
				ChatServerReturn chat = new ChatServerReturn(sock);
				Thread x = new Thread(chat);
				x.start();
			}
		}
		catch(Exception x)
		{
			System.out.println(x);
		}
	}
	
	public static void AddUserName(Socket x) throws IOException
	{
		Scanner input = new Scanner(x.getInputStream());
		String username = input.nextLine();
		currentUsers.add(username);
		
		for(int i = 1; i <= Server.connectionArray.size(); i++)
		{
			Socket temp_sock = (Socket) Server.connectionArray.get(i-1);
			PrintWriter out = new PrintWriter(temp_sock.getOutputStream());
			out.println("#?!" + currentUsers);
			out.flush();
		}
	}

}
