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
	private JPanel gamePanel, gameInfoTopPanel, gameInfoLeftPanel;
	private JLabel gameStatus,gameStatus2,gameStatus3;
	private JLabel cutoffLabel, maxDepthLabel, totalNodeLabel, maxPruneLabel, minPruneLabel;

	private JButton restartButton;
	private JButton[] boardBtnArray = new JButton[16];


	int gameDiff;
	boolean userPlayFirst;

	BoardStatus boardNow;
	ComputerPlayer computerPlayerInst;


	/*
	 * Main playing GUI (GUI2).
	 */
	public void GameView(int gameDifficulty, boolean uPlayFirst){
		this.gameDiff = gameDifficulty;
		this.userPlayFirst = uPlayFirst;
		boardNow = new BoardStatus();

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
		gameInfoLeftPanel.setLayout(new GridLayout(10, 1));

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


		computerPlayerInst = new ComputerPlayer();
		computerPlayerInst.setGameDifficulty(gameDiff);
		if (!uPlayFirst){
			computerPlayerInst.firstStep(boardNow);
			boardBtnArray[5].doClick(); //position (1, 1)
		}

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
		this.boardBtnArray[buttonIndex].setFont(new Font("Arial", Font.PLAIN, 60));
		this.boardBtnArray[buttonIndex].setPreferredSize(new Dimension(80, 80));

		//use inner class as listener
		boardBtnArray[buttonIndex].addActionListener(new boardButtonListener(x, y));

		this.gamePanel.add(boardBtnArray[buttonIndex]);
	}






	public void addGameInfo2 (int gameDiff) {
		if (gameDiff == 1) {
			this.gameStatus2 = new JLabel("Difficulty: Easy");
		} else if (gameDiff == 2){
			this.gameStatus2 = new JLabel("Difficulty: Intermediate");
		} else if (gameDiff == 4) {
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
		private int position;
		private int endValue;

		public boardButtonListener(int x, int y){
			this.x = x;
			this.y = y;
			this.position = 4*this.x + this.y;
			//System.out.println(this.x + "   " + this.y + "   " + this.position);

		}

		public void actionPerformed(ActionEvent event){
			//redraw full board?
			/*
			for (int i=0; i<4; i++){
				for (int j=0; j<4; j++){
					if
				}
			}
			*/

			//disable this button
			boardBtnArray[position].setEnabled(false);




			//set button value: X or O? and according to this to
			if (boardNow.getBoardOne(x, y) == 1) { //this is X
				System.out.println("XXXXXXXXXX"+x+y);

				//set button value
				boardBtnArray[position].setText("X");

				//set game info value
				cutoffLabel.setText("If Cutoff Occurred? " + computerPlayerInst.getCutOffOccurred());
				maxDepthLabel.setText("If Max Depth Reached? " + computerPlayerInst.getMaxDepthReached());
				totalNodeLabel.setText("Total Number of Nodes Generated: " + computerPlayerInst.getTotalGenerateNodes());
				maxPruneLabel.setText("Numbers of Pruning Occurred within MAX: " + computerPlayerInst.getPruneMax());
				minPruneLabel.setText("Numbers of Pruning Occurred within MIN: " + computerPlayerInst.getPruneMin());

				//check game terminal
				endValue = boardNow.isTerminal();
				//check game terminal
				if (endValue == 1 || endValue == 2 || endValue == 3) { //game end
					endGame(endValue);
				}

				//then wait and catch user click
				//

			}
			else if (boardNow.getBoardOne(x, y) == 0) { //this is O
				System.out.println("OOOOOOOOOOOOOO"+x+y);
				boardBtnArray[position].setText("O");
				boardNow.setBoardOne(x, y, 10); //give value 10 to announce O for this position in board

				endValue = boardNow.isTerminal();
				//check game terminal
				if (endValue == 1 || endValue == 2 || endValue == 3) { //game end
					endGame(endValue);
				}

				//then wait computer click
				int next = computerPlayerInst.getNextStep(boardNow);
				System.out.println("NNNNNNNNNNNNNNN" + next);
				boardBtnArray[next].doClick();
			}
			else {//no X or O? ERROR catch
				//System.out.println("!!!!!!!!!!!!!");
				/*
				for (int i=0; i<4; i++){
					for (int j=0; j<4; j++){
						System.out.println(i + ", "+ j + "= " + boardNow.getBoardOne(i,j));
					}
				}
				*/
			}






		}
	}

	/*
	 * end game method
	 * @param: int i: 1-X computer win; 2-O player win; 3-draw
	 */
	public void endGame(int i) {
		//disable all buttons
		for (int j=0; j<16; j++) {

			boardBtnArray[j].setEnabled(false);
		}

		//pop out result
		if (i == 1) {
			JOptionPane.showMessageDialog(frame,
					"Computer (X) win!\n"+
					"You can click the restart button to restart.");
		} else if (i == 2) {
			JOptionPane.showMessageDialog(frame,
					"You (O) win!\n"+
					"You can click the restart button to restart.");
		} else if (i == 3) {
			JOptionPane.showMessageDialog(frame,
					"Draw...\n"+
					"You can click the restart button to restart.");
		} else {
			System.out.println("WRONG PARA TO ENDGAME() METHOD");
		}
	}

}
