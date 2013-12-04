package dalmuti.server;

import java.util.ArrayList;

import dalmuti.shared.User;

public class Spiellogik {


	//Attribute
	public static ArrayList<User> userlist = new ArrayList<User>();
	
	public static void main(String[]args) {
		System.out.println(userlist.get(0).getNickname());
	}
	

}