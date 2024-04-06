import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
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
	
	public AddGame() {
		this.setLayout(new BorderLayout());
		
		addButton = new JButton("add game");
		addButton.setBackground(Color.GRAY);
		addButton.setFocusPainted(false);
		
		this.add(addButton, BorderLayout.CENTER);
	}
}
