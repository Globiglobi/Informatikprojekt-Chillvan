package dalmuti.WBmarco;

import java.util.ArrayList;
import java.util.Collections;

public class User {
	
	//Attribute
	public String nickname;
	public static ArrayList<Card> spielhand;	
	
	
	public User(String nickname){
		this.nickname = nickname;
		
		ArrayList<Card> spielhand = new ArrayList(20);
	}


	//Main-Methode
	public static void main(String[] args) {
		
		Deck d2 = new Deck();
		Collections.shuffle(d2);
		
		
	}

}
