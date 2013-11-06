package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class login extends JFrame /*implements ActionListener*/ {
	
	private static final long serialVersionUID = 1L;
	final static boolean shouldFill = true;

	public static void main(String[] args) {
		new login().setVisible(true);
	}
	
	public login() {
		super("Der Grosse Dalmuti");
		setSize(1024, 768);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initialize();
	}
	
	private void initialize() {
		
		Font f_titel = new Font("", Font.BOLD, 78);
		Font f_insert_nickname = new Font("", Font.PLAIN, 18);
		Font f_login = new Font("", Font.BOLD, 16);
		
		
		
		JPanel p1 = new JPanel(new GridBagLayout());
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel(new GridBagLayout());
		add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel(new GridBagLayout());
		add(p3, BorderLayout.SOUTH);

//		Panel_1
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(100,0,0,0);//top, left, bottom, right
		
		JLabel l_titel = new JLabel("Der Grosse Dalmuti");
		l_titel.setFont(f_titel);		
		p1.add(l_titel, gbc1);
		
//		Panel_2
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.insets = new Insets(10,0,10,0);//top, left, bottom, right
		
		JLabel insert_nickname = new JLabel("Gib hier deinen Nickname ein! (maximal 16 Zeichen)");
		insert_nickname.setFont(f_insert_nickname);
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		p2.add(insert_nickname);
		
		JTextField tf_nickname = new JTextField("Nickname", SwingConstants.CENTER);
		tf_nickname.setPreferredSize(new Dimension(460,30));
		tf_nickname.setFont(f_insert_nickname);
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		p2.add(tf_nickname, gbc2);
		
		JButton b_login = new JButton("Login");
		b_login.setPreferredSize(new Dimension(100,50));//width, height
		b_login.setFont(f_login);
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		p2.add(b_login, gbc2);	
		
//		Panel_3
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.insets = new Insets(20,20,20,20);//top, left, bottom, right
		
		JLabel l_copyright = new JLabel("Copyright 2013 Cornflakes. Alle Rechte vorbehalten.", SwingConstants.CENTER);
		p3.add(l_copyright, gbc3);
		
		JLabel l_version = new JLabel("");
		l_version.setText("<html><body>Version 1.0.0<br>6. November 2013</body></html>");
		p3.add(l_version, gbc3);
	}
}

