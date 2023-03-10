package Swing_Tut_8_JLayeredPane;

import java.awt.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,500,500); //position is in the top left
		
		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.red);
		label1.setBounds(50,50,200,200);
		
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.green);
		label2.setBounds(100,100,200,200);
		
		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.blue);
		label3.setBounds(150,150,200,200);
		
		JFrame frame =new JFrame("JLayeredPane");
		frame.add(layeredPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		frame.setLayout(null);
		
		
		
		
		/*
		layeredPane.add(label1);//Top most layer
		layeredPane.add(label2); //Middle
		layeredPane.add(label3); //Background
		*/
		
		//To specify layer, higher number is top most layer
		layeredPane.add(label1, Integer.valueOf(0));
		layeredPane.add(label2, Integer.valueOf(2)); 
		layeredPane.add(label3, Integer.valueOf(1)); 
		frame.setVisible(true);
	}
}
