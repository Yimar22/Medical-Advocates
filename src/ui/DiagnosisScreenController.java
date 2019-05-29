package ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class DiagnosisScreenController {


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView imgDialog1;

	@FXML
	private ImageView imgDialog2;

	@FXML
	private Label lbDialog;

	@FXML
	private Label lbDialog2;



	@FXML
	void initialize()  {
		String disease="";
		int ndisease = (int) Math.floor(Math.random()*2);
		switch (ndisease) {
		case 0:
			disease="una bacteria";
			break;
		case 1:
			disease="un virus";
			break;
		}

		lbDialog.setText("La paciente \n esta siendo \n atacada por \n" + disease);;

	/*	Platform.runLater(new Runnable(){

			@Override
			public void run() {
				lbDialog2.setText("Debemos \n hacer algo!");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}});

		Platform.runLater(new Runnable(){

			@Override
			public void run() {

				lbDialog.setText("Acompañame \n al laboratorio");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}});

		Platform.runLater(new Runnable(){

			@Override
			public void run() {

				lbDialog2.setText("Vamos!!");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}});
*/

	}


	@FXML
	void nextScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LaboratoryScreen.fxml"));
		Scene scene = new Scene(root);
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		appStage.setScene(scene);
		appStage.toFront();
		appStage.show();


	}

}
