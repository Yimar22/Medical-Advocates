//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to build the Space Invaders Game 
 */

package model;

//______________________________________________________THE CLASS__________________________________________________________

/**
 * This class defines the basic attributes of the easy levels of the game
 * @author Yimar Tamayo
 */

public class HardLevel extends Difficulty {

	//______________________________________________________ATTRIBUTES___________________________________________________________

	private Virus virus;
	private Bacterium bacterium;
	private Boss boss;
	
	private int amountOfBoss;

	//______________________________________________________METHODS___________________________________________________________

	/**
	 * The constructor of the easy levels of the game <br><br>
	 * @param name The name of the level <br><br>
	 * @param difficulty The difficulty of the level <br><br>
	 * @param amountOfNormalEnemies The amount of normal enemies in this level <br><br>
	 */

	public HardLevel(Difficultys diffuculty, int amountOfEnemies, int amountOfBoss) {
		super(diffuculty, 8);
		this.amountOfBoss=2;
		createVirus();
		createBacterium();

	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method creates all the normal enemies that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of normal enemies <br><br>
	 */

	public void createVirus() {

		virus = new Virus();
		Virus current = virus;
		int i = 0;
		while(i < amountOfEnemies - 1) {
			current.setNext(new Virus());
			current = current.getNext();
			i++;
		}

	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method creates all the normal enemies that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of normal enemies <br><br>
	 */

	public void createBacterium() {

		bacterium = new Bacterium();
		Bacterium current = bacterium;
		int i = 0;
		while(i < amountOfEnemies - 1) {
			current.setNext(new Bacterium());
			current = current.getNext();
			i++;
		}

	}
	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method creates all the normal enemies that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of normal enemies <br><br>
	 */

	public void createBoss() {

		boss = new Boss();
		Boss current = boss;
		int i = 0;
		while(i < amountOfBoss - 1) {
			current.setNext(new Boss());
			current = current.getNext();
			i++;
		}

	}
	
	//_________________________________________________________________________________________________________________________________________

}
