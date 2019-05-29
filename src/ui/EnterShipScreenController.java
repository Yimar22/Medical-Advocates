package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import exceptions.NickNameException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EnterShipScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;


	
	@FXML
	private ImageView user;

	@FXML
	private ImageView ship;
	
	private Image laserImage;
	private Node hero;
	private ArrayList<Node> laser= new ArrayList<Node>(); 
	

	@FXML
	void initialize() {

	}
	@FXML
	void startGame(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
		Parent root = loader.load();
		GameScreenController gc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		double width= gc.getAp().getMaxWidth();
		laserImage=new Image("file:images/laser.png");
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode().equals(KeyCode.W)||e.getCode().equals(KeyCode.UP)) {
					try {
						gc.movePlayer(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.S)||e.getCode().equals(KeyCode.DOWN)) {
					try {
						gc.movePlayer(2);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.A)||e.getCode().equals(KeyCode.LEFT)) {
					try {
						gc.movePlayer(3);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.D)||e.getCode().equals(KeyCode.RIGHT)) {
					try {
						gc.movePlayer(4);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.E)) {
					try {
						gc.movePlayer(5);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.Q)) {
					try {
						gc.movePlayer(6);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.SPACE)) {
					gc.shootThread();
				}else {
					try {
					//	String key = String.valueOf(e.getCode());
						throw new NickNameException();
					} catch (NickNameException e1) {
						System.out.println(e1.getMessage());
						
					}
				}
				/*	ImageView aLaser = new ImageView(laserImage);
					Node neLaser = aLaser;
					neLaser.relocate(gc.getShip().getLayoutX()+gc.getShip().getBoundsInLocal().getWidth(), gc.getShip().getLayoutY());
					laser.add(neLaser);
					gc.getAp().getChildren().add(neLaser);
					gc.shoot(laser);
				*/

				/*else if(e.getCode().equals(KeyCode.L)||e.getCode().equals(KeyCode.Q)) {
					atack = new AtackThread(gc);
					atack.start();
				}*/

			
			}
		});

		stage.setTitle("Medical Advocates");
		stage.setScene(scene);
		//stage.getIcons().add(new Image("icon.png"));
		stage.show();
		
	}
	

}