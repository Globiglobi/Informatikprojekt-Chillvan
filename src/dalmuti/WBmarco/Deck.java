package dalmuti.WBmarco;

import java.util.ArrayList;


public class Deck {
	
	//Attribute
	public static ArrayList<Card> deck;	
	
	//Konstruktor
	public Deck() {
		
		//Attribute
		deck = new ArrayList<Card>(80); // Liste mit allen Karten-Objekten
		
		Card dalmuti = new Card("Dalmuti", 1);
		deck.add(dalmuti);
		
		Card erzbischof = new Card("Erzbischof", 2);
		deck.add(erzbischof);
		Card erzbischof2 = new Card("Erzbischof", 2);
		deck.add(erzbischof2);
		
		Card hofmarschall = new Card("Hofmarschall", 3);
		deck.add(hofmarschall);
		Card hofmarschall2 = new Card("Hofmarschall", 3);
		deck.add(hofmarschall2);
		Card hofmarschall3 = new Card("Hofmarschall", 3);
		deck.add(hofmarschall3);
		
		Card baronin = new Card("Baronin", 4);
		deck.add(baronin);
		Card baronin2 = new Card("Baronin", 4);
		deck.add(baronin);
		Card baronin3 = new Card("Baronin", 4);
		deck.add(baronin);
		Card baronin4 = new Card("Baronin", 4);
		deck.add(baronin);

//		generateCard("�btissin", 5);//�btissin
//		generateCard("Ritter", 6);//Ritter
//		generateCard("N�herin", 7);//N�herin
//		generateCard("Steinmetz", 8);//Steinmetz
//		generateCard("K�chin", 9);//K�chin
//		generateCard("Schafhirtin", 10);//Schafhirtin 
//		generateCard("Bergmann", 11);//Bergmann
//		generateCard("Tagel�hner", 12);//Tagel�hner
//		generateCard("Narren", 0);//Narren
		
		
	}
	

	

	//Main-Methode (muss noch gel�scht werden, braucht es ja dann nicht mehr!)
	public static void main(String[] args) {
		
		Deck d = new Deck();
		System.out.println(deck.get(0).getName() + ", " + deck.get(0).getValue());

	}

}
