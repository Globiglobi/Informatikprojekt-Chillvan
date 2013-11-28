package dalmuti.WBmarco;

import java.util.ArrayList;

public class User {
	
	//Attribute
	public String nickname;
	public static ArrayList<Card> spielhand;	
	
	
	public User(String nickname){
		this.nickname = nickname;
		
		ArrayList<Card> spielhand = new ArrayList(20);
	}



}
