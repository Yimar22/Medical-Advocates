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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InfoScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lb;

    @FXML
    void SortLevel(ActionEvent event) {

    }

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

    @FXML
    void searchNickName(ActionEvent event) {

    }

    @FXML
    void searchScore(ActionEvent event) {

    }

    @FXML
    void sortNickNames(ActionEvent event) {

    }

    @FXML
    void sortScores(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert lb != null : "fx:id=\"lb\" was not injected: check your FXML file 'InfoScreen.fxml'.";

    }
}
