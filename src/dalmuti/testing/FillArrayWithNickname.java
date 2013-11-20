package dalmuti.testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FillArrayWithNickname {
	
	private JButton btLogin;
	private int i = 0;
	
	public FillArrayWithNickname(){
		btLogin = new JButton();
		btLogin.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					if(i == 0){
						//1. Nickname, i++
					}else if(i == 1){
						//2. Nickname, i++
					}else if(i == 2){
						//3. Nickname, i++
					}else if(i == 3){
						//4. Nickname, i++
					}
					
				}
			}
		);
	}
}
