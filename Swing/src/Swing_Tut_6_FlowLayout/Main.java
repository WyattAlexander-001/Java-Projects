package Swing_Tut_6_FlowLayout;
import java.awt.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,5,10 ));//Flow instead of Border, spacing x, spacing y
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,250));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBackground(Color.red);
		
		/* Regular way to add components
		JButton button1 = new JButton();		
		frame.add(button1);
		*/
		
		frame.add(panel);
		//Shortcut to add button components
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		
		
		//To avoid weird visibility issues, set this on the bottom
		frame.setVisible(true);	
	}

}
