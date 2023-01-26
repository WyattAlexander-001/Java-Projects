package Swing_Tut_19_ColorChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	
	JButton button;
	JLabel label;

	MyFrame(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Pick a color");
		button.addActionListener(this);
		
		label = new JLabel();
		label.setBackground(Color.pink);
		label.setOpaque(true);
		label.setText("Default Wyatt Text");
		label.setFont(new Font("Times New Romon",Font.PLAIN,100));
		
		this.add(button);
		this.add(label);
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource()==button) {
			JColorChooser colorChooser = new JColorChooser();
			Color color = JColorChooser.showDialog(null, "Pick a color for background", Color.blue);
			//label.setForeground(color);
			label.setBackground(color);
		}
	}

}
