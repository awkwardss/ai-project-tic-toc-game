package view;

import javax.swing.*;
import java.awt.*;

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
	public void GameView(){
		//better look for frame
		JFrame.setDefaultLookAndFeelDecorated(true);

		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
		frame.setTitle("Tic-toc-game");
		frame.setSize(800,500);
		frame.setResizable(false);


		//main game panel AND game info panel
		gamePanel = new JPanel();
		addChessBoard();


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

	private void addChessBoard(){

	}
	
}
