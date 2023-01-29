package main;

import javax.swing.*;

public class GameWindow extends JFrame{
	public GameWindow(GamePanel gamePanel) {
		//this is shorthand for JFrame
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(gamePanel);
		this.setLocationRelativeTo(null); //opens app in center of Monitor
		this.setVisible(true);//Always on bottom to avoid bug
	}

}
