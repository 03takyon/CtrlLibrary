import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.9.2024.002
 * 
 * Responsibilities of class:
 * 
 */
public class UserInterface {
	JFrame frame; // UserInterface HAS-A frame
	GameLibrary gameLibrary; // UserInterface HAS-A UserInterface
	NavBar navBar; // UserInterface HAS-A navBar
	
	public UserInterface() {
		frame = new JFrame("CtrlLibrary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.GRAY);
		
		gameLibrary = new GameLibrary();
		
		navBar = new NavBar(frame, gameLibrary);
		
		frame.add(navBar, BorderLayout.NORTH);
		frame.add(gameLibrary, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
