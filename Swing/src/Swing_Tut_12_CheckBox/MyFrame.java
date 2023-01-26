package Swing_Tut_12_CheckBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	JButton button;
	JCheckBox checkBox;
	ImageIcon xIcon;
	ImageIcon checkedIcon;
	
	MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		xIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\x_icon.png");
		checkedIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\checked_icon.png");
		
		button = new JButton();
		button.setText("Submit");
		button.addActionListener(this);
		
		checkBox = new JCheckBox();
		checkBox.setText("I'm checkbox #1!");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.PLAIN,34));
		checkBox.setIcon(xIcon); //Sets unchecked
		checkBox.setSelectedIcon(checkedIcon); //Sets checked
		
		this.add(button);
		this.add(checkBox);
		this.pack();
		this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println(checkBox.isSelected());
		}
	}
}
