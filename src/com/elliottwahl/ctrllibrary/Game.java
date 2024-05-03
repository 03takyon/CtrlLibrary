package com.elliottwahl.ctrllibrary;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.2.2024.005
 * 
 * Responsibilities of class: manage information about games, handling operations related to settings and retrieving details like
 * title, developer, genre, executable path, and icon
 * 
 */

// Game IS-A Serializable
public class Game implements Serializable {
	private String title; // Game HAS-A title
	private String genre; // Game HAS-A genre
	private String developer; // Game HAS-A developer
	private String path; // Game HAS-A path
	private transient ImageIcon icon; // Game HAS-A icon
	
	/**
	 * assigns various attributes to the Game object upon creation
	 * 
	 * @param title
	 * @param path
	 * @param icon
	 */
	public Game(String title, String path, ImageIcon icon) {
		this.title = title;
		this.path = path;
		this.icon = icon;
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
	 * returns the path of the game's executable
	 * 
	 * @return path
	 */
	public String getPath() {
		return path;
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
	 * returns the icon
	 * 
	 * @return icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}
	
	/**
	 * sets a new icon
	 * 
	 * @param icon
	 */
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
