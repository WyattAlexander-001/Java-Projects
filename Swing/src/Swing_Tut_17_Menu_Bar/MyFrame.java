package Swing_Tut_17_Menu_Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
	//Keep components outside constructor
	JMenuBar menuBar;
	
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	
	JMenuItem saveItem;
	JMenuItem loadItem;
	JMenuItem exitItem;
	
	ImageIcon saveIcon;
	ImageIcon loadIcon;
	ImageIcon exitIcon;
	
	
	MyFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640,480);
		this.setLayout(new FlowLayout());
		
		saveIcon = new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\floppy.png");
		loadIcon= new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\load.png");
		exitIcon= new ImageIcon("H:\\ProgramFiles\\eclipse\\Lacie\\Swing\\src\\images\\exit.png");
		
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Preferences");
		helpMenu = new JMenu("Help");
		
		saveItem = new JMenuItem("Save");
		loadItem = new JMenuItem("Load");
		exitItem = new JMenuItem("Exit");
		
		saveItem.addActionListener(this);
		loadItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		saveItem.setIcon(saveIcon);
		loadItem.setIcon(loadIcon);
		exitItem.setIcon(exitIcon);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_P);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		saveItem.setMnemonic(KeyEvent.VK_S); 
		loadItem.setMnemonic(KeyEvent.VK_L);
		exitItem.setMnemonic(KeyEvent.VK_0);
		
		//Bar
		this.setJMenuBar(menuBar);
		//MenuBar:
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		//MenuBarItems:
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(exitItem);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveItem) {
			System.out.println("FILE SAVED");
		}else if(e.getSource()==loadItem) {
			System.out.println("FILED LOADED");			
		}else if(e.getSource()==exitItem) {
			System.exit(0);
		}
	}
}
