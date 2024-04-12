package com.elliottwahl.ctrllibrary;

import javax.swing.SwingUtilities;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.9.2024.004
 * 
 * Responsibilities of class:
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
