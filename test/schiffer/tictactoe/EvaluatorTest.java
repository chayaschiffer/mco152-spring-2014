package schiffer.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class EvaluatorTest {
	@Test
	public void testHorizontalFirst() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(0, 0), Symbol.X);
		aboard.setSquare(new Location(0, 1), Symbol.X);
		aboard.setSquare(new Location(0, 2), Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testHorizontalSecond() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(1, 0), Symbol.X);
		aboard.setSquare(new Location(1, 1), Symbol.X);
		aboard.setSquare(new Location(1, 2), Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testHorizontalThird() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(2, 0), Symbol.X);
		aboard.setSquare(new Location(2, 1), Symbol.X);
		aboard.setSquare(new Location(2, 2), Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testVerticalFirst() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Location loc1 = new Location(0, 0);
		Location loc2 = new Location(1, 0);
		Location loc3 = new Location(2, 0);
		aboard.setSquare(loc1, Symbol.X);
		aboard.setSquare(loc2, Symbol.X);
		aboard.setSquare(loc3, Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testVerticalSecond() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Location loc1 = new Location(0, 1);
		Location loc2 = new Location(1, 1);
		Location loc3 = new Location(2, 1);
		aboard.setSquare(loc1, Symbol.X);
		aboard.setSquare(loc2, Symbol.X);
		aboard.setSquare(loc3, Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testVerticalThird() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Location loc1 = new Location(0, 2);
		Location loc2 = new Location(1, 2);
		Location loc3 = new Location(2, 2);
		aboard.setSquare(loc1, Symbol.X);
		aboard.setSquare(loc2, Symbol.X);
		aboard.setSquare(loc3, Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testEvaluateDiagonalRight() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Location loc1 = new Location(0, 0);
		Location loc2 = new Location(1, 1);
		Location loc3 = new Location(2, 2);
		aboard.setSquare(loc1, Symbol.X);
		aboard.setSquare(loc2, Symbol.X);
		aboard.setSquare(loc3, Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testEvaluateDiagonalLeft() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Location loc1 = new Location(2, 0);
		Location loc2 = new Location(1, 1);
		Location loc3 = new Location(0, 2);
		aboard.setSquare(loc1, Symbol.X);
		aboard.setSquare(loc2, Symbol.X);
		aboard.setSquare(loc3, Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testGetWinner() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Evaluator anEval = new Evaluator(aboard);
		aboard.setSquare(new Location(2, 0), Symbol.X);
		aboard.setSquare(new Location(1, 1), Symbol.X);
		aboard.setSquare(new Location(0, 2), Symbol.X);
		anEval.evaluate();
		assertNotNull(anEval.getWinner());
		assertEquals(anEval.getWinner(), Symbol.X);
	}

	@Test
	public void testNewGame() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		Evaluator anEval = new Evaluator(aboard);
		aboard.setSquare(new Location(2, 0), Symbol.X);
		aboard.setSquare(new Location(1, 1), Symbol.X);
		aboard.setSquare(new Location(0, 2), Symbol.X);
		anEval.evaluate();
		assertNotNull(anEval.getWinner());
		assertEquals(anEval.getWinner(), Symbol.X);
		anEval.resetGame();
		aboard.setSquare(new Location(2, 0), Symbol.X);
		aboard.setSquare(new Location(1, 1), Symbol.X);
		aboard.setSquare(new Location(0, 2), Symbol.X);
		anEval.evaluate();
		assertNotNull(anEval.getWinner());
		assertEquals(anEval.getWinner(), Symbol.X);

	}

	@Test
	public void testGetWinningList() {
		TicTacToeBoard aboard = new TicTacToeBoard();
		aboard.setSquare(new Location(2, 0), Symbol.X);
		aboard.setSquare(new Location(1, 1), Symbol.X);
		aboard.setSquare(new Location(0, 2), Symbol.X);
		Evaluator anEval = new Evaluator(aboard);
		anEval.evaluate();
		assertNotNull(anEval.getWinningSquares());
		List<Location> alist = new ArrayList<Location>();
		for (int j = 0; j < 2; j++) {
			alist.add(new Location(0, j));
		}
		for (int j = 0; j < 2; j++) {
			assert (anEval.getWinningSquares().get(j).equals(alist.get(j)));

		}
	}

}
