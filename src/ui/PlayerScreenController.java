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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nickNameText;

    @FXML
    void backtScene(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
		Parent root = loader.load();
		GameScreenController gc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void existingPlayer(ActionEvent event) {

    }

    @FXML
    void newPlayer(ActionEvent event) {

    }

    @FXML
	void nextScene(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DiagnosisScreen.fxml"));
		Parent root = loader.load();
		DiagnosisScreenController dsc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		stage.show();


	}

    @FXML
    void initialize() {
        assert nickNameText != null : "fx:id=\"nickNameText\" was not injected: check your FXML file 'PlayerScreen.fxml'.";

    }
}
