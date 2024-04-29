package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.28.2024.004
 * 
 * Responsibilities of class: manages a collection of game entries, providing functionalities to add, search, and display games
 * 
 */
public class GameLibrary {
	private JPanel panel; // GameLibrary HAS-A panel
	private JLabel noGamesLbl; // GameLibrary HAS-A noGamesLbl
	private HashMap<String, Game> games; // GameLibrary HAS-A games

	/**
	 * initialize a panel to display the library and setup a structure to store games
	 */
	public GameLibrary() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		
		// create a hashmap to store a game object as the value and a game's path as the key
		games = new HashMap<>();
		
		// initialize and configure a label to display when no games are found
		noGamesLbl = new JLabel("No games were found", SwingConstants.CENTER);
		noGamesLbl.setForeground(Color.WHITE);
		noGamesLbl.setFont(new Font("Arial", Font.BOLD, 14));
		noGamesLbl.setVisible(true);
		
		panel.add(noGamesLbl, BorderLayout.CENTER);
	}
	
	/**
	 * initialize panel for individual games
	 * 
	 * @param game
	 * @return gamePanel
	 */
	private JPanel createGamePanel(Game game) {
		// top panel to hold the imgLabel
		JPanel imgPanel = new JPanel(new BorderLayout());
		imgPanel.setPreferredSize(new Dimension(128, 128));
		imgPanel.setBackground(Color.DARK_GRAY);
		
		// main panel for individual games to hold all information
		JPanel gamePanel = new JPanel(new BorderLayout());
		gamePanel.setPreferredSize(new Dimension(128, 150));
		gamePanel.setBackground(Color.DARK_GRAY);
		
		// label to display the game's icon
		JLabel imageLbl = new JLabel(game.getIcon());
		imgPanel.add(imageLbl, BorderLayout.NORTH);
		gamePanel.add(imgPanel);

		// label to display the game's title
		JLabel gameLbl = new JLabel(game.getTitle(), SwingConstants.CENTER);
		gameLbl.setForeground(Color.WHITE);
		gamePanel.add(gameLbl, BorderLayout.SOUTH);
		
		return gamePanel;
	}
	
	/**
	 * adds a Game object to the games map, removing the "no games found" text if games is > 0
	 * prevents adding duplicate games by comparing paths
	 * 
	 * @param game
	 */
	public void addGame(Game game) {
		String path = game.getPath();
		
		if (!games.containsKey(path)) {
			games.put(path, game);
			
			if (games.size() == 1) {
				panel.removeAll();
				panel.setLayout(new FlowLayout());
				panel.setBackground(Color.DARK_GRAY);
			}

			JPanel gamePanel = createGamePanel(game);
			
			panel.add(gamePanel);
			panel.revalidate();
			panel.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "This game is already in your library!", "Duplicate Game", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * searches for games that match the given query
	 * filters games by title and dynamically updates the UI to display only those that contain the query term
	 * 
	 * @param query
	 */
	public void searchFor(String query) {
		panel.removeAll();
		games.values().stream()
			.filter(game -> game.getTitle().toLowerCase().contains(query.toLowerCase()))
			.forEach(game -> {
				JPanel gamePanel  = createGamePanel(game);
				panel.add(gamePanel);
			});
		
		panel.revalidate();
		panel.repaint();
	}
	
	/**
	 * returns the main panel
	 * 
	 * @return panel
	 */
	public JPanel getPanel() {
		return panel;
	}
}
