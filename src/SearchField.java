import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.5.2024.001
 * 
 * Responsibilities of class:
 * 
 */

// SearchField IS-A JPanel
public class SearchField extends JPanel {
	private static final long serialVersionUID = 1L; // temporary, just here to get rid of warning for now
	
	private JTextField textField; // SearchField HAS-A textField;
	private Dimension preferredSize; // SearchField HAS-A preferredSize;
	
	public SearchField() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setBackground(Color.DARK_GRAY);
		
		textField = new JTextField(20);

		preferredSize = textField.getPreferredSize();
		preferredSize.height = 40;
		
		textField.setPreferredSize(preferredSize);
		
		this.add(textField);
	}
}
