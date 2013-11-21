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

package dalmuti.client;
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
		panelWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWest.setPreferredSize(new Dimension(824,0));//width, height
		add(panelWest, BorderLayout.WEST);
		
		//Components in panelWest
		//empty
		
		
		
		
		//panelEast
		panelEast = new JPanel();
		panelEast.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEast.setPreferredSize(new Dimension(200,0));//width, height
		add(panelEast, BorderLayout.EAST);
		
		//Components in panelEast
		//this panel contains panelEastNorth, panelEastCenter, panelEastSouth
		
		
		
		
		//panelEastNorth
		panelEastNorth = new JPanel(new GridBagLayout());
		panelEastNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastNorth.setPreferredSize(new Dimension(200,200));//width, height
		panelEast.add(panelEastNorth, BorderLayout.NORTH);
		
		//Components in panelEastNorth
		GridBagConstraints gbcPanelEastNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastNorth.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		lbScore = new JLabel("SCOREBOARD:");
		panelEastNorth.add(lbScore, gbcPanelEastNorth);
		

		
		
		//panelEastCenter
		panelEastCenter = new JPanel(new GridBagLayout());
		panelEastCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastCenter.setPreferredSize(new Dimension(200,200));//width, height
		panelEast.add(panelEastCenter, BorderLayout.CENTER);
		
		//Components in panelEastCenter
		GridBagConstraints gbcPanelEastCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastCenter.insets = new Insets(10,0,10,0);//top, left, bottom, right
		
		btLegen = new JButton("Legen");
		btLegen.setPreferredSize(new Dimension(100,50));//width, height
		btLegen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridy = 0;
		panelEastCenter.add(btLegen, gbcPanelEastCenter);
		
		btPassen = new JButton("Passen");
		btPassen.setPreferredSize(new Dimension(100,50));//width, height
		btPassen.setFont(new Font("", Font.BOLD, 16));
		gbcPanelEastCenter.gridy = 1;
		panelEastCenter.add(btPassen, gbcPanelEastCenter);
		
		
		
		
		//panelEastSouth
		panelEastSouth = new JPanel(new GridBagLayout());
		panelEastSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEastSouth.setPreferredSize(new Dimension(200,418));//width, height
		panelEast.add(panelEastSouth, BorderLayout.SOUTH);
		
		//Components in panelEastSouth
		GridBagConstraints gbcPanelEastSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEastSouth.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		lbChat = new JLabel("CHAT:");
		panelEastSouth.add(lbChat, gbcPanelEastSouth);
	}
}
