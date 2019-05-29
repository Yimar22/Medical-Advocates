package model;
//________________________________________________________________________________________________________________

/**
* This class defines the basic attributes of the Virus Enemy
* @author Yimar Tamayo
*@version V0.1_2019
*/
public class Bacterium extends Disease{
	
	private Bacterium next;
	//________________________________________________________________________________________________________________

		/**
		 * The constructor of the Bacterium enemy <br><br>
		 */
	public Bacterium() {
		super(8, 30);
	}
	//________________________________________________________________________________________________________________

		/**
		 * This method returns another Bacterium linked to the current Bacterium <br><br>
		 * <b>Pre: </b> The current Bacterium must not be null <br><br>
		 * @return An object of type Bacterium that represents a Bacterium linked to the current Bacterium <br><br>
		 */
	public Bacterium getNext() {
		return next;
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method link a Bacterium to the current Bacterium <br><br>
	 * <b>Pre: </b> The current Bacterium must not be null <br><br>
	 * <b>Pre: </b> The new Bacterium must not be null <br><br>
	 * <b>Post: </b> The current Bacterium has another Virus linked to it <br><br> 
	 * @param nextBacterium The Bacterium that is going to be linked to the current <br><br>
	 */
	public void setNext(Bacterium next) {
		this.next = next;
	}
	
	
}
