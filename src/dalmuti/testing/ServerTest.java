package dalmuti.testing;

import javax.swing.JFrame;

public class ServerTest {
	public static void main(String[] args){
		Server miu = new Server();
		miu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miu.startRunning();
	}
}
