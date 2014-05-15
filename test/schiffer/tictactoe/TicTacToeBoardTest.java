package schiffer.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testReset() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.reset();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				assertNull(aboard.getSquare(new Location(i, j)));
			}
		}

	}

	@Test
	public void testSetSquare() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(0, 0), Symbol.O);
		assertEquals(aboard.getSquare(new Location(0, 0)), Symbol.O);

	}

	@Test
	public void testGetSquare() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(0, 0), Symbol.X);
		assertEquals(aboard.getSquare(new Location(0, 0)), Symbol.X);

	}

	@Test
	public void testIsFull() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				aboard.setSquare(new Location(i, j), Symbol.X);
			}
		}
	assert(aboard.isFull()==true);
	}
}
