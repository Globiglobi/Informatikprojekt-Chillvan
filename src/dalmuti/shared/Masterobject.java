package dalmuti.shared;

import java.util.ArrayList;

public class Masterobject {
	
	//Attributes
	public ArrayList<User> userlist;
	public ArrayList<Card> playedcards;
	public ArrayList<Move> moves;
	
	//Constructor
	public Masterobject(ArrayList<User> userlist, ArrayList<Card> playedcards, ArrayList<Move> moves){
		this.userlist = userlist;
		this.playedcards = playedcards;
		this.moves = moves;
	}
	

}
