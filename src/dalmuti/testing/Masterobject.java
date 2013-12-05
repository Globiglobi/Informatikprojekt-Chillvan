package dalmuti.testing;

import java.util.ArrayList;
import java.util.Collections;

import dalmuti.shared.Card;
import dalmuti.shared.Deck;
import dalmuti.shared.Move;
import dalmuti.shared.User;

public class Masterobject {
		
	// Attributes
	public ArrayList<User> activeusers;
	public ArrayList<User> passivusers;
	public ArrayList<Card> playedcards;
	public ArrayList<Move> moves;

	// Constructor
	public Masterobject(ArrayList<User> userlist) {
		this.activeusers = userlist;
		passivusers = new ArrayList<User>(activeusers.size());
		
	}

	// Methods
	// Create, shuffle and distribute Cards
	public void docards() {
		// 1 Kartendeck erstellen
		ArrayList<Card> deck = new ArrayList<Card>(Deck.createdeck());

		// Kartendeck mischeln
		Collections.shuffle(deck);

		// Karten verteilen
		while (deck.isEmpty() != true) {
			for (int i = 0; i < 4; i++) {
				this.activeusers.get(i).getHand().add(deck.remove(0));
			}
		}
	}
	public static void main(String[] args){
		
		ArrayList<User> userlist = new ArrayList<User>(4);
		
		User u1 = new User("Mario");
		User u2 = new User("Luigi");
		User u3 = new User("Peach");
		User u4 = new User("Yoshi");
		
		userlist.add(u1);
		userlist.add(u2);
		userlist.add(u3);
		userlist.add(u4);
		
		Masterobject mo = new Masterobject(userlist);
		mo.docards();
		

	}
}