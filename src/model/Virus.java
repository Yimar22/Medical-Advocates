package model;

//________________________________________________________________________________________________________________

/**
 * This class defines the basic attributes of the Virus Enemy
 * @author Yimar Tamayo
 *@version V0.1_2019
 */
public class Virus extends Disease{

	private Virus next;
	//________________________________________________________________________________________________________________

	/**
	 * The constructor of the Virus enemy <br><br>
	 */
	public Virus() {
		super(15, 50);
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method returns another Virus linked to the current Virus <br><br>
	 * <b>Pre: </b> The current Virus must not be null <br><br>
	 * @return An object of type Virus that represents a Virus linked to the current Virus <br><br>
	 */
	public Virus getNext() {
		return next;
	}
	//________________________________________________________________________________________________________________

	/**
	 * This method link a Virus to the current Virus <br><br>
	 * <b>Pre: </b> The current Virus must not be null <br><br>
	 * <b>Pre: </b> The new Virus must not be null <br><br>
	 * <b>Post: </b> The current Virus has another Virus linked to it <br><br> 
	 * @param nextVirus The Virus  that is going to be linked to the current <br><br>
	 */
	public void setNext(Virus next) {
		this.next = next;
	}


}
