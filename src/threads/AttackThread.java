package threads;


import javafx.scene.image.ImageView;
import ui.GameScreenController;

//_________________________________________________________________________________________________________________________________________
/**
* This class is the main
*@author Yimar Tamayo
*@version V0.1_2019
*/
public class AttackThread extends Thread{
	
	GameScreenController gc;
	ImageView laser;
	
	public AttackThread(ImageView laser) {
		gc = new GameScreenController();
		laser = gc.getLaser();		
	}
	
public void run() {
		
		
		while(laser.getLayoutY() >= -6.0) {
			
			gc.shoot(laser);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


}
