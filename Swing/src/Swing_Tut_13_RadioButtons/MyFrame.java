package Swing_Tut_13_RadioButtons;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	JRadioButton pizzaButton;
	JRadioButton hamburgerButton;
	JRadioButton hotDogButton;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		pizzaButton = new JRadioButton("Pizza");
		hamburgerButton = new JRadioButton("Hamburger");
		hotDogButton = new JRadioButton("Hotdog");
		
		ButtonGroup foodGroup = new ButtonGroup();
		foodGroup.add(pizzaButton);
		foodGroup.add(hamburgerButton);
		foodGroup.add(hotDogButton);
		
		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotDogButton.addActionListener(this);
		
		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotDogButton);
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pizzaButton) {
			System.out.println("You chose pizza!");
		}else if(e.getSource()==hamburgerButton) {
			System.out.println("You chose a burger!");
		}else if(e.getSource()== hotDogButton) {
			System.out.println("You chose a hotdog!");
		}else {
			System.out.println("Whatever");
		}
	}
}
