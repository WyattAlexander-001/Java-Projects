package Swing_Tut_9_NewWindow;

import java.awt.event.*;
import javax.swing.*;

public class LaunchPage implements ActionListener{
	JFrame frame = new JFrame();
	JButton myButton = new JButton("New Window");
	
	LaunchPage(){
		
		myButton.setBounds(100,160,200,40);
		myButton.setFocusable(false); //removes high-lighter around text
		myButton.addActionListener(this);
		
		frame.add(myButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620,480);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myButton) {
			frame.dispose();//Closes this window
			NewWindow myWindow = new NewWindow();//Creates new window
		}
		
	}

}
