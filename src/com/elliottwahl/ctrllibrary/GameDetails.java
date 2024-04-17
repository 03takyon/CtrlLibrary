package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.16.2024.002
 * 
 * Responsibilities of class:
 * 
 */
public class GameDetails {
	private JDialog detailsDialog; // GameDetails HAS-A detailsDialog
	private JButton browseBtn; // GameDetails HAS-A browseBtn
	private JPanel panel; // GameDetails HAS-A panel
	private JFileChooser fileChooser; // GameDetails HAS-A fileChooser
	private JLabel titleLbl; // GameDetails HAS-A titleLabel
	private JLabel changeTitleLbl; // GameDetails HAS-A changeTitleLbl
	private JPanel editPanel; // GameDetails HAS-A editPanel
	private JPanel selectPanel; // GameDetails HAS-A selectPanel
	private JTextField changeTitleFld; // GameDetails HAS-A changeTitleFld;
	private JButton submitBtn; // GameDetails HAS-A submitBtn
	private JPanel submitPanel; // GameDetails HAS-A submitPanel
	private File selectedFile; // GameDetails HAS-A selectedFile
	
	public GameDetails(GameLibrary gameLibrary) {
		detailsDialog = new JDialog();
		detailsDialog.setSize(410, 350);
		detailsDialog.setLocationRelativeTo(null);
		detailsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		detailsDialog.add(panel);
		
		selectPanel = new JPanel();
		selectPanel.setBackground(Color.DARK_GRAY);
		selectPanel.setPreferredSize(new Dimension(0, 50));
		panel.add(selectPanel, BorderLayout.NORTH);
		
		editPanel = new JPanel();
		editPanel.setBackground(Color.DARK_GRAY);
		panel.add(editPanel);
		
		changeTitleLbl = new JLabel("Title: ");
		changeTitleLbl.setForeground(Color.WHITE);
		editPanel.add(changeTitleLbl);
		
		changeTitleFld = new JTextField();
		changeTitleFld.setPreferredSize(new Dimension(200, 30));
		changeTitleFld.setBackground(Color.GRAY);
		changeTitleFld.setForeground(Color.WHITE);
		editPanel.add(changeTitleFld);
		
		submitPanel = new JPanel();
		submitPanel.setBackground(Color.DARK_GRAY);
		panel.add(submitPanel, BorderLayout.SOUTH);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBackground(Color.GRAY);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFocusPainted(false);
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newTitle = changeTitleFld.getText();
				
				if (newTitle.isEmpty()) {
					Game game = new Game(selectedFile.getName(), selectedFile.getAbsolutePath());
					
					gameLibrary.addGame(game);
				} else {
					Game game = new Game(newTitle, selectedFile.getAbsolutePath());
					
					gameLibrary.addGame(game);
				}
			}
		});
		submitPanel.add(submitBtn);
		
		fileChooser = new JFileChooser();

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
					selectedFile = fileChooser.getSelectedFile();
					
					titleLbl.setText(selectedFile.getName());
				}
			}
		});
		
		titleLbl = new JLabel("No file selected");
		titleLbl.setForeground(Color.WHITE);
		
		selectPanel.add(browseBtn);
		selectPanel.add(titleLbl);
		
		detailsDialog.setVisible(true);
	}
}
