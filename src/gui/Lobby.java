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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lobby extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Lobby().setVisible(true);
	}
	
	public Lobby() {
		setTitle("Der Grosse Dalmuti - Lobby");
		setSize(1024, 818);
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
		p2.setPreferredSize(new Dimension(340,0));//width, height
		add(p2, BorderLayout.WEST);
		
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setPreferredSize(new Dimension(340,0));//width, height
		add(p3, BorderLayout.CENTER);
		
		JPanel p4 = new JPanel(new GridBagLayout());
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setPreferredSize(new Dimension(342,0));//width, height
		add(p4, BorderLayout.EAST);
		
//		Panel_1
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(30,0,30,30);//top, left, bottom, right
		
		JLabel l_titel = new JLabel("WŠhle einen Spieltisch aus an dem du spielen mšchtest und klicke auf");
		l_titel.setFont(f_select_table);
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		p1.add(l_titel, gbc1);
		
		JButton b_login = new JButton("Spielen");
		b_login.setPreferredSize(new Dimension(100,50));//width, height
		b_login.setFont(f_button);
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
		gbc4.insets = new Insets(0,0,0,0);//top, left, bottom, right
		
		JLabel l_chat = new JLabel("Chat:");
		gbc4.anchor = GridBagConstraints.FIRST_LINE_START;
		p4.add(l_chat);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Spielregeln")) {
			JOptionPane.showMessageDialog(null, "Spielregeln: \n 1. Mach dies und das! \n 2. Du sollst nicht!", "Spielregeln", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
