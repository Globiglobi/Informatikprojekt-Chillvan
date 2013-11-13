/*
 * Copyright 2013 Cornflakes. Alle Rechte vorbehalten.
 * 
 * Autor: Bastian End
 * 
 * todo:
 * - background image
 * - spielfeld
 * - menu bar, braucht es settungs und view?
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

public class Spieltisch extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Spieltisch().setVisible(true);
	}

	public Spieltisch() {
		setTitle("Der Grosse Dalmuti - Spieltisch");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font f_button = new Font("", Font.BOLD, 16);
		
		JMenuBar bar = new JMenuBar();		
		JMenu settings = new JMenu("Settings");
		JMenu view = new JMenu("View");
		JMenu help = new JMenu("Help");
		JMenuItem spielregeln = new JMenuItem("Spielregeln");
		spielregeln.addActionListener(this);
		bar.add(settings);
		bar.add(view);	
		bar.add(help);
		help.add(spielregeln);
		setJMenuBar(bar);
		
		JPanel p1 = new JPanel();
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setPreferredSize(new Dimension(824,0));//width, height
		add(p1, BorderLayout.WEST);
		
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setPreferredSize(new Dimension(200,0));//width, height
		add(p2, BorderLayout.EAST);
		
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setPreferredSize(new Dimension(200,200));//width, height
		p2.add(p3, BorderLayout.NORTH);
		
		JPanel p4 = new JPanel(new GridBagLayout());
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setPreferredSize(new Dimension(200,200));//width, height
		p2.add(p4, BorderLayout.CENTER);
		
		JPanel p5 = new JPanel(new GridBagLayout());
		p5.setBorder(BorderFactory.createLineBorder(Color.black));
		p5.setPreferredSize(new Dimension(200,418));//width, height
		p2.add(p5, BorderLayout.SOUTH);
		
//		PANEL 1
		//WTF...
		JLabel l_wtf = new JLabel(new ImageIcon(getClass().getResource("bild.png")));
		p1.add(l_wtf);
		
//		PANEL 2
		//contains panel p3, p4, p5
		
//		PANEL 3
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		JLabel l_score = new JLabel("SCOREBOARD:");
		p3.add(l_score, gbc3);
		
//		PANEL 4
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.insets = new Insets(10,0,10,0);//top, left, bottom, right
		
		JButton b_legen = new JButton("Legen");
		b_legen.setPreferredSize(new Dimension(100,50));//width, height
		b_legen.setFont(f_button);
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		p4.add(b_legen, gbc4);
		
		JButton b_passen = new JButton("Passen");
		b_passen.setPreferredSize(new Dimension(100,50));//width, height
		b_passen.setFont(f_button);
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		p4.add(b_passen, gbc4);
		
//		PANEL 5
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		JLabel l_chat = new JLabel("CHAT:");
		p5.add(l_chat, gbc5);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Spielregeln")) {
			JOptionPane.showMessageDialog(null, "Spielregeln: \n 1. Mach dies und das! \n 2. Du sollst nicht!", "Spielregeln", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
