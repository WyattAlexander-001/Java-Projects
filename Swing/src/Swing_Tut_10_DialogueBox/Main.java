package Swing_Tut_10_DialogueBox;

import javax.swing.*;
public class Main {

	public static void main(String[] args) {
		
		//Showing types of messages
		//JOptionPane.showMessageDialog(null,"90 Day Fiance is Trash","90 Day Title Episode:", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(null,"90 Day Fiance is Trash","90 Day Title Episode:", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null,"90 Day Fiance is Trash","90 Day Title Episode:", JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showMessageDialog(null,"90 Day Fiance is Trash","90 Day Title Episode:", JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null,"90 Day Fiance is Trash","90 Day Title Episode:", JOptionPane.ERROR_MESSAGE);
		
		//JOptionPane.showConfirmDialog(null, "This box has yes,no,cancel: ", "3 options", JOptionPane.YES_NO_CANCEL_OPTION);
		
		//String name = JOptionPane.showInputDialog("What is your name?: ");
		//System.out.println("Hello " + name);
		String[] responses = {"No you're awesome", "THANKS!", "*Blush*"};
		
		ImageIcon icon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\jackfrost.png");
		
		JOptionPane.showOptionDialog(null, "You are awesome Annika!", "Title", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, responses, 0);
	}

}
