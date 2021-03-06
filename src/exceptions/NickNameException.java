//_________________________________________________________________________________________________________________________________________
package exceptions;
//_________________________________________________________________________________________________________________________________________
/**
 * This class creates exception objects type NickNamexception
 *@author Yimar Tamayo
 *@version V0.1_2019
 */
@SuppressWarnings("serial")
public class NickNameException extends Exception{

	//_________________________________________________________________________________________________________________________________________
	/**
	 * <b>NickNameException constructor</b><br>
	 */
	public NickNameException() {
		super("Please put a name");
	}
	//_________________________________________________________________________________________________________________________________________

}
