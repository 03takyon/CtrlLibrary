package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.21.2024.004
 * 
 * Responsibilities of class: creating and managing the navigation bar to add and search for games
 * 
 */
public class NavBar {
	private JPanel panel; // NavBar HAS-A panel
	private JButton addGameBtn; // NavBar HAS-A addGameBtn
	private JTextField searchField; // NavBar HAS-A searchField
	private JPanel searchPanel; // NavBar HAS-A searchPanel
	private JPanel buttonPanel; // NavBar HAS-A buttonPanel;
	private GridBagConstraints gbc; // NavBar HAS-A gbc;
	
	/**
	 * initialize the navigation bar, creating and displaying a button and search field
	 * 
	 * @param gameLibrary
	 */
	public NavBar(GameLibrary gameLibrary) {
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
		addGameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameDetails(gameLibrary);
			}
		});
		
		buttonPanel.add(addGameBtn, gbc);
		panel.add(buttonPanel, BorderLayout.WEST);
		
		/**
		 * DocumentListener allows for real-time searches
		 */
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(200, 30));
		searchField.setBackground(Color.GRAY);
		searchField.setForeground(Color.WHITE);
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			
			private void search() {
				String searchText = searchField.getText();
				gameLibrary.searchFor(searchText);
			}
		});
		searchPanel.add(searchField, gbc);
		panel.add(searchPanel, BorderLayout.EAST);
	}
	
	/**
	 * returns the panel
	 * 
	 * @return panel
	 */
	public JPanel getPanel() {
		return panel;
	}
}
