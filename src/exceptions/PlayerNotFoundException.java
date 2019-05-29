//_________________________________________________________________________________________________________________________________________
package exceptions;
//_________________________________________________________________________________________________________________________________________
/**
 * This class creates exception objects type PlayerNotFoundException
 *@author Yimar Tamayo
 *@version V0.1_2019
 */

@SuppressWarnings("serial")
public class PlayerNotFoundException extends Exception{

	//_________________________________________________________________________________________________________________________________________
	/**
	 * <b>PlayerNotFoundException constructor</b><br>
	 */
	public PlayerNotFoundException() {
		System.out.println("You havent added a player to the game");
	}
	
}
