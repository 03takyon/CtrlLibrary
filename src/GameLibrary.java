import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
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
	private List<Game> games = new ArrayList<>();
	
	public GameLibrary() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.GRAY);
	}
	
	public void addGame(Game game) {
		games.add(game);
		this.add(new JLabel(game.getTitle()));
		this.revalidate();
	}
}
