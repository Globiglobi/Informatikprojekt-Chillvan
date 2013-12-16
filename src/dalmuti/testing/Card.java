package dalmuti.testing;

import java.util.ArrayList;

public class Card{
	
	public static void main(String[] args){
		
		ArrayList<String> Strings = new ArrayList<String>(4);
		
		Strings.add("Dalmuti");
		Strings.add("Kleiner Dalmuti");
		Strings.add("Kleiner Diener");
		Strings.add("Grosser Diener");
		
		for(String a: Strings){
		System.out.println(a);
		}
	}
}