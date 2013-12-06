package dalmuti.testing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class BackgroundTest extends JPanel {
    private JLayeredPane layeredPane;
    private JLabel imageContainer = new JLabel();
    private JPanel panel = new JPanel();
    private JButton info = new JButton("LOGIN");
    private JLabel titel = new JLabel("DER GROSSE DALMUTI");

    BackgroundTest(ImageIcon image) {
        super();

        this.imageContainer.setIcon(image);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setOpaque(false);

        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(350, 600));
        layeredPane.add(imageContainer, new Integer(50));
        layeredPane.add(panel, new Integer(100));
        this.add(layeredPane);
        // CHANGED CODE
        // Manually set layout the components. 
        imageContainer.setBounds( 0, 0,  
                                  image.getIconWidth(),
                                  image.getIconHeight() ); 
        panel.setBounds(0, 0, 350, 600);
        panel.add(info);
        panel.add(titel);
    }
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new BackgroundTest( new ImageIcon("background.png")  ) );
        frame.pack();
        frame.setVisible( true );
    }
}