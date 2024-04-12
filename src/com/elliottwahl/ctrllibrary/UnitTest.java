package com.elliottwahl.ctrllibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {
	private Game game;

	@Test
	void testGameTitle() {
		game = new Game("title");
		assertEquals("title", game.getTitle());
		game.setTitle("newTitle");
		assertEquals("newTitle", game.getTitle());
	}

}
