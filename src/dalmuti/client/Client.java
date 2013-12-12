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
	static Playtable playtable;
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
		playtable = Login.playtable;
		// spieltisch = new Spieltisch(this.out, this.in);
		// spieltisch.setVisible(false);
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
//					playtable.UpdateButtons();

					//
					System.out.println("Masterobject erhalten!");
					System.out.println(client_ID);
//					 System.out.println(mo.activeusers.get(0).getUser_ID());
//					 System.out.println(mo.activeusers.get(1).getUser_ID());
//					 System.out.println(mo.activeusers.get(2).getUser_ID());
//					 System.out.println(mo.activeusers.get(3).getUser_ID());
					// System.out.println(mo.activeusers.get(0).getHand().get(0).getName());
					//
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
				System.arraycopy(mo.activeusers.get(i).getHand(),0, Playtable.handcopy,0,13);
				System.arraycopy(mo.activeusers.get(i).getHand(),0, Playtable.newhand,0,13);
//				System.out.println("ClientID: " + client_ID);
//				System.out.println("UserID: " + mo.activeusers.get(i).getUser_ID());
//				Playtable.newhand = mo.activeusers.get(i).getHand();
			
//				Playtable.btKarte1.setText(String.valueOf(Playtable.newhand[1]));
//				playtable.setAmountKarte10(Playtable.newhand[10]);
//				playtable.repaint();
				break;			
			}
		}
	}
}
