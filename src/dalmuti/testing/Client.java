package dalmuti.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client implements Runnable
{
	//Globals
	Socket sock;
	Scanner input;
	Scanner send = new Scanner(System.in);
	PrintWriter out;
	
	//Constructor
	public Client(Socket x)
	{
		this.sock = x;
	}
	
	public void run()
	{
		try
		{
			try
			{
				input = new Scanner(sock.getInputStream());
				out = new PrintWriter(sock.getOutputStream());
				out.flush();
				CheckStream();
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
	
	public void Disconnect() throws IOException
	{
		out.println(ChatClientGUI.username + " has diconnected.");
		out.flush();
		sock.close();
		JOptionPane.showMessageDialog(null, "You disconnected!");
		System.exit(0);
	}
	
	public void CheckStream()
	{
		while(true)
		{
			Receive();
		}
	}
	
	public void Receive()
	{
		if(input.hasNext())
		{
			String message = input.nextLine();
			
			if(message.contains("#?!"))
			{
				String temp1 = message.substring(3);
				temp1 = temp1.replace("[", "");
				temp1 = temp1.replace("]", "");
				
				String[] currentUsers = temp1.split(", ");
				
				ChatClientGUI.ltOnline.setListData(currentUsers);
			}
			else
			{
				ChatClientGUI.taConversation.append(message + "\n");
			}
		}
	}
	
	public void Send(String x)
	{
		out.println(ChatClientGUI.username + ": " + x);
		out.flush();
		ChatClientGUI.tfMessage.setText("");
	}
}
