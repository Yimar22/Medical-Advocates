package model;

//_________________________________________________________________________________________________________________________________________
	/**
	 * This class defines the basic attributes of the laser used by the ship of the player.
	 *@author Yimar Tamayo
	 *@version V0.1_2019
	 */
public class Laser {

	
	//_________________________________________________________________________________________________________________________________________

	private int damage;
	//methods_________________________________________________________________________________________________________________________________________

	/**
	 * The constructor of the missiles used by the ships <br><br>
	 * @param damage The damage cause by the laser when it hits <br><br>
	 */
	public Laser(int damage) {
		this.damage=damage;
	}
	//_________________________________________________________________________________________________________________________________________
	/**
	 * This method returns the damage of the laser <br><br>
	 * @return An integer that represents the damage caused by the laser <br><br>
	 */
	
	public int getDamage() {
		return damage;
	}
	//_________________________________________________________________________________________________________________________________________




}
