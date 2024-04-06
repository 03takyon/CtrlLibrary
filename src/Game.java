public class Game {
	private String title;
	private String genre;
	private String developer;
	
	public Game(String title) {
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getDeveloper() {
		return developer;
	}
}
