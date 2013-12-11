package dalmuti.shared;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Serializable {

	private String nickname;
	private int user_ID;
	private int[] hand;
	private int amount;
	private boolean active;
	
	public User(String nickname, int id) {
		this.nickname = nickname;
		this.user_ID = id;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean getActive() {
		return active;
	}

	public boolean setActive(boolean active) {
		this.active = active;
		return active;
	}

	public int getUser_ID(){
		return this.user_ID;
	}

	// Methoden
	public void createhand(int[] subdeck) {
		for (int i = 0; i < subdeck.length; i++) {
			hand[subdeck[i]]++;
		}
	}
	
	public void calcamount(){
		amount = 0;
		for(int i = 0; i < getHand().length; i++){
			amount =+ getHand()[i];
		}
	}
	
	//Equals Methode für Nickname
	public boolean equals(User other) {
		if(this.nickname == other.nickname)	 {
			return true;			
		}
		else{
			return false;
		}
	}
}