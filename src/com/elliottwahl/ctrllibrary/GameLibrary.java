package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
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
	private HashMap<Game, String> games; // GameLibrary HAS-A games

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
		games.put(game, game.getPath());
		
		if (games.size() == 1) {
			panel.removeAll();
			panel.setLayout(new GridLayout(0, 4));
			panel.setBackground(Color.DARK_GRAY);
		}
		
		JLabel gameLbl = new JLabel(game.getTitle(), SwingConstants.CENTER);
		gameLbl.setForeground(Color.WHITE);
		panel.add(gameLbl);

		panel.revalidate();
		panel.repaint();
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
