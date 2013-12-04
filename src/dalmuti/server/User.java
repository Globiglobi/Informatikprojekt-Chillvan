package dalmuti.server;

public class User {
	
	//private long userID;
	private String nickname;
	
	
	public User(String nickname){
		//this.userID = userID;
		this.nickname = nickname;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
