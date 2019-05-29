package threads;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicThread extends Thread{

	public MusicThread() {
		
	}
	
	@Override
	public void run() {
		
		String path = "resources/sounds/soundoforgan.mp3";
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setVolume(1.0);
		
		try {
			sleep(75000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	run();
		
		
	}
	
}
