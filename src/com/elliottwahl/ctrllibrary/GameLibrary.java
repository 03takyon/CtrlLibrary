package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

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
	private ArrayList<Game> games; // GameLibrary HAS-A games

	public GameLibrary() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		
		games = new ArrayList<>();
		
		noGamesLbl = new JLabel("No games were found", SwingConstants.CENTER);
		noGamesLbl.setForeground(Color.WHITE);
		noGamesLbl.setFont(new Font("Arial", Font.BOLD, 14));
		
		if (games.isEmpty()) {
			noGamesLbl.setVisible(true);
		}
		
		panel.add(noGamesLbl, BorderLayout.CENTER);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
