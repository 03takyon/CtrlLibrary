package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
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
 * Version/date: 5.16.2024.005
 * 
 * Responsibilities of class: creating and managing the GUI for editing and updating the properties of a game
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
	private File selectedGame; // GameDetails HAS-A selectedGame
	private JButton selectImgBtn; // GameDetails HAS-A selectImgBtn
	private JPanel imgPanel; // GameDetails HAS-A imgPanel
	private JPanel selectImgPanel; //GameDetails HAS-A selectImgPanel
	private JLabel imgLabel; // GameDetails HAS-A imgLabel
	private ImageIcon resizedIcon; // GameDetails HAS-A resizedIcon
	private ImageIcon newIcon; // GameDetails HAS-A newIcon
	private JLabel changeGenreLbl; // GameDetails HAS-A changeGenreLbl
	private JTextField changeGenreFld; // GameDetails HAS-A changeGenreFld
	private JLabel changeDevLbl; // GameDetails HAS-A changeDevLbl
	private JTextField changeDevFld; // GameDetails HAS-A changeDevFld
	private GridBagConstraints gbc; // GameDetails HAS-A gbc
	
	/**
	 * initialize and display a configuration dialog for managing game properties
	 * 
	 * @param gameLibrary
	 */
	public GameDetails(GameLibrary gameLibrary) {
		gbc = new GridBagConstraints();
		
		// setup the main dialog window for game details
		detailsDialog = new JDialog();
		detailsDialog.setSize(410, 350);
		detailsDialog.setLocationRelativeTo(null);
		detailsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		// set the default icon for game details
		resizedIcon = new ImageIcon("images/default.jpg");
		
		// main panel configuration
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		detailsDialog.add(panel);
		
		// top panel for file selection
		selectPanel = new JPanel();
		selectPanel.setBackground(Color.DARK_GRAY);
		selectPanel.setPreferredSize(new Dimension(0, 50));
		panel.add(selectPanel, BorderLayout.NORTH);
		
		// middle panel for editing title
		editPanel = new JPanel(new GridBagLayout());
		editPanel.setBackground(Color.DARK_GRAY);
		panel.add(editPanel, BorderLayout.CENTER);
		
		// title label and text field
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		changeTitleLbl = new JLabel("Title: ");
		changeTitleLbl.setForeground(Color.WHITE);
		editPanel.add(changeTitleLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		changeTitleFld = new JTextField(20);
		changeTitleFld.setBackground(Color.GRAY);
		changeTitleFld.setForeground(Color.WHITE);
		Dimension size = new Dimension(150, 30);
		changeTitleFld.setPreferredSize(size);
		changeTitleFld.setMinimumSize(size);
		changeTitleFld.setMaximumSize(size);
		editPanel.add(changeTitleFld, gbc);

		// genre label and text field
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		changeGenreLbl = new JLabel("Genre: ");
		changeGenreLbl.setForeground(Color.WHITE);
		editPanel.add(changeGenreLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		changeGenreFld = new JTextField(20);
		changeGenreFld.setBackground(Color.GRAY);
		changeGenreFld.setForeground(Color.WHITE);
		changeGenreFld.setPreferredSize(size);
		changeGenreFld.setMinimumSize(size);
		changeGenreFld.setMaximumSize(size);
		editPanel.add(changeGenreFld, gbc);

		// developer label and text field
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		changeDevLbl = new JLabel("Developer: ");
		changeDevLbl.setForeground(Color.WHITE);
		editPanel.add(changeDevLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		changeDevFld = new JTextField(20);
		changeDevFld.setBackground(Color.GRAY);
		changeDevFld.setForeground(Color.WHITE);
		changeDevFld.setPreferredSize(size);
		changeDevFld.setMinimumSize(size);
		changeDevFld.setMaximumSize(size);
		editPanel.add(changeDevFld, gbc);
		
		// bottom panel for submit button
		submitPanel = new JPanel();
		submitPanel.setBackground(Color.DARK_GRAY);
		panel.add(submitPanel, BorderLayout.SOUTH);
		
		// submit button to apply changes
		submitBtn = new JButton("Submit");
		submitBtn.setBackground(Color.GRAY);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFocusPainted(false);
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// create and add a new game object with the updated title
				String newTitle = changeTitleFld.getText();
				String newGenre = changeGenreFld.getText();
				String newDev = changeDevFld.getText();
				
				if (newTitle.isEmpty()) {
					Game game = new Game(selectedGame.getName(), newDev, newGenre, selectedGame.getAbsolutePath(), resizedIcon);
					
					gameLibrary.addGame(game);
				} else {
					Game game = new Game(newTitle, newDev, newGenre, selectedGame.getAbsolutePath(), resizedIcon);
					
					gameLibrary.addGame(game);
				}
			}
		});
		submitPanel.add(submitBtn);
		
		// file chooser for selecting game executable
		fileChooser = new JFileChooser();

		// button for browsing files
		browseBtn = new JButton();
		browseBtn.setText("Browse...");
		browseBtn.setBackground(Color.GRAY);
		browseBtn.setForeground(Color.WHITE);
		browseBtn.setFocusPainted(false);
		browseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open file dialog and update label with selected file's name
				int option = fileChooser.showOpenDialog(detailsDialog);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					selectedGame = fileChooser.getSelectedFile();
					
					titleLbl.setText(selectedGame.getName());
				}
			}
		});
		
		titleLbl = new JLabel("No file selected");
		titleLbl.setForeground(Color.WHITE);
		
		selectPanel.add(browseBtn);
		selectPanel.add(titleLbl);
		
		// panel for displaying and updating game icon
		imgPanel = new JPanel(new BorderLayout());
		imgPanel.setPreferredSize(new Dimension(128, 128));
		imgPanel.setBackground(Color.DARK_GRAY);
		
		imgLabel = new JLabel(resizedIcon);
		imgPanel.add(imgLabel);
		
		panel.add(imgPanel, BorderLayout.EAST);
		
		// right panel for displaying game icon
		selectImgPanel = new JPanel();
		selectImgPanel.setBackground(Color.DARK_GRAY);
		
		// button for selecting a new game icon
		selectImgBtn = new JButton("Select Image");
		selectImgBtn.setBackground(Color.GRAY);
		selectImgBtn.setForeground(Color.WHITE);
		selectImgBtn.setFocusPainted(false);
		selectImgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open file dialog to select a new image to use as the icon
				int option = fileChooser.showOpenDialog(detailsDialog);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					File selectedImage = fileChooser.getSelectedFile();
					
					newIcon = new ImageIcon(selectedImage.getPath());
					
					resizedIcon = resizeIcon(newIcon, 128, 128);
					
					imgLabel.setIcon(resizedIcon);
					imgPanel.revalidate();
					imgPanel.repaint();
				}
			}
		});
		selectImgPanel.add(selectImgBtn);
		
		imgPanel.add(selectImgPanel, BorderLayout.SOUTH);
		
		detailsDialog.setVisible(true);
	}
	
	/**
	 * resizes an icon to specified dimensions, maintaining aspect ratio for consistency
	 * 
	 * @param icon
	 * @param width
	 * @param height
	 * @return resizedImage
	 */
	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		return new ImageIcon(resizedImage);
	}
}
