package com.elliottwahl.ctrllibrary;

import java.io.Serializable;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.11.2024.001
 * 
 * Responsibilities of class: assign and retrieve data specific to a game object
 * 
 */

public abstract class GameBase implements Serializable {
	private static final long serialVersionUID = 1L; // GameBase HAS-A serialVersionUID
	
	private String title; // GameBase HAS-A title
	private String developer; // GameBase HAS-A developer
	private String genre; // GameBase HAS-A genre
	
	/**
	 * no-argument constructor to avoid overriding game attributes
	 */
	public GameBase() {
		
	}
	
	/**
	 * assigns the title, developer, and genre of a game object
	 * 
	 * @param title
	 * @param developer
	 * @param genre
	 */
	public GameBase(String title, String developer, String genre) {
		this.title = title;
		this.developer = developer;
		this.genre = genre;
	}
	
	/**
	 * returns the title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * sets a new title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * returns the developer
	 * 
	 * @return developer
	 */
	public String getDeveloper() {
		return developer;
	}
	
	/**
	 * sets a new developer
	 * 
	 * @param developer
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	/**
	 * returns the genre
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * sets a new genre
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * returns the path
	 * 
	 * @return String
	 */
	public abstract String getPath();
}
