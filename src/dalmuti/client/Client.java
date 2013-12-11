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

					//
					System.out.println("Masterobject erhalten!");
					System.out.println(client_ID);
					// System.out.println(mo.activeusers.get(0).getNickname());
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
		Iterator<User> i = mo.activeusers.iterator();
		while (i.hasNext()) {
			if (i.next().getUser_ID() == client_ID) {
				Playtable.newhand = i.next().getHand();
				Playtable.handcopy = i.next().getHand();
				playtable.repaint();
			}
		}

	}
}
