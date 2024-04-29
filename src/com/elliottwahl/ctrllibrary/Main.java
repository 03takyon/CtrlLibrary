package com.elliottwahl.ctrllibrary;

import javax.swing.SwingUtilities;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.28.2024.005
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
			}
		});
	}
}
