package dalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class ServerThread extends Thread {
	private Socket socket = null;
	static int client_ID = 0;
	static int user_ID = 0;
	// protected long userID;
//	public static ArrayList<Socket> sList = new ArrayList<Socket>();
	public static ArrayList<User> userlist = new ArrayList<User>(4);
	public static ArrayList<ObjectOutputStream> outlist = new ArrayList<ObjectOutputStream>(4);

	public ServerThread(Socket socket) {
		this.socket = socket;
//		sList.add(socket);
	}

	public void run() {

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
					if (inputObject instanceof User) {
						User user = (User) inputObject;
						user.setUser_ID(user_ID);
						userlist.add(user);
						user_ID++;
						out.writeObject(client_ID);
						client_ID++;

						// Creating Masterobject
						if (userlist.size() == 4) {

							Masterobject mo = new Masterobject(userlist);
							
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						// send Masterobject to Clients
							 Iterator<ObjectOutputStream> i = outlist.iterator();
							 while(i.hasNext()){
									i.next().writeObject(mo);
							 }
						}
					}

					else if (inputObject instanceof Masterobject) {
						Masterobject mo = (Masterobject) inputObject;
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						mo = Logic.control(mo);
						
						// Testoutput
						 Iterator<ObjectOutputStream> i = outlist.iterator();
						 while(i.hasNext()){
								i.next().writeObject(mo);
						 }
						

					} else {
						System.out.println("Unexpected object type:  "
								+ inputObject.getClass().getName());
					}
				}

			} catch (ClassNotFoundException cnfException) {
				cnfException.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
