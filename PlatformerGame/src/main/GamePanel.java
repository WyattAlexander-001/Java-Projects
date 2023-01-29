package main;

import java.awt.Graphics;


import javax.swing.*;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

//Frame >> Panel >> Graphics

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	
	public GamePanel() {
		
		 mouseInputs = new  MouseInputs();
		addKeyListener(new KeyboardInputs());
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //Call superclass JPanel paint component method
		//g.drawRect(100, 100, 200, 50);
		g.fillRect(10, 10, 100, 13);
	}
}

