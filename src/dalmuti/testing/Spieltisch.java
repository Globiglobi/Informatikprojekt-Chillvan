/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End
 * 
 * todo:
 * - background image
 * - Spielfl�che!
 * - Scoreboard!
 * - Chat
 * - btLegen 
 * - btPassen
 * - alles auf englisch
 * 
 * 
 *  Zeichen 	Unicode
 *	------------------------------
 *	�, � 		\u00c4, \u00e4
 *	�, � 		\u00d6, \u00f6
 *	�, � 		\u00dc, \u00fc
 *
 */

package dalmuti.testing;
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

@SuppressWarnings("serial")
public class Spieltisch extends JFrame implements ActionListener{
	
	ObjectOutputStream out;
	ObjectInputStream in;
	
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
	
	private static int cardAmount = 0;
	private static int resetAmount = 0;
	private int amountKarte1 = 1;
	private boolean useKarte1 = false;
	private int amountKarte2 = 2;
	private boolean useKarte2 = false;
	private int amountKarte3 = 3;
	private boolean useKarte3 = false;
	private int amountKarte4 = 0;
	private int amountKarte5 = 0;
	private int amountKarte6 = 0;
	private int amountKarte7 = 0;
	private int amountKarte8 = 0;
	private int amountKarte9 = 0;
	private int amountKarte10 = 0;
	private int amountKarte11 = 0;
	private int amountKarte12 = 0;
	private int amountKarteNarr = 0;
	
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
		setTitle("Der Grosse Dalmuti - Spieltisch");
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
				
		lbCardsPlayed = new JLabel(new ImageIcon(getClass().getResource("/dalmuti/image/karte1big.jpg")));
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
		panelWestSouth = new JPanel(new GridLayout(2, 7));
		panelWestSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWestSouth.setPreferredSize(new Dimension(700,300));//width, height
		panelWest.add(panelWestSouth, BorderLayout.SOUTH);
		
		//Components in panelWestNorth
		GridBagConstraints gbcPanelWestSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWestSouth.insets = new Insets(0,0,0,0);//top, left, bottom, right
				
		btKarte1 = new JButton(String.valueOf(amountKarte1), new ImageIcon(getClass().getResource("/dalmuti/image/karte1.jpg")));
		btKarte1.setHorizontalTextPosition(JButton.CENTER);
		btKarte1.setVerticalTextPosition(JButton.CENTER);
		btKarte1.setFont(new Font("", Font.BOLD, 72));
		btKarte1.setPreferredSize(new Dimension(97,150));//width, height
		btKarte1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//Sobald auf eine andere Karte geklickt wurde soll amountKarteX resetet werden!
						if(useKarte1 == false){
							resetAmount = amountKarte1;
						}
						useKarte1 = true;
						if(amountKarte1 != 0){
							if(useKarte1 == true && useKarte2 == false && useKarte3 == false){
								cardAmount++;
								amountKarte1--;
								btReset.setText(String.valueOf(cardAmount));
								btKarte1.setText(String.valueOf(amountKarte1));
							}else{
								
							}

						}
					}
				}
		);
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte1, gbcPanelWestSouth);
		
		btKarte2 = new JButton(String.valueOf(amountKarte2), new ImageIcon(getClass().getResource("/dalmuti/image/karte2.jpg")));
		btKarte2.setHorizontalTextPosition(JButton.CENTER);
		btKarte2.setVerticalTextPosition(JButton.CENTER);
		btKarte2.setFont(new Font("", Font.BOLD, 72));
		btKarte2.setPreferredSize(new Dimension(97,150));//width, height
		btKarte2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//Sobald auf eine andere Karte geklickt wurde soll amountKarteX resetet werden!
						useKarte2 = true;
						if(amountKarte2 != 0){
							if(useKarte1 == false && useKarte2 == true && useKarte3 == false){
								cardAmount++;
								amountKarte2--;
								btReset.setText(String.valueOf(cardAmount));
								btKarte2.setText(String.valueOf(amountKarte2));
							}else{
								
							}
						}
					}
				}
		);
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte2, gbcPanelWestSouth);
		
		btKarte3 = new JButton(String.valueOf(amountKarte3), new ImageIcon(getClass().getResource("/dalmuti/image/karte3.jpg")));
		btKarte3.setHorizontalTextPosition(JButton.CENTER);
		btKarte3.setVerticalTextPosition(JButton.CENTER);
		btKarte3.setFont(new Font("", Font.BOLD, 72));
		btKarte3.setPreferredSize(new Dimension(97,150));//width, height
		btKarte3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//Sobald auf eine andere Karte geklickt wurde soll amountKarteX resetet werden!
						if(amountKarte3 != 0 && cardAmount != 0){
							cardAmount++;
							amountKarte3--;
							btReset.setText(String.valueOf(cardAmount));
							btKarte3.setText(String.valueOf(amountKarte3));
						}
					}
				}
		);
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte3, gbcPanelWestSouth);
		
		btKarte4 = new JButton(String.valueOf(amountKarte4), new ImageIcon(getClass().getResource("/dalmuti/image/karte4.jpg")));
		btKarte4.setHorizontalTextPosition(JButton.CENTER);
		btKarte4.setVerticalTextPosition(JButton.CENTER);
		btKarte4.setFont(new Font("", Font.BOLD, 72));
		btKarte4.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte4, gbcPanelWestSouth);
		
		btKarte5 = new JButton(String.valueOf(amountKarte5), new ImageIcon(getClass().getResource("/dalmuti/image/karte5.jpg")));
		btKarte5.setHorizontalTextPosition(JButton.CENTER);
		btKarte5.setVerticalTextPosition(JButton.CENTER);
		btKarte5.setFont(new Font("", Font.BOLD, 72));
		btKarte5.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte5, gbcPanelWestSouth);
		
		btKarte6 = new JButton(String.valueOf(amountKarte6), new ImageIcon(getClass().getResource("/dalmuti/image/karte6.jpg")));
		btKarte6.setHorizontalTextPosition(JButton.CENTER);
		btKarte6.setVerticalTextPosition(JButton.CENTER);
		btKarte6.setFont(new Font("", Font.BOLD, 72));
		btKarte6.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte6, gbcPanelWestSouth);
		
		btKarte7 = new JButton(String.valueOf(amountKarte7), new ImageIcon(getClass().getResource("/dalmuti/image/karte7.jpg")));
		btKarte7.setHorizontalTextPosition(JButton.CENTER);
		btKarte7.setVerticalTextPosition(JButton.CENTER);
		btKarte7.setFont(new Font("", Font.BOLD, 72));
		btKarte7.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 0;
		panelWestSouth.add(btKarte7, gbcPanelWestSouth);
		
		btKarte8 = new JButton(String.valueOf(amountKarte8), new ImageIcon(getClass().getResource("/dalmuti/image/karte8.jpg")));
		btKarte8.setHorizontalTextPosition(JButton.CENTER);
		btKarte8.setVerticalTextPosition(JButton.CENTER);
		btKarte8.setFont(new Font("", Font.BOLD, 72));
		btKarte8.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 0;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte8, gbcPanelWestSouth);
		
		btKarte9 = new JButton(String.valueOf(amountKarte9), new ImageIcon(getClass().getResource("/dalmuti/image/karte9.jpg")));
		btKarte9.setHorizontalTextPosition(JButton.CENTER);
		btKarte9.setVerticalTextPosition(JButton.CENTER);
		btKarte9.setFont(new Font("", Font.BOLD, 72));
		btKarte9.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 1;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte9, gbcPanelWestSouth);
		
		btKarte10 = new JButton(String.valueOf(amountKarte10), new ImageIcon(getClass().getResource("/dalmuti/image/karte10.jpg")));
		btKarte10.setHorizontalTextPosition(JButton.CENTER);
		btKarte10.setVerticalTextPosition(JButton.CENTER);
		btKarte10.setFont(new Font("", Font.BOLD, 72));
		btKarte10.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 2;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte10, gbcPanelWestSouth);
		
		btKarte11 = new JButton(String.valueOf(amountKarte11), new ImageIcon(getClass().getResource("/dalmuti/image/karte11.jpg")));
		btKarte11.setHorizontalTextPosition(JButton.CENTER);
		btKarte11.setVerticalTextPosition(JButton.CENTER);
		btKarte11.setFont(new Font("", Font.BOLD, 72));
		btKarte11.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 3;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte11, gbcPanelWestSouth);
		
		btKarte12 = new JButton(String.valueOf(amountKarte12), new ImageIcon(getClass().getResource("/dalmuti/image/karte12.jpg")));
		btKarte12.setHorizontalTextPosition(JButton.CENTER);
		btKarte12.setVerticalTextPosition(JButton.CENTER);
		btKarte12.setFont(new Font("", Font.BOLD, 72));
		btKarte12.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 4;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarte12, gbcPanelWestSouth);
		
		btKarteNarr = new JButton(String.valueOf(amountKarteNarr), new ImageIcon(getClass().getResource("/dalmuti/image/narr.jpg")));
		btKarteNarr.setHorizontalTextPosition(JButton.CENTER);
		btKarteNarr.setVerticalTextPosition(JButton.CENTER);
		btKarteNarr.setFont(new Font("", Font.BOLD, 72));
		btKarteNarr.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 5;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btKarteNarr, gbcPanelWestSouth);
		
		//ResetButton nicht fertig!
		btReset = new JButton("0", new ImageIcon(getClass().getResource("/dalmuti/image/back.jpg")));
		btReset.setHorizontalTextPosition(JButton.CENTER);
		btReset.setVerticalTextPosition(JButton.CENTER);
		btReset.setFont(new Font("", Font.BOLD, 72));
		btReset.setPreferredSize(new Dimension(97,150));//width, height
		btReset.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//Sobald auf eine andere Karte geklickt wurde, soll amountKarteX resetet werden!

					}
				}
		);
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(btReset, gbcPanelWestSouth);

		
/*		
		//panelControl - Reset Button
		panelControl = new JPanel(new GridBagLayout());
		panelControl.setBorder(BorderFactory.createLineBorder(Color.black));
		panelControl.setPreferredSize(new Dimension(97,150));//width, height
		gbcPanelWestSouth.gridx = 6;
		gbcPanelWestSouth.gridy = 1;
		panelWestSouth.add(panelControl, gbcPanelWestSouth);
		
		GridBagConstraints gbcPanelControl = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelControl.insets = new Insets(25,0,0,0);//top, left, bottom, right
		
		lbAmount = new JLabel("0");
		lbAmount.setFont(new Font("", Font.BOLD, 72));
		gbcPanelControl.gridx = 0;
		gbcPanelControl.gridy = 0;
		panelControl.add(lbAmount, gbcPanelControl);
		
		btReset = new JButton("Reset");
		btReset.setPreferredSize(new Dimension(90,20));//width, height
		btReset.setFont(new Font("", Font.PLAIN, 12));
		btReset.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						cardAmount = 0;
						lbAmount.setText(String.valueOf(cardAmount));
						//reset also the amountKarteX!
					}
				}
		);
		gbcPanelControl.insets = new Insets(0,5,1,5);//top, left, bottom, right
		gbcPanelControl.gridx = 0;
		gbcPanelControl.gridy = 1;
		panelControl.add(btReset, gbcPanelControl);
*/

		
		
		
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
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource() == btLegen){
				this.out.writeObject("sfd");
			}else if(e.getSource() == btPassen){
				
			}else if(e.getSource() == btReset){
				
			}
		}catch (java.io.IOException IOException){
			IOException.printStackTrace();
		}
	}
}
