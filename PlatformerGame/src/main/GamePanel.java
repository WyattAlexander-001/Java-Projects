package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

//Frame >> Panel >> Graphics

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private float xDelta = 100;
	private float yDelta = 100;
	private float xDir = 1f;
	private float yDir = 1f;
	private int frames = 0;
	private long lastCheck = 0;
	private Color color = new Color(0xD0A384);
	private Random random;
	public GamePanel() {
		random = new Random();
		mouseInputs = new  MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //Call superclass JPanel paint component method

		updateRectangle();
		g.setColor(color); //hex-color is 0xhex
		g.fillRect((int)xDelta,(int)yDelta, 100, 13);
		

		//repaint();
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value; 
		repaint(); //repaints new positions
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}	
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	public void updateRectangle() {
		xDelta += xDir;
		if(xDelta >400 ||xDelta <0) {
			xDir *=-1;
			color = getRandomColor();
		}
		
		yDelta+=yDir;
		if(yDelta >400 ||yDelta <0) {
			yDir *=-1;
			color = getRandomColor();
		}		
	}

	private Color getRandomColor() {
		int r = random.nextInt(0,255); //0-255
		int b = random.nextInt(0,255);
		int g = random.nextInt(0,255);
		return new Color(r,b,g);
	}
}

