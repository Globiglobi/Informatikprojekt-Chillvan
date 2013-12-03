package dalmuti.WBmarco;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	//Attribute
	private ArrayList<Card> deck;	
	
	public ArrayList<Card> getDeck() {
		return deck;
	}


	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}


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
		deck.add(baronin2);
		Card baronin3 = new Card("Baronin", 4);
		deck.add(baronin3);
		Card baronin4 = new Card("Baronin", 4);
		deck.add(baronin4);
		
		Card aebtissin = new Card("Aebtissin", 5);
		deck.add(aebtissin);
		Card aebtissin2 = new Card("Aebtissin", 5);
		deck.add(aebtissin2);
		Card aebtissin3 = new Card("Aebtissin", 5);
		deck.add(aebtissin3);
		Card aebtissin4 = new Card("Aebtissin", 5);
		deck.add(aebtissin4);
		Card aebtissin5 = new Card("Aebtissin", 5);
		deck.add(aebtissin5);
		
		Card ritter = new Card("Ritter", 6);
		deck.add(ritter);
		Card ritter2 = new Card("Ritter", 6);
		deck.add(ritter2);
		Card ritter3 = new Card("Ritter", 6);
		deck.add(ritter3);
		Card ritter4 = new Card("Ritter", 6);
		deck.add(ritter4);
		Card ritter5 = new Card("Ritter", 6);
		deck.add(ritter5);
		Card ritter6 = new Card("Ritter", 6);
		deck.add(ritter6);

		Card naeherin = new Card("Naeherin", 7);
		deck.add(naeherin);
		Card naeherin2 = new Card("Naeherin", 7);
		deck.add(naeherin2);
		Card naeherin3 = new Card("Naeherin", 7);
		deck.add(naeherin3);
		Card naeherin4 = new Card("Naeherin", 7);
		deck.add(naeherin4);
		Card naeherin5 = new Card("Naeherin", 7);
		deck.add(naeherin5);
		Card naeherin6 = new Card("Naeherin", 7);
		deck.add(naeherin6);
		Card naeherin7 = new Card("Naeherin", 7);
		deck.add(naeherin7);
		
		Card steinmetz = new Card("Steinmetz", 8);
		deck.add(steinmetz);
		Card steinmetz2 = new Card("Steinmetz", 8);
		deck.add(steinmetz2);
		Card steinmetz3 = new Card("Steinmetz", 8);
		deck.add(steinmetz3);
		Card steinmetz4 = new Card("Steinmetz", 8);
		deck.add(steinmetz4);
		Card steinmetz5 = new Card("Steinmetz", 8);
		deck.add(steinmetz5);
		Card steinmetz6 = new Card("Steinmetz", 8);
		deck.add(steinmetz6);
		Card steinmetz7 = new Card("Steinmetz", 8);
		deck.add(steinmetz7);
		Card steinmetz8 = new Card("Steinmetz", 8);
		deck.add(steinmetz8);

		Card koechin = new Card("Koechin", 9);
		deck.add(koechin);
		Card koechin2 = new Card("Koechin", 9);
		deck.add(koechin2);
		Card koechin3 = new Card("Koechin", 9);
		deck.add(koechin3);
		Card koechin4 = new Card("Koechin", 9);
		deck.add(koechin4);
		Card koechin5 = new Card("Koechin", 9);
		deck.add(koechin5);
		Card koechin6 = new Card("Koechin", 9);
		deck.add(koechin6);
		Card koechin7 = new Card("Koechin", 9);
		deck.add(koechin7);
		Card koechin8 = new Card("Koechin", 9);
		deck.add(koechin8);
		Card koechin9 = new Card("Koechin", 9);
		deck.add(koechin9);
		
		Card schafhirtin = new Card("Schafhirtin", 10);
		deck.add(schafhirtin);
		Card schafhirtin2 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin2);
		Card schafhirtin3 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin3);
		Card schafhirtin4 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin4);
		Card schafhirtin5 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin5);
		Card schafhirtin6 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin6);
		Card schafhirtin7 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin7);
		Card schafhirtin8 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin8);
		Card schafhirtin9 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin9);
		Card schafhirtin10 = new Card("Schafhirtin", 10);
		deck.add(schafhirtin10);
		
		Card bergmann = new Card("Bergmann", 11);
		deck.add(bergmann);
		Card bergmann2 = new Card("Bergmann", 11);
		deck.add(bergmann2);
		Card bergmann3 = new Card("Bergmann", 11);
		deck.add(bergmann3);
		Card bergmann4 = new Card("Bergmann", 11);
		deck.add(bergmann4);
		Card bergmann5 = new Card("Bergmann", 11);
		deck.add(bergmann5);
		Card bergmann6 = new Card("Bergmann", 11);
		deck.add(bergmann6);
		Card bergmann7 = new Card("Bergmann", 11);
		deck.add(bergmann7);
		Card bergmann8 = new Card("Bergmann", 11);
		deck.add(bergmann8);
		Card bergmann9 = new Card("Bergmann", 11);
		deck.add(bergmann9);
		Card bergmann10 = new Card("Bergmann", 11);
		deck.add(bergmann10);
		Card bergmann11 = new Card("Bergmann", 11);
		deck.add(bergmann11);
		
		Card tagloehner = new Card("Tagloehner", 12);
		deck.add(tagloehner);
		Card tagloehner2 = new Card("Tagloehner", 12);
		deck.add(tagloehner2);
		Card tagloehner3 = new Card("Tagloehner", 12);
		deck.add(tagloehner3);
		Card tagloehner4 = new Card("Tagloehner", 12);
		deck.add(tagloehner4);
		Card tagloehner5 = new Card("Tagloehner", 12);
		deck.add(tagloehner5);
		Card tagloehner6 = new Card("Tagloehner", 12);
		deck.add(tagloehner6);
		Card tagloehner7 = new Card("Tagloehner", 12);
		deck.add(tagloehner7);
		Card tagloehner8 = new Card("Tagloehner", 12);
		deck.add(tagloehner8);
		Card tagloehner9 = new Card("Tagloehner", 12);
		deck.add(tagloehner9);
		Card tagloehner10 = new Card("Tagloehner", 12);
		deck.add(tagloehner10);
		Card tagloehner11 = new Card("Tagloehner", 12);
		deck.add(tagloehner11);
		Card tagloehner12 = new Card("Tagloehner", 12);
		deck.add(tagloehner12);
		
		Card narren = new Card("Narren", 0);
		deck.add(narren);
		Card narren2 = new Card("Narren", 0);
		deck.add(narren2);	
		
		//Collections.shuffle(deck);
	}
	
	//Methoden

	//Main-Methode (muss noch gelöscht werden, braucht es ja dann nicht mehr!)
	public static void main(String[] args) {
		
		//Deck d = new Deck();
		//Collections.shuffle(deck);
		//System.out.println(deck.get(0).getName() + ", " + deck.get(0).getValue());

		
	}

}
