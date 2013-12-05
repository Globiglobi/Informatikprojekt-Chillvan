package dalmuti.testing;

	import java.util.ArrayList;
import java.util.Collections;

import dalmuti.shared.Card;
	import dalmuti.shared.Deck;
import dalmuti.shared.Masterobject;
import dalmuti.shared.User;

	public class Testlogik{
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

				//Karten verteilen
				mo.docards();
				
				for(int k = 0; k < mo.activeusers.get(0).getHand().size(); k++){
				System.out.println(k + " " + mo.activeusers.get(0).getHand().get(k).getName());

			}
				System.out.println(mo.activeusers.get(0).getHand().size());
				System.out.println(mo.activeusers.get(1).getHand().size());
				System.out.println(mo.activeusers.get(2).getHand().size());
				System.out.println(mo.activeusers.get(3).getHand().size());
				
			}

		}

		public static void main(String[] args) {
			Spiellogiktest();

			
			
		}

	}