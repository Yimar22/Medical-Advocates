//____________________________________________________________________________________________________________________________________

package exceptions;


/**
 * This class manages the necessary attributes and methods to creates exception objects of type RepeatedPlayerException
 *@author Yimar Tamayo
 *@version V0.1_2019
 */
@SuppressWarnings("serial")
public class RepeatedPlayerException extends Exception {

	private String message;
	
	/**
	 * <b>RepeatedPlayerException constructor</b><br>
	 */
	public RepeatedPlayerException (String nickname) {
		super("The name ");
		message = nickname + "is already in use";
	}
//_________________________________________________________________________________________________________________________________________


}
