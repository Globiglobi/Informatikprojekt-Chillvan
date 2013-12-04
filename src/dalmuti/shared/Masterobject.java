package dalmuti.shared;

import java.util.ArrayList;

public class Masterobject {
	
	//Attributes
	public ArrayList<User> activeusers;
	public ArrayList<User> passivusers;
	public ArrayList<Card> playedcards;
	public ArrayList<Move> moves;
	
	//Constructor
	public Masterobject(ArrayList<User> userlist, ArrayList<Card> playedcards, ArrayList<Move> moves){
		this.activeusers = userlist;
		passivusers = new ArrayList<User>(activeusers.size());
		this.playedcards = playedcards;
		this.moves = moves;
	}
	

}
