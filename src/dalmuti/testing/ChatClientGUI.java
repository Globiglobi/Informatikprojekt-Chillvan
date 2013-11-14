package dalmuti.testing;

import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ChatClientGUI
{
	//Globals
	private static Client chatclient;
	public static String username = "Unknown";
	
	//Globals-GUI
	public static JFrame mainWindow = new JFrame();
	private static JButton btAbout = new JButton();
	private static JButton btConnect = new JButton();
	private static JButton btDisconnect = new JButton();
	private static JButton btHelp = new JButton();
	private static JButton btSend = new JButton();
	private static JLabel lbMessage = new JLabel("Message: ");
	public static JTextField tfMessage = new JTextField(20);
	private static JLabel lbConversation = new JLabel();
	public static JTextArea taConversation = new JTextArea();
	private static JScrollPane spConversation = new JScrollPane();
	private static JLabel lbOnline = new JLabel();
	public static JList ltOnline = new JList();
	private static JScrollPane spOnline = new JScrollPane();
	private static JLabel lbLoggedInAs = new JLabel();
	private static JLabel lbLoggedInAsBox = new JLabel();
	
	//Globals-GUI-Login
	public static JFrame loginWindow = new JFrame();
	public static JTextField tfUsernameBox = new JTextField(20);
	private static JButton btEnter = new JButton("Enter");
	private static JLabel lbEnterUsername = new JLabel();
	private static JPanel pnlLogin = new JPanel();
	
	//Main-Method
	public static void main(String[] args)
	{
		BuildMainWindow();
		Initialize();
	}
	
	public static void Connect()
	{
		try
		{
			final int port = 50002;
			final String host = InetAddress.getLocalHost().getHostName();
			Socket sock = new Socket(host,port);
			System.out.println("You connected to: " + host);
			
			chatclient = new Client(sock);
			
			//Send Name to add to the Online-List
			PrintWriter out = new PrintWriter(sock.getOutputStream());
			out.println(username);
			out.flush();
			
			Thread x = new Thread(chatclient);
			x.start();
		}
		catch(Exception x)
		{
			System.out.println(x);
			JOptionPane.showMessageDialog(null, "Server not responding.");
			System.exit(0);
		}
	}
	
	public static void Initialize()
	{
		btSend.setEnabled(false);
		btDisconnect.setEnabled(false);
		btConnect.setEnabled(true);
	}

	public static void BuildLoginWindow()
	{
		loginWindow.setTitle("What's your name?");
		loginWindow.setSize(400,100);
		loginWindow.setLocation(250, 200);
		loginWindow.setResizable(false);
		pnlLogin = new JPanel();
		pnlLogin.add(lbEnterUsername);
		pnlLogin.add(tfUsernameBox);
		pnlLogin.add(btEnter);
		loginWindow.add(pnlLogin);
		
		LoginAction();
		loginWindow.setVisible(true);
	}
	
	public static void BuildMainWindow()
	{
		mainWindow.setTitle(username + "'s Chat Box");
		mainWindow.setSize(450, 500);
		mainWindow.setLocation(220, 180);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConfigureMainWindow();
		MainWindow_Action();
		mainWindow.setVisible(true);
	}
	
	public static void ConfigureMainWindow()
	{
//		mainWindow.setBackground(new java.awt.Color(255, 255, 255));
		mainWindow.setSize(500, 320);
		mainWindow.getContentPane().setLayout(null);
		
//		btSend.setBackground(new java.awt.Color(0, 0, 255));
//		btSend.setForeground(new java.awt.Color(255, 255, 255));
		btSend.setText("Send");
		mainWindow.getContentPane().add(btSend);
		btSend.setBounds(250, 40, 81, 25);//x, y, width, height
		
//		btDisconnect.setBackground(new java.awt.Color(0, 0, 255));
//		btDisconnect.setForeground(new java.awt.Color(255, 255, 255));
		btDisconnect.setText("Disconnect");
		mainWindow.getContentPane().add(btDisconnect);
		btDisconnect.setBounds(10, 40, 110, 25);
		
//		btConnect.setBackground(new java.awt.Color(0, 0, 255));
//		btConnect.setForeground(new java.awt.Color(255, 255, 255));
		btConnect.setText("Connect");
		btConnect.setToolTipText("");
		mainWindow.getContentPane().add(btConnect);
		btConnect.setBounds(130, 40, 110, 25);
		
//		btHelp.setBackground(new java.awt.Color(0, 0, 255));
//		btHelp.setForeground(new java.awt.Color(255, 255, 255));
		btHelp.setText("Help");
		mainWindow.getContentPane().add(btHelp);
		btHelp.setBounds(420, 40, 70, 25);
		
//		btAbout.setBackground(new java.awt.Color(0, 0, 255));
//		btAbout.setForeground(new java.awt.Color(255, 255, 255));
		btAbout.setText("About");
		mainWindow.getContentPane().add(btAbout);
		btAbout.setBounds(340, 40, 75, 25);
		
		lbMessage.setText("Message:");
		mainWindow.getContentPane().add(lbMessage);
		lbMessage.setBounds(10, 10, 60, 20);//x, y, width, height
		
		tfMessage.setForeground(new java.awt.Color(0, 0, 255));
		tfMessage.requestFocus();
		mainWindow.getContentPane().add(tfMessage);
		tfMessage.setBounds(70, 4, 260, 30);
		
		lbConversation.setHorizontalAlignment(SwingConstants.CENTER);
		lbConversation.setText("Conversation");
		mainWindow.getContentPane().add(lbConversation);
		lbConversation.setBounds(100, 70, 140, 16);
		
		taConversation.setColumns(20);
		taConversation.setFont(new java.awt.Font("Tohama", 0, 12));
		taConversation.setForeground(new java.awt.Color(0, 0, 255));
		taConversation.setLineWrap(true);
		taConversation.setRows(5);
		taConversation.setEditable(false);
		
		spConversation.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spConversation.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spConversation.setViewportView(taConversation);
		mainWindow.getContentPane().add(spConversation);
		spConversation.setBounds(10, 90, 330, 180);
		
		lbOnline.setHorizontalAlignment(SwingConstants.CENTER);
		lbOnline.setText("Currently Online");
		lbOnline.setToolTipText("");
		mainWindow.getContentPane().add(lbOnline);
		lbOnline.setBounds(350, 70, 130, 16);
		
		ltOnline.setForeground(new java.awt.Color(0, 0, 255));
		
		spOnline.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spOnline.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spOnline.setViewportView(ltOnline);
		mainWindow.getContentPane().add(spOnline);
		spOnline.setBounds(350, 90, 130, 180);
		
		lbLoggedInAs.setFont(new java.awt.Font("Tohama", 0, 12));
		lbLoggedInAs.setText("Currently Logged In As");
		mainWindow.getContentPane().add(lbLoggedInAs);
		lbLoggedInAs.setBounds(348, 0, 140, 15);
		
		lbLoggedInAsBox.setHorizontalAlignment(SwingConstants.CENTER);
		lbLoggedInAsBox.setFont(new java.awt.Font("Tohama", 0, 12));
		lbLoggedInAsBox.setForeground(new java.awt.Color(255, 0, 0));
		lbLoggedInAsBox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		mainWindow.getContentPane().add(lbLoggedInAsBox);
		lbLoggedInAsBox.setBounds(340, 17, 150, 20);
	}
	
	public static void LoginAction()
	{
		btEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				Action_btEnter();
			}
		});
	}
	
	public static void Action_btEnter()
	{
		if(!tfUsernameBox.getText().equals(""))
		{
			username = tfUsernameBox.getText().trim();
			lbLoggedInAsBox.setText(username);
			Server.currentUsers.add(username);
			mainWindow.setTitle(username + "'s Chat Box");
			loginWindow.setVisible(false);
			btSend.setEnabled(true);
			btDisconnect.setEnabled(true);
			btConnect.setEnabled(false);
			Connect();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please enter a name!");
		}
	}
	
	public static void MainWindow_Action()
	{
		btSend.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				Action_btSend();
			}
		});
		
		btDisconnect.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				Action_btDisconnect();
			}
		});
		
		btConnect.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				BuildLoginWindow();
			}
		});
		
		btHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				Action_btHelp();
			}
		});
		
		btAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				Action_btHelp();
			}
		});
	}
	
	public static void Action_btSend()
	{
		if(!tfMessage.getText().equals(""))
		{
			chatclient.Send(tfMessage.getText());
			tfMessage.requestFocus();
		}
	}
	
	public static void Action_btDisconnect()
	{
		try
		{
			chatclient.Disconnect();
		}
		catch(Exception y)
		{
			y.printStackTrace();
		}
	}
	
	public static void Action_btHelp()
	{
		JOptionPane.showMessageDialog(null, "Multi-Chat Client");
	}
}
