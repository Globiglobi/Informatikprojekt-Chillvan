package dalmuti.testing;

import java.awt.*;
import javax.swing.*;
public class BackgroundTest extends JPanel {
    private JLayeredPane layeredPane;
    private JLabel imageContainer = new JLabel();
    private JButton info = new JButton("LOGIN");

    BackgroundTest(ImageIcon image) {
        super();

        this.imageContainer.setIcon(image);

        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(350, 600));
        layeredPane.add(imageContainer, new Integer(50));
        layeredPane.add(info, new Integer(100));
        this.add(layeredPane);
        // CHANGED CODE
        // Manually set layout the components. 
        imageContainer.setBounds( 0, 0,  
                                  image.getIconWidth(),
                                  image.getIconHeight() ); 
        info.setBounds( 100, 50,  100, 50 );
    }
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new BackgroundTest( new ImageIcon("karte2.jpg")  ) );
        frame.pack();
        frame.setVisible( true );
    }
}