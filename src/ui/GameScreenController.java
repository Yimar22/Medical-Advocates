package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Difficulty;
import model.Difficultys;
import model.EasyLevel;
import model.Game;
import model.HardLevel;
import model.HardcoreLevel;
import model.MediumLevel;
import model.Player;
import threads.AttackThread;



public class GameScreenController{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView user;

	@FXML ImageView ship;
	
	@FXML
	private ImageView laser; 

	@FXML
	private AnchorPane ap;
	
	private Game game;
	private Player player;
	private Difficulty difficulty;
	

	

	@FXML
	void initialize() {


		/*String score = String.valueOf(player.getScore());
		scoreLabel.setText(score);*/
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
	
	public void generateEnemies() {
		ImageView image1;
		Image i1;

		ImageView image2;
		Image i2;


		if (difficulty.getDifficultylevel().equals(Difficultys.EASY)) {

			EasyLevel easyLevel = (EasyLevel) difficulty;

			int sep = 400/easyLevel.getAmountOfEnemies();

			for (int i = 0; i < easyLevel.getAmountOfEnemies(); i++) {
				image1 = new ImageView();
				i1 = new Image("images/bacteria1.png");
				image1.setImage(i1);
				image1.setFitHeight(30);
				image1.setFitWidth(30);
				image1.setLayoutX(sep*(i+1));
				image1.setLayoutY(170);

				ap.getChildren().add(image1);

			}

		}else if (difficulty.getDifficultylevel().equals(Difficultys.MEDIUM)) {

			MediumLevel mediumLevel = (MediumLevel) difficulty;

			int sep = 400/mediumLevel.getAmountOfEnemies();
			int sep2 = 400/mediumLevel.getAmountOfBoss();

			for (int i = 0; i < mediumLevel.getAmountOfEnemies(); i++) {
				image1 = new ImageView();
				i1 = new Image("images/bacteria1.png");
				image1.setImage(i1);
				image1.setFitHeight(30);
				image1.setFitWidth(30);
				image1.setLayoutX(sep*(i+1));
				image1.setLayoutY(170);

				ap.getChildren().add(image1);

			}

			for (int i = 0; i < mediumLevel.getAmountOfBoss(); i++) {
				image2 = new ImageView();
				i2 = new Image("images/boss1.gif");
				image2.setImage(i2);
				image2.setFitHeight(30);
				image2.setFitWidth(30);
				image2.setLayoutX(sep2*(i+1));
				image2.setLayoutY(120);

				ap.getChildren().add(image2);

			}


		}else if(difficulty.getDifficultylevel().equals(Difficultys.HARD)){

			HardLevel hardLevel = (HardLevel) difficulty;

			int sep = 400/hardLevel.getAmountOfEnemies();
			int sep2 = 400/hardLevel.getAmountOfBoss();

			for (int i = 0; i < hardLevel.getAmountOfEnemies(); i++) {
				image1 = new ImageView();
				i1 = new Image("images/bacteria1.png");
				image1.setImage(i1);
				image1.setFitHeight(30);
				image1.setFitWidth(30);
				image1.setLayoutX(sep*(i+1));
				image1.setLayoutY(170);

				ap.getChildren().add(image1);

			}

			for (int i = 0; i < hardLevel.getAmountOfBoss(); i++) {
				image2 = new ImageView();
				i2 = new Image("images/boss1.gif");
				image2.setImage(i2);
				image2.setFitHeight(30);
				image2.setFitWidth(30);
				image2.setLayoutX(sep2*(i+1));
				image2.setLayoutY(120);

				ap.getChildren().add(image2);
			}

		}else {
			HardcoreLevel hardLevel = (HardcoreLevel) difficulty;

			int sep = 400/hardLevel.getAmountOfEnemies();
			int sep2 = 400/hardLevel.getAmountOfBoss();

			for (int i = 0; i < hardLevel.getAmountOfEnemies(); i++) {
				image1 = new ImageView();
				i1 = new Image("images/bacteria1.png");
				image1.setImage(i1);
				image1.setFitHeight(30);
				image1.setFitWidth(30);
				image1.setLayoutX(sep*(i+1));
				image1.setLayoutY(170);

				ap.getChildren().add(image1);

			}

			for (int i = 0; i < hardLevel.getAmountOfBoss(); i++) {
				image2 = new ImageView();
				i2 = new Image("images/boss1.gif");
				image2.setImage(i2);
				image2.setFitHeight(30);
				image2.setFitWidth(30);
				image2.setLayoutX(sep2*(i+1));
				image2.setLayoutY(120);

				ap.getChildren().add(image2);
			}
		}

	}
	

	public void shootThread() {
		AttackThread st = new AttackThread(createLaser());
		System.out.println(laser.getLayoutY());
		st.start();
		System.out.println(laser.getLayoutY());
	}
	

	public ImageView createLaser() {
		
		laser = new ImageView();
		laser.setLayoutX(laser.getLayoutX() + 22);
		laser.setLayoutY(laser.getLayoutY() - 6);
		
		return laser;
		
	}
	
	public void shoot(ImageView laser) {
		
		laser.setLayoutY(laser.getLayoutY() - 5);
			/*for(int i=0;i<laser.size();i++) {
						if(laser.get(i).getLayoutX()<ap.getMaxWidth()) {
							laser.get(i).relocate(laser.get(i).getLayoutX()+1,laser.get(i).getLayoutY());
						}else laser.remove(i);
					}*/
	}
	
/*	public void preShoot() {
		ImageView aWeapon= new ImageView(weaponImage);
		Node newWeapon = aWeapon;
		newWeapon.relocate(ship.getLayoutX()+ship.getBoundsInLocal().getWidth(), ship.getLayoutY());
		weapons.add(newWeapon);
		board.getChildren().add(newWeapon);
		shoot(10);
	}*/

	public ImageView getShip() {
		return ship;
	}

	public AnchorPane getAp() {
		return ap;
	}

	public ImageView getLaser() {
		return laser;
	}

	public void setLaser(ImageView laser) {
		this.laser = laser;
	}


	

	/*public void move(int key) {
		if(key==4) {
			ship.setLayoutX(ship.getLayoutX()-10);
		}else if(key==6) { 
			ship.setLayoutX(ship.getLayoutX()+10); 
		}		
	}*/



}