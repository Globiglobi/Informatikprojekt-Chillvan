/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Fabio Bally, Silvan Hoppler
 * 
 */

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
	private boolean passive;
	private int score = 0;
	
	public User(String nickname) {
		this.nickname = nickname;
		hand = new int[13];
		setActive(false);
		setPassive(false);
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

	public boolean isPassive() {
		return passive;
	}

	public void setPassive(boolean passive) {
		this.passive = passive;
	}

	public int getUser_ID(){
		return this.user_ID;
	}
	public void setUser_ID(int user_ID){
		this.user_ID = user_ID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// Methoden
	// Silvan Hoppler
	
	// Convert the deck array into a hand array
	public void createhand(int[] subdeck) {
		for (int i = 0; i < subdeck.length; i++) {
			hand[subdeck[i]]++;
		}
	}
	
	// Fabio Bally
	public void calcamount(){
		amount = 0;
		for(int i = 0; i < getHand().length; i++){
			amount += getHand()[i];
		}
	}
}