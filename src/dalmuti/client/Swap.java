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
	static int myRank;
	static int[] newhand = new int[13];
	static int[] handcopy = new int[13];
	static int[] display = new int[2];
	
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
	
	
	//only for testing purpose
		public static void main(String[] args) {
			new Swap().setVisible(true);
		}
		
	
	//Constructor
	public Swap(/*ObjectOutputStream out, ObjectInputStream in*/){
		init();
		this.out = out;
		this.in = in;
	}
	
	public void init(){
		setTitle("Der Grosse Dalmuti - Karten tauschen");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//panel north contains explination
		panelNorth = new JPanel(new GridBagLayout());
//		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelNorth.setPreferredSize(new Dimension(700,150));//width, height
		add(panelNorth, BorderLayout.NORTH);
		
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(20,0,0,0);//top, left, bottom, right
		

		lbExplain = new JLabel("<html><body style='width:500px'> Jetzt kannst du deine Karten tauschen. Dazu wähle 2 Karten die du tauschen möchtest aus. Klicke danach auf Tauschen.");
		lbExplain.setFont(new Font("", Font.PLAIN, 18));
		gbcPanelNorth.gridy = 0;
		panelNorth.add(lbExplain, gbcPanelNorth);
		
		
		btSwap = new JButton("Tauschen");
		btSwap.setPreferredSize(new Dimension(100, 40));// width, height
		btSwap.setFont(new Font("", Font.BOLD, 14));
		btSwap.setHorizontalTextPosition(JButton.CENTER);
		btSwap.setVerticalTextPosition(JButton.CENTER);
		btSwap.addActionListener(this);
		gbcPanelNorth.gridy = 1;
		panelNorth.add(btSwap, gbcPanelNorth);
		
		
		//panel center show the selected cards you re going to swap
		panelCenter = new JPanel(new GridBagLayout());
//		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelCenter.setPreferredSize(new Dimension(700,200));//width, height
		add(panelCenter, BorderLayout.CENTER);
		
		
		GridBagConstraints gbcPanelCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelCenter.insets = new Insets(0,40,0,40);//top, left, bottom, right
		
		lbSwapCard1 = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		lbSwapCard1.setBorder(new LineBorder(Color.red, 3));
		gbcPanelCenter.gridx = 0;
		panelCenter.add(lbSwapCard1, gbcPanelCenter);
		
		lbSwapCard2 = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		lbSwapCard2.setBorder(new LineBorder(Color.red, 3));
		gbcPanelCenter.gridx = 1;
		panelCenter.add(lbSwapCard2, gbcPanelCenter);
		
		
		//panel south contains your cards
		panelSouth = new JPanel(new GridLayout(2, 7));
//		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelSouth.setPreferredSize(new Dimension(700,300));//width, height
		add(panelSouth, BorderLayout.SOUTH);
		
		
		GridBagConstraints gbcPanelSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelSouth.insets = new Insets(0,0,0,0);//top, left, bottom, right
				
		
		btKarteNarr = new JButton(String.valueOf(newhand[0]), new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		btKarteNarr.setHorizontalTextPosition(JButton.CENTER);
		btKarteNarr.setVerticalTextPosition(JButton.CENTER);
		btKarteNarr.setFont(new Font("", Font.BOLD, 72));
		btKarteNarr.setPreferredSize(new Dimension(97,150));//width, height
		btKarteNarr.setBorder(new LineBorder(Color.black, 2));
		btKarteNarr.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						narrclick();
					}
				}
		);
		gbcPanelSouth.gridx = 0;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarteNarr, gbcPanelSouth);
		
		btKarte1 = new JButton(String.valueOf(newhand[1]), new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		btKarte1.setHorizontalTextPosition(JButton.CENTER);
		btKarte1.setVerticalTextPosition(JButton.CENTER);
		btKarte1.setFont(new Font("", Font.BOLD, 72));
		btKarte1.setPreferredSize(new Dimension(97,150));//width, height
		btKarte1.setBorder(new LineBorder(Color.black, 2));
		btKarte1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 1;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 1;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte1, gbcPanelSouth);
		
		btKarte2 = new JButton(String.valueOf(newhand[2]), new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		btKarte2.setHorizontalTextPosition(JButton.CENTER);
		btKarte2.setVerticalTextPosition(JButton.CENTER);
		btKarte2.setFont(new Font("", Font.BOLD, 72));
		btKarte2.setPreferredSize(new Dimension(97,150));//width, height
		btKarte2.setBorder(new LineBorder(Color.black, 2));
		btKarte2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 2;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 2;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte2, gbcPanelSouth);
		
		btKarte3 = new JButton(String.valueOf(newhand[3]), new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		btKarte3.setHorizontalTextPosition(JButton.CENTER);
		btKarte3.setVerticalTextPosition(JButton.CENTER);
		btKarte3.setFont(new Font("", Font.BOLD, 72));
		btKarte3.setPreferredSize(new Dimension(97,150));//width, height
		btKarte3.setBorder(new LineBorder(Color.black, 2));
		btKarte3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 3;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 3;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte3, gbcPanelSouth);
		
		btKarte4 = new JButton(String.valueOf(newhand[4]), new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		btKarte4.setHorizontalTextPosition(JButton.CENTER);
		btKarte4.setVerticalTextPosition(JButton.CENTER);
		btKarte4.setFont(new Font("", Font.BOLD, 72));
		btKarte4.setPreferredSize(new Dimension(97,150));//width, height
		btKarte4.setBorder(new LineBorder(Color.black, 2));
		btKarte4.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 4;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 4;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte4, gbcPanelSouth);
		
		btKarte5 = new JButton(String.valueOf(newhand[5]), new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		btKarte5.setHorizontalTextPosition(JButton.CENTER);
		btKarte5.setVerticalTextPosition(JButton.CENTER);
		btKarte5.setFont(new Font("", Font.BOLD, 72));
		btKarte5.setPreferredSize(new Dimension(97,150));//width, height
		btKarte5.setBorder(new LineBorder(Color.black, 2));
		btKarte5.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 5;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 5;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte5, gbcPanelSouth);
		
		btKarte6 = new JButton(String.valueOf(newhand[6]), new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		btKarte6.setHorizontalTextPosition(JButton.CENTER);
		btKarte6.setVerticalTextPosition(JButton.CENTER);
		btKarte6.setFont(new Font("", Font.BOLD, 72));
		btKarte6.setPreferredSize(new Dimension(97,150));//width, height
		btKarte6.setBorder(new LineBorder(Color.black, 2));
		btKarte6.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 6;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 6;
		gbcPanelSouth.gridy = 0;
		panelSouth.add(btKarte6, gbcPanelSouth);
		
		btKarte7 = new JButton(String.valueOf(newhand[7]), new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		btKarte7.setHorizontalTextPosition(JButton.CENTER);
		btKarte7.setVerticalTextPosition(JButton.CENTER);
		btKarte7.setFont(new Font("", Font.BOLD, 72));
		btKarte7.setPreferredSize(new Dimension(97,150));//width, height
		btKarte7.setBorder(new LineBorder(Color.black, 2));
		btKarte7.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 7;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 0;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte7, gbcPanelSouth);
		
		btKarte8 = new JButton(String.valueOf(newhand[8]), new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		btKarte8.setHorizontalTextPosition(JButton.CENTER);
		btKarte8.setVerticalTextPosition(JButton.CENTER);
		btKarte8.setFont(new Font("", Font.BOLD, 72));
		btKarte8.setPreferredSize(new Dimension(97,150));//width, height
		btKarte8.setBorder(new LineBorder(Color.black, 2));
		btKarte8.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 8;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 1;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte8, gbcPanelSouth);
		
		btKarte9 = new JButton(String.valueOf(newhand[9]), new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		btKarte9.setHorizontalTextPosition(JButton.CENTER);
		btKarte9.setVerticalTextPosition(JButton.CENTER);
		btKarte9.setFont(new Font("", Font.BOLD, 72));
		btKarte9.setPreferredSize(new Dimension(97,150));//width, height
		btKarte9.setBorder(new LineBorder(Color.black, 2));
		btKarte9.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 9;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 2;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte9, gbcPanelSouth);
		
		btKarte10 = new JButton(String.valueOf(newhand[10]), new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		btKarte10.setHorizontalTextPosition(JButton.CENTER);
		btKarte10.setVerticalTextPosition(JButton.CENTER);
		btKarte10.setFont(new Font("", Font.BOLD, 72));
		btKarte10.setPreferredSize(new Dimension(97,150));//width, height
		btKarte10.setBorder(new LineBorder(Color.black, 2));
		btKarte10.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 10;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 3;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte10, gbcPanelSouth);
		
		btKarte11 = new JButton(String.valueOf(newhand[11]), new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		btKarte11.setHorizontalTextPosition(JButton.CENTER);
		btKarte11.setVerticalTextPosition(JButton.CENTER);
		btKarte11.setFont(new Font("", Font.BOLD, 72));
		btKarte11.setPreferredSize(new Dimension(97,150));//width, height
		btKarte11.setBorder(new LineBorder(Color.black, 2));
		btKarte11.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 11;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 4;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte11, gbcPanelSouth);
		
		btKarte12 = new JButton(String.valueOf(newhand[12]), new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		btKarte12.setHorizontalTextPosition(JButton.CENTER);
		btKarte12.setVerticalTextPosition(JButton.CENTER);
		btKarte12.setFont(new Font("", Font.BOLD, 72));
		btKarte12.setPreferredSize(new Dimension(97,150));//width, height
		btKarte12.setBorder(new LineBorder(Color.black, 2));
		btKarte12.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int i = 12;
						cardclick(i);
					}
				}
		);
		gbcPanelSouth.gridx = 5;
		gbcPanelSouth.gridy = 1;
		panelSouth.add(btKarte12, gbcPanelSouth);
		
		
		
		//ResetButton
		btReset = new JButton(String.valueOf(display[1]), new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		btReset.setHorizontalTextPosition(JButton.CENTER);
		btReset.setVerticalTextPosition(JButton.CENTER);
		btReset.setFont(new Font("", Font.BOLD, 72));
		btReset.setPreferredSize(new Dimension(97,150));//width, height
		btReset.setBorder(new LineBorder(Color.red, 2));
		btReset.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						resetclick();
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
	
	// Methods
	
	// click on normal card
	public static void cardclick(int button) {
		// in case of button gets clicked again
		if ((newhand[button] != handcopy[button]) && newhand[button] >= 1) {
			newhand[button]--;
		}
		// in case new button gets clicked
		else if ((newhand[button] == handcopy[button]) && newhand[button] >= 1) {
			System.arraycopy(handcopy,0,newhand,0,13);
			newhand[button]--;
		}
		// in case of button gets clicked with 0 cards
		else if((newhand[button] == handcopy[button]) && newhand[button] == 0){
			System.arraycopy(handcopy,0,newhand,0,13);
		}
		// change display array
		display[0] = button;
		display[1] = handcopy[button] - newhand[button];
	}
	// click on narr button
	public static void narrclick() {
		// in case no card has been played yet
		if ((display[0] == 0 || display[0] == 13) && newhand[0] >= 1) {
			newhand[0]--;
			display[0] = 13;
			display[1]++;
		}
		// in case another card has been played
		else if (display[0] != 0 && newhand[0] >= 1) {
			newhand[0]--;
			display[1]++;
		}
	}
	
	// click on reset button
	public static void resetclick(){
		System.arraycopy(handcopy,0,newhand,0,13);
		display = new int[2];
	}

	// place cards
	public void placecards() {
		if((display[0] < Client.mo.playedcards[0] && display[1] == Client.mo.playedcards[1] || Client.mo.playedcards[0] == 0) && display[1] != 0){
			int[] check = new int[13];
			System.arraycopy(newhand, 0, check, 0,13);
			Client.mo.users.get(myRank).setHand(check);
			Client.mo.users.get(myRank).calcamount();
			System.arraycopy(display,0,Client.mo.playedcards,0,2);
			display = new int[2];
			Client.mo.pass = 0;
			sendObject();
		}
//		else{ return statement
//		}
	}
	// send Masterobject back to Server
	public static void sendObject(){
		try{
			Playtable.out.writeObject(Client.mo);
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

}
