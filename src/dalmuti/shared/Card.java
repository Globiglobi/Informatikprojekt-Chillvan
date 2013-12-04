package dalmuti.shared;

public class Card {
	
	//Attribute
	private String name;
	private int value;
	
	//Konstruktor
	public Card(String name, int value){
		this.name = name;
		this.value = value;	
	}
	
	//getter-Methoden
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
	//setter-Methoden
	public void setValue(int value){
		this.value = value;
	}


}
