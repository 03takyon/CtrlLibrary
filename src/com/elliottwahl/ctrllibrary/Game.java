package com.elliottwahl.ctrllibrary;
/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.11.2024.002
 * 
 * Responsibilities of class:
 * 
 */
public class Game {
	private String title; // Game HAS-A title
	private String genre; // Game HAS-A genre
	private String developer; // Game HAS-A developer
	private String executableName; // Game HAS-A executableName
	
	public Game(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
