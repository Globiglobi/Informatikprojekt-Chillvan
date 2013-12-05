package dalmuti.server;

import java.util.ArrayList;
import java.util.Collections;

import dalmuti.shared.Card;
import dalmuti.shared.Deck;
import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class Spiellogik {
	public static ArrayList<User> userlist;

	public static void logik() {
		userlist = new ArrayList<User>(4);
		
		//User erstellen fehlt noch!!!
		
		// Sobald 4 User eingeloggt
		if (userlist.size() == 4) {

			// Masterobjekt erstellen
			Masterobject mo = new Masterobject(userlist);

			//Karten verteilen
			mo.docards();
		}

	}

	public static void main(String[] args) {
		logik();

		
		
	}

}