package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class GameScreenController{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView user;

	@FXML
	private ImageView ship;

	@FXML
	private AnchorPane ap;
	
	private Group board;
	
	
	private static final double W = 800, H = 560;

	private static final String SHIP =
			"/resources/images/nave-removebg.png";
	private static final String WEAPON =
			"file:///C:/Users/yimar/eclipse-workspace/Medical-Advocates/resources/images/laser.png";
	
	private Image shipImage, weaponImage;
	private Node  shipp;
	private ArrayList<Node> weapons = new ArrayList<Node>();
	

	@FXML
	void initialize() {
		weaponImage = new Image(WEAPON);
		board = new Group();
	}

	public void movePlayer(int movement) throws IOException {
		if(movement==3) {
			ship.setLayoutX(ship.getLayoutX()-10); 
		}else if(movement==4) { 
			ship.setLayoutX(ship.getLayoutX()+10);
		}else if(movement==1) { 
			ship.setLayoutY(ship.getLayoutY()-10);
		}else if(movement==2) { 
			ship.setLayoutY(ship.getLayoutY()+10);
		}
		else if(movement==5) { 
			ship.setRotate(ship.getRotate()+5);
		}
		else if(movement==6) { 
			ship.setRotate(ship.getRotate()-5);
		}	

/*		if(ship.getLayoutX() > ap.getMaxWidth())
			ship.setLayoutX(0);
		if(ship.getLayoutY() > ap.getMaxHeight())
			ship.setLayoutY(0);

		if(ship.getLayoutX() < 0)
			ship.setLayoutX(ap.getMaxWidth());
		if(ship.getLayoutY() < 0)
			ship.setLayoutY(ap.getMaxHeight());
	*/}
	
	public void shoot(int delta) {
		for(int i=0;i<weapons.size();i++) {
			if(weapons.get(i).getLayoutX()<W) {
				weapons.get(i).relocate(weapons.get(i).getLayoutX()+delta,weapons.get(i).getLayoutY());
			}else weapons.remove(i);
		}
	}
	
	public void preShoot() {
		ImageView aWeapon= new ImageView(weaponImage);
		Node newWeapon = aWeapon;
		newWeapon.relocate(ship.getLayoutX()+ship.getBoundsInLocal().getWidth(), ship.getLayoutY());
		weapons.add(newWeapon);
		board.getChildren().add(newWeapon);
		shoot(10);
	}

	/*public void move(int key) {
		if(key==4) {
			ship.setLayoutX(ship.getLayoutX()-10);
		}else if(key==6) { 
			ship.setLayoutX(ship.getLayoutX()+10); 
		}		
	}*/



}