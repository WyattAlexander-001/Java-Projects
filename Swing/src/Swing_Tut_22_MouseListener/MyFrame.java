package Swing_Tut_22_MouseListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener,KeyListener{
	JLabel label;
	ImageIcon happy;
	ImageIcon money;
	ImageIcon puke;
	ImageIcon pout;
	MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);
		
		
		happy = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\happy.png");
		money = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\money.png");
		puke = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\puke.png");
		pout = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\pout.png");
		
		label = new JLabel();
		label.setBounds(0,0,100,100);
		label.setIcon(happy);
		label.addMouseListener(this);

		this.add(label);
		this.setVisible(true);		
	}
	
	//MouseListener Methods to override from abstract interface class
	@Override
	public void mouseClicked(MouseEvent e) {//Invoked when a mouse it pressed+released
		System.out.println("You clicked the icon");
		label.setIcon(puke);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("You pressed the icon");
		label.setIcon(pout);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("You RELEASED the icon");
				
	}
	@Override
	public void mouseEntered(MouseEvent e) {//Invoked when cursor enters an area
		System.out.println("You ENTERED the icon ZONE");
		this.getContentPane().setBackground(Color.blue);
	}
	@Override
	public void mouseExited(MouseEvent e) { //Invoked when cursor exits an area
		// TODO Auto-generated method stub
		System.out.println("You EXITED the icon ZONE");
		this.getContentPane().setBackground(Color.orange);
		label.setIcon(happy);
	}
	
	//KeyListener Methods to override from abstract interface class
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
