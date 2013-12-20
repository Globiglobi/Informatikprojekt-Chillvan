/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End, Silvan Hoppler
 * 
 */

package dalmuti.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Swap extends JFrame implements ActionListener{
	
	ObjectOutputStream out;
	ObjectInputStream in;
	static int display1 = 13;
	static int display2 = 13;
	static boolean servant;
	
	//GUI-Globals
	private JLabel lbBackground;
	
	//GUI-Globals what's to do
	private JPanel panelNorth;
	private JLabel lbExplain;
	private JButton btSwap;
	
	//GUI-Globals shows the card you're going to swap
	private JPanel panelCenter;
	private JLabel lbSwapCard1;
	private JLabel lbSwapCard2;
	
	//GUI-Globals all your cards
	private JPanel panelSouth;
	private JButton btKarte1;
	private JButton btKarte2;
	private JButton btKarte3;
	private JButton btKarte4;
	private JButton btKarte5;
	private JButton btKarte6;
	private JButton btKarte7;
	private JButton btKarte8;
	private JButton btKarte9;
	private JButton btKarte10;
	private JButton btKarte11;
	private JButton btKarte12;
	private JButton btKarteNarr;
	private JButton btReset;
	
	
	// Bastian End
	//Constructor
	public Swap(/*ObjectOutputStream out, ObjectInputStream in*/){
		init();
		this.out = out;
		this.in = in;
	}
	
	// Bastian End
	public void init(){
		setTitle("Der Grosse Dalmuti - Karten tauschen - " + Client.mo.users.get(Playtable.myRank).getNickname());
		setSize(700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Login.playtable.glassPane.setVisible(true);
		servant = false;
		
		//set Background Image
		getContentPane().setLayout(new BorderLayout());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon background = new ImageIcon(getClass().getResource("/dalmuti/image/swapbackground.png"));
		lbBackground = new JLabel(background);
		getLayeredPane().add(lbBackground, new Integer(Integer.MIN_VALUE));
		lbBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		
		
		//panel north contains explanation
		panelNorth = new JPanel(new GridBagLayout());
		panelNorth.setOpaque(false);
//		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelNorth.setPreferredSize(new Dimension(700,150));//width, height
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(20,0,0,0);//top, left, bottom, right
		

		lbExplain = new JLabel("<html><body style='width:500px'> ");
		setExplanation();
		lbExplain.setFont(new Font("", Font.BOLD, 16));
		gbcPanelNorth.gridy = 0;
		panelNorth.add(lbExplain, gbcPanelNorth);
		
		
		btSwap = new JButton("Tauschen");
		btSwap.setPreferredSize(new Dimension(120, 50));// width, height
		btSwap.setFont(new Font("", Font.BOLD, 16));
		btSwap.setHorizontalTextPosition(JButton.CENTER);
		btSwap.setVerticalTextPosition(JButton.CENTER);
		btSwap.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					swapcards();
				}
			}
		);
		gbcPanelNorth.gridy = 1;
		panelNorth.add(btSwap, gbcPanelNorth);
		
		
		//panel center show the selected cards you re going to swap
		panelCenter = new JPanel(new GridBagLayout());
		panelCenter.setOpaque(false);
//		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelCenter.setPreferredSize(new Dimension(700,200));//width, height
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		
		GridBagConstraints gbcPanelCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelCenter.insets = new Insets(0,40,0,40);//top, left, bottom, right
		
		lbSwapCard1 = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		lbSwapCard1.setBorder(new LineBorder(Color.gray, 3));
		gbcPanelCenter.gridx = 0;
		panelCenter.add(lbSwapCard1, gbcPanelCenter);
		
		lbSwapCard2 = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		lbSwapCard2.setBorder(new LineBorder(Color.gray, 3));
		gbcPanelCenter.gridx = 1;
		panelCenter.add(lbSwapCard2, gbcPanelCenter);
		
		
		//panel south contains your cards
		panelSouth = new JPanel(new GridLayout(2, 7));
//		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelSouth.setPreferredSize(new Dimension(700,300));//width, height
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		
		GridBagConstraints gbcPanelSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelSouth.insets = new Insets(0,0,0,0);//top, left, bottom, right
				
		
		btKarteNarr = new JButton(String.valueOf(Playtable.newhand[0]), new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		btKarteNarr.setHorizontalTextPosition(JButton.CENTER);
		btKarteNarr.setVerticalTextPosition(JButton.CENTER);
		btKarteNarr.setFont(new Font("", Font.BOLD, 72));
		btKarteNarr.setForeground(Color.white);
		btKarteNarr.setPreferredSize(new Dimension(97,150));//width, height
		btKarteNarr.setBorder(new LineBorder(Color.gray, 2));
		btKarteNarr.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(0);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 0;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarteNarr, gbcPanelSouth);
		
		btKarte1 = new JButton(String.valueOf(Playtable.newhand[1]), new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		btKarte1.setHorizontalTextPosition(JButton.CENTER);
		btKarte1.setVerticalTextPosition(JButton.CENTER);
		btKarte1.setFont(new Font("", Font.BOLD, 72));
		btKarte1.setForeground(Color.white);
		btKarte1.setPreferredSize(new Dimension(97,150));//width, height
		btKarte1.setBorder(new LineBorder(Color.gray, 2));
		btKarte1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(1);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 1;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte1, gbcPanelSouth);
		
		btKarte2 = new JButton(String.valueOf(Playtable.newhand[2]), new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		btKarte2.setHorizontalTextPosition(JButton.CENTER);
		btKarte2.setVerticalTextPosition(JButton.CENTER);
		btKarte2.setFont(new Font("", Font.BOLD, 72));
		btKarte2.setForeground(Color.white);
		btKarte2.setPreferredSize(new Dimension(97,150));//width, height
		btKarte2.setBorder(new LineBorder(Color.gray, 2));
		btKarte2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(2);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 2;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte2, gbcPanelSouth);
		
		btKarte3 = new JButton(String.valueOf(Playtable.newhand[3]), new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		btKarte3.setHorizontalTextPosition(JButton.CENTER);
		btKarte3.setVerticalTextPosition(JButton.CENTER);
		btKarte3.setFont(new Font("", Font.BOLD, 72));
		btKarte3.setForeground(Color.white);
		btKarte3.setPreferredSize(new Dimension(97,150));//width, height
		btKarte3.setBorder(new LineBorder(Color.gray, 2));
		btKarte3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(3);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 3;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte3, gbcPanelSouth);
		
		btKarte4 = new JButton(String.valueOf(Playtable.newhand[4]), new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		btKarte4.setHorizontalTextPosition(JButton.CENTER);
		btKarte4.setVerticalTextPosition(JButton.CENTER);
		btKarte4.setFont(new Font("", Font.BOLD, 72));
		btKarte4.setForeground(Color.white);
		btKarte4.setPreferredSize(new Dimension(97,150));//width, height
		btKarte4.setBorder(new LineBorder(Color.gray, 2));
		btKarte4.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(4);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 4;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte4, gbcPanelSouth);
		
		btKarte5 = new JButton(String.valueOf(Playtable.newhand[5]), new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		btKarte5.setHorizontalTextPosition(JButton.CENTER);
		btKarte5.setVerticalTextPosition(JButton.CENTER);
		btKarte5.setFont(new Font("", Font.BOLD, 72));
		btKarte5.setForeground(Color.white);
		btKarte5.setPreferredSize(new Dimension(97,150));//width, height
		btKarte5.setBorder(new LineBorder(Color.gray, 2));
		btKarte5.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(5);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 5;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte5, gbcPanelSouth);
		
		btKarte6 = new JButton(String.valueOf(Playtable.newhand[6]), new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		btKarte6.setHorizontalTextPosition(JButton.CENTER);
		btKarte6.setVerticalTextPosition(JButton.CENTER);
		btKarte6.setFont(new Font("", Font.BOLD, 72));
		btKarte6.setForeground(Color.white);
		btKarte6.setPreferredSize(new Dimension(97,150));//width, height
		btKarte6.setBorder(new LineBorder(Color.gray, 2));
		btKarte6.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(6);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 6;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte6, gbcPanelSouth);
		
		btKarte7 = new JButton(String.valueOf(Playtable.newhand[7]), new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		btKarte7.setHorizontalTextPosition(JButton.CENTER);
		btKarte7.setVerticalTextPosition(JButton.CENTER);
		btKarte7.setFont(new Font("", Font.BOLD, 72));
		btKarte7.setForeground(Color.white);
		btKarte7.setPreferredSize(new Dimension(97,150));//width, height
		btKarte7.setBorder(new LineBorder(Color.gray, 2));
		btKarte7.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(7);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 0;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte7, gbcPanelSouth);
		
		btKarte8 = new JButton(String.valueOf(Playtable.newhand[8]), new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		btKarte8.setHorizontalTextPosition(JButton.CENTER);
		btKarte8.setVerticalTextPosition(JButton.CENTER);
		btKarte8.setFont(new Font("", Font.BOLD, 72));
		btKarte8.setForeground(Color.white);
		btKarte8.setPreferredSize(new Dimension(97,150));//width, height
		btKarte8.setBorder(new LineBorder(Color.gray, 2));
		btKarte8.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(8);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 1;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte8, gbcPanelSouth);
		
		btKarte9 = new JButton(String.valueOf(Playtable.newhand[9]), new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		btKarte9.setHorizontalTextPosition(JButton.CENTER);
		btKarte9.setVerticalTextPosition(JButton.CENTER);
		btKarte9.setFont(new Font("", Font.BOLD, 72));
		btKarte9.setForeground(Color.white);
		btKarte9.setPreferredSize(new Dimension(97,150));//width, height
		btKarte9.setBorder(new LineBorder(Color.gray, 2));
		btKarte9.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(9);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 2;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte9, gbcPanelSouth);
		
		btKarte10 = new JButton(String.valueOf(Playtable.newhand[10]), new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		btKarte10.setHorizontalTextPosition(JButton.CENTER);
		btKarte10.setVerticalTextPosition(JButton.CENTER);
		btKarte10.setFont(new Font("", Font.BOLD, 72));
		btKarte10.setForeground(Color.white);
		btKarte10.setPreferredSize(new Dimension(97,150));//width, height
		btKarte10.setBorder(new LineBorder(Color.gray, 2));
		btKarte10.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(10);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 3;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte10, gbcPanelSouth);
		
		btKarte11 = new JButton(String.valueOf(Playtable.newhand[11]), new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		btKarte11.setHorizontalTextPosition(JButton.CENTER);
		btKarte11.setVerticalTextPosition(JButton.CENTER);
		btKarte11.setFont(new Font("", Font.BOLD, 72));
		btKarte11.setForeground(Color.white);
		btKarte11.setPreferredSize(new Dimension(97,150));//width, height
		btKarte11.setBorder(new LineBorder(Color.gray, 2));
		btKarte11.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(11);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 4;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte11, gbcPanelSouth);
		
		btKarte12 = new JButton(String.valueOf(Playtable.newhand[12]), new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		btKarte12.setHorizontalTextPosition(JButton.CENTER);
		btKarte12.setVerticalTextPosition(JButton.CENTER);
		btKarte12.setFont(new Font("", Font.BOLD, 72));
		btKarte12.setForeground(Color.white);
		btKarte12.setPreferredSize(new Dimension(97,150));//width, height
		btKarte12.setBorder(new LineBorder(Color.gray, 2));
		btKarte12.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						swapclick(12);
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 5;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte12, gbcPanelSouth);
		
		
		
		//ResetButton
		btReset = new JButton("Reset", new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		btReset.setHorizontalTextPosition(JButton.CENTER);
		btReset.setVerticalTextPosition(JButton.CENTER);
		btReset.setFont(new Font("", Font.BOLD, 30));
		btReset.setPreferredSize(new Dimension(97,150));//width, height
		btReset.setBorder(new LineBorder(Color.gray, 2));
		btReset.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						resetclick();
						swapimage();
						UpdateButtons();
					}
				}
		);
		gbcPanelSouth.gridx = 6;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btReset, gbcPanelSouth);
		
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == btSwap){
			//swap the cards!
		}
		
	}

	// Silvan Hoppler
	// Methods
	public void autofillin(){
		
		if(Playtable.myRank == 3){
			servant = true;
			for(int i = 1; i < Playtable.newhand.length; i++){
				if(Playtable.newhand[i] == 1 && display1 == 13){
					Playtable.newhand[i]--;
					display1 = i;
					continue;
				}
				if(Playtable.newhand[i] > 1 && display1 == 13){
					Playtable.newhand[i] = Playtable.newhand[i] - 2;
					display1 = i;
					display2 = i;
					break;
				}
				if(Playtable.newhand[i] >= 1 && display1 != 13){
					Playtable.newhand[i]--;
					display2 = i;
					break;
				}
			}
		}
		if(Playtable.myRank == 2){
			servant = true;
			for(int i = 1; i < Playtable.newhand.length; i++){
				if(Playtable.newhand[i] >= 1){
					Playtable.newhand[i]--;
					display1 = i;
					break;
				}
			}
		}
		swapimage();
		UpdateButtons();
	}
	
	// click on normal card
	public static void swapclick(int button) {
		if(servant == true){
			// do nothing
		}
		else{
			// if no card has been selected yet
			if (display1 == 13 && Playtable.newhand[button] != 0) {
				Playtable.newhand[button]--;
				display1 = button;
			}
		// if one card has been selected already
			else if (display1 != 13 && display2 == 13 && Playtable.newhand[button] != 0 && Playtable.myRank != 1) {
				Playtable.newhand[button]--;
				display2 = button;
			}
		}
	}
	
	// click on reset button
	public static void resetclick(){
		if(servant == true){
			// do nothing
		}
		else{
		System.arraycopy(Playtable.handcopy,0,Playtable.newhand,0,13);
		display1 = 13;
		display2 = 13;
		}
	}

	// swap cards
	public void swapcards() {
		if((((display1 != 13 && display2 != 13) && Playtable.myRank != 1) || servant == true || (display1 != 13 && display2 == 13 && Playtable.myRank == 1))){
			int[] check = new int[13];
			System.arraycopy(Playtable.newhand, 0, check, 0,13);
			Client.mo.users.get(Playtable.myRank).setHand(check);
			Client.mo.users.get(Playtable.myRank).calcamount();
			if(Playtable.myRank == 0){
				Client.mo.users.get(3).getHand()[display1]++;
				Client.mo.users.get(3).getHand()[display2]++;
			}
			if(Playtable.myRank == 1){
				Client.mo.users.get(2).getHand()[display1]++;
			}
			if(Playtable.myRank == 2){
				Client.mo.users.get(1).getHand()[display1]++;
			}
			if(Playtable.myRank == 3){
				Client.mo.users.get(0).getHand()[display1]++;
				Client.mo.users.get(0).getHand()[display2]++;
			}
			for(int i = 0; i < Client.mo.users.size(); i++){
				Client.mo.users.get(i).calcamount();
			}
			display1 = 13;
			display2 = 13;
			Client.mo.turn++;
			setVisible(false);
			sendObject();
		}

	}
	// send Masterobject back to Server
	public static void sendObject(){
		try{
			Playtable.out.writeObject(Client.mo);
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void UpdateButtons(){
		btKarte1.setText(String.valueOf(Playtable.newhand[1]));
		btKarte2.setText(String.valueOf(Playtable.newhand[2]));
		btKarte3.setText(String.valueOf(Playtable.newhand[3]));
		btKarte4.setText(String.valueOf(Playtable.newhand[4]));
		btKarte5.setText(String.valueOf(Playtable.newhand[5]));
		btKarte6.setText(String.valueOf(Playtable.newhand[6]));
		btKarte7.setText(String.valueOf(Playtable.newhand[7]));
		btKarte8.setText(String.valueOf(Playtable.newhand[8]));
		btKarte9.setText(String.valueOf(Playtable.newhand[9]));
		btKarte10.setText(String.valueOf(Playtable.newhand[10]));
		btKarte11.setText(String.valueOf(Playtable.newhand[11]));
		btKarte12.setText(String.valueOf(Playtable.newhand[12]));
		btKarteNarr.setText(String.valueOf(Playtable.newhand[0]));
	}
	
	public void swapimage(){
		// change image left card
		if(display1 == 0){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		}if(display1 == 12){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		}if(display1 == 11){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		}if(display1 == 10){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		}if(display1 == 9){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		}if(display1 == 8){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		}if(display1 == 7){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		}if(display1 == 6){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		}if(display1 == 5){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		}if(display1 == 4){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		}if(display1 == 3){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		}if(display1 == 2){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		}if(display1 == 1){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		}if(display1 == 13){
			lbSwapCard1.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		}
		// change image right card
		if(display2 == 0){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		}if(display2 == 12){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		}if(display2 == 11){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		}if(display2 == 10){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		}if(display2 == 9){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		}if(display2 == 8){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		}if(display2 == 7){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		}if(display2 == 6){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		}if(display2 == 5){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		}if(display2 == 4){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		}if(display2 == 3){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		}if(display2 == 2){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		}if(display2 == 1){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		}if(display2 == 13){
			lbSwapCard2.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		}
		
	}
	// set Explanation
	public void setExplanation(){
		if(Playtable.myRank == 3){
		lbExplain.setText("<html><body style='width:500px'> Als grosser Diener musst du dem Grossen Dalmuti deine beiden besten Karten geben. Bitte drück dafür auf Tauschen.");
		}
		if(Playtable.myRank == 2){
			lbExplain.setText("<html><body style='width:500px'> Als kleiner Diener musst du dem kleinen Dalmuti deine beste Karten geben. Bitte drück dafür auf Tauschen.");

		}
		if(Playtable.myRank == 1){
			lbExplain.setText("<html><body style='width:500px'> Als kleiner Dalmuti darfst du deine schlechteste Karten an den kleinen Diener abgeben. Bitte wähl deine Karte aus und drück auf Tauschen.");

		}
		if(Playtable.myRank == 0){
			lbExplain.setText("<html><body style='width:500px'> Als grosser Dalmuti darfst du deine zwei schlechtesten Karten an den grossen Diener abgeben. Bitte wähl deine Karten aus und drück auf Tauschen.");

		}
		
	}

}
