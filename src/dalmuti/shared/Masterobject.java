package dalmuti.shared;

import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<Card> deck = new ArrayList<Card>(80);
		deck = Deck.createdeck();

		// Kartendeck mischeln
		Collections.shuffle(deck);

		// Karten verteilen
		while (deck.isEmpty() != true) {
			for (int i = 0; i < 4; i++) {
				this.activeusers.get(i).getHand().add(deck.remove(0));
			}
		}
	}
}
