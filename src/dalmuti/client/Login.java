/*
 * Copyright 2013 Cornflakes. Alle Rechte vorbehalten.
 * 
 * @author Bastian End
 * 
 * todo:
 * - background image
 * - animated background, Karten bewegen sich gegeneinander
 * - nickname auf 16 Zeichen begrenzen
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame{
	
	//GUI-Globals menuBar
	private JMenuBar menuBar;
	private JMenu help;
	private JMenuItem spielregeln;
	private JMenuItem about;
	
	
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
	private JLabel lbgap1;
	private JLabel lbgap2;
	private JLabel lblogo;
	private JLabel lbgap3;
	private JLabel lbgap4;
	private JLabel lbversion;
	private JLabel lbgap5;
	private JLabel lbcopyright;
	private JLabel lbgap6;
	private JLabel lbgap7;
	
	
	public static void main(String[] args){
		new Login().setVisible(true);
	}
	

	//Constructor
	public Login(){
		super("Der Grosse Dalmuti - Login");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		
		
		//Set up MenuBar
		menuBar = new JMenuBar();
		help = new JMenu("Help");
		spielregeln = new JMenuItem("Spielregeln");
		spielregeln.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(null, 
								"1. Mach dies und das!\n"
								+ "2. Du sollst nicht!\n"
								+ "3. Ziel des Spiel ist es... noch ein bisschen Text um das Fenster gršsser zu machen^^", "Spielregeln - Der Grosse Dalmuti", JOptionPane.PLAIN_MESSAGE);
					}
				}
		);
		about = new JMenuItem("About");
		about.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(null,
								"Der Grosse Dalmuti for insane fun\n\n"
								+ "Copyright (c) Cornflakes. All rights are reserved.\n\n"
								+ "...noch ein bisschen Text um das Fenster gršsser zu machen^^ reicht doch noch net ganz xD", "About - Der Grosse Dalmuti", JOptionPane.PLAIN_MESSAGE);
					}
				}
		);
		menuBar.add(help);
		help.add(spielregeln);
		help.add(about);
		setJMenuBar(menuBar);

		
		
		
		//PanelNorth
		panelNorth = new JPanel(new GridBagLayout());
//		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelNorth, BorderLayout.NORTH);
		
		//Components in PanelNorth
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(100, 0, 0, 0);// top, left, bottom, right

		lbTitel = new JLabel("Der Grosse Dalmuti");
		lbTitel.setFont(new Font("", Font.BOLD, 78));
		panelNorth.add(lbTitel, gbcPanelNorth);

		
		
		
		//PanelCenter
		panelCenter = new JPanel(new GridBagLayout());
//		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelCenter, BorderLayout.CENTER);
		
		//Components in PanelCenter
		GridBagConstraints gbcPanelCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelCenter.insets = new Insets(10, 0, 10, 0);// top, left, bottom, right

		lbEnterNickname = new JLabel("Gib hier deinen Nickname ein! (maximal 16 Zeichen)");
		lbEnterNickname.setFont(new Font("", Font.PLAIN, 18));
		gbcPanelCenter.gridy = 0;
		panelCenter.add(lbEnterNickname);

		tfEnterNickname = new JTextField("Nickname");
		tfEnterNickname.setPreferredSize(new Dimension(460, 30));
		tfEnterNickname.setFont(new Font("", Font.PLAIN, 18));
		tfEnterNickname.setHorizontalAlignment(JLabel.CENTER);
		gbcPanelCenter.gridy = 1;
		panelCenter.add(tfEnterNickname, gbcPanelCenter);

		btLogin = new JButton("Login");
		btLogin.setPreferredSize(new Dimension(100, 50));// width, height
		btLogin.setFont(new Font("", Font.BOLD, 16));
		btLogin.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						// create UserObject
					}
				}
		);
		gbcPanelCenter.gridy = 2;
		panelCenter.add(btLogin, gbcPanelCenter);

		
		
		
		//PanelSouth
		panelSouth = new JPanel(new GridBagLayout());
//		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelSouth, BorderLayout.SOUTH);
		
		//Components in PanelSouth
		GridBagConstraints gbcPanelSouth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right

		/* Information about the GridBagConstraints - Anchor
		 * 
		 * FIRST_LINE_START		PAGE_START		FIRST_LINE_END 
		 * LINE_START			CENTER			LINE_END
		 * LAST_LINE_START		PAGE_END		LAST_LINE_END
		 */

		//Components on gridLevel Y=0
		lbgap1 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbgap1, gbcPanelSouth);

		lbgap2 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbgap2, gbcPanelSouth);

		lblogo = new JLabel(new ImageIcon(getClass().getResource("logo_trans.png")));
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lblogo, gbcPanelSouth);

		lbgap3 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbgap3, gbcPanelSouth);

		lbgap4 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, -10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 0;
		panelSouth.add(lbgap4, gbcPanelSouth);

		//Components on gridLevel Y=1
		lbversion = new JLabel("");
		lbversion.setText("<html><body>Version 1.0.0<br>6. November 2013</body></html>");
		gbcPanelSouth.anchor = GridBagConstraints.FIRST_LINE_START;
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbversion, gbcPanelSouth);

		lbgap5 = new JLabel("");
		gbcPanelSouth.anchor = GridBagConstraints.LAST_LINE_START;
		gbcPanelSouth.insets = new Insets(0, 110, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbgap5, gbcPanelSouth);

		lbcopyright = new JLabel("Copyright 2013 Cornflakes. Alle Rechte vorbehalten.");
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbcopyright, gbcPanelSouth);

		lbgap6 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 110, 10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbgap6, gbcPanelSouth);

		lbgap7 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 55, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbgap7, gbcPanelSouth);
	}
}
