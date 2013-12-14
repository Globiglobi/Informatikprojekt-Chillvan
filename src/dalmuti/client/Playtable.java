/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End
 * 
 */

package dalmuti.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dalmuti.shared.Masterobject;

@SuppressWarnings("serial")
public class Playtable extends JFrame implements ActionListener, MouseListener{
	
	static ObjectOutputStream out;
	static ObjectInputStream in;
	static int myRank;
	static int[] newhand = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] handcopy = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] display = {0,0};
	static int[] playedcards = {0,0};
	
	
	//GUI-Globals glassPane
	public JPanel glassPane;
	
	//GUI-Globals menuBar
	private JMenuBar menuBar;
	private JMenu help;
	private JMenuItem spielregeln;
	private JMenuItem about;
		
	
	//GUI-Globals panelWest
	private JPanel panelWest;
	
	//GUI-Globals panelWestNorth - gegner oben
	private JPanel panelWestNorth;
	private JLabel lbCardsLeftNorth;
	
	//GUI-Globals panelWestWest - gegner links
	private JPanel panelWestWest;
	private JLabel lbCardsLeftWest;
	
	//GUI-Globals panelWestCenter - gespielte karten!
	private JPanel panelWestCenter;
	private JLabel lbCardsPlayed;
	private JLabel lbAmountCardsPlayed;
	
	//GUI-Globals panelWestEast - gegner rechts
	private JPanel panelWestEast;
	private JLabel lbCardsLeftEast;
	
	//GUI-Globals panelWestSouth - deine karten
	private JPanel panelWestSouth;
	private JPanel panelControl;
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
	private JLabel lbAmount;

	
	private static int cardAmount = 0;
		
	//GUI-Globals panelEast
	private JPanel panelEast;
		
	//GUI-Globals panelEastNorth
	private JPanel panelEastNorth;
	private JLabel lbScore;
		
	//GUI-Globals panelEastCenter
	private JPanel panelEastCenter;
	private JButton btLegen;
	private JButton btPassen;
		
	//GUI-Globals panelEastSouth
	private JPanel panelEastSouth;
	private JLabel lbChat;
		
/*
	//only for testing purpose
	public static void main(String[] args) {
		new Spieltisch().setVisible(true);
	}
*/	
	
	
	//Constructor
	public Playtable(ObjectOutputStream out, ObjectInputStream in){
		init();
		this.out = out;
		this.in = in;
	}

	
	public void init(){
		setTitle("Der Grosse Dalmuti - Playtable");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//set up glassPane
		//Create a panel to use as the glass pane  
		glassPane = new JPanel()  
		{  
		   public void paintComponent(Graphics g)  
		   {  
		      //Set the color grey with a 50% alpha  
		      g.setColor(new Color(0, 0, 0, 0.1f));  
		   
		      //Fill a rectangle with the 50% grey 
		      g.fillRect(0, 0, this.getWidth(), this.getHeight());  
		   }  
		};  
		//Turn off the opaque attribute of the panel  
		//This allows the controls to show through  
		glassPane.setOpaque(false);
		glassPane.addMouseListener(this);
		   
		//Set the glass pane in the JFrame  
		setGlassPane(glassPane); 
		
		//activate.GlassPane
		glassPane.setVisible(true);

		
	

		
		
		
		//panelWest
		panelWest = new JPanel();
//		panelWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWest.setPreferredSize(new Dimension(700,768));//width, height
		add(panelWest, BorderLayout.WEST);
		
		//Components in panelWest
		//this panel contains panelWestNorth, panelWestWest, panelWestCenter, panelWestEast, panelWestSouth
		
		
		
		//panelWestNorth - player top
		panelWestNorth = new JPanel(new GridBagLayout());
		panelWestNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestNorth.setPreferredSize(new Dimension(700,50));//width, height
		panelWest.add(panelWestNorth, BorderLayout.NORTH);
		
		//Components in panelWestNorth
		GridBagConstraints gbcPanelWestNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestNorth.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftNorth = new JLabel("Nickname hat 5 Karten");
		panelWestNorth.add(lbCardsLeftNorth, gbcPanelWestNorth);
		
		
		
		
		//panelWestWest - player left
		panelWestWest = new JPanel(new GridBagLayout());
		panelWestWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestWest.setPreferredSize(new Dimension(192,430));//width, height
		panelWest.add(panelWestWest, BorderLayout.WEST);
		
		//Components in panelWestWest
		GridBagConstraints gbcPanelWestWest = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestWest.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftWest = new JLabel("Nickname hat 5 Karten");
		panelWestWest.add(lbCardsLeftWest, gbcPanelWestWest);
		
		
		
		
		//panelWestCenter - played cards
		panelWestCenter = new JPanel(new GridBagLayout());
		panelWestCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestCenter.setPreferredSize(new Dimension(300,430));//width, height
		panelWest.add(panelWestCenter, BorderLayout.CENTER);
		
		//Components in panelWestCenter
		GridBagConstraints gbcPanelWestCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestCenter.insets = new Insets(5,30,5,30);//top, left, bottom, right
				
		lbCardsPlayed = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/narrbig.jpg")));
		gbcPanelWestCenter.gridx = 0;
		gbcPanelWestCenter.gridy = 0;
		panelWestCenter.add(lbCardsPlayed, gbcPanelWestCenter);
		
		lbAmountCardsPlayed = new JLabel("Diese Karte wurde 1 Mal gespielt");
		gbcPanelWestCenter.gridx = 0;
		gbcPanelWestCenter.gridy = 1;
		panelWestCenter.add(lbAmountCardsPlayed, gbcPanelWestCenter);		
		
		
		
		//panelWestEast - player right
		panelWestEast = new JPanel(new GridBagLayout());
		panelWestEast.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestEast.setPreferredSize(new Dimension(192,430));//width, height
		panelWest.add(panelWestEast, BorderLayout.EAST);
		
		//Components in panelWestEast
		GridBagConstraints gbcPanelWestEast = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestEast.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftEast = new JLabel("Nickname hat 5 Karten");
		panelWestEast.add(lbCardsLeftEast, gbcPanelWestEast);
		
		
		
		
		//panelWestSouth - deine karten
		panelWestSouth = new JPanel(new GridLayout(2, 7));
		panelWestSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestSouth.setPreferredSize(new Dimension(700,300));//width, height
		panelWest.add(panelWestSouth, BorderLayout.SOUTH);
		
		//Components in panelWestNorth
		GridBagConstraints gbcPanelWestSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestSouth.insets = new Insets(0,0,0,0);//top, left, bottom, right
				
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarteNarr, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte1, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte2, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte3, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte4, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte5, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte6, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte7, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte8, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte9, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte10, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte11, gbcPanelWestSouth);
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte12, gbcPanelWestSouth);
		
		
		
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
						Image();
						UpdateButtons();
					}
				}
		);
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btReset, gbcPanelWestSouth);

		

		
		
		
		//panelEast - Contains Scoreboard, Buttons, Chat
		panelEast = new JPanel();
//		panelEast.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEast.setPreferredSize(new Dimension(300,768));//width, height
		add(panelEast, BorderLayout.EAST);
		
		//Components in panelEast
		//this panel contains panelEastNorth, panelEastCenter, panelEastSouth
		
		
		
		
		//panelEastNorth - scoreboard
		panelEastNorth = new JPanel(new GridBagLayout());
		panelEastNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastNorth.setPreferredSize(new Dimension(300,200));//width, height
		panelEast.add(panelEastNorth, BorderLayout.NORTH);
		
		//Components in panelEastNorth
		GridBagConstraints gbcPanelEastNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastNorth.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		lbScore = new JLabel("SCOREBOARD:");
		panelEastNorth.add(lbScore, gbcPanelEastNorth);
		

		
		
		//panelEastCenter - buttons
		panelEastCenter = new JPanel(new GridBagLayout());
		panelEastCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastCenter.setPreferredSize(new Dimension(300,100));//width, height
		panelEast.add(panelEastCenter, BorderLayout.CENTER);
		
		//Components in panelEastCenter
		GridBagConstraints gbcPanelEastCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastCenter.insets = new Insets(10,20,10,20);//top, left, bottom, right
		
		btLegen = new JButton("Legen");
		btLegen.setPreferredSize(new Dimension(100,50));//width, height
		btLegen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						placecards();
						UpdateButtons();
					}
				}
		);
		btLegen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridx = 0;
		panelEastCenter.add(btLegen, gbcPanelEastCenter);
		
		
		btPassen = new JButton("Passen");
		btPassen.setPreferredSize(new Dimension(100,50));//width, height
		btPassen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						pass();
						UpdateButtons();
					}
				}
		);
		btPassen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridx = 1;
		panelEastCenter.add(btPassen, gbcPanelEastCenter);
		
		
		
		
		//panelEastSouth - chat
		panelEastSouth = new JPanel(new GridBagLayout());
		panelEastSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastSouth.setPreferredSize(new Dimension(300,480));//width, height
		panelEast.add(panelEastSouth, BorderLayout.SOUTH);
		
		//Components in panelEastSouth
		GridBagConstraints gbcPanelEastSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastSouth.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		lbChat = new JLabel("CHAT:");
		panelEastSouth.add(lbChat, gbcPanelEastSouth);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		try{
//			if(e.getSource() == btLegen){
//				this.out.writeObject("sfd");
//			}else if(e.getSource() == btPassen){
//				
//			}else if(e.getSource() == btReset){
//				
//			}
//		}catch (java.io.IOException IOException){
//			IOException.printStackTrace();
//		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		e.consume();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		e.consume();
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		e.consume();
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		e.consume();
	}


	@Override
	public void mouseExited(MouseEvent e) {
		e.consume();
	}
	
	// Methods
	
	// click on normal card
	public static void cardclick(int button) {
		// in case of button gets clicked again
		System.out.println("Input handcopy " + handcopy[button]);
		if ((newhand[button] != handcopy[button]) && newhand[button] >= 1) {
			newhand[button]--;
			System.out.println("click again " + newhand[button]);
		}
		// in case new button gets clicked
		else if ((newhand[button] == handcopy[button]) && newhand[button] >= 1) {
			System.arraycopy(handcopy,0,newhand,0,13);
			newhand[button]--;
			System.out.println("first click " + newhand[button]);
			System.out.println("handcopy " + handcopy[button]);
		}
		// in case of button gets clicked with 0 cards
		else if((newhand[button] == handcopy[button]) && newhand[button] == 0){
			System.arraycopy(handcopy,0,newhand,0,13);
		}
		// change display array
		display[0] = button;
		display[1] = handcopy[button] - newhand[button];
		System.out.println("Display!!! " + display[1]);

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
		display[0] = 0;
		display[1] = 0;
	}

	// place cards
	public void placecards() {
		Client.mo.activeusers.get(myRank).setHand(newhand);
		Client.mo.activeusers.get(myRank).calcamount();
		System.arraycopy(display,0,Client.mo.playedcards,0,2);
		playedcards();
		display[0] = 0;
		display[1] = 0;
		sendObject();
	}

	// pass round
	public static void pass() {
		System.arraycopy(handcopy,0,newhand,0,13);
		display[0] = 0;
		display[1] = 0;
		sendObject();
	}

	public static void main(String[] args) {

	}
	public static void UpdateButtons(){
		Login.playtable.btKarte1.setText(String.valueOf(newhand[1]));
		Login.playtable.btKarte2.setText(String.valueOf(newhand[2]));
		Login.playtable.btKarte3.setText(String.valueOf(newhand[3]));
		Login.playtable.btKarte4.setText(String.valueOf(newhand[4]));
		Login.playtable.btKarte5.setText(String.valueOf(newhand[5]));
		Login.playtable.btKarte6.setText(String.valueOf(newhand[6]));
		Login.playtable.btKarte7.setText(String.valueOf(newhand[7]));
		Login.playtable.btKarte8.setText(String.valueOf(newhand[8]));
		Login.playtable.btKarte9.setText(String.valueOf(newhand[9]));
		Login.playtable.btKarte10.setText(String.valueOf(newhand[10]));
		Login.playtable.btKarte11.setText(String.valueOf(newhand[11]));
		Login.playtable.btKarte12.setText(String.valueOf(newhand[12]));
		Login.playtable.btKarteNarr.setText(String.valueOf(newhand[0]));
		Login.playtable.btReset.setText(String.valueOf(display[1]));
	}
	public void Image(){
		if(display[0] == 13){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		}if(display[0] == 12){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		}if(display[0] == 11){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		}if(display[0] == 10){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		}if(display[0] == 9){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		}if(display[0] == 8){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		}if(display[0] == 7){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		}if(display[0] == 6){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		}if(display[0] == 5){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		}if(display[0] == 4){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		}if(display[0] == 3){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		}if(display[0] == 2){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		}if(display[0] == 1){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		}if(display[0] == 0){
			btReset.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		}
		
	}
	public void playedcards(){
		if(Client.mo.playedcards[0] == 13){
			lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/narrbig.jpg")));
		}if(Client.mo.playedcards[0] == 12){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte12big.jpg")));
		}if(Client.mo.playedcards[0] == 11){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte11big.jpg")));
		}if(Client.mo.playedcards[0] == 10){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte10big.jpg")));
		}if(Client.mo.playedcards[0] == 9){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte9big.jpg")));
		}if(Client.mo.playedcards[0] == 8){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte8big.jpg")));
		}if(Client.mo.playedcards[0] == 7){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte7big.jpg")));
		}if(Client.mo.playedcards[0] == 6){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte6big.jpg")));
		}if(Client.mo.playedcards[0] == 5){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte5big.jpg")));
		}if(Client.mo.playedcards[0] == 4){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte4big.jpg")));
		}if(Client.mo.playedcards[0] == 3){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte3big.jpg")));
		}if(Client.mo.playedcards[0] == 2){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte2big.jpg")));
		}if(Client.mo.playedcards[0] == 1){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/karte1big.jpg")));
		}if(Client.mo.playedcards[0] == 0){
			Login.playtable.lbCardsPlayed.setIcon(new ImageIcon(getClass().getResource("/dalmuti/image/backbig.jpg")));
		}
		
	}
	public static void sendObject(){
		try{
			Playtable.out.writeObject(Client.mo);
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

}
