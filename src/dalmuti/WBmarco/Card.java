package dalmuti.WBmarco;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
	
	//Attribute
	public String name;
	public int value;
	
	//Konstruktor
	public Card(String name, int value){
		this.name = name;
		this.value = value;	
	}
	
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
	




	
	// irgendeine Karte wie Dalmuti, Erzbischof, usw. generieren
//	public static void generateCard(String cardName, int value) {
//		int index = 0;
//		if(cardName == "Narren") {
//			deck.add(index, (cardName, value));
//			index++;
//		}
//		else {
//		for(int i = 0; i<value; i++) {	
//			DeckListName.add(index, (cardName));
//			DeckListValue.add(index,(value));
//			index++;
//		}
//		}
//	}

}
