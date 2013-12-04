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
 *	Zeichen 	Unicode
 *	------------------------------
 *	€, Š 		\u00c4, \u00e4
 *	…, š 		\u00d6, \u00f6
 *	†, Ÿ 		\u00dc, \u00fc
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
import java.io.PrintWriter;

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
public class Login extends JFrame implements ActionListener{
	
	PrintWriter out;
	
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
	public Login(PrintWriter out){
		this.init();
		this.out = out;
	}
	
	public void init(){
		setTitle("Der Grosse Dalmuti - Login");
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

		
		
		
		//panelNorth - Titel
		panelNorth = new JPanel(new GridBagLayout());
//		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelNorth, BorderLayout.NORTH);
		
		//Components in panelNorth
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(100, 0, 0, 0);// top, left, bottom, right

		lbTitel = new JLabel("Der Grosse Dalmuti");
		lbTitel.setFont(new Font("", Font.BOLD, 78));
		panelNorth.add(lbTitel, gbcPanelNorth);

		
		
		
		//panelCenter - Login
		panelCenter = new JPanel(new GridBagLayout());
//		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelCenter, BorderLayout.CENTER);
		
		//Components in panelCenter
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
		btLogin.addActionListener(this);
		gbcPanelCenter.gridy = 2;
		panelCenter.add(btLogin, gbcPanelCenter);

		
		
		
		//panelSouth - Version + Copyright
		panelSouth = new JPanel(new GridBagLayout());
//		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelSouth, BorderLayout.SOUTH);
		
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
		gbcPanelSouth.insets = new Insets(0, 120, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap5, gbcPanelSouth);

		lbCopyright = new JLabel("Copyright 2013 Cornflakes. Alle Rechte vorbehalten.");
		gbcPanelSouth.insets = new Insets(0, 0, 10, 0);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbCopyright, gbcPanelSouth);

		lbGap6 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 120, 10, 55);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap6, gbcPanelSouth);

		lbGap7 = new JLabel("");
		gbcPanelSouth.insets = new Insets(0, 65, 10, 110);// top, left, bottom, right
		gbcPanelSouth.gridy = 1;
		panelSouth.add(lbGap7, gbcPanelSouth);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.out.println(tfEnterNickname.getText());
		tfEnterNickname.setText("");		
	}
}
