package dalmuti.testing;

import java.util.ArrayList;
import java.util.Collections;

import dalmuti.shared.User;

public class TestSpiellogik {
	
	//4 Userers
	static User u1;
	static User u2;
	static User u3;
	static User u4;

	//Liste mit 4 Spieler generieren
	static ArrayList<User> activeUsers;
	
	//Liste ganzes Kartendeck
	static ArrayList<Card> deck;
	
	//Liste mit ausgewählten Karten
	static ArrayList<Card> choosenCard = new ArrayList<Card>(20);;
	
	
	//Main-Methode
	public static void main(String[] args) {
		
		//4 Userers generieren
		u1 = new User("Fabio");
		u2 = new User("Bastian");
		u3 = new User("Silvan");
		u4 = new User("Marco");
		
		//4 Useres in eine Liste speichern
		activeUsers = new ArrayList<User>(4);
		activeUsers.add(u1);
		activeUsers.add(u2);
		activeUsers.add(u3);
		activeUsers.add(u4);
		
		//1 Kartendeck generieren
		deck = new ArrayList<Card>(Card.createdeck());
		
		// Kartendeck mischeln
		Collections.shuffle(deck);
		
		//Alle Karten an die jeweiligen Spieler austeilen
		while (deck.isEmpty() != true) {
			for (int i = 0; i < 4; i++) {
				activeUsers.get(i).getHand().add(deck.remove(0));
			}
		}
		
		//Alle Karten von User 1 ausgeben
		System.out.print("Hand Spieler1: ");
		for(int i = 0; i< 20; i++) {
		System.out.print(activeUsers.get(0).getHand().get(i).getName() + " ");
		}
		System.out.println();
		
		//Alle Karten von User 2 ausgeben
		System.out.print("Hand Spieler2: ");
		for(int i = 0; i< 20; i++) {
		System.out.print(activeUsers.get(1).getHand().get(i).getName() + " ");
		}
		System.out.println();
		
		//Alle Karten von User 3 ausgeben
		System.out.print("Hand Spieler3: ");
		for(int i = 0; i< 20; i++) {
		System.out.print(activeUsers.get(2).getHand().get(i).getName() + " ");
		}
		System.out.println();
		
		//Alle Karten von User 4 ausgeben
		System.out.print("Hand Spieler4: ");
		for(int i = 0; i< 20; i++) {
		System.out.print(activeUsers.get(3).getHand().get(i).getName() + " ");
		}
		System.out.println();
		System.out.println("*******************");
		
		//Spieler 1 beginnt
		//System.out.println(activeUsers.get(0).getNickname().contains("Fabio"));
		int auswahl;  // Welche Karten wählt der User aus? z.B. Karte auf Position 2 in ArrayList
		auswahl = 0;
		chooseCard(auswahl);  //Karte auf Slot 0 wird zu ArrayList choosenCard hinzugefügt
		auswahl = 2;
		chooseCard(auswahl);
		auswahl = 4;
		chooseCard(auswahl);

		//Auswahl ausgeben (chossenCard ausgeben)
		for(int i=0; i<choosenCard.size();i++) {
			System.out.print(choosenCard.get(i).getName() + " ");
	}
		
		//Kontrolle 1: Hat der Spieler gleiche Karten in der Hand? 
		//Wenn false kommt hat er verschiedene Karten auf der Hand, bei ture hat er gleiche Karten auf der Hand
		System.out.println();
		System.out.println("Ist der Spielzug erlaubt? " + checkCard(choosenCard));
		
		//Kontrolle 2: Sind die gespielten Karten besser als die, die auf dem Tisch liegen? 

	


	


}
	
	private static boolean checkCard(ArrayList<Card> choosenCard2) {
		boolean checkCard;
		for(int i=0; i<choosenCard.size()-1;i++) {
			if(choosenCard.get(i).getName().equals(choosenCard.get(i+1).getName())){
				continue;
			}
			else{
				return checkCard = false;
				
			}
	}
	
		return checkCard = true;		
	}

	//Methoden
	public static void chooseCard(int auswahl){
		
	switch(auswahl) {
	case 0: Card c0 = activeUsers.get(0).getHand().get(0);
	choosenCard.add(c0);
	break;
	case 1: Card c1 = activeUsers.get(0).getHand().get(1);
	choosenCard.add(c1);
	break;
	case 2: Card c2 = activeUsers.get(0).getHand().get(2);
	choosenCard.add(c2);
	break;
	case 3: Card c3 = activeUsers.get(0).getHand().get(3);
	choosenCard.add(c3);
	break;
	case 4: Card c4 = activeUsers.get(0).getHand().get(4);
	choosenCard.add(c4);
	break;
	case 5: Card c5 = activeUsers.get(0).getHand().get(5);
	choosenCard.add(c5);
	break;
	case 6: Card c6 = activeUsers.get(0).getHand().get(1);
	choosenCard.add(c6);
	break;
	case 7: Card c7 = activeUsers.get(0).getHand().get(2);
	choosenCard.add(c7);
	break;
	case 8: Card c8 = activeUsers.get(0).getHand().get(3);
	choosenCard.add(c8);
	break;
	case 9: Card c9 = activeUsers.get(0).getHand().get(4);
	choosenCard.add(c9);
	break;
	case 10: Card c10 = activeUsers.get(0).getHand().get(5);
	choosenCard.add(c10);
	break;
	case 11: Card c11 = activeUsers.get(0).getHand().get(1);
	choosenCard.add(c11);
	break;
	case 12: Card c12 = activeUsers.get(0).getHand().get(2);
	choosenCard.add(c12);
	break;
	case 13: Card c13 = activeUsers.get(0).getHand().get(3);
	choosenCard.add(c13);
	break;
	case 14: Card c14 = activeUsers.get(0).getHand().get(4);
	choosenCard.add(c14);
	break;
	case 15: Card c15 = activeUsers.get(0).getHand().get(5);
	choosenCard.add(c15);
	break;
	case 16: Card c16 = activeUsers.get(0).getHand().get(1);
	choosenCard.add(c16);
	break;
	case 17: Card c17 = activeUsers.get(0).getHand().get(2);
	choosenCard.add(c17);
	break;
	case 18: Card c18 = activeUsers.get(0).getHand().get(3);
	choosenCard.add(c18);
	break;
	case 19: Card c19 = activeUsers.get(0).getHand().get(4);
	choosenCard.add(c19);
	break;
	case 20: Card c20 = activeUsers.get(0).getHand().get(5);
	choosenCard.add(c20);
	break;
	
	}
	}
}
