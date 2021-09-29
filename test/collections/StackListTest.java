package collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Game;

public class StackListTest {

	private StackList<Game> games;

	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		games = new StackList<>();
	}
	
	public void setupStage3() {
		games = new StackList<>();
		games.push(new Game(112, 13000, 4, "A", 2));
		games.push(new Game(341, 30000, 1, "B", 1));
		games.push(new Game(541, 25000, 2, "A", 5));
	}
	
	@Test
	public void testStackList() {
		setupStage1();
		games = new StackList<>();
		
		assertNotNull("The stack of games was succesfully created", games);
	}
	
	@Test
	public void testPush1() {
		setupStage2();
		Game newGame = new Game(401, 15000, 1, "A", 1);
		games.push(newGame);
		
		assertNotNull(games.top());
		assertEquals(newGame, games.top());
	}
	
	@Test
	public void testPush2() {
		setupStage3();
		Game newGame = new Game(212, 40000, 2, "D", 5);
		games.push(newGame);
		
		assertNotNull(games.top());
		assertEquals(newGame, games.top());
	}
	
	@Test
	public void testPop1() {
		setupStage3();
		Game temp = games.top();
		assertEquals(temp, games.pop().getItem());
		assertEquals(games.top(), games.pop().getItem());
	}
	
	@Test
	public void testPop2() {
		setupStage3();
		Game temp = games.top();
		assertEquals(temp, games.pop().getItem());
		assertEquals(games.top(), games.pop().getItem());
	}

}
