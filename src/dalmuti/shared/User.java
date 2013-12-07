package dalmuti.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Serializable {

	private String nickname;
	private int[] hand;
	private boolean active;
	
	public User(String nickname) {
		this.nickname = nickname;
		hand = new int[13];
		setActive(false);
	}

	// Getter and Setter Methods
	public String getNickname() {
		return nickname;
	}

	public int[] getHand() {
		return hand;
	}

	public void setHand(int[] hand) {
		this.hand = hand;
	}

	public boolean getActive() {
		return active;
	}

	public boolean setActive(boolean active) {
		this.active = active;
		return active;
	}

	// Methoden
	public void createhand(int[] subdeck) {
		for (int i = 0; i < subdeck.length; i++) {
			hand[subdeck[i]]++;
		}

	}
	
}