package main;

public class Game {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	public Game() {
		System.out.println("DEFAULT TEXT OF GAME CONSTRUCTOR");
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		
	}

}