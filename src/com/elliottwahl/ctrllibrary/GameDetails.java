package com.elliottwahl.ctrllibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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
 * Version/date: 4.18.2024.003
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
	private File selectedGame; // GameDetails HAS-A selectedGame
	private JButton selectImgBtn; // GameDetails HAS-A selectImgBtn
	private JPanel imgPanel; // GameDetails HAS-A imgPanel
	private JPanel selectImgPanel; //GameDetails HAS-A selectImgPanel
	private JLabel imgLabel; // GameDetails HAS-A imgLabel
	private ImageIcon resizedIcon; // GameDetails HAS-A resizedIcon
	private ImageIcon newIcon; // GameDetails HAS-A newIcon
	
	public GameDetails(GameLibrary gameLibrary) {
		detailsDialog = new JDialog();
		detailsDialog.setSize(410, 350);
		detailsDialog.setLocationRelativeTo(null);
		detailsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		resizedIcon = new ImageIcon("images/default.jpg");
		
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
					Game game = new Game(selectedGame.getName(), selectedGame.getAbsolutePath(), resizedIcon);
					
					gameLibrary.addGame(game);
				} else {
					Game game = new Game(newTitle, selectedGame.getAbsolutePath(), resizedIcon);
					
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
					selectedGame = fileChooser.getSelectedFile();
					
					titleLbl.setText(selectedGame.getName());
				}
			}
		});
		
		titleLbl = new JLabel("No file selected");
		titleLbl.setForeground(Color.WHITE);
		
		selectPanel.add(browseBtn);
		selectPanel.add(titleLbl);
		
		imgPanel = new JPanel(new BorderLayout());
		imgPanel.setPreferredSize(new Dimension(128, 128));
		imgPanel.setBackground(Color.DARK_GRAY);
		
		imgLabel = new JLabel(resizedIcon);
		imgPanel.add(imgLabel);
		
		panel.add(imgPanel, BorderLayout.EAST);
		
		selectImgPanel = new JPanel();
		selectImgPanel.setBackground(Color.DARK_GRAY);
		
		selectImgBtn = new JButton("Select Image");
		selectImgBtn.setBackground(Color.GRAY);
		selectImgBtn.setForeground(Color.WHITE);
		selectImgBtn.setFocusPainted(false);
		selectImgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = fileChooser.showOpenDialog(detailsDialog);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					File selectedImage = fileChooser.getSelectedFile();
					
					newIcon = new ImageIcon(selectedImage.getPath());
					
					resizedIcon = resizeIcon(newIcon, imgPanel.getWidth(), imgPanel.getHeight());
					
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
	
	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		return new ImageIcon(resizedImage);
	}
}
