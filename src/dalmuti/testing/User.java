package dalmuti.testing;

public class User {

	// Attribute
	public String nickname;
	public int UserID;

	// Konstruktor
	public User(String nickname) {
		this.nickname = nickname;
		this.UserID = 1;


		// muss nacher wieder gelšscht werden, nur zum zeigen das etwas passiert
		System.out.println(UserID);
		System.out.println(nickname);
		this.UserID++;

	}

}
