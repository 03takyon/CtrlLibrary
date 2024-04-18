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
 * Version/date: 4.11.2024.002
 * 
 * Responsibilities of class:
 * 
 */
public class GameLibrary {
	private JPanel panel; // GameLibrary HAS-A panel
	private JLabel noGamesLbl; // GameLibrary HAS-A noGamesLbl
	private HashMap<String, Game> games; // GameLibrary HAS-A games

	public GameLibrary() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		
		games = new HashMap<>();
		
		noGamesLbl = new JLabel("No games were found", SwingConstants.CENTER);
		noGamesLbl.setForeground(Color.WHITE);
		noGamesLbl.setFont(new Font("Arial", Font.BOLD, 14));
		noGamesLbl.setVisible(true);
		
		panel.add(noGamesLbl, BorderLayout.CENTER);
	}
	
	public void addGame(Game game) {
		String path = game.getPath();
		
		if (!games.containsKey(path)) {
			games.put(path, game);
			
			if (games.size() == 1) {
				panel.removeAll();
				panel.setLayout(new FlowLayout());
				panel.setBackground(Color.DARK_GRAY);
			}
			
			JPanel gamePanel = new JPanel(new BorderLayout());
			gamePanel.setPreferredSize(new Dimension(128, 150));
			gamePanel.setBackground(Color.DARK_GRAY);

			JLabel gameLbl = new JLabel(game.getTitle(), SwingConstants.CENTER);
			gameLbl.setForeground(Color.WHITE);
			gamePanel.add(gameLbl, BorderLayout.SOUTH);

			panel.add(gamePanel);
			panel.revalidate();
			panel.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "This game is already in your library!", "Duplicate Game", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public JPanel getPanel() {
		return panel;
	}
}
