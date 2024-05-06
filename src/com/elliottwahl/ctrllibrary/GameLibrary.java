package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.5.2024.006
 * 
 * Responsibilities of class: manages a collection of game entries, providing functionalities to add, search, and display games
 * 
 */
public class GameLibrary {
	private static JPanel panel; // GameLibrary HAS-A panel
	private static JLabel noGamesLbl; // GameLibrary HAS-A noGamesLbl
	private static HashMap<String, Game> games; // GameLibrary HAS-A games

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
	 * persists the current state of the games HashMap to 'games.txt'
	 */
	private void saveLibrary() {
		try {
			FileOutputStream fileOut = new FileOutputStream("games.txt");
			
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(games);
			
			fileOut.close();
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * loads the games HashMap data from 'games.txt'
	 */
	public static void loadLibrary() {
		File file = new File("games.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (file.length() != 0) {
			try {
				FileInputStream fileIn = new FileInputStream(file);
				
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				
				HashMap<String, Game> newGames = (HashMap<String, Game>) objIn.readObject();
				
				if (newGames != null) {
					games = newGames;
					refreshUI();
				}
				
				fileIn.close();
				objIn.close();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * refreshes the UI to reflect the current state of the games HashMap
	 */
	private static void refreshUI() {
		panel.removeAll();
		if (games.isEmpty()) {
			panel.add(noGamesLbl);
		} else {
			panel.setLayout(new FlowLayout());
			for (Game game : games.values()) {
				JPanel gamePanel = createGamePanel(game);
				panel.add(gamePanel);
			}
		}
		
		panel.revalidate();
		panel.repaint();
	}
	
	/**
	 * initialize panel for individual games
	 * 
	 * @param game
	 * @return gamePanel
	 */
	private static JPanel createGamePanel(Game game) {
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
			
			saveLibrary();
			
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
		if (games.size() > 1) {
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
