package com.elliottwahl.ctrllibrary;

import javax.swing.SwingUtilities;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.3.2024.006
 * 
 * Responsibilities of class: initiate the application, utilizing 'SwingUtilities.invokeLater' to safely start up the GUI in the
 * Event Dispatch Thread
 * 
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new UserInterface();
				
				GameLibrary.loadLibrary();
			}
		});
	}
}
