package Swing_Tut_4_Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	JButton button;
	JLabel label;
	MyFrame() {
		
		ImageIcon defaultIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\jackfrost.png");
		ImageIcon resultIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\blackfrost.png");
		label = new JLabel();
		label.setIcon(resultIcon);
		label.setBounds(150,600,150,150);
		label.setVisible(false);
		
		button = new JButton();
		button.setBounds(150,150,400,300);
		button.addActionListener(this);
		button.setText("CLICK ME!");
		button.setFocusable(false);
		button.setIcon(defaultIcon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		button.setIconTextGap(-10);
		button.setForeground(new Color(0x814587)); //text color
		button.setBackground(new Color(0xD874E1)); //button color
		button.setBorder(BorderFactory.createEtchedBorder()); //Adds bevel
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true); 
    	this.setTitle("Tutorial #4 ON BUTTONS");
    	this.setSize(1000,1000); 	
    	
    	
    	this.add(button);
    	this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("Console words");
			label.setVisible(true);
			//button.setEnabled(false); //Will disable button after one click
		}
		
	}
	
	
	
	


}
