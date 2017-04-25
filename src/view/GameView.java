package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView {



	private JFrame frame;
	//GUI2
	private JPanel gamePanel;
	private JPanel gameInfoPanel;
	private JLabel gameStatus;
	private JLabel cutoffLabel;
	private JLabel maxDepthLabel;
	private JLabel totalNodeLabel;
	private JLabel maxPruneLabel;
	private JLabel minPruneLabel;


	/*
	 * Main playing GUI (GUI2).
	 */
	public void GameView(int gameDifficulty, boolean compPlayFirst){
		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);

		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		frame.setTitle("Tic-toc-game");
		frame.setSize(800,500);
		frame.setResizable(false);


		//main game panel AND game info panel
		//game board panel
		gamePanel = new JPanel();
		//gamePanel.add(new boardComponent());
		addBoard();
		//gamePanel.setBackground(Color.pink);


		// game info panel
		gameInfoPanel = new JPanel();
		gameInfoPanel.setLayout(new GridLayout(6, 1));

		////////////////////////////
		/////////////not right//////need modify//////////
		/////////////////////////////////////////
		////////////////////////
		gameStatus = new JLabel("Game Status:");
		cutoffLabel = new JLabel("If Cutoff Occurred?");
		maxDepthLabel = new JLabel("If Max Depth Reached?");
		totalNodeLabel = new JLabel("Total Number of Nodes Generated:");
		maxPruneLabel = new JLabel("Numbers of Pruning Occurred within MAX:");
		minPruneLabel = new JLabel("Numbers of Pruning Occurred within MIN:");
		gameInfoPanel.add(gameStatus);
		gameInfoPanel.add(cutoffLabel);
		gameInfoPanel.add(maxDepthLabel);
		gameInfoPanel.add(totalNodeLabel);
		gameInfoPanel.add(maxPruneLabel);
		gameInfoPanel.add(minPruneLabel);

		frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
		frame.getContentPane().add(BorderLayout.WEST, gameInfoPanel);

		frame.setVisible(true);
	}


	public void addBoard(){
		//JLabel way: not used
		//JLabel boardLabel = new JLabel(new ImageIcon("img/board.png"));
		//gamePanel.add(BorderLayout.CENTER, boardLabel);

		//JPanel way:
		JPanel boardPanel = new BoardPanel();
		boardPanel.setPreferredSize(new Dimension(405, 405)); //board pic size 405*405
		gamePanel.add(boardPanel);

	}

	public class BoardPanel extends JPanel {
		/*
		private Image board;
		public BoardPanel(){
			try {
				board = ImageIO.read(new File("img/board.png"));
			} catch (IOException ex) {
				System.out.print("Fail to read board image!");
			}
		}
		*/

		private  ImageIcon icon;
		private Image board;
		public BoardPanel() {
			icon =  new ImageIcon("img/board.png");
			board = icon.getImage();
		}


		@Override
		public void paintComponent (Graphics g) {
			//super.paintComponent(g);
			g.drawImage(board, 0, 0, icon.getIconWidth(),icon.getIconHeight(), null);

		}
	}
	
}
