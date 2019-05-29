package exceptions;

public class PlayerNotFoundException extends Exception{

	public PlayerNotFoundException() {
		System.out.println("You havent added a player to the game");
	}
}
