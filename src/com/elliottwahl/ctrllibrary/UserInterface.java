package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.9.2024.001
 * 
 * Responsibilities of class:
 * 
 */
public class UserInterface {
	private JFrame frame; // UserInterface HAS-A frame
	private JPanel panel; // UserInterface HAS-A panel
	private NavBar navBar; // UserInterface HAS-A navBar
	private GameLibrary gameLibrary; // UserInterface HAS-A gameLibrary
	
	public UserInterface() {
		frame = new JFrame("CtrlLibrary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 700);
		
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		frame.add(panel);
		
		navBar = new NavBar();
		panel.add(navBar.getPanel(), BorderLayout.NORTH);
		
		gameLibrary = new GameLibrary();
		panel.add(gameLibrary.getPanel(), BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
