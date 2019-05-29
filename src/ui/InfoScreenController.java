package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Difficulty;
import model.Game;
import model.Player;

public class InfoScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private TextField tfNickName;

	@FXML
	private TextField tfScores;

	@FXML
	private Label lb;

	private Game game;

	private Player player;
	//__________________________________________________________________________________________________________________________

	/**
	 * This methods calls the necessary methods to show and list of all the levels ordered by difficulty <br><br>
	 * @param event The cause to execute the method <br><br>
	 */
	@FXML
	void SortLevel(ActionEvent event) {
		ArrayList<Difficulty> list = game.sortLevelByDifficulty();;

		String message = "Difficulty";

		for (int i = 0; i < list.size(); i++) {

			message += list.get(i).getDifficultylevel();

		}

		lb.setText(message);
	}

	//__________________________________________________________________________________________________________________________


	@FXML
	void backScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
		Parent root = loader.load();
		StartScreenController ssc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();
	}

	//__________________________________________________________________________________________________________________________

	@FXML
	void searchNickName(ActionEvent event) {
		
		String nickName = tfNickName.getText();

		ArrayList<Player> list = game.sortByNickName();

		try {

			int pos = game.searchPlayer(nickName);
			Player player = list.get(pos);
			this.player = player;

		} catch (ArrayIndexOutOfBoundsException e) {
			Alert dialogo = new Alert(AlertType.INFORMATION);
			dialogo.setTitle("Player not found");
			dialogo.setHeaderText(null);
			dialogo.setContentText(e.getMessage());
			dialogo.initStyle(StageStyle.UTILITY);
			dialogo.showAndWait();
			e.printStackTrace();
		}	

	}
	//__________________________________________________________________________________________________________________________

	@FXML
	void searchScore(ActionEvent event) {
		String nickName = tfNickName.getText();

		ArrayList<Player> list = game.sortByScore(game);

		try {

			int pos = game.searchPlayer(nickName);
			Player player = list.get(pos);
			this.player = player;

		} catch (ArrayIndexOutOfBoundsException e) {
			Alert dialogo = new Alert(AlertType.INFORMATION);
			dialogo.setTitle("Score not found");
			dialogo.setHeaderText(null);
			dialogo.setContentText(e.getMessage());
			dialogo.initStyle(StageStyle.UTILITY);
			dialogo.showAndWait();
			e.printStackTrace();
		}	
	}
	//__________________________________________________________________________________________________________________________

	@FXML
	void sortNickNames(ActionEvent event) {

		ArrayList<Player> list = game.sortByNickName();
		String message = "NICKNAME\tSCORE\n";

		for (int i = 0; i < list.size(); i++) {

			message += list.get(i).getNickName() + "\t\t" + list.get(i).getScore();

		}

		lb.setText(message);
	}
	//__________________________________________________________________________________________________________________________

	@FXML
	void sortScores(ActionEvent event) {
		ArrayList<Player> list = game.sortByScore(game);
		String message = "SCORE\tNICKNAME\n";

		for (int i = 0; i < list.size(); i++) {

			message += list.get(i).getScore() + "\t\t"+list.get(i).getNickName(); 
		}

		lb.setText(message);
	}
	//__________________________________________________________________________________________________________________________

	@FXML
	void initialize() {
		assert lb != null : "fx:id=\"lb\" was not injected: check your FXML file 'InfoScreen.fxml'.";

	}
}
