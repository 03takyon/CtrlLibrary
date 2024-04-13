package com.elliottwahl.ctrllibrary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.13.2024.001
 * 
 * Responsibilities of class:
 * 
 */
public class GameDetails {
	private JDialog detailsDialog; // GameDetails HAS-A detailsDialog
	private JButton browseBtn; // GameDetails HAS-A browseBtn
	private JPanel panel; // GameDetails HAS-A panel
	private JFileChooser fileChooser; // GameDetails HAS-A fileChooser
	private JLabel pathLabel; // GameDetails HAS-A pathLabel
	
	public GameDetails(GameLibrary gameLibrary) {
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		fileChooser = new JFileChooser();
		
		detailsDialog = new JDialog();
		detailsDialog.setSize(410, 350);
		detailsDialog.setLocationRelativeTo(null);
		detailsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		detailsDialog.add(panel);

		browseBtn = new JButton();
		browseBtn.setText("Browse...");
		browseBtn.setBackground(Color.GRAY);
		browseBtn.setForeground(Color.WHITE);
		browseBtn.setFocusPainted(false);
		browseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = fileChooser.showOpenDialog(detailsDialog);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					
					pathLabel.setText(selectedFile.getName());
					
					Game game = new Game(selectedFile.getName(), selectedFile.getName());
					
					gameLibrary.addGame(game);
				}
			}
		});
		
		pathLabel = new JLabel("No file selected");
		pathLabel.setForeground(Color.WHITE);
		
		panel.add(browseBtn);
		panel.add(pathLabel);
		
		detailsDialog.setVisible(true);
	}
}
