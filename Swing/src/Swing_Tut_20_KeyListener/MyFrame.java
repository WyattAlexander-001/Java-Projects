package Swing_Tut_20_KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyFrame extends JFrame implements KeyListener {
	JLabel label;
	ImageIcon player;
	
	MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,500);
		this.setLayout(null);
		this.addKeyListener(this);
		//this.pack(); This makes it so you can't set size
		
		player = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\blackfrost.png");
				
		label = new JLabel();
		label.setBounds(0,0,100,100);
		label.setIcon(player);
		//label.setOpaque(true);
		//label.setBackground(Color.pink);
		
		this.getContentPane().setBackground(Color.magenta);
		this.add(label);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a': label.setLocation(label.getX()-10, label.getY());
			break;
		case 'w': label.setLocation(label.getX(), label.getY()-10);
			break;
		case 's': label.setLocation(label.getX(), label.getY()+10);
			break;
		case 'd': label.setLocation(label.getX()+10, label.getY());
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37: label.setLocation(label.getX()-50, label.getY());
			break;
		case 38: label.setLocation(label.getX(), label.getY()-50);
			break;
		case 39: label.setLocation(label.getX()+50, label.getY());
			break;
		case 40: label.setLocation(label.getX(), label.getY()+50);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("You released key char: " + e.getKeyChar()); //Doesn't show arrow keys though
		System.out.println("You released key char: " + e.getKeyCode());
	}


}
