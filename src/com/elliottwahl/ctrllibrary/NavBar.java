package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.11.2024.002
 * 
 * Responsibilities of class:
 * 
 */
public class NavBar {
	private JPanel panel; // NavBar HAS-A panel
	private JButton addGameBtn; // NavBar HAS-A addGameBtn
	private JTextField searchField; // NavBar HAS-A searchField
	
	public NavBar() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(0, 50));
		
		addGameBtn = new JButton();
		addGameBtn.setText("Add Game");
		addGameBtn.setBackground(Color.GRAY);
		addGameBtn.setForeground(Color.WHITE);
		addGameBtn.setFocusPainted(false);
		panel.add(addGameBtn, BorderLayout.WEST);
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(200, 0));
		panel.add(searchField, BorderLayout.EAST);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
