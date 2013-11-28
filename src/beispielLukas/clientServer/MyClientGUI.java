package beispielLukas.clientServer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class MyClientGUI extends JFrame  implements ActionListener{
	
	PrintWriter out;
	JLabel jl;
	JTextField jtf;
	JButton jb;
	
	public MyClientGUI(PrintWriter out){
		this.init();
		this.out = out;
	}
	
	public void init(){
		this.setSize(400, 400);
		
		jl = new JLabel();
		jb = new JButton();
		jb.addActionListener(this);
		jtf = new JTextField();
		
		this.setLayout(new GridLayout(3, 1));
		this.add(jl);
		this.add(jtf);
		this.add(jb);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		this.out.println(jtf.getText());
		this.jtf.setText("");
	}
	
	public void writeText(String text){
		jl.setText(text);
	}

}
