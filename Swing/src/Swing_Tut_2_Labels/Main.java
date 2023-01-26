package Swing_Tut_2_Labels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame(); //Makes a new WINDOW, a "frame." Title: "Whatever string you put inside"    	            	        
        frame.setVisible(true); //Makes Window Visible
        frame.setTitle("I AM THE NAME OF THE WINDOW!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Will Terminate the program when you click the red X    	        
        frame.setSize(500,500);//Setting size: I love classic PC games, so this is a standard resolution   			
		frame.setLayout(null);

        //Placing Text
        JLabel label = new JLabel();
        label.setBounds(100,100,250,250); //X,Y,Scale,Scale
		label.setText("This is a way to set text!");        
        frame.add(label);
        label.setHorizontalTextPosition(JLabel.CENTER); //Can set text: LEFT,RIGHT,CENTER of Image
        label.setVerticalTextPosition(JLabel.TOP); //Can set text: TOP,BOT, CENTER of image
        label.setForeground(new Color(0x00FF00)); //Sets color of text to FALLOUT GREEN
        label.setFont(new Font("MV Boli", Font.ITALIC, 20)); //Font style, in italic, 20pt size
        label.setIconTextGap(100); //set gap of text to image 
        
        //Set background and border
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color
        
        //Create border
        Border border = BorderFactory.createLineBorder(Color.red);
        label.setBorder(border);
        
        //Alignment of vertical and center
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        //Placing Image
        ImageIcon image = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_2_Labels\\images\\princess_zelda.png");
        label.setIcon(image);
        
        //Pack Method:
		//frame.pack();
		//frame.add(label);
	}

}
