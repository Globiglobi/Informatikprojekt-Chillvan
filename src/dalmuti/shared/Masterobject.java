package dalmuti.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.io.Serializable;

import dalmuti.shared.User;

public class Masterobject implements Serializable {

	// Attributes
	public ArrayList<User> users;
	public ArrayList<User> nextround;
	public int[] playedcards = {0,0};
	public int pass = 0;

	// Constructor
	public Masterobject() {
	}

	public Masterobject(ArrayList<User> userlist) {
		this.users = userlist;
		nextround = new ArrayList<User>(users.size());
		int[] deck = createdeck();
		shuffle(deck);
		distribute(deck);
		users.get(0).setActive(true);

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
		this.users.get(0).createhand(Arrays.copyOfRange(deck, 0, 20));
		this.users.get(1).createhand(Arrays.copyOfRange(deck, 20, 40));
		this.users.get(2).createhand(Arrays.copyOfRange(deck, 40, 60));
		this.users.get(3).createhand(Arrays.copyOfRange(deck, 60, 80));

		for (int i = 0; i < 4; i++) {
			this.users.get(i).calcamount();
		}

	}

	// Determinate active user
	public int whosactive() {
		int pos = 0;
		Iterator<User> i = this.users.iterator();
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

	// Determine Rank
	public int rank(int id) {
		int pos = 0;
		for (int i = 0; i < users.size(); i++) {
			if (id == users.get(i).getUser_ID()) {
				pos = i;
				break;
			}

		}
		return pos;
	}
	// Determine next player
		public int nextplayer(int currentplayer) {
			int nextplayer = currentplayer + 1;
			if (nextplayer > users.size() - 1) {
				nextplayer = 0;
			}
			return nextplayer;
		}

		public static void main(String[] args) {

		}

}