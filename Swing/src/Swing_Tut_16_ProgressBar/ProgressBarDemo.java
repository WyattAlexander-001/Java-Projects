package Swing_Tut_16_ProgressBar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class ProgressBarDemo {
	
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar();
	
	ProgressBarDemo(){
		
		bar.setValue(0);
		bar.setBounds(0,0,500,50);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.PLAIN,25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
		
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620,480);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill();
	}
	
	public void fill() {
		int counter = 0;
		while(counter<=100) {
			bar.setValue(counter);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter +=1;
		}
		
		bar.setString("DONE LOADING!");
		bar.setFont(new Font("MV Boli", Font.BOLD,45));
	}

}
