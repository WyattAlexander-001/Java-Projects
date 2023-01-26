package Swing_Tut_1_Basics;
//In Eclipse I needed to right-click and fix it
import javax.swing.*;
import java.awt.Color;

public class App {    
    public static void main(String[] args){
//    	//For multi-threading to prevent crashing:
//    	SwingUtilities.invokeLater(new Runnable(){
//    		public void run(){    	    	
//    	        JFrame frame = new JFrame(); //Makes a new WINDOW, a "frame." Title: "Whatever string you put inside"    	            	        
//    	        frame.setVisible(true); //Makes Window Visible
//    	        frame.setTitle("I AM THE NAME OF THE WINDOW!");
//    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Will Terminate the program when you click the red X    	        
//    	        frame.setSize(640,480);//Setting size: I love classic PC games, so this is a standard resolution   			
//    	        
//    	        //Neat additions:
//    	        //frame.setResizable(false); //Makes it so you can't reize window
//    	        
//    	        ImageIcon image = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\Swing_Tut_1\\images\\triforce.png");
//    	        frame.setIconImage(image.getImage()); //change icon of frame
//    	        
//    	        frame.getContentPane().setBackground(new Color(0xFF8500)); //sets frame color, 0xHexadecimal color value
//    	        
//    		}
//    	});
    	
    	//Now we can use the MyFrame Class
    	
    	//If we want to make changes here we can invoke it here
    	//MyFrame myFrame = new MyFrame();
    	//Otherwise we can invoke it like this
    	
    	new MyFrame();
    }
}

