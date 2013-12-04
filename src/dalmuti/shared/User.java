package dalmuti.shared;

import java.util.ArrayList;

public class User {
	
	private String nickname;
	private ArrayList<Card> hand;
	
	
	
	public User(String nickname){
		this.nickname = nickname;
		setHand(new ArrayList<Card>(20));
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

}
