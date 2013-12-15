/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End
 * 
 * todo:
 * - btLogin soll userObject generieren
 * - background image
 * - animated background, Karten bewegen sich gegeneinander
 * - nickname auf 16 Zeichen begrenzen
 * - alles auf englisch
 * 
 *
 */

package dalmuti.client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dalmuti.shared.User;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	ObjectOutputStream out;
	ObjectInputStream in;
	int user_id = 0;
	static Playtable playtable;
	
	
	//GUI-Globals JLayeredPane
	private JLabel lbBackground;
	
	
	//GUI-Globals panelNorth
	private JPanel panelNorth;
	private JLabel lbTitel;
	
	
	//GUI-Globals panelCenter
	private JPanel panelCenter;
	private JLabel lbEnterNickname;
	private JTextField tfEnterNickname;
	private JButton btLogin;
	
	
	//GUI-Globals panelSouth
	private JPanel panelSouth;
	private JLabel lbGap1;
	private JLabel lbGap2;
	private JLabel lbLogo;
	private JLabel lbGap3;
	private JLabel lbGap4;
	private JLabel lbVersion;
	private JLabel lbGap5;
	private JLabel lbCopyright;
	private JLabel lbGap6;
	private JLabel lbGap7;
	

/*	//nur zu testzwecken
	public static void main(String[] args){
		new Login().setVisible(true);
	}*/
	

	//Constructor
	public Login(ObjectOutputStream out, ObjectInputStream in){
		this.init();
		this.out = out;
		this.in = in;
	}
	
	public void init(){
		setTitle("Der Grosse Dalmuti - Login");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	

		
		
		//set Background Image
		getContentPane().setLayout(new BorderLayout());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon background = new ImageIcon(getClass().getResource("/dalmuti/image/background.png"));
		lbBackground = new JLabel(background);
		getLayeredPane().add(lbBackground, new Integer(Integer.MIN_VALUE));
		lbBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		

		
		
		//panelNorth -Titel
		panelNorth = new JPanel(new GridBagLayout());
		panelNorth.setOpaque(false);
//		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		//Components in panelNorth
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(100, 0, 0, 0);// top, left, bottom, right

		lbTitel = new JLabel("Der Grosse Dalmuti");
		lbTitel.setFont(new Font("", Font.BOLD, 80));
		panelNorth.add(lbTitel, gbcPanelNorth);
		
		
		
		
		//panelCenter - Enter Nickname + LoginButton
		panelCenter = new JPanel(new GridBagLayout());
		panelCenter.setOpaque(false);
//		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		//Components in panelCenter
		GridBagConstraints gbcPanelCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelCenter.insets = new Insets(10, 0, 10, 0);// top, left, bottom, right

		lbEnterNickname = new JLabel("Gib hier deinen Nickname ein.");
		lbEnterNickname.setFont(new Font("", Font.BOLD, 20));
		gbcPanelCenter.gridy = 0;
		panelCenter.add(lbEnterNickname);

		tfEnterNickname = new JTextField();
		tfEnterNickname.setPreferredSize(new Dimension(460, 40));
		tfEnterNickname.setFont(new Font("", Font.PLAIN, 18));
		tfEnterNickname.setHorizontalAlignment(JLabel.CENTER);
		tfEnterNickname.addActionListener(this);
		gbcPanelCenter.gridy = 1;
		panelCenter.add(tfEnterNickname, gbcPanelCenter);

		btLogin = new JButton("Login");
		btLogin.setPreferredSize(new Dimension(100, 50));// width, height
		btLogin.setFont(new Font("", Font.BOLD, 18));
		btLogin.setHorizontalTextPosition(JButton.CENTER);
		btLogin.setVerticalTextPosition(JButton.CENTER);
		btLogin.addActionListener(this);
		gbcPanelCenter.gridy = 2;
		panelCenter.add(btLogin, gbcPanelCenter);


		
		
		
		//panelSouth - Logo, Copyright, Version
		panelSouth = new JPanel(new GridBagLayout());
		panelSouth.setOpaque(false);
//		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		//Components in panelSouth
		GridBagConstraints gbcPanelSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right

		/* Information about the GridBagConstraints - Anchor
		 * 
		 * FIRST_LINE_START		PAGE_START		FIRST_LINE_END 
		 * LINE_START			CENTER			LINE_END
		 * LAST_LINE_START		PAGE_END		LAST_LINE_END
		 */

		//Components on gridLevel Y=0
		lbGap1 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbGap1, gbcPanelSouth);

		lbGap2 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbGap2, gbcPanelSouth);

		lbLogo = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/logo_trans.png")));
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbLogo, gbcPanelSouth);

		lbGap3 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbGap3, gbcPanelSouth);

		lbGap4 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbGap4, gbcPanelSouth);

		//Components on gridLevel Y=1
		lbVersion = new JLabel("");
		lbVersion.setText("<html><body>Version 1.0.0<br>6. November 2013</body></html>");
		gbcPanelSouth.anchor = GridBagConstraints.FIRST_LINE_START;
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbVersion, gbcPanelSouth);

		lbGap5 = new JLabel("");
		gbcPanelSouth.anchor = GridBagConstraints.LAST_LINE_START;
		gbcPanelSouth.insets = new Insets(0, 110, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap5, gbcPanelSouth);

		lbCopyright = new JLabel("Copyright 2013 Cornflakes. Alle Rechte vorbehalten.");
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbCopyright, gbcPanelSouth);

		lbGap6 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 110, 10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap6, gbcPanelSouth);

		lbGap7 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap7, gbcPanelSouth);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == btLogin){
			try{
				if(tfEnterNickname.getText().length() <= 8){
				User Loginuser = new User(tfEnterNickname.getText());
				this.out.writeObject(Loginuser);
				tfEnterNickname.setText("");
				setVisible(false);
				playtable = new Playtable(this.out, this.in);
				}else{
					JOptionPane.showMessageDialog(null, "Nickname darf nicht mehr als 8 Zeichen haben!", "Dein Nickname ist zu lang!", JOptionPane.PLAIN_MESSAGE);
					tfEnterNickname.setText("");
				}
			}catch (java.io.IOException IOException){
				IOException.printStackTrace();
			}
		}else if(src == tfEnterNickname){
			try{
				if(tfEnterNickname.getText().length() <= 8){
				User Loginuser = new User(tfEnterNickname.getText());
				this.out.writeObject(Loginuser);
				tfEnterNickname.setText("");
				setVisible(false);
				playtable = new Playtable(this.out, this.in);
				}else{
					JOptionPane.showMessageDialog(null, "Nickname darf nicht mehr als 8 Zeichen haben!", "Dein Nickname ist zu lang!", JOptionPane.PLAIN_MESSAGE);
					tfEnterNickname.setText("");
				}
			}catch (java.io.IOException IOException){
				IOException.printStackTrace();
			}
		}
	}
}
