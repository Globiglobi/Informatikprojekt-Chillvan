package dalmuti.shared;

import java.util.ArrayList;
import java.util.Collections;

public class Testing {

	public static void main(String[] args) {
		
		//4 User erstellen
		User u1 = new User("Fabio");
		User u2 = new User("Marco");
		User u3 = new User("Bastian");
		User u4 = new User("Silvan");
		
		//1 Kartendeck erstellen
		Deck d1 = new Deck();
		
		//Kartendeck mischeln
		Collections.shuffle(d1.deck);
		
		//Kartdendeck an die 4 Users austeilen
		for(int i=0; i<d1.deck.size();i++) {
			
			
		}
		
		
		
		System.out.println(d1.deck.get(2).getName());



	}

}
