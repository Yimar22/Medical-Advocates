package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;



class GameTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	private Game game;

//________________________________________________STAGES________________________________________________________________
	
	private void stage1() {
		
	}
	
	private void stage2() {
		
		try {
			game = new Game();
		} catch (IOException e) {
			fail("EXCEPTION THROWN");
			e.printStackTrace();
		}
		
	}
	
//________________________________________________TEST METHODS________________________________________________________________
	
	@Test
	public void testGame() {
		
		stage1();
		
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
		
		stage2();
		
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
		
		stage2();
		
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
		
		stage2();
		
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
		
		stage2();
		
		Player player = new Player("prueba2", 1000);
		game.addPlayer(player);
		game.order();
		
		int index = game.searchPlayer(player.getNickName());
		
		assertTrue("Player not added", index != -1);
		
	}
//________________________________________________________________________________________________________________

	@Test
	public void testOrder() {
		
		stage2();
		
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
		
		stage2();
		
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
		
		stage2();
		
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
		
		stage2();
		
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
		
		stage2();
		Player player = new Player("prueba 3", 50);
		game.addPlayer(player);
		
		int index = game.searchPlayer(player.getNickName());
		
		assertTrue("player not found", index != -1);
		
	}

//________________________________________________________________________________________________________________

	@Test
	public void testChooseRandomLevel() {
		
		stage2();
		Difficulty difficulty = game.chooseRandomLevel();
		
		assertTrue("the level was not choose", difficulty != null);
		
	}

//________________________________________________________________________________________________________________


	
}























