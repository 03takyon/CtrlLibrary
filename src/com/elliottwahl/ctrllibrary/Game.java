package com.elliottwahl.ctrllibrary;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Lead Author(s):
 * @author Elliott Wahl
 * 
 * Version/date: 5.11.2024.007
 * 
 * Responsibilities of class: manage information about games, handling operations related to settings and retrieving details like
 * title, developer, genre, executable path, and icon
 * 
 */

// Game IS-A Serializable
public class Game extends GameBase implements Serializable {
	private static final long serialVersionUID = 1L; // Game HAS-A serialVersionUID
	
	private String path; // Game HAS-A path
	private ImageIcon icon; // Game HAS-A icon
	
	/**
	 * assigns various attributes to the Game object upon creation
	 * 
	 * @param title
	 * @param path
	 * @param icon
	 */
	public Game(String title, String developer, String genre, String path, ImageIcon icon) {
		super(title, developer, genre);
		this.path = path;
		this.icon = icon;
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
