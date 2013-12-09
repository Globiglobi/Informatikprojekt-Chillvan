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
	public int[] deck = new int[80];
	public static int[] hand1 = new int[20];
	public int[] hand2 = new int[20];
	public int[] hand3 = new int[20];
	public int[] hand4 = new int[20];
	

	//public int[] playedcards;
	//public ArrayList<Move> moves;

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
		//this.activeusers.get(0).createhand(Arrays.copyOfRange(deck, 0, 20));
		this.hand1[0] = deck[0];
		this.hand1[1] = deck[1];
		this.hand1[2] = deck[2];
		this.hand1[3] = deck[3];
		this.hand1[4] = deck[4];
		this.hand1[5] = deck[5];
		this.hand1[6] = deck[6];
		this.hand1[7] = deck[7];
		this.hand1[8] = deck[8];
		this.hand1[9] = deck[9];
		this.hand1[9] = deck[9];
		this.hand1[10] = deck[10];
		this.hand1[11] = deck[11];
		this.hand1[12] = deck[12];
		this.hand1[13] = deck[13];
		this.hand1[14] = deck[14];
		this.hand1[15] = deck[15];
		this.hand1[16] = deck[16];
		this.hand1[17] = deck[17];
		this.hand1[18] = deck[18];
		this.hand1[19] = deck[19];
//		this.activeusers.get(1).createhand(Arrays.copyOfRange(deck, 20, 40));
//		this.activeusers.get(2).createhand(Arrays.copyOfRange(deck, 40, 60));
//		this.activeusers.get(3).createhand(Arrays.copyOfRange(deck, 60, 80));

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
	
	//getter-/setter-Methoden
	public int[] getHand1() {
		return hand1;
	}

	public void setHand1(int[] hand1) {
		this.hand1 = hand1;
	}
	
	public int[] getDeck() {
		return deck;
	}

	public void setDeck(int[] deck) {
		this.deck = deck;
	}
}