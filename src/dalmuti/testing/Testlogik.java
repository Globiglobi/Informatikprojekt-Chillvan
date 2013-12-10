package dalmuti.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

public class Testlogik {
	public static ArrayList<User> userlist;

	public static void Spiellogiktest() {
		userlist = new ArrayList<User>(4);

		User u1 = new User("Fabio");
		User u2 = new User("Marco");
		User u3 = new User("Bastian");
		User u4 = new User("Silvan");

		userlist.add(u1);
		userlist.add(u2);
		userlist.add(u3);
		userlist.add(u4);

		// Sobald 4 User eingeloggt
		if (userlist.size() == 4) {

			// Masterobjekt erstellen
			Masterobject mo = new Masterobject(userlist);

			int[] array = mo.activeusers.get(0).getHand();
			for (int a : array) {
				System.out.print(a + " ");
			}
			// mo.activeusers.get(0).setActive(true);
			// System.out.println(mo.whosactive());
		}
	}

	public static void main(String[] args) {
		Spiellogiktest();

		int[] k = new int[4];

		k[0] = 1;
		k[1] = 3;
		k[2] = 3;
		k[3] = 4;

		while (k[0] == k[1] || k[0] == k[2] || k[0] == k[3] || k[1] == k[2]
				|| k[1] == k[3] || k[2] == k[3]) {

			for (int i = 0; i < 1; i++) {
				for (int j = 1; j < k.length; j++) {
					if (k[i] == k[j]) {
						System.out.println("2 Karten sind gleich");
						// Hier Programm Anweisung für neue Karte zuweisen
					}
				}

			}
			for (int i = 1; i < 2; i++) {
				for (int j = 2; j < k.length; j++) {
					if (k[i] == k[j]) {
						System.out.println("2 Karten sind gleich");
						k[j] = 2;
						// Hier Programm Anweisung für neue Karte zuweisen
					}
				}
			}
			if (k[2] == k[3]) {
				System.out.println("2 Karten sind gleich");
				// Hier Programm Anweisung für neue Karte zuweisen
			}

		}

		// nur für Testzwecke
		for (int c : k) {
			System.out.println("k = " + c);
		}
	}

}
