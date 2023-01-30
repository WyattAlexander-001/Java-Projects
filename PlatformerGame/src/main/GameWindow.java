package main;

import javax.swing.*;

public class GameWindow extends JFrame{
	public GameWindow(GamePanel gamePanel) {
		//this is shorthand for JFrame
		//this.setSize(400,400); //Set window default size, but this includes the top border which varies per operating system
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamePanel);
		this.setLocationRelativeTo(null); //opens app in center of Monitor
		this.setResizable(false); //prevents user from resizing application window
		this.pack(); //JFRame sets the window the size of its components eg: JPanel is 1280x800
		this.setVisible(true);//Always on bottom to avoid bug
	}

}
