package Swing_Tut_7_GridLayout;
import java.awt.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout(5,100,20,20));//Grid instead of Border, rows, columns,x spacing, y spacing

		
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		frame.add(new JButton("A"));
		frame.add(new JButton("B"));
		frame.add(new JButton("C"));
		frame.add(new JButton("D"));
		frame.add(new JButton("F"));
		frame.add(new JButton("JIM"));
		frame.add(new JButton("TIM"));
		frame.add(new JButton("FIN"));
		frame.add(new JButton("WALTER"));
		frame.add(new JButton("LARRY"));
		frame.add(new JButton("BARRY"));
		frame.add(new JButton("X"));
		frame.add(new JButton("Y"));
		frame.add(new JButton("Z"));
		frame.add(new JButton("Ojama"));
		frame.add(new JButton("Lime"));
		frame.add(new JButton("Coconut"));
		frame.add(new JButton("Apple"));
		frame.add(new JButton("Quicny"));
		frame.add(new JButton("Soul Reaper"));
		frame.add(new JButton("Ichio"));
		frame.add(new JButton("Orihime"));
		frame.add(new JButton("Sado"));
		frame.add(new JButton("Zangetsu"));
		frame.add(new JButton("Rukia"));
		
		//Keep to bottom
		frame.setVisible(true);	
	}
}
