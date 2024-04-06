import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.5.2024.002
 * 
 * Responsibilities of class:
 * 
 */

// NavBar IS-A JPanel
public class NavBar extends JPanel {
	private static final long serialVersionUID = 1L; // temporary, just here to get rid of warning for now
	
	private SearchField searchField; // NavBar HAS-A searchField
	private AddGame addGame; // NavBar HAS-A addGame
	
	public NavBar() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		
		searchField = new SearchField();
		
		addGame = new AddGame();
		
		this.add(searchField, BorderLayout.EAST);
		this.add(addGame, BorderLayout.WEST);
	}
}
