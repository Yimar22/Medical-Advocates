package model;
//_________________________________________________________________________________________________________________________________________
/**
 * TThis class defines the basic attributes of the Ship used by the player
 *@author Yimar Tamayo
 *@version V0.1_2019
 */
public class Ship {

	//_________________________________________________________________________________________________________________________________________

	public final static double MAX_HEALTH =100;

	private double health;

	private Laser next;
	//_________________________________________________________________________________________________________________________________________

	/**
	 * Constructor of the ships <br><br>
	 * @param health The health of the spaceship <br><br>
	 */
	//_________________________________________________________________________________________________________________________________________

	public Ship(double health){
		health=MAX_HEALTH;
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method returns the health of the object <br><br>
	 * <b>Pre: </b> The object must not be null <br><br>
	 * @return An integer that represents the health of the ship <br><br>
	 */

	public double getHealth() {
		return health;
	}
	//_________________________________________________________________________________________________________________________________________

	public void setHealth(double health) {
		this.health = health;
	}
	//_________________________________________________________________________________________________________________________________________

	public Laser getNext() {
		return next;
	}
	//_________________________________________________________________________________________________________________________________________

	public void setNext(Laser next) {
		this.next = next;
	}





}
