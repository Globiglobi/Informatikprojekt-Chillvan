package dalmuti.server;

public class User {
	
	private long userID;
	protected String nickname;
	
	public void User(long userID, String nickname){
		this.userID = userID;
		this.nickname = nickname;
	}

}
