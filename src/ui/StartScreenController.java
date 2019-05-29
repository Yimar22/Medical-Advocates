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

public class StartScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;


	@FXML
	void showPlayerAndScores(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoScreen.fxml"));
		Parent root = loader.load();
		InfoScreenController isc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void startGame(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerScreen.fxml"));
		Parent root = loader.load();
		PlayerScreenController psc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();


	}

	@FXML
	void initialize() {

	}

}
