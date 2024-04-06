import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class UserInterface {
	public static void main(String[] args) {
		JFrame frame = new JFrame("CtrlLibrary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.GRAY);
		
		NavBar navBar = new NavBar();
		
		frame.add(navBar, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}
