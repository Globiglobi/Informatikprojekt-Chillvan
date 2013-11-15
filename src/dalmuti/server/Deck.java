package dalmuti.server;

import java.util.ArrayList;

public class Deck {
	
	//Attribute
	private static String cardName;
	private static int value;
	public static ArrayList DeckList = new ArrayList(80); // Liste mit allen Karten
	
	
	//Konstruktor
	public Deck() {
		this.cardName = cardName;
		this.value = value;
		
		generateCard("Dalmuti", 1); //Dalmuti
		generateCard("Erzbischof", 2); //Erzbischof
		generateCard("Hofmarschall", 3);//Hofmarschall
		generateCard("Baronin", 4);//Baronin
		generateCard("Äbtissin", 5);//Äbtissin
		generateCard("Ritter", 6);//Ritter
		generateCard("Näherin", 7);//Näherin
		generateCard("Steinmetz", 8);//Steinmetz
		generateCard("Köchin", 9);//Köchin
		generateCard("Schafhirtin", 10);//Schafhirtin 
		generateCard("Bergmann", 11);//Bergmann
		generateCard("Tagelöhner", 12);//Tagelöhner
		generateCard("Narren", 0);//Narren
		
	}
	// Methoden
	// irgendeine Karte wie Dalmuti, Erzbischof, usw. generieren
	public static void generateCard(String cardName, int value) {
		int index = 0;
		if(cardName == "Narren") {
			DeckList.add(index, (cardName + " " + 0));
			DeckList.add(index, (cardName + " " + 0));
		}
		else {
		for(int i = 0; i<value; i++) {	
			DeckList.add(index, (cardName + " " + value));
			index++;
		}
		}
	}
	

	//Main-Methode (muss noch gelöscht werden, braucht es ja dann nicht mehr!)
	public static void main(String[] args) {
		
		Deck d1 = new Deck();
		System.out.println(DeckList);

	}

}
