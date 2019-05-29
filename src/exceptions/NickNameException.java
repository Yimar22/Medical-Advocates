//_________________________________________________________________________________________________________________________________________
package exceptions;
//_________________________________________________________________________________________________________________________________________
/**
 * This class manages the necessary attributes and methods to creates exception objects of type InvalidInformationException
 *@author Yimar Tamayo
 *@version V0.1_2019
 */
public class NickNameException extends Exception{
	private String invalidNickName;
	//_________________________________________________________________________________________________________________________________________
	/**
	 * <b>InvalidInformationException constructor</b><br>
	 */
	public NickNameException(String invalidNickName) {
		super();
		this.invalidNickName = invalidNickName;
	}
	//_________________________________________________________________________________________________________________________________________
	/**
	 * This method allow the exception to generates an special message for every case where the user enter or choosed wrong values
	 * @return A string report with the reason that lead the program to caused an exception
	 */
	@Override
	public String getMessage() {
		//report that is going to be return
		String report = "";
		if(this.invalidNickName.equals("")) {
			report += "Please write a name for the player";
		}
		return report;
	}
	//____________________________________________________________________________________________________________________________________

}
