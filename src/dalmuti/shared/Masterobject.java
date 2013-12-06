package dalmuti.shared;

import java.util.ArrayList;
import java.util.Collections;
import dalmuti.shared.Card;
import java.io.Serializable;

public class Masterobject implements Serializable{

	// Attributes
	public ArrayList<User> activeusers;
	public ArrayList<User> passivusers;
	public ArrayList<Card> playedcards;
	public ArrayList<Move> moves;

	// Constructor
	public Masterobject(){
	}
	
	public Masterobject(ArrayList<User> userlist) {
		this.activeusers = userlist;
		passivusers = new ArrayList<User>(activeusers.size());
		
	}

	// Methods
	// Create, shuffle and distribute Cards
	public void docards() {
		// 1 Kartendeck erstellen
		ArrayList<Card> deck = new ArrayList<Card>(Card.createdeck());

		// Kartendeck mischeln
		Collections.shuffle(deck);

		// Karten verteilen
		while (deck.isEmpty() != true) {
			for (int i = 0; i < 4; i++) {
				this.activeusers.get(i).getHand().add(deck.remove(0));
			}
		}
		//fill amount array
		for(this.activeusers.)
	}
}
