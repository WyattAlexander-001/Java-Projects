package main;

public class Game implements Runnable{
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	
	public Game() {
		System.out.println("DEFAULT TEXT OF GAME CONSTRUCTOR");
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
		//gamePanel.requestFocusInWindow(); //recommended for inputs but doesn't work with Switch
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0/FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
;		while(true) {
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
	}

}
