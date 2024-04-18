package com.elliottwahl.ctrllibrary;

import javax.swing.ImageIcon;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 4.13.2024.003
 * 
 * Responsibilities of class:
 * 
 */
public class Game {
	private String title; // Game HAS-A title
	private String genre; // Game HAS-A genre
	private String developer; // Game HAS-A developer
	private String path; // Game HAS-A path
	private ImageIcon icon; // Game HAS-A icon
	
	public Game(String title, String path, ImageIcon icon) {
		this.title = title;
		this.path = path;
		this.icon = icon;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPath() {
		return path;
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
	
	public ImageIcon getIcon() {
		return icon;
	}
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
