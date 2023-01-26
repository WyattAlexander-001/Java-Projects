package Swing_Tut_14_DropDownBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	JComboBox comboBox;
	
	MyFrame(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//Needs to be a ref data type, strings are auto ref
		//Integer[] instead of int[], since you need to use wrapper classes
		String[] food = {"Shake", "Fries", "Meat"};
		comboBox = new JComboBox(food);
		comboBox.addActionListener(this);
		
		comboBox.setEditable(true); //For searching the box
		
		comboBox.addItem("Nugget");
		comboBox.insertItemAt("Carl", 0);
		comboBox.setSelectedIndex(0);
		
		comboBox.removeItem("Meat");
		comboBox.removeItemAt(0);
		//comboBox.removeAllItems();//reset
		
		this.add(comboBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox) {
			System.out.println("Total in list: " + comboBox.getItemCount());
			System.out.println(comboBox.getSelectedItem());
			System.out.println(comboBox.getSelectedIndex());	
		}
	}
}
