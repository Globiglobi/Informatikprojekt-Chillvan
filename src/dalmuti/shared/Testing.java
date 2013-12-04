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
			
			if(i <20) {
			u1.getHand().add(d1.deck.get(i));
			}
			
			if(i>20 && i<40) {
			u2.getHand().add(d1.deck.get(i));
			}
			
			if(i>40 && i<60){
				u3.getHand().add(d1.deck.get(i));
			}
			
			if(i>60 && i<80) {
				u4.getHand().add(d1.deck.get(i));
			}
			
		}
		//Die Kartenhände der Users ausgeben:
		//Hand User 1
		System.out.println(u1.getHand().get(0).getName());
		System.out.println(u1.getHand().get(1).getName());
		System.out.println(u1.getHand().get(2).getName());
		System.out.println(u1.getHand().get(3).getName());
		System.out.println(u1.getHand().get(4).getName());
		System.out.println(u1.getHand().get(5).getName());
		System.out.println(u1.getHand().get(6).getName());
		System.out.println(u1.getHand().get(7).getName());
		System.out.println(u1.getHand().get(8).getName());
		System.out.println(u1.getHand().get(9).getName());
		System.out.println(u1.getHand().get(10).getName());
		System.out.println(u1.getHand().get(11).getName());
		System.out.println(u1.getHand().get(12).getName());
		System.out.println(u1.getHand().get(13).getName());
		System.out.println(u1.getHand().get(14).getName());
		System.out.println(u1.getHand().get(15).getName());
		System.out.println(u1.getHand().get(16).getName());
		System.out.println(u1.getHand().get(17).getName());
		System.out.println(u1.getHand().get(18).getName());
		System.out.println(u1.getHand().get(19).getName());
		//Hand User 2

		
		



	}

}
