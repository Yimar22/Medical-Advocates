package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;



class GameTest {

//_______________________________________________________________________________________________________________

	private Game game;

//Scenarys________________________________________________________________________________________________________________
	
	private void setUpScenary1() {
		
	}
	
	private void setUpScenary2() {
		
		try {
			game = new Game();
		//	game.addPlayer(new Player("Juan", 100));
		} catch (IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}
		
		assertNotNull("The game is null and it was not created", game);
		
	}
	
//Test methods________________________________________________________________________________________________________________
	
	@Test
	public void testGame() {
		
		setUpScenary1();
		try {
			game = new Game();
		} catch (IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}
		assertTrue("The game was not created correctly", game != null);
		
	}
	
//________________________________________________________________________________________________________________

//________________________________________________________________________________________________________________

	//error
	public void testGeneratePlayerTree() {
		
		setUpScenary2();
		
		FileReader fr;
		BufferedReader br;
		
		try {
			
			fr = new FileReader(new File(Game.PLAYERINFO));
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			String[] parts = line.split(",");
			boolean found = true;
			
			while(line != null && found == true){
				System.out.println(parts[0] + "\n");
				
				if (game.searchPlayer(parts[0]) == -1) {
					System.out.println("not found");
					found = false;
				}
				
				line = br.readLine();
				
				if (line != null) {
					parts = line.split(",");
				}
						
			}
			
			br.close();
			fr.close();
			
			assertTrue("No está bien generado el árbol", found == true);
			
		} catch (IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}	
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testWritePlayer() {
		
		setUpScenary2();
		
		Player player = new Player("prueba1", 1000);
		FileReader fr;
		BufferedReader br;
		
		try {
			
			game.savePlayer(player);
			
			fr = new FileReader(new File(Game.PLAYERINFO));
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			String[] parts = line.split(",");
			boolean found = false;
			while(line != null && found == false){
				if (parts[0].equals(player.getNickName())) {
					found = true;
				}
				
				line = br.readLine();
				
				if (line != null) {
					parts = line.split(",");
				}
			}
			
			assertTrue("player not added", found == true);
			
		} catch (IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}
		
	}
	
	
//________________________________________________________________________________________________________________
	
	@Test
	public void testLoadPlayers() {
		
		setUpScenary2();
		
		try {
			game.loadPlayers();
		} catch (ClassNotFoundException | IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}
		
		assertTrue("Not desearialized Arraylist ", game.getPlayers() != null);
		
	}

//________________________________________________________________________________________________________________
	
	@Test
	public void testaddPlayer() {
		
		setUpScenary2();
		
		Player player = new Player("prueba2", 1000);
		game.addPlayer(player);
		game.order();
		
		int index = game.searchPlayer(player.getNickName());
		
		assertTrue("Player not added", index != -1);
		
	}
//________________________________________________________________________________________________________________

	@Test
	public void testOrder() {
		
		setUpScenary2();
		
		ArrayList<Player> list = game.order();
		
		boolean ordered = true;
		
		for (int i = 0; i < list.size() - 1 && ordered == true; i++) {
			
			if (list.get(i).compareTo(list.get(i+1)) < 0) {
				ordered = false;
			}
			
		}
		
		assertTrue("list badly generated", ordered == true);
		
	}
//________________________________________________________________________________________________________________

	@Test
	public void testOrderLevel() {
		
		setUpScenary2();
		
		ArrayList<Difficulty> list = game.orderLevel();
		
		boolean ordered = true;
		
		for (int i = 0; i < list.size() - 1 && ordered == true; i++) {
			
			if (list.get(i).compareTo(list.get(i+1)) > 0) {
				ordered = false;
			}
			
		}
		
		assertTrue("list badly generated", ordered == true);
		
	}


//________________________________________________________________________________________________________________
	
	@Test
	public void testSortByNickName() {
		
		setUpScenary2();
		
		ArrayList<Player> list = game.sortByNickName();
		
		boolean ordered = true;
		
		for (int i = 0; i < list.size()-1 && ordered == true; i++) {
			
			if (list.get(i).getNickName().compareTo(list.get(i+1).getNickName()) > 0) {
				ordered = false;
			}
			
		}
		
		assertTrue("list badly generated", ordered == true);
		
	}
	
	
//________________________________________________________________________________________________________________	

	@Test
	public void testSortLevelByDifficulty() {
		
		setUpScenary2();
		
		ArrayList<Difficulty> list = game.sortLevelByDifficulty();
		
		boolean ordered = true;
		
		for (int i = 0; i < list.size()-1 && ordered == true; i++) {
			
			if (list.get(i).getDifficultylevel().compareTo(list.get(i+1).getDifficultylevel()) > 0) {
				ordered = false;
			}
			
		}
		
		assertTrue("list badly generated", ordered == true);
		
		
	}
	
//________________________________________________________________________________________________________________	
	
	@Test
	public void testSearchPlayer() {
		
		setUpScenary2();
		Player player = new Player("prueba 3", 50);
		game.addPlayer(player);
		
		int index = game.searchPlayer(player.getNickName());
		
		assertTrue("player not found", index != -1);
		
	}

//________________________________________________________________________________________________________________

	@Test
	public void testChooseRandomLevel() {
		
		setUpScenary2();
		Difficulty difficulty = game.chooseRandomLevel();
		
		assertTrue("the level was not choose", difficulty != null);
		
	}

//________________________________________________________________________________________________________________


	
}























