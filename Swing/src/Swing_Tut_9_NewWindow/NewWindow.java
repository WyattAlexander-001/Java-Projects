package Swing_Tut_9_NewWindow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class NewWindow {
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Some Default Text!");
	NewWindow(){
		
		label.setBounds(0,0,500,250);
		label.setOpaque(true);
		label.setBackground(Color.red);
		label.setFont(new Font(null,Font.PLAIN,25));
		
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620,480);
		frame.setLayout(null);
		frame.setVisible(true);	
	}

}
