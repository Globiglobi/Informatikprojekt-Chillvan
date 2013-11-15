/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Bastian End
 * 
 * todo:
 * - background image
 * - btSpielen soll GUISpieltisch šffnen
 * - Spieltische anzeigen
 * - CurrentUsers anzeigen
 * - Multi-Chat implementieren
 * - alles auf englisch
 * 
 * 
 * 	Zeichen 	Unicode
 *	------------------------------
 *	€, Š 		\u00c4, \u00e4
 *	…, š 		\u00d6, \u00f6
 *	†, Ÿ 		\u00dc, \u00fc
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

@SuppressWarnings("serial")
public class Lobby extends JFrame{

	//GUI-Globals menuBar
	private JMenuBar menuBar;
	private JMenu help;
	private JMenuItem spielregeln;
	private JMenuItem about;
	
	
	//GUI-Globals panelNorth
	private JPanel panelNorth;
	private JLabel lbTitel;
	private JButton btSpielen;
	
	
	//GUI-Globals panelWest
	private JPanel panelWest;
	private JLabel lbSpieltisch;
	
	
	//GUI_Globals panelCenter
	private JPanel panelCenter;
	private JLabel lbCurrentUser;
	
	
	//GUI_Globals panelEast
	private JPanel panelEast;
	private JTextArea taConversation;
	private JScrollPane spScroll;
	private JTextField tfMessage;
	private JButton btSend;
	
	
	public static void main(String[] args){
		new Lobby().setVisible(true);
	}
	
	
	//Constructor
	public Lobby(){
		super("Der Grosse Dalmuti - Lobby");
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
		
		
		
		
		//panelNorth
		panelNorth = new JPanel(new GridBagLayout());
//		panelNorth.setBackground(Color.white);
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panelNorth, BorderLayout.NORTH);
		
		//Components in panelNorth
		GridBagConstraints gbcPanelNorth = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelNorth.insets = new Insets(25,0,25,25);//top, left, bottom, right
		
		lbTitel = new JLabel("W\u00e4hle einen Spieltisch aus an dem du spielen m\u00f6chtest und klicke auf");
		lbTitel.setFont(new Font("", Font.PLAIN, 18));
		gbcPanelNorth.gridx = 0;
		panelNorth.add(lbTitel, gbcPanelNorth);
		
		btSpielen = new JButton("Spielen");
		btSpielen.setPreferredSize(new Dimension(100,50));//width, height
		btSpielen.setFont(new Font("", Font.BOLD, 16));
		btSpielen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						//User betritt Spieltisch
					}
				}
		);
		gbcPanelNorth.gridx = 1;
		panelNorth.add(btSpielen, gbcPanelNorth);	


		
		
		//panelWest
		panelWest = new JPanel(new GridBagLayout());
		panelWest.setBorder(BorderFactory.createLineBorder(Color.black));
		panelWest.setPreferredSize(new Dimension(240,668));//width, height
		add(panelWest, BorderLayout.WEST);
		
		//Components in panelWest
		GridBagConstraints gbcPanelWest = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelWest.insets = new Insets(0,0,0,0);//top, left, bottom, right
		
		lbSpieltisch = new JLabel("Spieltische welche man beitreten kann.");
		panelWest.add(lbSpieltisch);
		
		
		
		
		//panelCenter
		panelCenter = new JPanel(new GridBagLayout());
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.black));
		panelCenter.setPreferredSize(new Dimension(240,668));//width, height
		add(panelCenter, BorderLayout.CENTER);
		
		//Components in panelCenter
		GridBagConstraints gbcPanelCenter = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelCenter.insets = new Insets(0,0,0,0);//top, left, bottom, right
		
		lbCurrentUser = new JLabel("Anzeige der CurrentUser (nickname)");
		panelCenter.add(lbCurrentUser);
		
		
		
		
		//panelEast
		panelEast = new JPanel();
		panelEast.setBorder(BorderFactory.createLineBorder(Color.black));
		panelEast.setPreferredSize(new Dimension(542,668));//width, height
		add(panelEast, BorderLayout.EAST);
		
		//Components in panelEast
		GridBagConstraints gbcPanelEast = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPanelEast.insets = new Insets(20,20,20,20);//top, left, bottom, right
		
		taConversation = new JTextArea();
		taConversation.setEnabled(false);
		
		spScroll = new JScrollPane(taConversation);
		spScroll.setPreferredSize(new Dimension(500,600));
		gbcPanelEast.gridx = 0;
		gbcPanelEast.gridy = 0;
		panelEast.add(spScroll, gbcPanelEast);
		
		tfMessage = new JTextField();
		tfMessage.setPreferredSize(new Dimension(400, 50));
		Action sendMessage = new AbstractAction(){
			public void actionPerformed(ActionEvent event){
				sendMessage();
				tfMessage.setText("");
			}
		};
		tfMessage.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), sendMessage);
		gbcPanelEast.gridx = 0;
		gbcPanelEast.gridy = 1;
		panelEast.add(tfMessage, gbcPanelEast);
		
		btSend = new JButton("Send");
		btSend.setPreferredSize(new Dimension(100, 50));
		btSend.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage();
						tfMessage.setText("");
					}
				}
		);
		gbcPanelEast.gridx = 1;
		gbcPanelEast.gridy = 1;
		panelEast.add(btSend, gbcPanelEast);		
	}
	
	
	
	
	private void sendMessage(){
		try{
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket s = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

			// Send the message from the text box
			w.write(tfMessage.getText() + "\n");
			w.flush();

			// Read and display the reply
			String msgIn = r.readLine();
			taConversation.setText(taConversation.getText() + "\n" + msgIn);

			// Clean up
			r.close();
			w.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
