//_________________________________________________________________________________________________________________


package model;

//________________________________________________________________________________________________________________

/**
 * This class defines the basic attributes of the Hardcore difficulties of the game
 * @author Yimar Tamayo
 */

public class HardcoreLevel extends Difficulty{

	//_________________________________________________________________________________________________________________

	private Virus virus;
	private Bacterium bacterium;
	private Boss boss;

	private int amountOfBoss;
	
	//Methods_________________________________________________________________________________________________________________

	/**
	 * The constructor of the easy levels of the game <br><br>
	 * @param name The name of the level <br><br>
	 * @param difficulty The difficulty of the level <br><br>
	 * @param amountOfEnemies The amount of enemies in this level <br><br>
	 * @param amountOfBoss The amount of boss in this level <br><br>
	 */

	public HardcoreLevel(Difficultys diffuculty, int amountOfEnemies, int amountOfBoss) {
		super(diffuculty, 12);
		this.amountOfBoss=5;
		createVirus();
		createBacterium();

	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * This method creates all the Virus that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of Virus <br><br>
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
	 * This method creates all the Bacterium that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of Bacterium  <br><br>
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
	 * This method creates all the Boss that the level in going to have <br><br>
	 * <b>Pre: </b> The level must not be null <br><br>
	 * <b>Post: </b> The level has a linked list of Boss <br><br>
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

	
	public int getAmountOfBoss() {
		return amountOfBoss;
	}

	public void setAmountOfBoss(int amountOfBoss) {
		this.amountOfBoss = amountOfBoss;
	}
}
