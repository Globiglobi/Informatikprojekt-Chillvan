package dalmuti.shared;

import java.util.ArrayList;

public class User {
	
	private String nickname;
	private ArrayList<Card> hand;
	private final int MAX_Hand = 20;
	
	
	
	public User(String nickname){
		this.nickname = nickname;
		hand = new ArrayList<Card>(MAX_Hand);
	}

	//Getter und Setter Methoden
	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public ArrayList<Card> getHand() {
		return hand;
	}


	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	//Methoden
	
	
	
	
}
