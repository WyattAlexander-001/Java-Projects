package Swing_Tut_3_Panels;

import javax.swing.*;
import java.awt.*;

//Panels act as containers, good for sectioning off components
public class Main {
	public static void main(String[] args) {
		ImageIcon yukikoIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_3_Panels\\images\\yukiko.png");
		ImageIcon teddieIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_3_Panels\\images\\teddie.png");
		ImageIcon narukamiIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_3_Panels\\images\\narukami.png");
		
		JLabel yukiko = new JLabel();
		yukiko.setText("This is bad...");
		yukiko.setIcon(yukikoIcon);
		yukiko.setVerticalAlignment(JLabel.BOTTOM);
		yukiko.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel teddie = new JLabel();
		teddie.setText("TEDDIE POWER!");
		teddie.setIcon(teddieIcon);
		teddie.setVerticalAlignment(JLabel.TOP);
		teddie.setHorizontalAlignment(JLabel.RIGHT);

		JLabel narukami = new JLabel();
		narukami.setText("Dinner?");
		narukami.setIcon(narukamiIcon);
		narukami.setVerticalAlignment(JLabel.CENTER);
		narukami.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,250,250);//x,y,width,height
		redPanel.setLayout(new BorderLayout());
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250,0,250,250);
		bluePanel.setLayout(new BorderLayout());
		
		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.yellow);
		yellowPanel.setBounds(0,250,500,250);
		yellowPanel.setLayout(new BorderLayout());
		
		JFrame frame = new JFrame(); 	        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        frame.setTitle("Tutorial Number 3!");
        frame.setSize(750,750);
        frame.setLayout(null); //worry about later tutorials
        
        redPanel.add(yukiko);
        frame.add(redPanel); //Remember to add your panel
        
        bluePanel.add(narukami);
        frame.add(bluePanel);
        
        yellowPanel.add(teddie);
        frame.add(yellowPanel);
	}
}
