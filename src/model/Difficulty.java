package model;

//_________________________________________________________________________________________________________________________________________
/**
* This class defines the basic attributes of the difficulty of the game
*@author Yimar Tamayo
*@version V0.1_2019
*/
public class Difficulty implements Comparable<Difficulty> {

	//Attributes_________________________________________________________________________________________________________________

	private Difficultys difficultylevel;

	private Difficulty left;
	private Difficulty right;
	
	protected int amountOfEnemies;

	//Methods_________________________________________________________________________________________________________________

	/**
	 * The constructor of the levels of the game <br><br>
	 * @param difficultylevel The difficulty of the level <br><br>
	 * @param amountOfEnemies The amount of enemies the level <br><br>
	 */

	public Difficulty(Difficultys difficultylevel, int amountOfEnemies) {
		this.difficultylevel = difficultylevel;
		this.amountOfEnemies = amountOfEnemies;
	}

	
	public int getAmountOfEnemies() {
		return amountOfEnemies;
	}


	public void setAmountOfEnemies(int amountOfEnemies) {
		this.amountOfEnemies = amountOfEnemies;
	}


	//_____________________________________________________________________________________________________________________________________
	/**
	 * This method returns the difficultylevel asocciated to this game<br>
	 * <b>Pre:</b> the Game exists<br>
	 * @return the difficulty level which determinates the hardeness of this game
	 */
	public Difficultys getDifficultylevel(){
		return difficultylevel;
	}
	//_____________________________________________________________________________________________________________________________________
	/**
	 * This method sets the difficultylevel associated to this game in the case that the user had choosen one<br>
	 * <b>Pre:</b> the Game exists<br>
	 * <b>Pos:</b> the requested level was succesfully set to this game<br>
	 * @param difficultylevel the difficulty level which determinates the hardeness of this game
	 */
	public void setDifficultyLevel(Difficultys difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	//________________________________________________________________________________________________________________

	/**
	 * This method returns the level linked at the left of the current level <br><br>
	 * <b>Pre: </b> The current level must not be null <br><br>
	 * @return A level linked to the current level <br><br>
	 */
	
	public Difficulty getLeft() {
		return left;
	}

	//________________________________________________________________________________________________________________
	
	/**
	 * This method returns the level linked at the right of the current level <br><br>
	 * <b>Pre: </b> The current level must not be null <br><br>
	 * @return A level linked to the current level <br><br>
	 */
	
	public Difficulty getRight() {
		return right;
	}

	//________________________________________________________________________________________________________________
	
	/**
	 * This method link a level at the left of the current level <br><br>
	 * <b>Pre: </b> The current level must not be null <br><br>
	 * <b>Pre: </b> The new level must not be null <br><br>
	 * <b>Post: </b> A new level has been linked to the current level <br><br>
	 * @param left The level that is going to be linked at the left of the current level <br><br>
	 */
	
	public void setLeft(Difficulty left) {
		this.left = left;
	}

	//________________________________________________________________________________________________________________
	
	/**
	 * This method link a level at the right of the current level <br><br>
	 * <b>Pre: </b> The current level must not be null <br><br>
	 * <b>Pre: </b> The new level must not be null <br><br>
	 * <b>Post: </b> A new level has been linked to the current level <br><br>
	 * @param newRightLevel The level that is going to be linked at the right of the current level <br><br>
	 */
	
	public void setRight(Difficulty right) {
		this.right = right;
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method compare two level and decides if the current level is bigger, smaller or equal to another level based on their difficulty <br><br>
	 * <b>Pre: </b> The current level must not be null <br><br>
	 * <b>Pre: </b> The other level must not be null <br><br>
	 * @param anotherLevel The level which is going to be compared with the current level <br><br>
	 * @return An integer that is equal to 0 if both levels are equal, equal to -1 if the other level is bigger and equal to 1 if the current level is bigger <br><br>  
	 */

	@Override
	public int compareTo(Difficulty anotherLevel) {

		int c;

		if (difficultylevel.compareTo(anotherLevel.difficultylevel) < 0) {
			c = -1;
		}else if (difficultylevel.compareTo(anotherLevel.difficultylevel) > 0) {
			c = 1;
		}else {
			c = 0;
		}

		return c;
	}

	//_________________________________________________________________________________________________________________________________________


}
