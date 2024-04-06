import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.5.2024.003
 * 
 * Responsibilities of class:
 * 
 */
public class UserInterface {
	public static void main(String[] args) {
		JFrame frame = new JFrame("CtrlLibrary"); // UserInterface HAS-A frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.GRAY);
		
		NavBar navBar = new NavBar(frame); // UserInterface HAS-A navBar
		
		GameLibrary gameLibrary = new GameLibrary(); // UserInterface HAS-A UserInterface
		
		frame.add(navBar, BorderLayout.NORTH);
		frame.add(gameLibrary, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
