package com.elliottwahl.ctrllibrary;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.21.2024.001
 * 
 * Responsibilities of class: tests various aspects of the program to ensure values are assigned/retrieved as intended
 * 
 */
class UnitTest {
	private Game game;

	/**
	 * ensure various attributes of a game object are correctly assigned/retrieved
	 */
	@Test
	void testGame() {
		ImageIcon icon = new ImageIcon();
		
		game = new Game("title", "developer", "genre", "path", icon);
		assertEquals("title", game.getTitle());
		game.setTitle("newTitle");
		assertEquals("newTitle", game.getTitle());
		
		assertEquals("developer", game.getDeveloper());
		game.setDeveloper("newDeveloper");
		assertEquals("newDeveloper", game.getDeveloper());
		
		assertEquals("genre", game.getGenre());
		game.setGenre("newGenre");
		assertEquals("newGenre", game.getGenre());
		
		assertEquals("path", game.getPath());
		
		ImageIcon newIcon = new ImageIcon();
		assertEquals(icon, game.getIcon());
		game.setIcon(newIcon);
		assertEquals(newIcon, game.getIcon());
	}
}
