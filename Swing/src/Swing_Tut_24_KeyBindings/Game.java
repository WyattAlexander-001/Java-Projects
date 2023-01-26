package Swing_Tut_24_KeyBindings;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Game {
	
	JFrame frame;
	JLabel label;
	
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;
	
	Game(){
		frame = new JFrame("KeyBind Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		label = new JLabel();
		label.setBackground(Color.green);
		label.setOpaque(true);
		label.setBounds(100,100,100,100);
		
		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		
		label.getInputMap().put(KeyStroke.getKeyStroke('w'),"upAction");
		label.getActionMap().put("upAction", upAction);
		
		label.getInputMap().put(KeyStroke.getKeyStroke('s'),"downAction");
		label.getActionMap().put("downAction", downAction);
		
		label.getInputMap().put(KeyStroke.getKeyStroke('a'),"leftAction");
		label.getActionMap().put("leftAction", leftAction);
		
		label.getInputMap().put(KeyStroke.getKeyStroke('d'),"rightAction");
		label.getActionMap().put("rightAction", rightAction);
		
		frame.add(label);
		frame.setVisible(true);
		
		
	}
	
	public class UpAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(),label.getY()-10);
		}	
	}

	public class DownAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {	
			label.setLocation(label.getX(),label.getY()+ 10);
		}	
	}
	
	public class LeftAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()-10,label.getY());
		}	
	}
	
	public class RightAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()+10,label.getY());
		}	
	}
}
