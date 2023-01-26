package Swing_Tut_23_DragAndDrop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
	
	DragPanel dragPanel = new DragPanel();
	
	MyFrame(){
		
		this.setTitle("Drag and Drop Demo");
		this.setSize(640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.add(dragPanel);
		this.setVisible(true);
	}

}
