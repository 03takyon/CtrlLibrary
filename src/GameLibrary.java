import java.awt.GridLayout;

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

// GameLibrary IS-A JPanel
public class GameLibrary extends JPanel {
	private static final long serialVersionUID = 1L; // temporary, just here to get rid of warning for now
	
	public GameLibrary() {
		this.setLayout(new GridLayout(3, 0));
		
		// adding placeholder buttons to visualize the grid layout
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton("Placeholder " + i);
			this.add(button);
		}
	}
}
