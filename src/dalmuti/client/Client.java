package dalmuti.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class Client {

	Login login;
//	Playtable playtable;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	static Masterobject mo;
	static int client_ID;

	// call constructor to set up server, call gui-login, call method
	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out, this.in);
//		playtable = Login.playtable;
		receiveObjectFromServer();

	}

	// set up connection to server
	public void init(String hostName, int portNumber) {
		try {
			socket = new Socket(hostName, portNumber);
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());

		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	public void receiveObjectFromServer(/* Object user */) {
		// receive the UserObject and do whatever the client has to do...
		try {
			while ((inputObject = in.readObject()) != null) {
				if (inputObject instanceof Masterobject) {
					mo = (Masterobject) inputObject;

					UpdatePlaytable();
					Playtable.UpdateButtons();
					Login.playtable.playedcards();

					//
					System.out.println("Masterobject erhalten!");
					System.out.println(client_ID);
					
				} else if (inputObject instanceof Integer) {
					client_ID = (int) inputObject;
				} else {
					System.out.println("Unexpected object type:  "
							+ inputObject.getClass().getName());
				}
			}
		} catch (ClassNotFoundException | IOException cnfException) {
			cnfException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String hostName = "localhost";
		int portNumber = 50000;
		new Client(hostName, portNumber);
	}

	public static void UpdatePlaytable() {
		for(int i = 0; i < mo.activeusers.size(); i++){
			if(mo.activeusers.get(i).getUser_ID() == client_ID){
				Login.playtable.myRank = i;
				System.arraycopy(mo.activeusers.get(i).getHand(),0, Playtable.handcopy,0,13);
				System.arraycopy(mo.activeusers.get(i).getHand(),0, Playtable.newhand,0,13);
				break;			
			}
		}
		if(mo.activeusers.get(Login.playtable.myRank).getActive() == true){
			Login.playtable.glassPane.setVisible(false);
		}else{
			Login.playtable.glassPane.setVisible(true);
		}
	}
}
