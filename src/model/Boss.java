package model;


//________________________________________________________________________________________________________________

/**
 * This class defines the basic attributes of the Virus Enemy
 * @author Yimar Tamayo
 *@version V0.1_2019
 */

public class Boss extends Disease{

	private Boss next;

	//________________________________________________________________________________________________________________

	/**
	 * The constructor of the Virus enemy <br><br>
	 */
	public Boss() {
		super(35, 200);
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method returns another Boss linked to the current Boss <br><br>
	 * <b>Pre: </b> The current Boss must not be null <br><br>
	 * @return An object of type Boss that represents a Boss linked to the current Boss <br><br>
	 */
	public Boss getNext() {
		return next;
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method link a Boss to the current Boss <br><br>
	 * <b>Pre: </b> The current VirBossus must not be null <br><br>
	 * <b>Pre: </b> The new Boss must not be null <br><br>
	 * <b>Post: </b> The current Boss has another Boss linked to it <br><br> 
	 * @param nextBoss The Boss that is going to be linked to the current <br><br>
	 */
	public void setNext(Boss next) {
		this.next = next;
	}


}
