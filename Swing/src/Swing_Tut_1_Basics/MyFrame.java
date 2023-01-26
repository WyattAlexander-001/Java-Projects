package Swing_Tut_1_Basics;

import java.awt.Color;

import javax.swing.*;

public class MyFrame extends JFrame {
	MyFrame(){
		this.setVisible(true); //Makes Window Visible
    	this.setTitle("I LOVE YOU ANNI!");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Will Terminate the program when you click the red X    	        
    	this.setSize(640,480);//Setting size: I love classic PC games, so this is a standard resolution   			
    	        
    	//Neat additions:
    	//this.setResizable(false); //Makes it so you can't reize window
    	        
    	ImageIcon image = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_1_Basics\\images\\triforce.png");
    	this.setIconImage(image.getImage()); //change icon of this
    	        
    	this.getContentPane().setBackground(new Color(0xFF8500)); //sets this color, 0xHexadecimal color value
    }
}


