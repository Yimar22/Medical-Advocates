package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

public class StartScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private Game game;

	@FXML
	void showScores(ActionEvent event) {
		/*FXMLLoader loader = new FXMLLoader(getClass().getResource("Scores.fxml"));
		Parent root = loader.load();
		ScoresScreenController ssc = loader.getController();
		scc.setGame(this.game);
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("BrickBreaker");
		stage.setScene(scene);
		stage.show();*/
	}

	@FXML
	void startGame(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DiagnosisScreen.fxml"));
		Parent root = loader.load();
		DiagnosisScreenController dsc = loader.getController();
		dsc.setGame(this.game);
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical-Advocates");
		stage.setScene(scene);
		stage.show();


	}

	@FXML
	void initialize() {

	}

	public void setGame(Game game) {
		this.game = game;
	}
}
