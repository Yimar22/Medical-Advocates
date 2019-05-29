package model;

import java.io.Serializable;

//_________________________________________________________________________________________________________________________________________
/**
 * This class manages the necessary attributes and methods to create and Players
 *@author Yimar Tamayo
 *@version V0.1_2019
 */

public class Player implements Comparable<Player>, Serializable{

	//Attributes_________________________________________________________________________________________________________________________________________

	private String nickName;
	private int score;

	private Patient patient;
	private Ship ship;

	private Player left;
	private Player right;

	//methods________________________________________________________________________________________________________________

	/**
	 * The constructor of the player of the game <br><br>
	 * @param nickName The nickname of the player <br><br>
	 * @param score The score of the player <br><br>
	 */

	public Player(String nickName, int score) {
		this.nickName=nickName;
		this.score=score;

	}
	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method returns the nickname of the player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * @return A string that represents the nickname of the player <br><br>
	 */
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method returns the score of the player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * @return An integer that represents the score of the player <br><br>
	 */
	public int getScore() {
		return score;
	}

	//________________________________________________________________________________________________________________	

	/**
	 * This method modifies the score of the player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * <b>Post: </b> The score of the player has been modified <br><br>
	 * @param score An integer that represents the new score of the player <br><br>
	 */
	public void setScore(int score) {
		this.score = score;
	}

	//________________________________________________________________________________________________________________

	public Patient getPatient() {
		return patient;
	}
	//________________________________________________________________________________________________________________

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	//________________________________________________________________________________________________________________

	public Ship getShip() {
		return ship;
	}
	//________________________________________________________________________________________________________________
	/**
	 * This method modifies the spaceship of the player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * <b>Post: </b> The spaceship of the player has been modified <br><br>
	 * @param ship An object of type Ship that represents the new ship of the player <br><br>
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	//________________________________________________________________________________________________________________

	/**
	 * This method returns another player linked at the left to the current player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * @return A player linked to the current player <br><br>
	 */
	public Player getLeft() {
		return left;
	}

	//________________________________________________________________________________________________________________

	public void setLeft(Player left) {
		this.left = left;
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method returns another player linked at the right to the current player <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * @return A player linked to the current player <br><br>
	 */

	public Player getRight() {
		return right;
	}

	//________________________________________________________________________________________________________________

	public void setRight(Player right) {
		this.right = right;
	}
	//________________________________________________________________________________________________________________



	/**
	 * This method compare two players and decides if the current player is bigger, smaller or equal to another player based on their score <br><br>
	 * <b>Pre: </b> The current player must not be null <br><br>
	 * <b>Pre: </b> The other player must not be null <br><br>
	 * @param anotherPlayer The player which is going to be compared with the current player <br><br>
	 * @return An integer that is equal to 0 if both players are equal, equal to -1 if the other player is bigger and equal to 1 if the current player is bigger <br><br>  
	 */

	@Override
	public int compareTo(Player anotherPlayer) {

		int c;

		if (score < anotherPlayer.getScore()) {
			c = -1;
		}else if (score > anotherPlayer.getScore()) {
			c = 1;
		}else {
			c = 0;
		}

		return c;
	}




}
