package dalmuti.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerReturn implements Runnable
{
	//Globals
	Socket sock;
	private Scanner input;
	private PrintWriter out;
	String message = "";
	
	//Constructor
	public ChatServerReturn (Socket x)
	{
		this.sock = x;
	}
	
	public void CheckConnection() throws IOException
	{
		if(!sock.isConnected())
		{
			for(int i = 1; i <= Server.connectionArray.size(); i++)
			{
				if(Server.connectionArray.get(i) == sock)
				{
					Server.connectionArray.remove(i);
				}
			}
			for(int i = 1; i <= Server.connectionArray.size(); i++)
			{
				Socket temp_sock = (Socket) Server.connectionArray.get(i-1);
				PrintWriter temp_out = new PrintWriter(temp_sock.getOutputStream());
				temp_out.println(temp_sock.getLocalAddress().getHostName() + " disconnected.");
				temp_out.flush();
				//Show disconnection at Server
				System.out.println(temp_sock.getLocalAddress().getHostName() + " disconnected.");
			}
		}
	}
	
	public void run()
	{
		try
		{
			try
			{
				input = new Scanner(sock.getInputStream());
				out = new PrintWriter(sock.getOutputStream());
				
				while(true)
				{
					CheckConnection();
					
					if(!input.hasNext())
					{
						return;
					}
					
					message = input.nextLine();
					
					System.out.println("Client said: " + message);
					
					for(int i = 1; i <= Server.connectionArray.size(); i++)
					{
						Socket temp_sock = (Socket) Server.connectionArray.get(i-1);
						PrintWriter temp_out = new PrintWriter(temp_sock.getOutputStream());
						temp_out.println(message);
						temp_out.flush();
						//Show disconnection at Server
						System.out.println("Sent to " + temp_sock.getLocalAddress().getHostName());
					}
				}
			}
			finally
			{
				sock.close();
			}
		}
		catch(Exception x)
		{
			System.out.println(x);
		}
	}

}
