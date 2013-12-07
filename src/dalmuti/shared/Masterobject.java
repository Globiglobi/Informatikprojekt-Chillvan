package dalmuti.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.io.Serializable;
import dalmuti.shared.User;

public class Masterobject implements Serializable {

	// Attributes
	public ArrayList<User> activeusers;
	public ArrayList<User> passivusers;
	public int[] playedcards;
	public ArrayList<Move> moves;

	// Constructor
	public Masterobject() {
	}

	public Masterobject(ArrayList<User> userlist) {
		this.activeusers = userlist;
		passivusers = new ArrayList<User>(activeusers.size());
		int[] deck = createdeck();
		shuffle(deck);
		distribute(deck);


	}

	// Methods
	// Create Deck Array
	public static int[] createdeck() {
		int[] deck = new int[80];
		int pos = 0;
		for (int i = 1; i <= 12; i++) {
			for (int j = 0; j < i; j++) {
				deck[pos] = i;
				pos++;
			}
		}
		deck[78] = 0;
		deck[79] = 0;
		return deck;
	}

	// Fisher-Yates deck shuffle
	public static void shuffle(int[] deck) {
		Random rnd = new Random();
		for (int i = deck.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = deck[index];
			deck[index] = deck[i];
			deck[i] = a;
		}
	}

	// distribute hands to users
	public void distribute(int[] deck) {
		this.activeusers.get(0).createhand(Arrays.copyOfRange(deck, 0, 20));
		this.activeusers.get(1).createhand(Arrays.copyOfRange(deck, 20, 40));
		this.activeusers.get(2).createhand(Arrays.copyOfRange(deck, 40, 60));
		this.activeusers.get(3).createhand(Arrays.copyOfRange(deck, 60, 80));

	}

	// Determinate active user
	public int whosactive() {
		int pos = 0;
		Iterator<User> i = this.activeusers.iterator();
		while (i.hasNext()) {
			boolean thechosenone = i.next().getActive();
			if (thechosenone == true) {
				break;
			} else {
				pos++;
			}
		}
		return pos;
	}
}