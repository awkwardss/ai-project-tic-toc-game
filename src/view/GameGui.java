package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameGui implements ActionListener{
	//codes for first view: choose difficulty
	public void initGUI1(){
		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		//frame, level list and start button
		JFrame startFrame = new JFrame();
	
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		startFrame.setTitle("Tic-toc-game");
		startFrame.setSize(500,500);
			
		//difficulty choose box AND start button: 2 panels
		//start button panel
		JPanel startButtonPanel = new JPanel();
		JButton startButton = new JButton("Start!");
		startButtonPanel.add(startButton);
		//use JPannel to store buttons
		JPanel buttongroupPanel = new JPanel();
		buttongroupPanel.setLayout(new GridLayout(4, 1));//use grid layout for button list
		//buttongroupPanel.setLayout(new BoxLayout(buttongroupPanel, BoxLayout.Y_AXIS));
		JLabel diffLabel = new JLabel("Please choose difficult level:");
		//single choice
			ButtonGroup group = new ButtonGroup();
			JRadioButton easyButton = new JRadioButton("Easy", false);
			JRadioButton midiumButton = new JRadioButton("Intermediate", false);
			JRadioButton difficultButton = new JRadioButton("Difficult", true);
			group.add(easyButton);
			group.add(midiumButton);
			group.add(difficultButton);	
		buttongroupPanel.add(diffLabel);
		buttongroupPanel.add(easyButton);
		buttongroupPanel.add(midiumButton);
		buttongroupPanel.add(difficultButton);
		
		startButton.addActionListener(this);
				
				
			
		startFrame.getContentPane().add(BorderLayout.SOUTH, startButtonPanel);
		startFrame.getContentPane().add(BorderLayout.CENTER, buttongroupPanel);
				
					
		startFrame.setVisible(true); 
	}

	public void actionPerformed(ActionEvent e) {//action when click start
		// TODO Auto-generated method stub
		// get the difficulty level and show game view
			
	}
	
}
