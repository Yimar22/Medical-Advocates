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
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


public class LaboratoryScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView user;


	@FXML
	private ImageView ship;

	@FXML
	private Label lbDialog;
	
	

	@FXML
	void initialize() {


	}

	@FXML
	void nextScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EnterShipScreen.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

	}

}