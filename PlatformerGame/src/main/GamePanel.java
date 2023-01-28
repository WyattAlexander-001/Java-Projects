package main;

import java.awt.Graphics;
import javax.swing.*;
//Frame >> Panel >> Graphics
public class GamePanel extends JPanel{
	public GamePanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //Call superclass JPanel paint component method
		//g.drawRect(100, 100, 200, 50);
		//g.fillRect(10, 10, 100, 13);
	}
}

