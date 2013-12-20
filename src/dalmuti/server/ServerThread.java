/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * The Class ServerThread
 * This class sends and receives objects 
 * 
 * @author Marco Mangold
 * 
 */

package dalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class ServerThread extends Thread {
	//attributes
	private Socket socket = null;
	//static attributes
	static int client_ID = 0;
	static int user_ID = 0;
	public static ArrayList<User> userlist = new ArrayList<User>(4);
	public static ArrayList<ObjectOutputStream> outlist = new ArrayList<ObjectOutputStream>(
			4);
	
	//constructor
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	//run-method
	public void run() {
		//sends object (out) and receives object (in)
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					socket.getOutputStream());
			out.flush();
			outlist.add(out);
			ObjectInputStream in = new ObjectInputStream(
					socket.getInputStream());

			Object inputObject;
			try {
				
				while ((inputObject = in.readObject()) != null) {
					//object from User
					if (inputObject instanceof User) {
						User user = (User) inputObject;
						user.setUser_ID(user_ID);
						userlist.add(user);
						user_ID++;
						out.writeObject(client_ID);
						client_ID++;

						// creating Masterobject
						if (userlist.size() == 4) {

							Masterobject mo = new Masterobject(userlist);
							//sleep - otherwise complications with Clients (update-problem)
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// send Masterobject to Clients
							Iterator<ObjectOutputStream> i = outlist.iterator();
							while (i.hasNext()) {
								i.next().writeObject(mo);
							}
						}
					}
					//object from Masterobject
					else if (inputObject instanceof Masterobject) {
						Masterobject mo = (Masterobject) inputObject;
						//just for safety
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// call Logic.control()
						mo = Logic.control(mo);
						// send updated Masterobejct to Clients
						Iterator<ObjectOutputStream> i = outlist.iterator();
						while (i.hasNext()) {
							i.next().writeObject(mo);
						}

					} 
					
					//else-loop
					else {
						System.out.println("Unexpected object type:  "
								+ inputObject.getClass().getName());
					}
				}
			} catch (ClassNotFoundException cnfException) {
				cnfException.printStackTrace();
			} 
			//in case User quit the game
			catch (SocketException e) {
				int x = 0;
				try {
					for (int i = 0; i < outlist.size(); i++) {
						x = i;
						outlist.get(i).writeObject(e);
					}
				} catch (SocketException SendException) {
					try {
						for (int i = x + 1; i < outlist.size(); i++) {
							outlist.get(i).writeObject(e);
						}
					} catch (SocketException DoNothing) {

					}
				}
				System.exit(1);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
