package threads;

import java.util.Random;
import ui.GameScreenController;

public class MoveEnemiesThread extends Thread{

	private GameScreenController game;
	private boolean alive;
	
	public MoveEnemiesThread(GameScreenController gui, boolean live) {
		game = gui;
		alive = live;
	}
	
	public void Run() {
		while(alive) {
			Random rnd = new Random();
			int move = rnd.nextInt(4);
			game.moveEnemy(move);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
