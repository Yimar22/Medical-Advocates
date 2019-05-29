package exceptions;


/**
 * This class manages the necessary attributes and methods to creates exception objects of type PlayerDoesNotExistException
 *@author Yimar Tamayo
 *@version V0.1_2019
 */
public class RepeatedPlayerException extends Exception {

	private String nickname;
	
	/**
	 * <b>PlayerDoesNotExistException constructor</b><br>
	 */
	public RepeatedPlayerException (String nickname) {
		super();
		this.nickname = nickname;
	}
//_________________________________________________________________________________________________________________________________________
	/**
	 * getMessage method allow the exception to generates an special message for every case where the user tries to sign in with a player
	 * that does not exist
	 * @return A string report with the reason that lead the program to caused an exception
	 */
	@Override
	public String getMessage() {
		String report = "";
		
		if(nickname.equals("")) {
			report += "You can not sign in if you haven't enter any information";
		}
		else {
			report += "The: "+nickname +" player does not exists or maybe it's already removed. Try signing up if the problem persists";
		}
		return report;
	}
//____________________________________________________________________________________________________________________________________

}
