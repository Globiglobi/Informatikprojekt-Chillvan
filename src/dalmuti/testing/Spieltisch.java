/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End
 * 
 * todo:
 * - background image
 * - Spielfläche!
 * - Scoreboard!
 * - Chat
 * - btLegen 
 * - btPassen
 * - alles auf englisch
 * 
 * 
 *  Zeichen 	Unicode
 *	------------------------------
 *	Ä, ä 		\u00c4, \u00e4
 *	Ö, ö 		\u00d6, \u00f6
 *	Ü, ü 		\u00dc, \u00fc
 *
 */

package dalmuti.testing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

@SuppressWarnings("serial")
public class Spieltisch extends JFrame{
	
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
	private JButton btNarr;
	private JLabel lbAmount;
	private JButton btReset;
	
	private int valueKarte1 = 0;
	private int valueKarte2 = 0;
	private int valueKarte3 = 0;
	private int valueKarte4 = 0;
	private int valueKarte5 = 0;
	private int valueKarte6 = 0;
	private int valueKarte7 = 0;
	private int valueKarte8 = 0;
	private int valueKarte9 = 0;
	private int valueKarte10 = 0;
	private int valueKarte11 = 0;
	private int valueKarte12 = 0;
	private int valueKarteNarr = 0;
	
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
		

	//only for testing purpose
	public static void main(String[] args) {
		new Spieltisch().setVisible(true);
	}

	
	public Spieltisch(){
		super("Der Grosse Dalmuti - Spieltisch");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Set up MenuBar
		menuBar = new JMenuBar();
		help = new JMenu("Help");
		spielregeln = new JMenuItem("Spielregeln");
		spielregeln.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(null, 
								"1. Mach dies und das!\n"
								+ "2. Du sollst nicht!\n"
								+ "3. Ziel des Spiel ist es... noch ein bisschen Text um das Fenster gr\u00f6sser zu machen^^", "Spielregeln - Der Grosse Dalmuti", JOptionPane.PLAIN_MESSAGE);
					}
				}
		);
		about = new JMenuItem("About");
		about.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(null,
								"Der Grosse Dalmuti for insane fun\n\n"
								+ "Copyright (c) Cornflakes. All rights are reserved.\n\n"
								+ "...noch ein bisschen Text um das Fenster gr\u00f6sser zu machen^^ reicht doch noch net ganz xD", "About - Der Grosse Dalmuti", JOptionPane.PLAIN_MESSAGE);
					}
				}
		);
		menuBar.add(help);
		help.add(spielregeln);
		help.add(about);
		setJMenuBar(menuBar);

		
		
		
		//panelWest
		panelWest = new JPanel();
//		panelWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWest.setPreferredSize(new Dimension(700,768));//width, height
		add(panelWest, BorderLayout.WEST);
		
		//Components in panelWest
		//this panel contains panelWestNorth, panelWestWest, panelWestCenter, panelWestEast, panelWestSouth
		
		
		
		//panelWestNorth - gegner oben
		panelWestNorth = new JPanel(new GridBagLayout());
		panelWestNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestNorth.setPreferredSize(new Dimension(700,50));//width, height
		panelWest.add(panelWestNorth, BorderLayout.NORTH);
		
		//Components in panelWestNorth
		GridBagConstraints gbcPanelWestNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestNorth.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftNorth = new JLabel("Dieser Spieler hat noch 5 Karten");
		panelWestNorth.add(lbCardsLeftNorth, gbcPanelWestNorth);
		
		
		
		
		//panelWestWest - gegner links
		panelWestWest = new JPanel(new GridBagLayout());
		panelWestWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestWest.setPreferredSize(new Dimension(192,400));//width, height
		panelWest.add(panelWestWest, BorderLayout.WEST);
		
		//Components in panelWestWest
		GridBagConstraints gbcPanelWestWest = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestWest.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftWest = new JLabel("Dieser Spieler hat noch 5 Karten");
		panelWestWest.add(lbCardsLeftWest, gbcPanelWestWest);
		
		
		
		
		//panelWestCenter - gespielte karten
		panelWestCenter = new JPanel(new GridBagLayout());
		panelWestCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestCenter.setPreferredSize(new Dimension(300,400));//width, height
		panelWest.add(panelWestCenter, BorderLayout.CENTER);
		
		//Components in panelWestCenter
		GridBagConstraints gbcPanelWestCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestCenter.insets = new Insets(5,30,5,30);//top, left, bottom, right
				
		lbCardsPlayed = new JLabel(new ImageIcon(getClass().getResource("karte1big.jpg")));
		gbcPanelWestCenter.gridx = 0;
		gbcPanelWestCenter.gridy = 0;
		panelWestCenter.add(lbCardsPlayed, gbcPanelWestCenter);
		
		lbAmountCardsPlayed = new JLabel("Diese Karte wurde 1 Mal gespielt");
		gbcPanelWestCenter.gridx = 0;
		gbcPanelWestCenter.gridy = 1;
		panelWestCenter.add(lbAmountCardsPlayed, gbcPanelWestCenter);
		
		
		
		
		//panelWestEast - gegner rechts
		panelWestEast = new JPanel(new GridBagLayout());
		panelWestEast.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestEast.setPreferredSize(new Dimension(192,400));//width, height
		panelWest.add(panelWestEast, BorderLayout.EAST);
		
		//Components in panelWestEast
		GridBagConstraints gbcPanelWestEast = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestEast.insets = new Insets(30,30,30,30);//top, left, bottom, right
				
		lbCardsLeftEast = new JLabel("Dieser Spieler hat noch 5 Karten");
		panelWestEast.add(lbCardsLeftEast, gbcPanelWestEast);
		
		
		
		
		//panelWestSouth - deine karten
		panelWestSouth = new JPanel(new GridBagLayout());
		panelWestSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestSouth.setPreferredSize(new Dimension(700,300));//width, height
		panelWest.add(panelWestSouth, BorderLayout.SOUTH);
		
		//Components in panelWestNorth
		GridBagConstraints gbcPanelWestSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestSouth.insets = new Insets(0,0,0,0);//top, left, bottom, right
				
		btKarte1 = new JButton(String.valueOf(valueKarte1), new ImageIcon(getClass().getResource("karte1.jpg")));
		btKarte1.setPreferredSize(new Dimension(97,150));//width, height
		btKarte1.setContentAreaFilled(false);
//		btKarte1.setBorderPainted(false);
//		btKarte1.setFocusPainted(false);
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte1, gbcPanelWestSouth);
		
		btKarte2 = new JButton(String.valueOf(valueKarte2), new ImageIcon(getClass().getResource("karte2.jpg")));
		btKarte2.setPreferredSize(new Dimension(97,150));//width, height
		btKarte2.setContentAreaFilled(false);
//		btKarte2.setBorderPainted(false);
//		btKarte2.setFocusPainted(false);
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte2, gbcPanelWestSouth);
		
		btKarte3 = new JButton(String.valueOf(valueKarte3), new ImageIcon(getClass().getResource("karte3.jpg")));
		btKarte3.setPreferredSize(new Dimension(97,150));//width, height
		btKarte3.setContentAreaFilled(false);
//		btKarte3.setBorderPainted(false);
//		btKarte3.setFocusPainted(false);
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte3, gbcPanelWestSouth);
		
		btKarte4 = new JButton(new ImageIcon(getClass().getResource("karte4.jpg")));
		btKarte4.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte4, gbcPanelWestSouth);
		
		btKarte5 = new JButton(new ImageIcon(getClass().getResource("karte5.jpg")));
		btKarte5.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte5, gbcPanelWestSouth);
		
		btKarte6 = new JButton(new ImageIcon(getClass().getResource("karte6.jpg")));
		btKarte6.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte6, gbcPanelWestSouth);
		
		btKarte7 = new JButton(new ImageIcon(getClass().getResource("karte7.jpg")));
		btKarte7.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte7, gbcPanelWestSouth);
		
		btKarte8 = new JButton(new ImageIcon(getClass().getResource("karte8.jpg")));
		btKarte8.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte8, gbcPanelWestSouth);
		
		btKarte9 = new JButton(new ImageIcon(getClass().getResource("karte9.jpg")));
		btKarte9.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte9, gbcPanelWestSouth);
		
		btKarte10 = new JButton(new ImageIcon(getClass().getResource("karte10.jpg")));
		btKarte10.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte10, gbcPanelWestSouth);
		
		btKarte11 = new JButton(new ImageIcon(getClass().getResource("karte11.jpg")));
		btKarte11.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte11, gbcPanelWestSouth);
		
		btKarte12 = new JButton(new ImageIcon(getClass().getResource("karte12.jpg")));
		btKarte12.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte12, gbcPanelWestSouth);
		
		btNarr = new JButton(new ImageIcon(getClass().getResource("narr.jpg")));
		btNarr.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btNarr, gbcPanelWestSouth);

		//panleControl - Reset Button
		panelControl = new JPanel(new GridBagLayout());
		panelControl.setBorder(BorderFactory.createLineBorder(Color.black));
		panelControl.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(panelControl, gbcPanelWestSouth);
		
		GridBagConstraints gbcPanelControl = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelControl.insets = new Insets(0,15,10,15);//top, left, bottom, right
		
		lbAmount = new JLabel("1");
		lbAmount.setFont(new Font("", Font.BOLD, 72));
		gbcPanelControl.gridx = 0;
		gbcPanelControl.gridy = 0;
		panelControl.add(lbAmount, gbcPanelControl);
		
		btReset = new JButton("Reset");
		btReset.setPreferredSize(new Dimension(90,20));//width, height
		btReset.setFont(new Font("", Font.PLAIN, 12));
		gbcPanelControl.gridx = 0;
		gbcPanelControl.gridy = 1;
		panelControl.add(btReset, gbcPanelControl);
		

		
		
		//panelEast
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
		btLegen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridx = 0;
		panelEastCenter.add(btLegen, gbcPanelEastCenter);
		
		btPassen = new JButton("Passen");
		btPassen.setPreferredSize(new Dimension(100,50));//width, height
		btPassen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridx = 1;
		panelEastCenter.add(btPassen, gbcPanelEastCenter);
		
		
		
		
		//panelEastSouth - chat
		panelEastSouth = new JPanel(new GridBagLayout());
		panelEastSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastSouth.setPreferredSize(new Dimension(300,450));//width, height
		panelEast.add(panelEastSouth, BorderLayout.SOUTH);
		
		//Components in panelEastSouth
		GridBagConstraints gbcPanelEastSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastSouth.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		lbChat = new JLabel("CHAT:");
		panelEastSouth.add(lbChat, gbcPanelEastSouth);
	}
}
