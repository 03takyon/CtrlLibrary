import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
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
	
	public AddGame(JFrame frame) {
		this.setLayout(new BorderLayout());
		
		addButton = new JButton("add game");
		addButton.setBackground(Color.GRAY);
		addButton.setFocusPainted(false);
		
		addDialog = new JDialog(frame, "enter game details", true);
		addDialog.setSize(450, 400);
		addDialog.setLocationRelativeTo(frame);
		
		addButton.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog.setVisible(true);
			}
		});
		
		this.add(addButton, BorderLayout.CENTER);
	}
}
