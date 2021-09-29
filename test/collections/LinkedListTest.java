package collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Game;

public class LinkedListTest {
	
	private LinkedList<Game> games;

	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		games = new LinkedList<>();
	}
	
	public void setupStage3() {
		games = new LinkedList<>();
		games.add(new Game(112, 13000, 4, "A", 2));
		games.add(new Game(341, 30000, 1, "B", 1));
		games.add(new Game(541, 25000, 2, "A", 5));
	}
	
	@Test
	public void testLinkedList() {
		setupStage1();
		LinkedList<Game> games = new LinkedList<>();
		
		assertTrue(games != null, "The linked list was successfully created");
		assertEquals(null, games.getHead());
		assertEquals(0, games.size());
		assertEquals(null, games.getTail());
	}
	
	@Test
	public void testAdd1() {
		setupStage2();
		games.add(new Game(331, 17000, 1, "A", 1));
		
		assertFalse(games.isEmpty());
		assertEquals(1, games.size());
		assertNotNull(games.getHead());
	}
	
	@Test
	public void testAdd2() {
		setupStage3();
		Game newGame = new Game(331, 17000, 1, "A", 1);
		games.add(newGame);
		
		assertEquals(4, games.size());
		assertNotNull(games.get(games.size()-1));
		assertEquals(newGame, games.getTail().getItem());
	}
	
	@Test
	public void testRemove1() {
		setupStage3();
		
		assertTrue(games.size() == 3);
		games.remove(0);
		
		assertEquals(2, games.size());
	}

}
