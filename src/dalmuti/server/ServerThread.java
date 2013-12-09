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
	//protected long userID;
	public ArrayList<Socket> sList = new ArrayList<Socket>();
	public static ArrayList<User> userlist = new ArrayList<User>(4);
	public static ArrayList<Masterobject> mList = new ArrayList<Masterobject>();



	public ServerThread(Socket socket) {
		this.socket = socket;
		sList.add(socket);
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
					
//					else if (inputObject instanceof Masterobject) {
//						Masterobject mo = (Masterobject) inputObject;
//						mList.add(mo);
//					    
//						//Testoutput
//						System.out.println(mList.size());
//					}
//					else {
//					    System.out.println("Unexpected object type:  " + inputObject.getClass().getName());
//					}
					
					//Creating Masterobject					
					if (userlist.size() == 4) {

						Masterobject mo = new Masterobject(userlist);
						//Spielerhand 1 ausgeben
						for(int i: Masterobject.hand1) {
							System.out.print(i + " ");
						}
						
						
						//Testsend
//						Iterator<Socket> i = sList.iterator();
//						while(i.hasNext()){
//							i.next().getOutputStream();
//							out.writeObject(mo);
//						}
						
						
						//print sList
//						System.out.println(sList.get(0).toString());
//						System.out.println(sList.get(1).toString());
//						System.out.println(sList.get(2).toString());
//						System.out.println(sList.get(3).toString());
						
						
//						//Testoutput
//						
//						for(int a: mo.activeusers.get(0).getHand()){
//							System.out.print(a + " ");
//						}
//						System.out.println(mo.activeusers.get(0).getHand()[12]);
//						System.out.println(mo.activeusers.get(1).getHand()[0]);
//						System.out.println(mo.activeusers.get(2).getHand()[0]);
//						System.out.println(mo.activeusers.get(3).getHand()[0]);
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
