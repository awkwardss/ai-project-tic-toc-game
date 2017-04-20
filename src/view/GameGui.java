package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * GUI file for game. Contains 2 GUI page: GUI1 and GUI2
 */
public class GameGui{
	
		int gameDifficulty;
		
		private JFrame frame;
		//GUI1
		private JPanel startButtonPanel;
		private JPanel buttongroupPanel;
		private JButton startButton;
		private JLabel diffLabel;
		private ButtonGroup group;
	
	
	/*
	 * First GUI page method: choose game difficulty and start button
	 */
	public void initGUI1(){
		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//frame, level list and start button
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		frame.setTitle("Tic-toc-game");
		frame.setSize(500,500);
			
		//difficulty choose box AND start button: 2 panels
		//use JPannel to store buttons
		buttongroupPanel = new JPanel();
		buttongroupPanel.setLayout(new GridLayout(4, 1));//use grid layout for button list
		//buttongroupPanel.setLayout(new BoxLayout(buttongroupPanel, BoxLayout.Y_AXIS));
		diffLabel = new JLabel("Please choose difficult level:");
		buttongroupPanel.add(diffLabel);
		//radio button for difficulty
		group = new ButtonGroup();
		addRadioButton("Easy", 1);
		addRadioButton("Intermediate", 2);
		addRadioButton("Difficult", 3);

		//start button panel
		startButtonPanel = new JPanel();
		startButton = new JButton("Start!");
		startButtonPanel.add(startButton);
		//listener
		startButton.addActionListener(new StartButtonListener());
				
		frame.getContentPane().add(BorderLayout.SOUTH, startButtonPanel);
		frame.getContentPane().add(BorderLayout.CENTER, buttongroupPanel);
				
					
		frame.setVisible(true); 
	}
	
	/*
	 * Method for the GUI1. Add radio button into panel
	 * @param name: the name of the radio button
	 * @param difficulty: the difficulty of the game 1-easy 2-medium 3-hard
	 */
	public void addRadioButton(String name, int difficulty){
		JRadioButton button = new JRadioButton(name, true);
		group.add(button);
		buttongroupPanel.add(button);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gameDifficulty = difficulty;
				
			}
		};
		
		button.addActionListener(listener);
	}
	

	/*
	 * inner class for start button listener
	 */
	class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			//frame.repaint();//can call new GUI?
			new GameView();
		}
	}
	
}
