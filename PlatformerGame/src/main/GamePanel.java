package main;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

//Frame >> Panel >> Graphics

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage img , subImg;


	
	public GamePanel() {

		mouseInputs = new  MouseInputs(this);
		importImage();
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png"); //access resources, "/" is used to get to the folder at the same level of src 
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800); // 1280/32 = 40 images wide and 800/32 = 25 images in height
		//setMinimumSize(size);
		//setMaximumSize(size);
		setPreferredSize(size);
		

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); //Call superclass JPanel paint component method 
		g.drawImage(img.getSubimage(0, 0, 64, 40), (int)xDelta, (int)yDelta, 128,80,null); //width is 64, height 40 due to sprite sheet. 128,80 is to double size.
	
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
	
	/* 
	 * Method to include RGB 
	private Color getRandomColor() {
		int r = random.nextInt(0,255); //0-255
		int b = random.nextInt(0,255);
		int g = random.nextInt(0,255);
		return new Color(r,b,g);
	}
	*/
	
	
}

