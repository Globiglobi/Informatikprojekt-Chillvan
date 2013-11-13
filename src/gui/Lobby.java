/*
 * Copyright 2013 Cornflakes. Alle Rechte vorbehalten.
 * 
 * Autor: Bastian End
 * 
 * todo:
 * - background image
 * - spieltisch button machen
 * - menu bar, braucht es settungs und view?
 * 
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Lobby extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea ta_messages;
	private JTextField tf_write;
	private JButton b_send;
	private JScrollPane scroll;

	public static void main(String[] args) {
		new Lobby().setVisible(true);
//		new Server().setVisible(true);
	}
	
	public Lobby() {
		setTitle("Der Grosse Dalmuti - Lobby");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font f_select_table = new Font("", Font.PLAIN, 18);
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
		
		JPanel p1 = new JPanel(new GridBagLayout());
//		p1.setBackground(Color.white);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel(new GridBagLayout());
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setPreferredSize(new Dimension(340,668));//width, height
		add(p2, BorderLayout.WEST);
		
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setPreferredSize(new Dimension(340,668));//width, height
		add(p3, BorderLayout.CENTER);
		
		JPanel p4 = new JPanel();
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setPreferredSize(new Dimension(342,668));//width, height
		p4.setBackground(Color.white);
		add(p4, BorderLayout.EAST);
		
//		Panel_1
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(25,0,25,25);//top, left, bottom, right
		
		JLabel l_titel = new JLabel("WŠhle einen Spieltisch aus an dem du spielen mšchtest und klicke auf");
		l_titel.setFont(f_select_table);
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		p1.add(l_titel, gbc1);
		
		JButton b_login = new JButton("Spielen");
		b_login.setPreferredSize(new Dimension(100,50));//width, height
		b_login.setFont(f_button);
		b_login.addActionListener(this);
		b_login.setActionCommand("Login");
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		p1.add(b_login, gbc1);	

		/* 		FIRST_LINE_START	PAGE_START		FIRST_LINE_END
		 *		LINE_START			CENTER			LINE_END
		 *		LAST_LINE_START		PAGE_END		LAST_LINE_END		
		 */		
		
//		Panel_2
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.insets = new Insets(0,0,0,0);//top, left, bottom, right
		
		JLabel l_tisch = new JLabel("Tisch 1");
		gbc2.anchor = GridBagConstraints.LINE_START;
		p2.add(l_tisch);
		
//		Panel_3
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.insets = new Insets(0,0,0,0);//top, left, bottom, right
		
		JLabel l_playeranzahl = new JLabel("Spieler 4/4");
		gbc3.anchor = GridBagConstraints.LINE_START;
		p3.add(l_playeranzahl);
		
//		Panel_4
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.insets = new Insets(0,0,10,0);//top, left, bottom, right
		
		ta_messages = new JTextArea();
		ta_messages.setEnabled(false);
//		ta_messages.setPreferredSize(new Dimension(300, 600));
//		ta_messages.setBorder(BorderFactory.createEtchedBorder());
		scroll = new JScrollPane(ta_messages);
		scroll.setPreferredSize(new Dimension(300,600));
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		p4.add(scroll, gbc4);
		
		tf_write = new JTextField();
		tf_write.setPreferredSize(new Dimension(225, 30));
		Action sendMessage = new AbstractAction() {
			@Override
		    public void actionPerformed(ActionEvent e) {
		        sendMessage();
		        tf_write.setText(null);
		    }
		};
		tf_write.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), sendMessage);
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		p4.add(tf_write, gbc4);
		
		b_send = new JButton("Send");
		b_send.addActionListener(this);
		b_send.setActionCommand("Send");
		gbc4.gridx = 1;
		gbc4.gridy = 1;
		p4.add(b_send, gbc4);
		
		setVisible(true);
	}
	
	private void sendMessage() {
		try {
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket s = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

			// Send the message from the text box
			w.write(tf_write.getText() + "\n");
			w.flush();

			// Read and display the reply
			String msgIn = r.readLine();
			ta_messages.setText(ta_messages.getText() + "\n" + msgIn);

			// Clean up
			r.close();
			w.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Spielregeln")) {
			JOptionPane.showMessageDialog(null, "Spielregeln: \n 1. Mach dies und das! \n 2. Du sollst nicht!", "Spielregeln", JOptionPane.PLAIN_MESSAGE);
		}
		else if (name.equals("Login")) {
			dispose();
			new Spieltisch();
		}
		else if (name.equals("Send")) {
			sendMessage();
			tf_write.setText(null);
		}
	}

}
