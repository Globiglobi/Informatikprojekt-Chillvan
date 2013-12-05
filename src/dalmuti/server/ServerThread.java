package dalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class ServerThread extends Thread {
	private Socket socket = null;
	protected long userID;
	public static ArrayList<User> userlist = new ArrayList<User>(4);



	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					socket.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(
					socket.getInputStream());
			// definition was der server empfangen und senden kann
			// while-schlaufe mit der spiellogik
			
			
			// syso vom nickname
			Object inputObject;
			// userID = Thread.currentThread().getId();
			try {

				while ((inputObject = in.readObject()) != null) {
					if (inputObject instanceof User) {
					    User user = (User)inputObject;
					    userlist.add(user);
					    //Testoutput
					    System.out.println(user.getNickname());
					    System.out.println(userlist.size());
					}
					else if (inputObject instanceof Masterobject) {
					    Masterobject mo = (Masterobject) inputObject;
					    //...
					}
					else {
					    System.out.println("Unexpected object type:  " + inputObject.getClass().getName());
					}
					//Creating Masterobject
					
					if (userlist.size() == 4) {

						Masterobject mo = new Masterobject(userlist);
						mo.docards();
						
						//Testoutput
						
						System.out.println(mo.activeusers.get(0).getHand().get(0).getName());
						System.out.println(mo.activeusers.get(1).getHand().get(0).getName());
						System.out.println(mo.activeusers.get(2).getHand().get(0).getName());
						System.out.println(mo.activeusers.get(3).getHand().get(0).getName());
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
