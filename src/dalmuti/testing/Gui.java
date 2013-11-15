package dalmuti.testing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Gui extends JFrame{

	//Attribute
	private JLabel label1; // Label fŸr: Gib hier deinen Namen ein:
	private JTextArea txtNickname;
	private JButton jbOk;
	public String nickname;
	
	//getter-Methode
	public String getNickname() {
		return nickname;
	}
	
	//Konstruktor
	public Gui() {
		super("Login");
		//set layout manger
		this.setLayout(new BorderLayout());
		//create controls
		label1 = new JLabel("Gib hier deinen Namen ein: ");
		this.add(label1, BorderLayout.WEST); //label
		txtNickname = new JTextArea();
		this.add(txtNickname, BorderLayout.CENTER); //eingabe user
		jbOk = new JButton("OK");
		this.add(jbOk, BorderLayout.EAST);
		//action Listener setzen!!!
		jbOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				//nickname vom User wird in String abgespeichert
				nickname = txtNickname.getText();
				//mit dem String nickname kann jetzt ein neuer User erstellt werden (--> Zugriff auf User-Klasse!!!)
				User u1 = new User(nickname); //User 1 ist nun erstellt
				

				
				
			}	
		}
		
		);
		
		//Dynamic layout
		this.pack();
		//Show result
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		Gui g1 = new Gui();
		
		
		

	}




}

