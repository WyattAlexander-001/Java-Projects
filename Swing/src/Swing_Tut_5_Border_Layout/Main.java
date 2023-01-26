package Swing_Tut_5_Border_Layout;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		//Margin
		frame.setLayout(new BorderLayout(10,10));
		frame.setVisible(true);
		
		//Making the panels
		JPanel header = new JPanel();
		JPanel body = new JPanel();
		JPanel footer = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		//Colors for the panels
		header.setBackground(Color.red);
		body.setBackground(Color.blue);
		footer.setBackground(Color.green);
		leftPanel.setBackground(Color.yellow);
		rightPanel.setBackground(Color.pink);
		
		//Set dimensions for panel
		header.setPreferredSize(new Dimension(100,200));
		body.setPreferredSize(new Dimension(500,500));
		footer.setPreferredSize(new Dimension(10,100));
		leftPanel.setPreferredSize(new Dimension(100,200));
		rightPanel.setPreferredSize(new Dimension(100,200));
		
		//Sub panels of body
		body.setLayout(new BorderLayout());
		JPanel body1 = new JPanel();
		JPanel body2 = new JPanel();
		JPanel body3 = new JPanel();
		JPanel body4 = new JPanel();
		JPanel body5 = new JPanel();		
		
		body1.setBackground(Color.black);
		body2.setBackground(Color.cyan);
		body3.setBackground(Color.gray);
		body4.setBackground(Color.lightGray);
		body5.setBackground(Color.magenta);

		body1.setPreferredSize(new Dimension(50,50));
		body2.setPreferredSize(new Dimension(50,50));
		body3.setPreferredSize(new Dimension(50,50));
		body4.setPreferredSize(new Dimension(50,50));
		body5.setPreferredSize(new Dimension(50,50));
		
		//Add main panels and direction
		frame.add(header,BorderLayout.NORTH);
		frame.add(body,BorderLayout.CENTER);
		frame.add(footer,BorderLayout.SOUTH);
		frame.add(rightPanel,BorderLayout.EAST);
		frame.add(leftPanel,BorderLayout.WEST);
		
		//Add sub panels to body
		body.add(body1,BorderLayout.NORTH);
		body.add(body2,BorderLayout.CENTER);
		body.add(body3,BorderLayout.EAST);
		body.add(body4,BorderLayout.WEST);
		body.add(body5,BorderLayout.SOUTH);


	}

}
