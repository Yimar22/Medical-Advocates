package model;

import java.io.Serializable;

//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to create and Save PlayedTimes
	 *@author Yimar Tamayo
	 *@version V0.1_2019
	 */

public class Player implements Comparable<Player>, Serializable{

	private String nickName;
	private int score;
	
	private Patient patient;
	private Ship ship;
	
	private Player left;
	private Player right;
	
	public Player(String nickName, int score) {
		this.nickName=nickName;
		this.score=score;
		
	}
	

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	public Player getLeft() {
		return left;
	}


	public void setLeft(Player left) {
		this.left = left;
	}


	public Player getRight() {
		return right;
	}


	public void setRight(Player right) {
		this.right = right;
	}


		
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
