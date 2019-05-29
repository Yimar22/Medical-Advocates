//_________________________________________________________________________________________________________________________________________
package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

//The class________________________________________________________________________________________________________________________________
/**
 * This class manages the necessary attributes and methods to create a Game and its all components
 *@author Yimar Tamayo
 *@version V0.1_2019
 */

public class Game {

	//Constants______________________________________________________________________________________________________________________________

	public final static String PLAYERINFO = "resources/txt/playerinfo.txt";
	public final static String LEVELINFO = "resources/txt/levelinfo.txt";

	//Atributtes_______________________________________________________________________________________________________________________________
	private Player rootP;
	private Difficulty rootD;;
	private ArrayList<Player> players;

	//Methods___________________________________________________________________________________________________________________________________

	/**
	 * <b>Game Constructor</b><br>
	 * This method allows you to build a game with all the specified components.<br>
	 * @throws IOException 
	 */
	public Game() throws IOException {
		generatePlayer();
		generateDifficulty();
		players = new ArrayList<Player>();
	}

	//_________________________________________________________________________________________________________________________________________
	/**
	 * getPlayer method returns the root element of the players tree <br><br> 
	 * <b>Pre: </b> The game must not be null <br><br>
	 * @return A player which is locate in the root of the tree <br><br>
	 */
	public Player getPlayer() {
		return rootP;
	}

	//_________________________________________________________________________________________________________________________________________
	/**
	 * getPlayers method returns the players of the game<br>
	 * <b>Pre:</b> the Game exists<br>
	 * @return the list that contains all the players registered in the game
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	//_________________________________________________________________________________________________________________________________________
	/**
	 * getRootDifficulty method returns the root element of the levels tree <br><br> 
	 * <b>Pre: </b> The game must not be null <br><br>
	 * @return A level which is locate in the root of the tree <br><br>
	 */

	public Difficulty getRootDifficulty() {
		return rootD;
	}

	//_________________________________________________________________________________________________________________________________________
	/**
	/* generateDifficulty method generates the game levels after reading a text file <br> <br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Pre: </b> The text file must exist <br> <br>
	 * <b>Pos: </b> The game has a tree of levels with all levels to play <br> <br>
	 * @throws IOException when there is a problem reading the text file <br> <br>
	 */

	public void generateDifficulty() throws IOException {

		FileReader fr = new FileReader(new File(LEVELINFO));
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		String[] parts = line.split(",");
		while(line != null){

			int difficulty = Integer.valueOf(parts[0]);

			if (difficulty == 1) {

				int amountOfEnemies = Integer.valueOf(parts[1]);
				int amountOfBoss = Integer.valueOf(parts[2]);
				EasyLevel easyLevel = new EasyLevel(Difficultys.EASY, amountOfEnemies, amountOfBoss);
				addDifficulty(easyLevel);

			}else if (difficulty == 2) {

				int amountOfEnemies = Integer.valueOf(parts[3]);
				int amountOfBoss = Integer.valueOf(parts[4]);

				MediumLevel mediumLevel = new MediumLevel(Difficultys.MEDIUM, amountOfEnemies, amountOfBoss);
				addDifficulty(mediumLevel);

			}else if (difficulty == 3){

				int amountOfEnemies = Integer.valueOf(parts[5]);
				int amountOfBoss = Integer.valueOf(parts[6]);

				HardLevel hardLevel = new HardLevel(Difficultys.HARD, amountOfEnemies, amountOfBoss);
				addDifficulty(hardLevel);

			}else {

			}


			line = br.readLine();
			if(line != null) {
				parts = line.split(",");
			}
		}

		br.close();
		fr.close();

	}

	//_________________________________________________________________________________________________________________________________________
	/**
	 * addDifficulty method adds a new level to the levels tree <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The level tree has a new element <br><br>
	 * @param level The level which is going to be added <br><br>
	 */

	public void addDifficulty(Difficulty difficulty) {

		if(rootD == null) {
			rootD = difficulty;
		} else {
			Difficulty current = rootD;
			boolean added = false;
			while(!added) {
				if(difficulty.compareTo(current) <= 0) {
					if(current.getLeft() == null) {
						current.setLeft(difficulty);
						added = true;
					} else {
						current = current.getLeft();
					} 
				} else {
					if(current.getRight() == null) {
						current.setRight(difficulty);
						added = true;
					} else {
						current = current.getRight();
					}
				}
			}
		}
	}

	//_________________________________________________________________________________________________________________________________________
	/**
	 * generatePlayer method generates the players after reading a text file <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Pre: </b> The text file must exists <br><br>
	 * <b>Post: </b> The game has a players tree with all the players that have played the game <br><br>
	 * @throws IOException When occur a problem reading the text file <br><br>
	 */

	public void generatePlayer() throws IOException {

		FileReader fr = new FileReader(new File(PLAYERINFO));
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		String[] parts = line.split(",");


		String nickName = parts[0];
		int score = Integer.valueOf(parts[1]);

		Player player = new Player(nickName, score);
		addPlayer(player);


		line = br.readLine();
		if(line != null) {
			parts = line.split(",");
		}

		br.close();
		fr.close();

	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * addPlayer method adds a new player to the players tree <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The player tree has a new element <br><br>
	 * @param player The player which is going to be added <br><br>
	 */
	public void addPlayer(Player player){

		if(rootP==null){
			rootP = player;
		}else{
			Player current = rootP;
			boolean added = false;

			while(!added){
				if(rootP.getScore()<player.getScore()){
					if(current.getRight() == null){
						current.setRight(player);
						added = true;
					}else{
						current = current.getRight();
					}
				}else{
					if(current.getLeft() == null){
						current.setLeft(player);
						added = true;
					}else{
						current = current.getLeft();
					}
				} 
			}
		}
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * writePlayer method saves the player which is going to play while the stage of the game is launch <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Pre: </b> The player must not be null <br><br>
	 * <b>Post: </b> The player has been serialized <br><br>
	 * @param  player which is going to be saved <br><br>
	 * @throws IOException When occur a problem writing the object <br><br>
	 */

	public void savePlayer(Player player) throws IOException {

		String message = "\n" + player.getNickName() + "," + player.getScore() + ",";

		FileWriter fw = new FileWriter(PLAYERINFO, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);

		out.print(message);

		out.close();
	}

	//________________________________________________________________________________________________________________
	/**
	 * loadNewPlayers method deserialize the list of  players <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The list of players has been deserialized <br><br>
	 * @throws IOException When occur a problem while deserializing the list <br><br>
	 * @throws ClassNotFoundException When the specified file is not found <br><br>
	 */

	@SuppressWarnings("unchecked")
	public void loadPlayers() throws ClassNotFoundException, IOException  {

		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(PLAYERINFO));

		players = (ArrayList<Player>) reader.readObject();

		reader.close();

		for (int i = 0; i < players.size(); i++) {
			addPlayer(players.get(i));
			System.out.println(players.get(i).getNickName());
		}



	}

	//_________________________________________________________________________________________________________________________________________


	/**
	 * order method call upon a method that creates an ordered ArrayList of players <br><br>
	 * <b>Pre: </b> The game must not be null <br><br> 
	 * @return An ArrayList of players <br><br>
	 */


	public ArrayList<Player> order(){
		return order(rootP);
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * order recursive method returns an ordered ArrayList of players created by players  tree <br><br>
	 * <b>Pre: </b> The game must not be null <br><br> 
	 * @param current Player of the tree that will be the start point <br><br>
	 * @return An ArrayList with all the player ordered by score <br><br>
	 */

	private ArrayList<Player> order(Player current){

		ArrayList<Player> list = new ArrayList<Player>();

		if (current != null) {
			ArrayList<Player> leftList = order(current.getLeft());
			ArrayList<Player> rightList = order(current.getRight());

			list.addAll(rightList);
			list.add(current);
			list.addAll(leftList);
		}

		return list;
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * orderLevel method calls a method that creates an ordered ArrayList of levels <br><br>
	 * <b>Pre: </b> The game must not be null <br><br> 
	 * @return An ArrayList of levels <br><br>
	 */

	public ArrayList<Difficulty> orderLevel(){
		return orderLevel(rootD);
	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * orderLevel recursive method returns an ordered ArrayList of levels created by moving through the levels tree <br><br>
	 * <b>Pre: </b> The game must not be null <br><br> 
	 * @param current The level of the tree that will be the start point <br><br>
	 * @return An ArrayList with all the level ordered by difficulty <br><br>
	 */

	private ArrayList<Difficulty> orderLevel(Difficulty current){
		ArrayList<Difficulty> list = new ArrayList<Difficulty>();

		if (current != null) {
			ArrayList<Difficulty> leftList = orderLevel(current.getLeft());
			ArrayList<Difficulty> rightList = orderLevel(current.getRight());

			list.addAll(leftList);
			list.add(current);
			list.addAll(rightList);
		}

		return list;
	}

	//_________________________________________________________________________________________________________________________________________


	//_________________________________________________________________________________________________________________________________________
	/**
	 * sortByNickName method used the selection sorting to order an ArrayList which contains the players <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The players are now ordered by nickname <br><br>
	 * @return An ArrayList of players <br><br>
	 */

	public ArrayList<Player> sortByNickName() {

		ArrayList<Player> list = order();

		for (int i = 0; i < list.size() - 1; i++) {
			Player less = list.get(i);
			int current = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).getNickName().compareTo(less.getNickName()) < 0) {
					less = list.get(j);
					current = j;
				}
			}

			Player temp = list.get(i);
			list.set(i, less);
			list.set(current, temp);

		}

		return list;

	}


	//_________________________________________________________________________________________________________________________________________

	/**
	 * sortByScore method used the bubble sorting to order the array which contains the top players <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The top players are now ordered by score <br><br>
	 */

	public 	ArrayList<Player> sortByScore(Game game) {
		ArrayList<Player> list = order();

		for (int i = 0; i < list.size() - 1; i++) {
			for(int j=0;j<list.size()-i-1;j++) {
				if(list.get(j).getScore()>(list.get(j+1).getScore())) {
					Player aux = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, aux);
				}
			}
		}
		return list;
	}
	//_________________________________________________________________________________________________________________________________________

	/**
	 * sortLevelByDifficulty method used the insertion sorting to order an ArrayList which contains the levels <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Post: </b> The levels are now ordered by difficulty <br><br>
	 * @return An ArrayList of levels <br><br>
	 */

	public ArrayList<Difficulty> sortLevelByDifficulty(){ 

		ArrayList<Difficulty> list = orderLevel();

		for (int i = 1; i < list.size(); i++) {

			for (int j = i; j > 0 && list.get(j).getDifficultylevel().compareTo(list.get(j-1).getDifficultylevel()) < 0; j--) {

				Difficulty temp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j - 1, temp);

			}

		}

		return list;

	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * searchPlayer method use binary searching to find a player in an ArrayList with an specific nickname <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Pre: </b> The list must be ordered by nickname <br><br> 
	 * @param nickName The nickname of the wanted player <br><br>
	 * @return An integer that represents the position of the player in the ArrayList. If the player is not found it returns -1 <br><br>
	 */

	public int searchPlayer(String nickName) {

		ArrayList<Player> list = sortByNickName();

		int index = -1;

		int low = 0;
		int high = list.size() - 1;
		int mid;

		while(low <= high) {

			mid = (low + high) / 2;

			if (list.get(mid).getNickName().compareToIgnoreCase(nickName) < 0) {
				low = mid + 1;
			}else if (list.get(mid).getNickName().compareToIgnoreCase(nickName) > 0) {
				high = mid -1;
			}else {
				index = mid;
				return index;
			}

		}

		return -1;


	}

	//_________________________________________________________________________________________________________________________________________

	/**
	 * searchPlayer method use binary searching to find a player in an ArrayList with an specific nickname <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * <b>Pre: </b> The list must be ordered by nickname <br><br> 
	 * @param nickName The nickname of the wanted player <br><br>
	 * @return An integer that represents the position of the player in the ArrayList. If the player is not found it returns -1 <br><br>
	 */

	public int searchScore(int score) {

		ArrayList<Player> list = sortByScore(this);

		int index = -1;

		int less = 0;
		int higher = list.size() - 1;
		int mid;

		while(less <= higher) {

			mid = (less + higher) / 2;

			if (list.get(mid).getScore()< score) {
				less = mid + 1;
			}else if (list.get(mid).getScore()>score) {
				higher = mid -1;
			}else {
				index = mid;
				return index;
			}

		}

		return -1;

	}

	//_________________________________________________________________________________________________________________________________________


	/**
	 * chooseRandomLevel method choose a random level from all the levels in the game <br><br>
	 * <b>Pre: </b> The game must not be null <br><br>
	 * @return The level chose randomly <br><br>
	 */

	public Difficulty chooseRandomLevel() {

		ArrayList<Difficulty> list = orderLevel();

		Random random = new Random();
		int pos = random.nextInt(list.size()-1);

		Difficulty level = list.get(pos);

		return level;

	}
}
