package dalmuti.server;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Server extends JFrame implements Runnable {
	private static Server server;
	private static Thread serverThread;

	private JTextArea txtMessages;
	private JScrollPane scroll;

	public static void main(String[] args) {
		server = new Server();
		serverThread = new Thread(server, "Listener");
		serverThread.start();
	}

	public Server() {
		super("Simple server");
		this.setPreferredSize(new java.awt.Dimension(600,400));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		
		txtMessages = new JTextArea();
		txtMessages.setEnabled(false);
//		txtMessages.setPreferredSize(new java.awt.Dimension(600, 300));
		scroll = new JScrollPane(txtMessages);
		this.add(scroll, BorderLayout.CENTER);
//		this.add(txtMessages, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	@Override
	public void run() {
		try {
			// Create the server socket, to listen for incoming requests
			ServerSocket listener = new ServerSocket(50001, 2, null);

			while (true) {
				// Wait for and accept an incoming request
				Socket s = listener.accept();

				// Create reader and writer for the socket
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

				// read the incoming message; append it to the text area
				String msgIn = r.readLine();
				txtMessages.setText(txtMessages.getText() + "\n" + msgIn);

				// write our confirmation
				w.write("Nickname: " + msgIn + "\n");
				w.flush();

				// Clean up
				r.close();
				w.close();
				s.close();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

