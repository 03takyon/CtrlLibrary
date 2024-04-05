import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class NavBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public NavBar() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(800, 50));
	}
}
