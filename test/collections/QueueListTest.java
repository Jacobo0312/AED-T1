package collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.Game;

public class QueueListTest {

	private QueueList<Game> games;

	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		games = new QueueList<>();
	}
	
	public void setupStage3() {
		games = new QueueList<>();
		games.enqueue(new Game(112, 13000, 4, "A", 2));
		games.enqueue(new Game(341, 30000, 1, "B", 1));
		games.enqueue(new Game(541, 25000, 2, "A", 5));
	}
	
	@Test
	public void testQueueList() {
		setupStage1();
		games = new QueueList<>();
		
		assertNotNull("The queue of games was succesfully created", games);
	}
	
	@Test
	public void testEnqueue1() {
		setupStage2();
		Game newGame = new Game(401, 15000, 1, "A", 1);
		games.enqueue(newGame);
		
		assertNotNull(games.front());
		assertEquals(newGame, games.front().getItem());
	}
	
	@Test
	public void testEnqueue2() {
		setupStage3();
		Game newGame = new Game(212, 40000, 2, "D", 5);
		games.enqueue(newGame);
		
		assertNotNull(games.front());
	}
	
	@Test
	public void testDequeue1() {
		setupStage3();
		Game temp = games.front().getItem();
		assertEquals(temp, games.dequeue().getItem());
	}
	
	@Test
	public void testDequeue2() {
		setupStage3();
		Game temp = games.front().getItem();
		assertEquals(temp, games.dequeue().getItem());
	}

}
