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
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	static Masterobject mo;
	static int client_ID;
	static int tempID;

	// call constructor to set up server, call gui-login, call method
	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out, this.in);
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

	public void receiveObjectFromServer() {
		// receive the UserObject and do whatever the client has to do...
		try {
			while ((inputObject = in.readObject()) != null) {
				if (inputObject instanceof Masterobject) {
					mo = (Masterobject) inputObject;
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					UpdatePlaytable();

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

	// Methods
	
	// Refresh Playtable
	public static void UpdatePlaytable() {
		for(int i = 0; i < mo.users.size(); i++){
			if(mo.users.get(i).getUser_ID() == client_ID){
				Login.playtable.myRank = i;
				System.arraycopy(mo.users.get(i).getHand(),0, Playtable.handcopy,0,13);
				System.arraycopy(mo.users.get(i).getHand(),0, Playtable.newhand,0,13);
				break;			
			}
		}
		if(mo.turn == 0){
			Playtable.updatePlayerpositions();
			Login.playtable.updateScore();
			mo.round++;
		}
		Login.playtable.updateCardsleft();
		if(mo.users.get(Login.playtable.myRank).getActive() == true){
			Login.playtable.glassPane.setVisible(false);
			// First 4 rounds to swap cards between dalmuti and servants
			if(mo.turn < 4){
				try{
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				Swap swap = new Swap();
				swap.autofillin();
				swap.UpdateButtons();
			}
		}else{
			Login.playtable.glassPane.setVisible(true);
		}
		Playtable.updateButtons();
		Login.playtable.updatePlayedcards();
		Login.playtable.updateCardsleft();
	}
	
}
