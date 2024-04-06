import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.5.2024.001
 * 
 * Responsibilities of class:
 * 
 */

// AddGame IS-A JPanel
public class AddGame extends JPanel {
	private static final long serialVersionUID = 1L; // temporary, just here to get rid of warning for now
	
	private JButton addButton; // AddGame HAS-A addButton
	private JDialog addDialog; // AddGame HAS-A addDialog
	private JFileChooser fileChooser; // AddGame HAS-A fileChooser
	private JButton browseButton; // AddGame HAS-A browseButton
	private GameLibrary gameLibrary; // AddGame HAS-A library
	
	public AddGame(JFrame frame, GameLibrary library) {
		this.setLayout(new BorderLayout());
		this.gameLibrary = library;
		
		addButton = new JButton("add game");
		addButton.setBackground(Color.GRAY);
		addButton.setFocusPainted(false);
		
		addDialog = new JDialog(frame, "enter game details", true);
		addDialog.setLayout(new FlowLayout(FlowLayout.LEFT));
		addDialog.setSize(450, 400);
		addDialog.setLocationRelativeTo(frame);
		
		browseButton = new JButton();
		browseButton.setFocusPainted(false);
		browseButton.setText("Browse");
		
		addDialog.add(browseButton);
		
		fileChooser = new JFileChooser();
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog.setVisible(true);
			}
		});
		
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(frame);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					java.io.File gameFile = fileChooser.getSelectedFile();
					
					Game game = new Game(gameFile.getName());
					
					gameLibrary.addGame(game);
				}
			}
		});
		
		this.add(addButton, BorderLayout.CENTER);
	}
}
