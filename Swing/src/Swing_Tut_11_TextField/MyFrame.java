package Swing_Tut_11_TextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	//Fields:
	JTextField textField;
	JButton submit;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Consolas",Font.PLAIN,25));
		textField.setForeground(new Color(0x00FF00));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.yellow);
		textField.setText("DEFAULT TEXT");
		//textField.setEditable(false);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		this.add(submit);
		this.add(textField);
		this.setTitle("TUTORIAL ON TEXT FIELDS");
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			System.out.println("Welcome " + textField.getText());
			submit.setEnabled(false); //locks button
			textField.setEditable(false); //locks you from typing
		}
		
	}
}
