package dalmuti.WBmarco;

import java.util.ArrayList;

public class Deck {
	
	//Attribute
	public static ArrayList<String> DeckListName;
	public static ArrayList<Integer> DeckListValue;	
	
	//Konstruktor
	public Deck() {
		
		//Attribute
		DeckListName = new ArrayList<String>(80); // Liste mit allen Karten Namen
		DeckListValue = new ArrayList<Integer>(80); // Liste mit allen Werten
		
		generateCard("Dalmuti", 1); //Dalmuti
		generateCard("Erzbischof", 2); //Erzbischof
		generateCard("Hofmarschall", 3);//Hofmarschall
		generateCard("Baronin", 4);//Baronin
		generateCard("�btissin", 5);//�btissin
		generateCard("Ritter", 6);//Ritter
		generateCard("N�herin", 7);//N�herin
		generateCard("Steinmetz", 8);//Steinmetz
		generateCard("K�chin", 9);//K�chin
		generateCard("Schafhirtin", 10);//Schafhirtin 
		generateCard("Bergmann", 11);//Bergmann
		generateCard("Tagel�hner", 12);//Tagel�hner
		generateCard("Narren", 0);//Narren
		
		
	}
	// Methoden
	
	// irgendeine Karte wie Dalmuti, Erzbischof, usw. generieren
	public static void generateCard(String cardName, int value) {
		int index = 0;
		if(cardName == "Narren") {
			DeckListName.add(index, (cardName));
			DeckListValue.add(index,(0));
			index++;
			DeckListName.add(index, (cardName));
			DeckListValue.add(index, (0));
			index++;
		}
		else {
		for(int i = 0; i<value; i++) {	
			DeckListName.add(index, (cardName));
			DeckListValue.add(index,(value));
			index++;
		}
		}
	}
	

	

	//Main-Methode (muss noch gel�scht werden, braucht es ja dann nicht mehr!)
	public static void main(String[] args) {
		
		Deck d1 = new Deck();
		System.out.println(DeckListName);
		System.out.println(DeckListValue);
		
		//System.out.println(d1);

	}

}
