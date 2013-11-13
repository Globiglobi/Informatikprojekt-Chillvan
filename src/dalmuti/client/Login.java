/*
 * Copyright 2013 Cornflakes. Alle Rechte vorbehalten.
 * 
 * Autor: Bastian End
 * 
 * todo:
 * - background image
 * - animated background, Karten bewegen sich gegeneinander
 * - nickname auf 16 Zeichen begrenzen
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dalmuti.server.Server;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField tf_nickname;
	private JLabel testlabel;
	public String nickname;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run()
            {
                new Login().setVisible(true);
            }

        });
	}
	
	public Login() {
		setTitle("Der Grosse Dalmuti - Login");
		setSize(1024, 818);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		ImageIcon icon = new ImageIcon(getClass().getResource("background.png"));
//		Image background = icon.getImage();
		
		Font f_titel = new Font("", Font.BOLD, 78);
		Font f_insert_nickname = new Font("", Font.PLAIN, 18);
		Font f_button = new Font("", Font.BOLD, 16);
		
		JMenuBar bar = new JMenuBar();		
		JMenu help = new JMenu("Help");
		JMenuItem spielregeln = new JMenuItem("Spielregeln");
		spielregeln.addActionListener(this);
		spielregeln.setActionCommand("Spielregeln");	
		bar.add(help);
		help.add(spielregeln);
		setJMenuBar(bar);
		
		JPanel p1 = new JPanel(new GridBagLayout());
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
//		Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
//	    p1.drawImage(background, 0, 0, null);
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel(new GridBagLayout());
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p3, BorderLayout.SOUTH);
		
//		PANEL 1
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(100,0,0,0);//top, left, bottom, right
		
		JLabel l_titel = new JLabel("Der Grosse Dalmuti");
		l_titel.setFont(f_titel);		
		p1.add(l_titel, gbc1);
		
//		PANEL 2
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.insets = new Insets(10,0,10,0);//top, left, bottom, right
		
		JLabel insert_nickname = new JLabel("Gib hier deinen Nickname ein! (maximal 16 Zeichen)");
		insert_nickname.setFont(f_insert_nickname);
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		p2.add(insert_nickname);
		
		tf_nickname = new JTextField("Nickname", SwingConstants.CENTER);
		tf_nickname.setPreferredSize(new Dimension(460,30));
		tf_nickname.setFont(f_insert_nickname);
		tf_nickname.setHorizontalAlignment(JLabel.CENTER);
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		p2.add(tf_nickname, gbc2);
		
		JButton b_login = new JButton("Login");
		b_login.setPreferredSize(new Dimension(100,50));//width, height
		b_login.setFont(f_button);
		b_login.addActionListener(this);
		b_login.setActionCommand("Login");
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		p2.add(b_login, gbc2);	
		
		
		testlabel = new JLabel("dsgdsfgdsg");
		gbc2.gridy = 3;
		p2.add(testlabel, gbc2);
		
//		PANEL 3
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.insets = new Insets(0,0,10,0);//top, left, bottom, right
		
		/** 	FIRST_LINE_START	PAGE_START		FIRST_LINE_END
		 *		LINE_START			CENTER			LINE_END
		 *		LAST_LINE_START		PAGE_END		LAST_LINE_END		
		 */
		
//		GRIDY 0
		JLabel l_gap4 = new JLabel("");
		gbc3.insets = new Insets(0,55,-10,55);//top, left, bottom, right
		gbc3.gridy = 0;
		p3.add(l_gap4, gbc3);
		
		JLabel l_gap5 = new JLabel("");
		gbc3.insets = new Insets(0,55,-10,55);//top, left, bottom, right
		gbc3.gridy = 0;
		p3.add(l_gap5, gbc3);
		
		JLabel l_logo = new JLabel(new ImageIcon(getClass().getResource("logo_trans.png")));
		gbc3.gridy = 0;
		p3.add(l_logo, gbc3);
		
		JLabel l_gap6 = new JLabel("");
		gbc3.insets = new Insets(0,55,-10,55);//top, left, bottom, right
		gbc3.gridy = 0;
		p3.add(l_gap6, gbc3);
		
		JLabel l_gap7 = new JLabel("");
		gbc3.insets = new Insets(0,55,-10,55);//top, left, bottom, right
		gbc3.gridy = 0;
		p3.add(l_gap7, gbc3);
		
//		GRIDY 1
		JLabel l_version = new JLabel("");
		l_version.setText("<html><body>Version 1.0.0<br>6. November 2013</body></html>");
		gbc3.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc3.insets = new Insets(0,0,10,0);//top, left, bottom, right
		gbc3.gridy = 1;
		p3.add(l_version, gbc3);
		
		JLabel l_gap1 = new JLabel("");
		gbc3.anchor = GridBagConstraints.LAST_LINE_START;
		gbc3.insets = new Insets(0,110,10,110);//top, left, bottom, right
		gbc3.gridy = 1;
		p3.add(l_gap1, gbc3);
		
		JLabel l_copyright = new JLabel("Copyright 2013 Cornflakes. Alle Rechte vorbehalten.");
		gbc3.anchor = GridBagConstraints.LAST_LINE_START;
		gbc3.insets = new Insets(0,0,10,0);//top, left, bottom, right
		gbc3.gridy = 1;
		p3.add(l_copyright, gbc3);
		
		JLabel l_gap2 = new JLabel("");
		gbc3.insets = new Insets(0,110,10,55);//top, left, bottom, right
		gbc3.gridy = 1;
		p3.add(l_gap2, gbc3);
		
		JLabel l_gap3 = new JLabel("");
		gbc3.insets = new Insets(0,55,10,110);//top, left, bottom, right
		gbc3.gridy = 1;
		p3.add(l_gap3, gbc3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Spielregeln")) {
			JOptionPane.showMessageDialog(null, "Spielregeln: \n 1. Mach dies und das! \n 2. Du sollst nicht!", "Spielregeln", JOptionPane.PLAIN_MESSAGE);
		}
		else if (name.equals("Login")) {
			nickname = new String(tf_nickname.getText());
			testlabel.setText(nickname);
			dispose();
			new Lobby();
			new Server();
		}
	}
/*	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 10, 10, null); 
	}
	*/
}

