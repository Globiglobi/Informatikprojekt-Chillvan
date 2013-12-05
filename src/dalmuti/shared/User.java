package dalmuti.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String nickname;
	private ArrayList<Card> hand;
	private int[] amount;
	private final int MAX_Hand = 20;
	
	
	
	public User(String nickname){
		this.nickname = nickname;
		hand = new ArrayList<Card>(MAX_Hand);
		amount = new int[13];
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
	public void calcamount(){
		for((hand.iterator()).getValue()){
			
		};
		
	}
	
	
	
}
