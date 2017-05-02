package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * GUI file for game. Contains GUI page: GUI1
 * GUI 1 is the GUI page for playing order and difficulty choices
 * For easy level: computer will only generate 1 layer nodes.
 * For medium level: will generate 5 layers nodes.
 * For hard level: will generate 8 layers nodes. (9 layers computing will exceed the 10 seconds computing time limit for my computer)
 */

public class GameGui{
	
	int gameDifficulty = 1;
	boolean userPlayFirst = true;
		
	private JFrame frame;
	//GUI1
	private JPanel startButtonPanel;
	private JPanel orderGroupPanel;
	private JPanel buttonGroupPanel;
	private JButton startButton;
	private JLabel diffLabel;
	private ButtonGroup group;
	private ButtonGroup group2;
	private JLabel orderLabel;
	
	
	/*
	 * First GUI page method: choose game difficulty and start button
	 */
	public void initGUI1(){
		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		frame.setTitle("Tic-toc-game");
		frame.setSize(500,300);
		frame.setResizable(false);
			
		//difficulty choose box AND order choose box AND start button: 3 panels
		//use JPanel to store buttons
		buttonGroupPanel = new JPanel();
		buttonGroupPanel.setLayout(new GridLayout(4, 1));//use grid layout for button list
		//buttonGroupPanel.setLayout(new BoxLayout(buttongroupPanel, BoxLayout.Y_AXIS));
		diffLabel = new JLabel("Please choose difficult level:");
		buttonGroupPanel.add(diffLabel);
		//radio button for difficulty
		group = new ButtonGroup();
		addRadioButton("Easy", 1);
		addRadioButton("Intermediate", 5);
		addRadioButton("Difficult", 8);

		//Playing order choosing radio box
		orderGroupPanel = new JPanel();
		orderGroupPanel.setLayout(new GridLayout(3, 1));
		orderLabel = new JLabel("Please choose playing first or second:");
		orderGroupPanel.add(orderLabel);
		group2 = new ButtonGroup();
		addOrderRadioButton("Play first", true);
		addOrderRadioButton("Play second", false);


		//start button panel
		startButtonPanel = new JPanel();
		startButton = new JButton("Start!");
		startButtonPanel.add(startButton);
		//listener for start button
		startButton.addActionListener(new StartButtonListener());
				
		frame.getContentPane().add(BorderLayout.SOUTH, startButtonPanel);
		frame.getContentPane().add(BorderLayout.CENTER, buttonGroupPanel);
		frame.getContentPane().add(BorderLayout.NORTH, orderGroupPanel);
				
					
		frame.setVisible(true); 
	}
	
	/*
	 * Method for the GUI1. Add radio button into difficulty choosing panel
	 * @param name: the name of the radio button
	 * @param difficulty: the difficulty of the game 1-easy 2-medium 3-hard
	 */
	public void addRadioButton(String name, int difficulty){
		JRadioButton button = new JRadioButton(name, true);
		group.add(button);
		buttonGroupPanel.add(button);

		//use anonymous class as listener
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameDifficulty = difficulty;
			}
		});

	}
	
	/*
	 * Method for GUI1. Add radio button to order choosing panel
	 * @param name: name of radio button
	 * @param order: boolean for play order: T - user play first; F - user play second.
	 */
	public void addOrderRadioButton(String name, boolean order){
		JRadioButton button = new JRadioButton(name, true);
		group2.add(button);
		orderGroupPanel.add(button);


		//use anonymous class as listener
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userPlayFirst = order;
			}
		});


	}

	/*
	 * inner class for start button listener
	 * Once user click start button will jump to GUI2.
	 */
	class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			//frame.repaint();//can call new GUI?
			frame.setVisible(false);
			GameView g2 = new GameView();
			g2.GameView(gameDifficulty, userPlayFirst);
		}
	}
	
}
