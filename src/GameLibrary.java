import java.awt.Color;
import java.awt.GridLayout;

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
		this.setBackground(Color.GRAY);
	}
}
