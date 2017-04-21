package view;

import javax.swing.*;

public class GameView {
	//GUI2
	private JPanel gamePanel;
	private JPanel gameInfoPanel;
	private JLabel gameStatus;
	private JLabel cutoffLabel;
	private JLabel maxDepthLabel;
	private JLabel totalNodeLabel;
	private JLabel maxPruneLabel;
	private JLabel minPruneLabel;

	public void GameView(){
		gamePanel = new JPanel();
		gameInfoPanel = new JPanel();

		gameStatus = new JLabel("Game Status:");
		cutoffLabel = new JLabel("If Cutoff Occurred?");
		maxDepthLabel = new JLabel("If Max Depth Reached?");
		totalNodeLabel = new JLabel("Total Number of Nodes Generated:");
		maxPruneLabel = new JLabel("Numbers of Pruning Occurred within MAX:");
		minPruneLabel = new JLabel("Numbers of Pruning Occurred within MIN:");
	}
	
}
