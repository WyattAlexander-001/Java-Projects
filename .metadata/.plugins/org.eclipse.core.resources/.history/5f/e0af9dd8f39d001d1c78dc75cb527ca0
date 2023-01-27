package Swing_Tut_15_Sliders;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SliderDemo implements ChangeListener{
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	
	SliderDemo(){
		frame = new JFrame("Slider Demo");
		panel = new JPanel();
		label = new JLabel();
		
		slider = new JSlider(0,100); //Min, Max, and starting point  numbers for slider
		slider.setPreferredSize(new Dimension(400,200));
		
		slider.setPaintTicks(true); //Adds ticks
		slider.setMinorTickSpacing(10); //Spaces ticks 10
		
		slider.setPaintTrack(true); //Adds ticks
		slider.setMajorTickSpacing(25); //
		
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli", Font.ITALIC,15));
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.addChangeListener(this);
		
		label.setFont(new Font("MV Boli", Font.PLAIN,25));
		label.setText("°C =  " + slider.getValue());

		
		
		frame.setSize(620,480);
		panel.add(slider);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		label.setText("°C =  " + slider.getValue());
	}

}
