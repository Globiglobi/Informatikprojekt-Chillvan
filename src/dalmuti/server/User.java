package dalmuti.server;

public class User {
	
	private long userID;
	protected String nickname;
	
	public User(long userID, String nickname){
		this.userID = userID;
		this.nickname = nickname;
	}

}
