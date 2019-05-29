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

	String disease="";

	@FXML
	void initialize()  {
		int ndisease = (int) Math.floor(Math.random()*2);
		switch (ndisease) {
		case 0:
			disease="una bacteria";
			break;
		case 1:
			disease="un virus";
			break;
		}

		dialogs();
	}

	public void dialogs() {
		int count = 0;
		for(int i = 0; i<4;i++) {
		showDialogs(count);
		count++;
		}
	
	}
	
	public void showDialogs(int count) {
		switch(count) {
		case 0:
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					long time= System.currentTimeMillis();
					lbDialog.setText("La paciente \n esta siendo \n atacada por \n " + disease);
					long finall= System.currentTimeMillis();
					System.out.println(time-finall);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		
			break;
		case 1:
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					long time1= System.currentTimeMillis();
					lbDialog2.setText("Debemos \n hacer algo!");
					long finall1= System.currentTimeMillis();
					System.out.println(time1-finall1);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		
			break;
		case 2:
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					long time11= System.currentTimeMillis();
					lbDialog.setText("Acompañame \n al laboratorio");
					long finall11= System.currentTimeMillis();
					System.out.println(time11-finall11);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			break;
		case 3:
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					long time111= System.currentTimeMillis();
					lbDialog2.setText("Vamos!!");
					long finall111= System.currentTimeMillis();
					System.out.println(time111-finall111);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			break;

		}
	}
	/*	
public void run() {
	Platform.runLater(new Runnable() {
	    @Override
	    public void run() {
	//    dialogs();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	});
}*/


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
