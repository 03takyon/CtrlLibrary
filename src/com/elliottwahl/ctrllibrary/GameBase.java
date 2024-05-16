package com.elliottwahl.ctrllibrary;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.11.2024.001
 * 
 * Responsibilities of class: 
 * 
 */

public abstract class GameBase {
	private String title; // GameBase HAS-A title
	private String developer; // GameBase HAS-A developer
	private String genre; // GameBase HAS-A genre
	
	public GameBase(String title, String developer, String genre) {
		this.title = title;
		this.developer = developer;
		this.genre = genre;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public abstract String getPath();
}
