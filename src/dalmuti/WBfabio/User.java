package dalmuti.WBfabio;

public class User {

	// Attribute
	public String Nickname;
	public int UserID;
	public int Score;
	public int Rank;

	// Definiton der Methode anfragenNickname
	public String anfragenNickname() {
		System.out.println("Nickname: " + Nickname);
		return Nickname;
	}

	// Definition der Methode anfragenUserID
	public int anfragenUserID() {
		System.out.println("UserID: " + UserID);
		return UserID;
	}
	//Definition Constructor Nickname
	public User () {
	}
	// DEfiniton Constructur
	public User (String Nickname) {

		// Deklarieren der maximalen Anzahl an Objekten
		int MAX_OBJ = 8;

		// Anlegen des Arrays des Objekts einUser
		User[] einUser = new User[MAX_OBJ];

		// Anlegen der Objekte
		for (int i = 0; i < MAX_OBJ; i++)
			einUser[i] = new User();

		// F�llen des Objekts mit Werten
		for (int i = 0; i < MAX_OBJ; i++) {
			einUser[i].Nickname = Nickname;
			einUser[i].UserID = i + 1;
			einUser[i].Score = 1;
			einUser[i].Rank = 1;
		}

		// Ausgabe des Objekts
//		for (int i = 0; i < MAX_OBJ; i++) {

//			System.out.println("\n");
//			einUser[i].anfragenNickname();
//			einUser[i].anfragenUserID();
//			System.out.println("Score: " + einUser[i].Score);
//			System.out.println("Rank: " + einUser[i].Rank);
//		}
	}
}
