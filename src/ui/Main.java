package ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import threads.MusicThread;
//_________________________________________________________________________________________________________________________________________
/**
* This class is the main
*@author Yimar Tamayo
*@version V0.1_2019
*/
public class Main extends Application{
	public static void main(String[] args) {
		MusicThread mt = new MusicThread();
		mt.start();
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Parent root =
				FXMLLoader.load(getClass().getResource("EnterShipScreen.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();

	}  
}
