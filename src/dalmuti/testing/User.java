package dalmuti.testing;

public class User {

	// Attribute
	public String nickname;
	public int UserID;

	// Konstruktor
	public User(String nickname) {
		this.nickname = nickname;
		CalculateID();


		// muss nacher wieder gelšscht werden, nur zum zeigen das etwas passiert
		System.out.println(UserID + " " + nickname);
		

	}
	
	//Methoden
	public int CalculateID() {
		UserID=0;
		UserID++;
		return UserID;
	}

}
