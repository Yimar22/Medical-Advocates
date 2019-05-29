package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import exceptions.NickNameException;
import exceptions.RepeatedPlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import model.Player;

public class PlayerScreenController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField nickNameText;

	@FXML
	private Button startButton;

	@FXML
	private Button saveButton;

	private Game game;

	private Player player;

	public final static String INFORPLAYER = "txt/playerinfo.txt";

	@FXML
	void backtScene(ActionEvent event) throws IOException {
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
	void existingPlayer(ActionEvent event) {
		startButton.setDisable(false);

	}

	@FXML
	void newPlayer(ActionEvent event) throws IOException {

		try {

			String nickName = nickNameText.getText();

			if (nickName.isEmpty()) {
				throw new  NickNameException();
			}

			if (game.searchPlayer(nickName) != -1) {
				throw new RepeatedPlayerException(nickName);
			}


			Player newPlayer = new Player(nickName, 0);
			game.addPlayer(newPlayer);

			game.savePlayer(newPlayer);
			startButton.setDisable(false);

			this.player = newPlayer;

		}  catch (RepeatedPlayerException e) {
			Alert dialogo = new Alert(AlertType.INFORMATION);
			dialogo.setTitle("ERROR!");
			dialogo.setHeaderText(null);
			dialogo.setContentText(e.getMessage());
			dialogo.initStyle(StageStyle.UTILITY);
			dialogo.showAndWait();
			e.printStackTrace();

		} catch (NickNameException e) {
			Alert dialogo = new Alert(AlertType.INFORMATION);
			dialogo.setTitle(e.getMessage());
			dialogo.setHeaderText(null);
			dialogo.setContentText(e.getMessage());
			dialogo.initStyle(StageStyle.UTILITY);
			dialogo.showAndWait();
			e.printStackTrace();

		}
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

	//_________________________________________________________________________________________________________________________________________
	/**
	 * This method sets the game used by the PlayerController <br><br> 
	 * @param game The game to set <br><br>
	 */

	public void setGame(Game game) {
		this.game = game;
	}
	//_________________________________________________________________________________________________________________________________________
	/**
	 * This method calls the necessary methods to save the current game in order to send it to the GameController <br><br>
	 */

	public void serializeGame() {
		Game g = game;
		ObjectOutputStream writer;
		try {
			writer = new ObjectOutputStream(new FileOutputStream(INFORPLAYER));
			writer.writeObject(g);
			writer.close();
		} catch (IOException e) {
			Alert dialogo = new Alert(AlertType.INFORMATION);
			dialogo.setTitle("ERROR!");
			dialogo.setHeaderText(null);
			dialogo.setContentText("ERROR WHILE SERIALIZING");
			dialogo.initStyle(StageStyle.UTILITY);
			dialogo.showAndWait();
			e.printStackTrace();
		}

	}
	//_________________________________________________________________________________________________________________________________________

	public void deserializeGame() {

		ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(INFORPLAYER));
			game = (Game) reader.readObject();

			reader.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}



	}

	//_________________________________________________________________________________________________________________________________________

	@FXML
	void initialize() {
	//	startButton.setDisable(true);
		nickNameText.setDisable(false);
		
	}
}
