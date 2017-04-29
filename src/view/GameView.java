package view;

import gamecontrol.BoardStatus;
import gamecontrol.ComputerPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView {



	private JFrame frame;
	//GUI2
	private JPanel gamePanel;
	private JPanel gameInfoTopPanel;
	private JPanel gameInfoLeftPanel;
	private JLabel gameStatus;
	private JLabel gameStatus2;
	private JLabel gameStatus3;
	private JLabel cutoffLabel;
	private JLabel maxDepthLabel;
	private JLabel totalNodeLabel;
	private JLabel maxPruneLabel;
	private JLabel minPruneLabel;

	private JButton restartButton;

	private JButton[] boardBtnArray = new JButton[16];


	int gameDiff;
	boolean userPlayFirst;

	BoardStatus boardNow;


	/*
	 * Main playing GUI (GUI2).
	 */
	public void GameView(int gameDifficulty, boolean uPlayFirst){
		this.gameDiff = gameDifficulty;
		this.userPlayFirst = uPlayFirst;

		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);

		//frame
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(30, 30));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		frame.setTitle("Tic-toc-game");
		frame.setSize(800,500);
		frame.setResizable(false);


		//main game panel AND game info panel
		//game board panel
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(4, 4));
		gamePanel.setPreferredSize(new Dimension(400,400));
		addBoard();
		//gamePanel.setBackground(Color.pink);


		// game info panel -- TOP part
		gameInfoTopPanel = new JPanel();
		gameInfoTopPanel.setLayout(new GridLayout(1, 4));

		gameStatus = new JLabel("Game Status");
		gameInfoTopPanel.add(gameStatus);
		addGameInfo2(gameDiff);
		addGameInfo3(userPlayFirst);

		restartButton = new JButton("RE-Start!");
		gameInfoTopPanel.add(restartButton);
		//listener for restart button
		restartButton.addActionListener(new reStartButtonListener());




		////////////////////////////
		/////////////not right//////need modify//////////
		/////////////////////////////////////////
		////////////////////////
		// game info panel -- LEFT part
		gameInfoLeftPanel = new JPanel();
		gameInfoLeftPanel.setLayout(new GridLayout(5, 1));

		cutoffLabel = new JLabel("If Cutoff Occurred?");
		maxDepthLabel = new JLabel("If Max Depth Reached?");
		totalNodeLabel = new JLabel("Total Number of Nodes Generated:");
		maxPruneLabel = new JLabel("Numbers of Pruning Occurred within MAX:");
		minPruneLabel = new JLabel("Numbers of Pruning Occurred within MIN:");

		gameInfoLeftPanel.add(cutoffLabel);
		gameInfoLeftPanel.add(maxDepthLabel);
		gameInfoLeftPanel.add(totalNodeLabel);
		gameInfoLeftPanel.add(maxPruneLabel);
		gameInfoLeftPanel.add(minPruneLabel);


		frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
		frame.getContentPane().add(BorderLayout.NORTH, gameInfoTopPanel);
		frame.getContentPane().add(BorderLayout.WEST, gameInfoLeftPanel);

		frame.setVisible(true);

		/*
		if (!uPlayFirst){
			ComputerPlayer cp = new ComputerPlayer();
			cp.firstStep(boardNow);
		}
		*/
	}


	/*
	 * Method for GUI2. Automatically add game board buttons method
	 */
	public void addBoard(){

		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				this.addBoardButton(i, j);
			}
		}

	}

/*
	/*
	 * Method for GUI2. Add game board buttons
	 * @param x: x value of button position
	 * @param y: y value of button position
	 */
	public void addBoardButton(int x, int y){
		int buttonIndex = 4*x+y;
		this.boardBtnArray[buttonIndex] = new JButton();
		this.boardBtnArray[buttonIndex].setPreferredSize(new Dimension(80, 80));
		this.gamePanel.add(boardBtnArray[buttonIndex]);


		//use anonymous class as listener
		boardBtnArray[buttonIndex].addActionListener(new boardButtonListener(x, y));
	}






	public void addGameInfo2 (int gameDiff) {
		if (gameDiff == 1) {
			this.gameStatus2 = new JLabel("Difficulty: Easy");
		} else if (gameDiff == 2){
			this.gameStatus2 = new JLabel("Difficulty: Intermediate");
		} else if (gameDiff == 3) {
			this.gameStatus2 = new JLabel("Difficulty: Difficult");
		}
		this.gameInfoTopPanel.add(gameStatus2);
	}

	public void addGameInfo3 (boolean userPlayFirst) {
		if (userPlayFirst) {
			this.gameStatus3 = new JLabel("USER plays first");
		} else if (!userPlayFirst){
			this.gameStatus3 = new JLabel("COMPUTER plays first");
		}
		this.gameInfoTopPanel.add(gameStatus3);
	}

	/*
	 * inner class for start button listener
	 */
	class reStartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			//frame.repaint();//can call new GUI?
			frame.setVisible(false);
			GameGui g1 = new GameGui();
			g1.initGUI1();
		}
	}

	/*
	 * inner class for board button listener
	 */
	class boardButtonListener implements ActionListener {
		private int x;
		private int y;

		public void boardButtonListener(int x, int y){
			this.x = x;
			this.y = y;
		}
		public void actionPerformed(ActionEvent event){

		}
	}
}
