package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
	private JPanel searchPanel; // NavBar HAS-A searchPanel
	private JPanel buttonPanel; // NavBar HAS-A buttonPanel;
	private GridBagConstraints gbc; // NavBar HAS-A gbc;
	
	public NavBar() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(0, 50));
		
		searchPanel = new JPanel(new GridBagLayout());
		searchPanel.setBackground(Color.DARK_GRAY);
		
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 10, 0, 10);
		
		addGameBtn = new JButton();
		addGameBtn.setText("Add Game");
		addGameBtn.setBackground(Color.GRAY);
		addGameBtn.setForeground(Color.WHITE);
		addGameBtn.setFocusPainted(false);		
		buttonPanel.add(addGameBtn, gbc);
		panel.add(buttonPanel, BorderLayout.WEST);
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(200, 30));
		searchPanel.add(searchField, gbc);
		panel.add(searchPanel, BorderLayout.EAST);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}